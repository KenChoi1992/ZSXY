package com.zsxy.activity.implementation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;

import com.zsxy.R;
import com.zsxy.activity.CourseScheduleControllerListener;
import com.zsxy.constant.ZsxyConstant;
import com.zsxy.controller.CourseFunctionItemController;
import com.zsxy.controller.CourseScheduleController;
import com.zsxy.controller.CourseWeekController;
import com.zsxy.view.CourseFunctionItemView;
import com.zsxy.view.CourseScheduleView;
import com.zsxy.view.CourseWeekView;

/*
 * 这是显示课程界面的Activity，就是显示课表的Activity
 * */

public class CourseScheduleActivity extends Fragment implements
		CourseScheduleControllerListener {

	// 定义周数下拉框的Controller和View
	private CourseWeekController m_courseWeekController;
	private CourseWeekView m_courseWeekView;

	// 定义用户下拉框的Controller和View
	private CourseFunctionItemView m_functionView;
	private CourseFunctionItemController m_functionControler;

	// 获得屏幕像素密度
	private int m_int_Density;
	private int m_int_width;

	// 定义PopupWindow
	private PopupWindow m_userPopWin = null;
	private PopupWindow m_WeekPopWin = null;

	// 定义相应PopupWindow的View
	private View m_userView;
	private View m_WeekView;

	// 主界面的View
	private View m_mainView;

	// 相应的View和Controller
	private CourseScheduleView m_courseView;
	private CourseScheduleController m_courseController;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LayoutInflater layoutInflater = getActivity().getLayoutInflater();
		m_mainView = layoutInflater.inflate(R.layout.activity_schedule,
				(ViewGroup) getActivity().findViewById(R.layout.activity_main),
				false);

		// 获得屏幕的大小
		DisplayMetrics dm = new DisplayMetrics();
		dm = getResources().getDisplayMetrics();
		m_int_Density = dm.densityDpi;
		m_int_width = (dm.widthPixels / 15) * 2;

		m_courseView = (CourseScheduleView) m_mainView
				.findViewById(R.id.courseSchedule);
		m_courseView.initModule();
		m_courseController = new CourseScheduleController(m_courseView, this);
		m_courseController.getParamers(m_int_Density, m_int_width);

		m_courseView.setOnClickListener(m_courseController);

		init();
	}

	// 初始化相应的控件和变量
	private void init() {

		// Layout的初始化
		m_userView = getActivity().getLayoutInflater().inflate(
				R.layout.functionitem, null);
		m_WeekView = getActivity().getLayoutInflater().inflate(
				R.layout.week_popupwindow, null);

		// 初始化PopupWindow
		m_userPopWin = new PopupWindow(m_userView, 150,
				LayoutParams.MATCH_PARENT, true);
		m_WeekPopWin = new PopupWindow(m_WeekView, (105 * m_int_Density) / 160,
				450, true);

		// 设置用户头像的下拉框的控制器和View
		m_functionView = new CourseFunctionItemView(m_userView);
		m_functionView.initModule();
		m_functionControler = new CourseFunctionItemController(this);
		m_functionView.setListeners(m_functionControler);

		// 设置周数的下拉框的控制器和View
		m_courseWeekView = new CourseWeekView(m_WeekView);
		m_courseWeekView.initModule();
		m_courseWeekController = new CourseWeekController(m_courseWeekView,
				this, m_courseView, m_int_width, m_courseController);
		m_courseWeekView.setListeners(m_courseWeekController);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ViewGroup p = (ViewGroup) m_mainView.getParent();
		if (p != null) {
			p.removeAllViewsInLayout();
		}
		return m_mainView;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		Intent intent = null;
		if (resultCode == ZsxyConstant.COURSE_SURE_RESULT_CODE) {
			// 发送广播给Controller
			intent = new Intent(ZsxyConstant.COURSE_BROADCAST);
			intent.putExtra(ZsxyConstant.STUDENT_ID,
					data.getStringExtra(ZsxyConstant.STUDENT_ID));
			intent.putExtra(ZsxyConstant.STUDENT_PASSWORD,
					data.getStringExtra(ZsxyConstant.STUDENT_PASSWORD));
			getActivity().sendBroadcast(intent);
		}
		if (resultCode == ZsxyConstant.SCORE_SURE_RESULT_CODE) {
			// 发送广播给Controller
			intent = new Intent(ZsxyConstant.SCORE_BROADCAST);
			intent.putExtra(ZsxyConstant.STUDENT_ID,
					data.getStringExtra(ZsxyConstant.STUDENT_ID));
			intent.putExtra(ZsxyConstant.STUDENT_PASSWORD,
					data.getStringExtra(ZsxyConstant.STUDENT_PASSWORD));
			getActivity().sendBroadcast(intent);
		}
		if (resultCode == ZsxyConstant.COURSE_CANCEL_RESULT_CODE) {
			// 发送广播给Controller
			intent = new Intent(ZsxyConstant.COURSE_CANCEL_BROADCAST);
			getActivity().sendBroadcast(intent);
			intent = new Intent(ZsxyConstant.SCORE_CANCEL_BROADCAST);
			getActivity().sendBroadcast(intent);
		}
		if (resultCode == ZsxyConstant.SCORE_CANCEL_RESULT_CODE) {
			// 发送广播给Controller
			intent = new Intent(ZsxyConstant.COURSE_CANCEL_BROADCAST);
			getActivity().sendBroadcast(intent);
			intent = new Intent(ZsxyConstant.SCORE_CANCEL_BROADCAST);
			getActivity().sendBroadcast(intent);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		if (m_userPopWin.isShowing())
			m_userPopWin.dismiss();
		super.onResume();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		m_courseController.Destroy();
		super.onDestroy();
	}

	@Override
	public void showUserWindow() {
		// TODO Auto-generated method stub
		m_userPopWin.setTouchable(true);
		m_userPopWin.setOutsideTouchable(true);
		m_userPopWin.setBackgroundDrawable(new BitmapDrawable(getResources(),
				(Bitmap) null));
		if (m_userPopWin.isShowing())
			m_userPopWin.dismiss();
		else
			m_userPopWin.showAsDropDown(m_mainView.findViewById(R.id.user));
	}

	@Override
	public void showLoginWindow(int which) {
		// TODO Auto-generated method stub
		if (which == 1) {
			Intent intent = new Intent();
			intent.putExtra(ZsxyConstant.LOGIN_FOR_WHICH, which);
			intent.setClass(getActivity(), CourseLoginActivity.class);
			startActivityForResult(intent, ZsxyConstant.SURE_REQUEST_CODE);
		}
		if (which == 2) {
			Intent intent = new Intent();
			intent.putExtra(ZsxyConstant.LOGIN_FOR_WHICH, which);
			intent.setClass(getActivity(), CourseLoginActivity.class);
			startActivityForResult(intent, ZsxyConstant.SURE_REQUEST_CODE);
		}
	}

	@Override
	public void showWeekWindow() {
		// TODO Auto-generated method stub
		m_WeekPopWin.setTouchable(true);
		m_WeekPopWin.setOutsideTouchable(true);
		m_WeekPopWin.setBackgroundDrawable(new BitmapDrawable(getResources(),
				(Bitmap) null));
		if (m_WeekPopWin.isShowing())
			m_WeekPopWin.dismiss();
		else
			m_WeekPopWin.showAsDropDown(m_mainView.findViewById(R.id.weeks), 0,
					10);

	}

	@Override
	public void startSourseInfoActivity(int startTime, String week) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.putExtra(ZsxyConstant.WEEK_NUM, "");
		intent.putExtra(ZsxyConstant.START_TIME, startTime);
		intent.putExtra(ZsxyConstant.WEEK, week);
		intent.setClass(getActivity(), CourseInfoActivity.class);
		startActivity(intent);
	}

	@Override
	public Context getContext() {
		// TODO Auto-generated method stub
		return getActivity();
	}

	@Override
	public void startScoreInfoActivity() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), ScoreInfoActivity.class);
		startActivity(intent);
	}

	@Override
	public void dismissWeekWindow() {
		// TODO Auto-generated method stub
		m_WeekPopWin.dismiss();
	}

	@Override
	public void dismissUserWindow() {
		// TODO Auto-generated method stub
		m_userPopWin.dismiss();
	}

}
