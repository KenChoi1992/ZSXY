package com.zsxy.adapter;

import java.util.List;

import com.zsxy.R;
import com.zsxy.models.Score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ZsxyListAdapter extends BaseAdapter {
	/**
	 * 该类是显示成绩的ListView的Adapter
	 * */

	private List<Score> m_ScoreList;
	private LayoutInflater m_Inflater;

	private TextView m_txtScoreLessonFromTo; // 学年
	private TextView m_txtScoreName;// 课程名称
	private TextView m_txtScoreTerm; // 学期
	private TextView m_txtScoreValue;// 成绩
	private TextView m_txtScoreReexamValue;// 补考成绩

	public ZsxyListAdapter() {
		// TODO Auto-generated constructor stub
	}

	public ZsxyListAdapter(Context m_Context, List<Score> m_ScoreList) {
		super();
		this.m_ScoreList = m_ScoreList;

		m_Inflater = LayoutInflater.from(m_Context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return m_ScoreList.size();
	}

	@Override
	public Object getItem(int index) {
		// TODO Auto-generated method stub
		return m_ScoreList.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		if (view == null) {
			view = m_Inflater.inflate(R.layout.score_list_item, null);
		}
		m_txtScoreLessonFromTo = (TextView) view.findViewById(R.id.xuenian);
		m_txtScoreName = (TextView) view.findViewById(R.id.kecheng);
		m_txtScoreTerm = (TextView) view.findViewById(R.id.xueqi);
		m_txtScoreValue = (TextView) view.findViewById(R.id.chengji);
		m_txtScoreReexamValue = (TextView) view.findViewById(R.id.bukao);

		Score score = m_ScoreList.get(position);
		if (position % 2 == 1) {
			m_txtScoreLessonFromTo.setBackgroundResource(R.color.zsxyLinetwo1);
			m_txtScoreName.setBackgroundResource(R.color.zsxyLinetwo2);
			m_txtScoreTerm.setBackgroundResource(R.color.zsxyLinetwo1);
			m_txtScoreValue.setBackgroundResource(R.color.zsxyLinetwo2);
			m_txtScoreReexamValue.setBackgroundResource(R.color.zsxyLinetwo1);
		} else {
			m_txtScoreLessonFromTo.setBackgroundResource(R.color.zsxyLineOne1);
			m_txtScoreName.setBackgroundResource(R.color.zsxyLineOne2);
			m_txtScoreTerm.setBackgroundResource(R.color.zsxyLineOne1);
			m_txtScoreValue.setBackgroundResource(R.color.zsxyLineOne2);
			m_txtScoreReexamValue.setBackgroundResource(R.color.zsxyLineOne1);
		}

		m_txtScoreLessonFromTo.setText(score.getM_ScoreLessonFromTo());
		m_txtScoreName.setText(score.getM_ScoreName());
		m_txtScoreTerm.setText(score.getM_ScoreTerm());
		m_txtScoreValue.setText(score.getM_ScoreValue());
		m_txtScoreReexamValue.setText(score.getM_ScoreReexamValue());

		return view;
	}
}
