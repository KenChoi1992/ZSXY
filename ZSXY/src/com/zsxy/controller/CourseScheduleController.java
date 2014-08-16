package com.zsxy.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONException;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zsxy.R;
import com.zsxy.activity.CourseScheduleControllerListener;
import com.zsxy.constant.ZsxyConstant;
import com.zsxy.database.DatabaseManager;
import com.zsxy.models.Courses;
import com.zsxy.tools.GetDate;
import com.zsxy.view.CourseScheduleView;
import com.zsxy.webservices.GetCourseHttp;

public class CourseScheduleController implements OnClickListener {

	private Handler m_handler = null;
	// 登录显示对话框
	private Dialog m_progressDialog = null;

	private DatabaseManager m_databaseManager;
	private GetCourseHttp m_getCourseHttp;
	private GetDate m_getDate;

	// 获得屏幕像素密度
	// private int m_int_Density;
	private int m_int_width;

	private int startTime;
	private String week;

	private CourseScheduleControllerListener m_courseListener;
	private CourseScheduleView m_courseView;

	public CourseScheduleController(CourseScheduleView courseSchedule,
			CourseScheduleControllerListener courseListener) {
		this.m_courseView = courseSchedule;
		this.m_courseListener = courseListener;

		initModule();
		initWeekDate();
		// m_courseView.cleanClass(width)
	}

	// 初始化相应的变量
	public void initModule() {
		m_databaseManager = new DatabaseManager(m_courseListener.getContext());
		m_getCourseHttp = new GetCourseHttp();
		m_getDate = new GetDate();
		registerBoradcastReceiver();
		m_handler = new Handler();
	}
	
	public void initWeekDate() {
		m_courseView.setWeekDate(m_getDate.initDate());

	}
	
	public void changeDate(int position){
		m_courseView.setWeekDate(m_getDate.changeWeekDate(position));
	}
	

	// 获得课表的函数
	public List<Courses> getCourses() {
		return m_databaseManager.queryAllCourse();
	}

	// 从Activity中获得相应的参数
	public void getParamers(int density, int width) {
		// this.m_int_Density = density;
		this.m_int_width = width;

		m_courseView.cleanClass(m_int_width);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.weeks:
			m_courseListener.showWeekWindow();
			break;
		case R.id.imageView1:
			m_courseListener.showUserWindow();
			break;
		case R.id.imageView3:
			m_courseView.setAddImageVisible(false);
			m_courseListener.showLoginWindow(1);
			Thread updateThread = new Thread() {
				@Override
				public void run() {
					Looper.prepare();
					try {
						Thread.sleep(500);
						m_progressDialog = createLoadingDialog(
								m_courseListener.getContext(), "登录中");
						m_progressDialog.show();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Looper.loop();
				}
			};
			updateThread.start();
			break;
		// 用户头像下拉框功能的监听
		case R.id.search:
			m_courseListener.startSourseInfoActivity(2, "周二");
			break;
		case R.id.homework:
		case R.id.notification:
		case R.id.partner:
		case R.id.set:
			break;
		// 监听增加课表按钮
		case R.id.addSchedule:
			m_courseView.setAddImageVisible(false);
			m_courseListener.showLoginWindow(1);
			Thread addThread = new Thread() {
				@Override
				public void run() {
					Looper.prepare();
					try {
						Thread.sleep(500);
						m_progressDialog = createLoadingDialog(
								m_courseListener.getContext(), "登录中");
						m_progressDialog.show();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Looper.loop();
				}
			};
			addThread.start();
			break;
		// 显示课表内容控件的监听事件的相应
		// 周一课表
		case R.id.mon1:
			startTime = 1;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon2:
			startTime = 2;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon3:
			startTime = 3;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon4:
			startTime = 4;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon5:
			startTime = 5;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon6:
			startTime = 6;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon7:
			startTime = 7;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon8:
			startTime = 8;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon9:
			startTime = 9;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon10:
			startTime = 10;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon11:
			startTime = 11;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.mon12:
			startTime = 12;
			week = "Mon";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;

		// 周二课表
		case R.id.Tues1:
			startTime = 1;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues2:
			startTime = 2;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues3:
			startTime = 3;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues4:
			startTime = 4;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues5:
			startTime = 5;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues6:
			startTime = 6;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues7:
			startTime = 7;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues8:
			startTime = 8;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues9:
			startTime = 9;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues10:
			startTime = 10;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues11:
			startTime = 11;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Tues12:
			startTime = 12;
			week = "Tue";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		// 周三课表
		case R.id.Wed1:
			startTime = 1;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed2:
			startTime = 2;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed3:
			startTime = 3;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed4:
			startTime = 4;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed5:
			startTime = 5;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed6:
			startTime = 6;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed7:
			startTime = 7;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed8:
			startTime = 8;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed9:
			startTime = 9;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed10:
			startTime = 10;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed11:
			startTime = 11;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Wed12:
			startTime = 12;
			week = "Wed";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		// 周四课表
		case R.id.Thur1:
			startTime = 1;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur2:
			startTime = 2;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur3:
			startTime = 3;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur4:
			startTime = 4;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur5:
			startTime = 5;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur6:
			startTime = 6;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur7:
			startTime = 7;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur8:
			startTime = 8;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur9:
			startTime = 9;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur10:
			startTime = 10;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur11:
			startTime = 11;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Thur12:
			startTime = 12;
			week = "Thu";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		// 周五课表
		case R.id.Fri1:
			startTime = 1;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri2:
			startTime = 2;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri3:
			startTime = 3;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri4:
			startTime = 4;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri5:
			startTime = 5;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri6:
			startTime = 6;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri7:
			startTime = 7;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri8:
			startTime = 8;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri9:
			startTime = 9;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri10:
			startTime = 10;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri11:
			startTime = 11;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Fri12:
			startTime = 12;
			week = "Fri";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		// 周六课表
		case R.id.Sat1:
			startTime = 1;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat2:
			startTime = 2;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat3:
			startTime = 3;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat4:
			startTime = 4;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat5:
			startTime = 5;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat6:
			startTime = 6;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat7:
			startTime = 7;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat8:
			startTime = 8;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat9:
			startTime = 9;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat10:
			startTime = 10;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat11:
			startTime = 11;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sat12:
			startTime = 12;
			week = "Sat";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		// 周日课表
		case R.id.Sun1:
			startTime = 1;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun2:
			startTime = 2;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun3:
			startTime = 3;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun4:
			startTime = 4;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun5:
			startTime = 5;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun6:
			startTime = 6;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun7:
			startTime = 7;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun8:
			startTime = 8;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun9:
			startTime = 9;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun10:
			startTime = 10;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun11:
			startTime = 11;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;
		case R.id.Sun12:
			startTime = 12;
			week = "Sun";
			m_courseListener.startSourseInfoActivity(startTime, week);
			break;

		}
	}

	// 创建弹出的登陆框
	public static Dialog createLoadingDialog(Context context, String msg) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
		// main.xml中的ImageView
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
		// 加载动画
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.drawable.loading_animation);
		// 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText(msg);// 设置加载信息
		tipTextView.setTextColor(Color.WHITE);
		Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

