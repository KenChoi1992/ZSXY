package com.zsxy.adapter;

import java.util.List;

import com.zsxy.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WeekListAdapter extends BaseAdapter {

	private LayoutInflater m_Inflater;
	List<String> m_listItem;
	TextView m_txt_weekNum;

	public WeekListAdapter(Context context, List<String> listItem) {
		this.m_Inflater = LayoutInflater.from(context);
		this.m_listItem = listItem;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return m_listItem.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return m_listItem.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = m_Inflater.inflate(com.zsxy.R.layout.week_list_item, null);
		}
		m_txt_weekNum = (TextView)convertView.findViewById(R.id.week_num);
		m_txt_weekNum.setText(m_listItem.get(position).toString());
		return convertView;
	}

}
