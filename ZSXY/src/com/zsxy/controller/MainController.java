package com.zsxy.controller;

import java.util.ArrayList;
import java.util.List;

import com.zsxy.R;
import com.zsxy.activity.MainControllerListener;
import com.zsxy.activity.implementation.CourseScheduleActivity;
import com.zsxy.activity.implementation.DiscoveryActivity;
import com.zsxy.activity.implementation.PortalActivity;
import com.zsxy.activity.implementation.ServiceActivity;
import com.zsxy.adapter.ZsxyViewPagerAdapter;
import com.zsxy.view.MainView;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;

public class MainController implements OnClickListener, OnPageChangeListener {

	private MainView m_mainView;
	private MainControllerListener m_mainListener;

	// ∂®“ÂFragment
	private PortalActivity m_portal;
	private DiscoveryActivity m_discovery;
	private ServiceActivity m_service;
	private CourseScheduleActivity m_courseSchedule;

	private List<Fragment> m_fragmentList;

	private ZsxyViewPagerAdapter m_viewPagerAdapter;

	public MainController(MainView mainView, MainControllerListener mainListener) {
		this.m_mainView = mainView;
		this.m_mainListener = mainListener;

		setViewPager();
	}

	private void setViewPager() {
		m_portal = new PortalActivity();
		m_discovery = new DiscoveryActivity();
		m_service = new ServiceActivity();
		m_courseSchedule = new CourseScheduleActivity();

		m_fragmentList = new ArrayList<Fragment>();
		m_fragmentList.add(m_portal);
		m_fragmentList.add(m_discovery);
		m_fragmentList.add(m_service);
		m_fragmentList.add(m_courseSchedule);

		m_viewPagerAdapter = new ZsxyViewPagerAdapter(
				m_mainListener.getSupportFragmentManger(), m_fragmentList);
		m_mainView.setViewPagerAdapter(m_viewPagerAdapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.protal:
			m_mainView.setCurrentItem(0);
			break;
		case R.id.discovery:
			m_mainView.setCurrentItem(1);
			break;
		case R.id.service:
			m_mainView.setCurrentItem(2);
			break;
		case R.id.schedule:
			m_mainView.setCurrentItem(3);
			break;
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int index) {
		// TODO Auto-generated method stub
		m_mainView.setTitleColor(index);
	}

}