		loadingDialog.setCancelable(false);// 不可以用“返回键”取消
		loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
//		loadingDialog.setOnCancelListener(new OnCancelListener() {
//			
//			@Override
//			public void onCancel(DialogInterface dialog) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		return loadingDialog;

	}

	private BroadcastReceiver m_BroadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String action = intent.getAction();
			List<Courses> l_resultList = new ArrayList<Courses>();
			if (action.equals(ZsxyConstant.COURSE_BROADCAST)) {
				try {
					m_getCourseHttp.getCourseHttp(intent
							.getStringExtra(ZsxyConstant.STUDENT_ID), intent
							.getStringExtra(ZsxyConstant.STUDENT_PASSWORD));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				l_resultList = m_getCourseHttp.getM_CourseList();
				m_databaseManager.deleteAll();
				if (l_resultList.size() != 0) {
					m_courseView.showCourseSchedule();
					m_databaseManager.AddCourse(m_getCourseHttp
							.getM_CourseList());
					m_courseView.setWeekDate(m_getDate.initDate());
					m_courseView.setClass(false, 0, getCourses(), m_int_width);
				} else {
					m_courseView.setAddImageVisible(true);
					Toast toast = Toast.makeText(m_courseListener.getContext(),
							"获取课表失败", Toast.LENGTH_LONG);
					toast.show();
				}
				m_handler.post(r2);
			}
			if (action.equals(ZsxyConstant.COURSE_CANCEL_BROADCAST)) {
				m_handler.post(r2);
				m_courseView.setAddImageVisible(true);
			}
		}
	};

	// 注册广播
	private void registerBoradcastReceiver() {
		IntentFilter zsxyIntentFilter = new IntentFilter();
		zsxyIntentFilter.addAction(ZsxyConstant.COURSE_CANCEL_BROADCAST);
		zsxyIntentFilter.addAction(ZsxyConstant.COURSE_BROADCAST);
		// 注册广播
		m_courseListener.getContext().registerReceiver(m_BroadcastReceiver,
				zsxyIntentFilter);
	}

	// 释放广播
	public void Destroy() {
		m_courseListener.getContext().unregisterReceiver(m_BroadcastReceiver);
	}

	Runnable r2 = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			m_progressDialog.dismiss();
		}
	};

}
