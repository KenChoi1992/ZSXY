package com.zsxy.view;

import com.zsxy.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ScoreInfoView extends LinearLayout {

	private ImageView m_imgView_back;
	private ListView m_lVi_scoreList;

	public ScoreInfoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void initModule() {
		m_imgView_back = (ImageView) findViewById(R.id.back);
		m_lVi_scoreList = (ListView) findViewById(R.id.scoreList);
	}

	public void setAdapter(ListAdapter adapter) {
		m_lVi_scoreList.setAdapter(adapter);
	}

	public void setOnClickListener(OnClickListener onclickListener) {
		m_imgView_back.setOnClickListener(onclickListener);
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		m_lVi_scoreList.setOnItemClickListener(listener);
	}
}
