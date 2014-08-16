package com.zsxy.activity.implementation;

import com.zsxy.R;
import com.zsxy.activity.ScoreInfoControllerListener;
import com.zsxy.controller.ScoreInfoController;
import com.zsxy.view.ScoreInfoView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

/*
 * 这是查询分数时界面的Activity
 * */

public class ScoreInfoActivity extends Activity implements
		ScoreInfoControllerListener {

	private ScoreInfoView m_scoreInfoView;
	private ScoreInfoController m_scoreInfoController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_score);

		m_scoreInfoView = (ScoreInfoView) findViewById(R.id.scoreInfo);
		m_scoreInfoView.initModule();
		m_scoreInfoController = new ScoreInfoController(m_scoreInfoView, this);

		m_scoreInfoView.setOnClickListener(m_scoreInfoController);
	}

	@Override
	public Context getContext() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void scoreFinish() {
		// TODO Auto-generated method stub
		this.finish();
	}

}
