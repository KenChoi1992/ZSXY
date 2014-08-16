package com.zsxy.activity.implementation;

import com.zsxy.R;
import com.zsxy.activity.CourseInfoControllerListener;
import com.zsxy.constant.ZsxyConstant;
import com.zsxy.controller.CourseInfoController;
import com.zsxy.view.CourseInfoView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/*
 * 这是课表详细信息显示界面的Activity
 * */

public class CourseInfoActivity extends Activity implements
		CourseInfoControllerListener {

	private CourseInfoView m_course_info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_course_info);

		Intent intent = getIntent();
		int startTime = intent.getIntExtra(ZsxyConstant.START_TIME, 1);
		String week = intent.getStringExtra(ZsxyConstant.WEEK);

		m_course_info = (CourseInfoView) findViewById(R.id.course_info);
		m_course_info.initModule();
		CourseInfoController l_courseInfoController = new CourseInfoController(
				m_course_info, this);
		m_course_info.setListener(l_courseInfoController);

		l_courseInfoController.getParams(startTime, week);
	}

	// 在课程信息界面点击返回按钮，返回课表界面
	@Override
	public void onClickBack() {
		this.finish();
	}

	@Override
	public Context getContext() {
		// TODO Auto-generated method stub
		return this;
	}

}
