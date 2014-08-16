package com.zsxy.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import com.zsxy.R;
import com.zsxy.activity.CourseScheduleControllerListener;
import com.zsxy.constant.ZsxyConstant;
import com.zsxy.database.DatabaseManager;
import com.zsxy.models.Score;
import com.zsxy.webservices.GetScoreHttp;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CourseFunctionItemController implements OnClickListener {
	private Handler m_handler = null;

	private DatabaseManager m_databaseManager;
	private GetScoreHttp m_getScoreHttp;

	// ��¼��ʾ�Ի���
	private Dialog m_progressDialog = null;

	private CourseScheduleControllerListener m_courseListener;

	public CourseFunctionItemController(
			CourseScheduleControllerListener functionItem_listener) {
		this.m_courseListener = functionItem_listener;

		init();

		registerBoradcastReceiver();
	}

	private void init() {
		m_databaseManager = new DatabaseManager(m_courseListener.getContext());
		m_getScoreHttp = new GetScoreHttp();
		m_handler = new Handler();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// �����ɼ������¼�
		case R.id.search:
			m_courseListener.showLoginWindow(2);
			Thread searchThread = new Thread() {
				@Override
				public void run() {
					Looper.prepare();
					try {
						Thread.sleep(500);
						m_progressDialog = createLoadingDialog(
								m_courseListener.getContext(), "��ѯ��");
						m_progressDialog.show();

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Looper.loop();
				}
			};
			searchThread.start();
			break;

		// ��ҵ
		case R.id.homework:
			break;

		// ����֪ͨ
		case R.id.notification:
			break;

		// С���
		case R.id.partner:
			break;

		// ����
		case R.id.set:
			break;
		}
	}

	// ���������ĵ�½��
	public static Dialog createLoadingDialog(Context context, String msg) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// �õ�����view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// ���ز���
		// main.xml�е�ImageView
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// ��ʾ����
		// ���ض���
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.drawable.loading_animation);
		// ʹ��ImageView��ʾ����
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText(msg);// ���ü�����Ϣ
		tipTextView.setTextColor(Color.WHITE);
		Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// �����Զ�����ʽdialog

		loadingDialog.setCancelable(false);// �������á����ؼ���ȡ��
		loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));// ���ò���
		return loadingDialog;

	}

	private BroadcastReceiver m_Score_BroadcastReceiver = new BroadcastReceiver() {

		@SuppressWarnings("null")
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String action = intent.getAction();
			List<Score> l_resultList = new ArrayList<Score>();
			if (action.equals(ZsxyConstant.SCORE_BROADCAST)) {
				try {
					m_getScoreHttp.getScoreHttp(intent
							.getStringExtra(ZsxyConstant.STUDENT_ID), intent
							.getStringExtra(ZsxyConstant.STUDENT_PASSWORD));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.e("error", e.toString());
				}
				l_resultList = m_getScoreHttp.getM_ScoreList();
				m_databaseManager.deleteScore();
				if ( l_resultList.size() != 0) {
					m_databaseManager.AddScore(l_resultList);
				} else {
					Toast l_toast = Toast.makeText(
							m_courseListener.getContext(), "��ȡ�ɼ�ʧ��",
							Toast.LENGTH_LONG);
					l_toast.show();
				}
				m_handler.post(r2);
				m_courseListener.startScoreInfoActivity();
			}
			if (action.equals(ZsxyConstant.SCORE_CANCEL_BROADCAST)) {
				m_handler.post(r2);
			}
		}
	};

	// ע��㲥
	private void registerBoradcastReceiver() {
		IntentFilter zsxyIntentFilter = new IntentFilter();
		zsxyIntentFilter.addAction(ZsxyConstant.SCORE_CANCEL_BROADCAST);
		zsxyIntentFilter.addAction(ZsxyConstant.SCORE_BROADCAST);
		// ע��㲥
		m_courseListener.getContext().registerReceiver(
				m_Score_BroadcastReceiver, zsxyIntentFilter);
	}

	// �ͷŹ㲥
	public void Destroy() {
		m_courseListener.getContext().unregisterReceiver(
				m_Score_BroadcastReceiver);
	}

	Runnable r2 = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			m_progressDialog.dismiss();
		}
	};
}
