package com.zsxy.activity.implementation;

import com.zsxy.R;
import com.zsxy.activity.MainControllerListener;
import com.zsxy.controller.MainController;
import com.zsxy.view.MainView;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;

/*
 * 这是主界面的Activity，负责显示界面间的跳转
 * */

public class MainActivity extends FragmentActivity implements
		MainControllerListener {

	private MainController m_mainController;
	private MainView m_mainView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		m_mainView = (MainView) findViewById(R.id.mainView);
		m_mainView.initModule();
		m_mainController = new MainController(m_mainView, this);

		m_mainView.setOnClickListener(m_mainController);
		m_mainView.setOnPageChangeListener(m_mainController);
	}

	@Override
	public FragmentManager getSupportFragmentManger() {
		// TODO Auto-generated method stub
		return getSupportFragmentManager();
	}

}
