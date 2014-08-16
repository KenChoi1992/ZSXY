package com.zsxy.controller;

import com.zsxy.R;
import com.zsxy.activity.CourseLoginControllerListener;
import com.zsxy.view.CourseLoginView;

import android.view.View;
import android.view.View.OnClickListener;

public class CourseLoginController implements OnClickListener {
	
	private int m_int_which;

	private CourseLoginView m_courseLoginView;
	private CourseLoginControllerListener m_listener;

	public CourseLoginController(CourseLoginView courseLoginView,
			CourseLoginControllerListener listener, int which) {
		this.m_courseLoginView = courseLoginView;
		this.m_listener = listener;
		this.m_int_which = which;
		setTitle(m_int_which);
	}
	
	public void setTitle(int which){
		if(which == 1){
			m_courseLoginView.setTitleText("连接教务系统，更新至最新课表");
		}
		if(which == 2){
			m_courseLoginView.setTitleText("请登录获取最新成绩");
		}
	}

	// 点击登录按钮
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_submit:
			if (m_courseLoginView.getStudentId().isEmpty()
					|| m_courseLoginView.getStudentId().equals("")) {
				m_courseLoginView.studentIdError(m_listener.getContext());
				break;
			}
			if (m_courseLoginView.getStudentPassword().isEmpty()
					|| m_courseLoginView.getStudentPassword().equals("")) {
				m_courseLoginView.studentPasswordError(m_listener.getContext());
				break;
			}
			// 登录成功后显示课表
			m_listener.onLoginSuccess(m_courseLoginView.getStudentId(),
					m_courseLoginView.getStudentPassword());
			break;
		case R.id.login_cancel:
			m_listener.onLoginCancel();
			break;
		}

	}

}
