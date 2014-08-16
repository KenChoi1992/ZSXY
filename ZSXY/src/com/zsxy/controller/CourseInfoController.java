package com.zsxy.controller;

import java.util.List;

import com.zsxy.activity.CourseInfoControllerListener;
import com.zsxy.database.DatabaseManager;
import com.zsxy.models.Courses;
import com.zsxy.view.CourseInfoView;

import android.view.View;
import android.view.View.OnClickListener;

public class CourseInfoController implements OnClickListener {

	private CourseInfoView m_courseInfoView;
	private CourseInfoControllerListener m_courseInfo_listener;

	private DatabaseManager m_databaseManager;

	private int m_int_startTime;
	private String m_str_week;

	public CourseInfoController(CourseInfoView courseInfoView,
			CourseInfoControllerListener courseInfo_listener) {
		this.m_courseInfoView = courseInfoView;
		this.m_courseInfo_listener = courseInfo_listener;

		init();
	}

	public void init() {
		m_databaseManager = new DatabaseManager(
				m_courseInfo_listener.getContext());
	}

	public void getParams(int startTime, String week) {
		this.m_int_startTime = startTime;
		this.m_str_week = week;

		queryScore();
	}

	public void queryScore() {

		List<Courses> query = m_databaseManager.queryCourseByTime(
				m_int_startTime, m_str_week);
		m_courseInfoView.ShowInfo(query, m_str_week);
	}

	@Override
	public void onClick(View v) {
		m_courseInfo_listener.onClickBack();
	}

}
