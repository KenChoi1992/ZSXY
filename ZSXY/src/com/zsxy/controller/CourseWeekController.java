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
	// ���ݿ����
	private DatabaseManager m_databaseManager;

	private String[] m_str_weekNum;

	private int m_int_width;

	private CourseWeekView m_courseWeekView;
	private CourseScheduleControllerListener m_listener;
	private CourseScheduleController m_courseScheduleController;
	private GetDate m_getDate;
	private CourseScheduleView m_courseScheduleView;
	boolean m_isWeek = false; // �ж��Ƿ����ڲ�ѯ�α�

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
		m_str_weekNum = new String[] { "��һ��", "�ڶ���", "������", "������", "������",
				"������", "������", "�ڰ���", "�ھ���", "��ʮ��", "��ʮһ��", "��ʮ����", "��ʮ����",
				"��ʮ����", "��ʮ����", "��ʮ����", "��ʮ����", "��ʮ����", "��ʮ����", "�ڶ�ʮ��",
				"�ڶ�ʮһ��", "�ڶ�ʮ����", "�ڶ�ʮ����" };
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
		// ������õڼ���
		m_courseScheduleView.cleanClass(m_int_width);
		m_courseScheduleView.setClass(true, 0,
				m_databaseManager.queryCourseByWeek(position + 1), m_int_width);
		m_courseScheduleView.setWeekText(m_str_weekNum[position]);
		//�ı�γ�����
		m_courseScheduleController.changeDate(position);
		m_listener.dismissWeekWindow();
	}

}
