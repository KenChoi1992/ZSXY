package com.zsxy.view;

import com.zsxy.R;

import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CourseWeekView {
	private ListView m_week_list = null;
	private View m_mainView;

	public CourseWeekView(View view) {
		this.m_mainView = view;
	}

	public void initModule() {
		m_week_list = (ListView) m_mainView.findViewById(R.id.week_list);
	}

	public void setAdapter(ListAdapter adapter) {
		m_week_list.setAdapter(adapter);
	}

	public void setListeners(OnItemClickListener onClickListener) {
		m_week_list.setOnItemClickListener(onClickListener);
	}

}
