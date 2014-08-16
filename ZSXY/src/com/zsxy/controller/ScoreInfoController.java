package com.zsxy.controller;

import com.zsxy.R;
import com.zsxy.activity.ScoreInfoControllerListener;
import com.zsxy.adapter.ZsxyListAdapter;
import com.zsxy.database.DatabaseManager;
import com.zsxy.view.ScoreInfoView;

import android.view.View;
import android.view.View.OnClickListener;

public class ScoreInfoController implements OnClickListener {

	private ScoreInfoControllerListener m_listener;
	private ScoreInfoView m_scoreView;

	private ZsxyListAdapter m_scoreAdapter;

	private DatabaseManager m_databaseManager;

	public ScoreInfoController(ScoreInfoView scoreInfoView,
			ScoreInfoControllerListener scoreListener) {
		this.m_listener = scoreListener;
		this.m_scoreView = scoreInfoView;

		init();
	}

	private void init() {
		m_databaseManager = new DatabaseManager(m_listener.getContext());
		m_scoreAdapter = new ZsxyListAdapter(m_listener.getContext(),
				m_databaseManager.queryAllScore());
		m_scoreView.setAdapter(m_scoreAdapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			m_listener.scoreFinish();
			break;
		}
	}

}
