package com.zsxy.activity.implementation;

import com.zsxy.R;
import com.zsxy.activity.CourseLoginControllerListener;
import com.zsxy.constant.ZsxyConstant;
import com.zsxy.controller.CourseLoginController;
import com.zsxy.view.CourseLoginView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/*
 * 这是登陆弹出窗空界面的Activity
 * */

public class CourseLoginActivity extends Activity implements
		CourseLoginControllerListener {

	private boolean m_judge;

	private int m_int_which;

	private CourseLoginView m_courseLogin = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		m_judge = false;

		m_int_which = getIntent().getIntExtra(ZsxyConstant.LOGIN_FOR_WHICH, 0);

		m_courseLogin = (CourseLoginView) findViewById(R.id.course_login);
		m_courseLogin.initModule();
		CourseLoginController l_courseLoginController = new CourseLoginController(
				m_courseLogin, this, m_int_which);
		m_courseLogin.setListeners(l_courseLoginController);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (m_int_which == 1 && !m_judge) {
			Intent intent = new Intent(ZsxyConstant.COURSE_CANCEL_BROADCAST);
			this.sendBroadcast(intent);
		}
		if (m_int_which == 2 && !m_judge) {
			Intent intent = new Intent(ZsxyConstant.SCORE_CANCEL_BROADCAST);
			this.sendBroadcast(intent);
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	// 登录成功，显示课表
	@Override
	public void onLoginSuccess(String studentId, String studentPassword) {
		Intent intent = new Intent();
		intent.putExtra(ZsxyConstant.STUDENT_ID, studentId);
		intent.putExtra(ZsxyConstant.STUDENT_PASSWORD, studentPassword);
		if (m_int_which == 1) {
			setResult(ZsxyConstant.COURSE_SURE_RESULT_CODE, intent);
			m_judge = true;
		}
		if (m_int_which == 2) {
			setResult(ZsxyConstant.SCORE_SURE_RESULT_CODE, intent);
			m_judge = true;
		}
		finish();
	}

	// 在登录学号窗口点击取消按钮，返回
	@Override
	public void onLoginCancel() {
		Intent intent = new Intent();
		intent.putExtra(ZsxyConstant.LOGIN_FOR_WHICH, m_int_which);
		if (m_int_which == 1) {
			setResult(ZsxyConstant.COURSE_CANCEL_RESULT_CODE, intent);
		}
		if (m_int_which == 2) {
			setResult(ZsxyConstant.SCORE_CANCEL_RESULT_CODE, intent);
		}
		finish();
	}

	@Override
	public Context getContext() {
		return this;
	}

}
