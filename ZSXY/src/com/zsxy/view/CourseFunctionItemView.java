package com.zsxy.view;

import com.zsxy.R;

import android.view.View;
import android.view.View.OnClickListener;

public class CourseFunctionItemView {

	private View m_mainView;

	private ZsxyTextView m_txt_search = null;
	private ZsxyTextView m_txt_homework = null;
	private ZsxyTextView m_txt_notification = null;
	private ZsxyTextView m_txt_partner = null;
	private ZsxyTextView m_txt_set = null;

	public CourseFunctionItemView(View view) {
		this.m_mainView = view;
	}

	public void initModule() {
		m_txt_search = (ZsxyTextView) m_mainView.findViewById(R.id.search);
		m_txt_homework = (ZsxyTextView) m_mainView.findViewById(R.id.homework);
		m_txt_notification = (ZsxyTextView) m_mainView
				.findViewById(R.id.notification);
		m_txt_partner = (ZsxyTextView) m_mainView.findViewById(R.id.partner);
		m_txt_set = (ZsxyTextView) m_mainView.findViewById(R.id.set);
	}

	public void setListeners(OnClickListener onClickListener) {
		m_txt_search.setOnClickListener(onClickListener);
		m_txt_homework.setOnClickListener(onClickListener);
		m_txt_notification.setOnClickListener(onClickListener);
		m_txt_partner.setOnClickListener(onClickListener);
		m_txt_set.setOnClickListener(onClickListener);
	}

}
