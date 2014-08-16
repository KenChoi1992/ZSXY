package com.zsxy.activity.implementation;

import com.zsxy.R;
import com.zsxy.activity.PortalControllerListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 * 这是门户界面的Activity
 * */

public class PortalActivity extends Fragment implements
		PortalControllerListener {

	private View m_mainView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LayoutInflater layoutInflater = getActivity().getLayoutInflater();
		m_mainView = layoutInflater.inflate(R.layout.activity_portal,
				(ViewGroup) getActivity().findViewById(R.layout.activity_main),
				false);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ViewGroup p = (ViewGroup) m_mainView.getParent();
		if (p != null) {
			p.removeAllViewsInLayout();
		}
		return m_mainView;
	}

}
