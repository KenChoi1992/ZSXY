package com.zsxy.controller;

import java.util.ArrayList;
import java.util.List;

import com.zsxy.activity.CourseScheduleControllerListener;
import com.zsxy.adapter.WeekListAdapter;
import com.zsxy.database.DatabaseManager;
import com.zsxy.tools.GetDate;
import com.zsxy.view.CourseScheduleView;
import com.zsxy.view.CourseWeekView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class CourseWeekController implements OnItemClickListener {
	// 数据库操作
	private DatabaseManager m_databaseManager;

	private String[] m_str_weekNum;

	private int m_int_width;

	private CourseWeekView m_courseWeekView;
	private CourseScheduleControllerListener m_listener;
	private CourseScheduleController m_courseScheduleController;
	private GetDate m_getDate;
	private CourseScheduleView m_courseScheduleView;
	boolean m_isWeek = false; // 判断是否按星期查询课表

	public CourseWeekController(CourseWeekView m_courseWeekView,
			CourseScheduleControllerListener m_listener,
			CourseScheduleView m_courseScheduleView, int width,
			CourseScheduleController m_courseScheduleController) {
		this.m_courseWeekView = m_courseWeekView;
		this.m_listener = m_listener;
		this.m_courseScheduleView = m_courseScheduleView;
		this.m_int_width = width;
		this.m_courseScheduleController =m_courseScheduleController;
		this.m_getDate = new GetDate();

		m_databaseManager = new DatabaseManager(m_listener.getContext());

		initAdapter();
	}

	public void initAdapter() {
		m_str_weekNum = new String[] { "第一周", "第二周", "第三周", "第四周", "第五周",
				"第六周", "第七周", "第八周", "第九周", "第十周", "第十一周", "第十二周", "第十三周",
				"第十四周", "第十五周", "第十六周", "第十七周", "第十八周", "第十九周", "第二十周",
				"第二十一周", "第二十二周", "第二十三周" };
		List<String> l_listItem = new ArrayList<String>();
		for (int i = 0; i < m_str_weekNum.length; i++) {
			l_listItem.add(m_str_weekNum[i]);
		}
		WeekListAdapter m_weekListAdapter = new WeekListAdapter(
				m_listener.getContext(), l_listItem);
		m_courseWeekView.setAdapter(m_weekListAdapter);
	}

	@Override
	public void onItemClick(AdapterView<?> viewAdapter, View view,
			int position, long id) {
		m_isWeek = true;
		// 点击设置第几周
		m_courseScheduleView.cleanClass(m_int_width);
		m_courseScheduleView.setClass(true, 0,
				m_databaseManager.queryCourseByWeek(position + 1), m_int_width);
		m_courseScheduleView.setWeekText(m_str_weekNum[position]);
		//改变课程日期
		m_courseScheduleController.changeDate(position);
		m_listener.dismissWeekWindow();
	}

}
