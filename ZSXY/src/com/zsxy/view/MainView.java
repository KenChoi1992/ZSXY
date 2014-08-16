package com.zsxy.view;

import com.zsxy.R;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainView extends RelativeLayout {

	private TextView[] m_txt_List;
	private int[] m_textViewListId;
	private ViewPager m_viewPager;

	public MainView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MainView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	// ��ʼ����Ӧ�Ŀؼ��ͱ���
	public void initModule() {
		m_viewPager = (ViewPager) findViewById(R.id.viewpager);

		m_textViewListId = new int[] { R.id.protal, R.id.discovery,
				R.id.service, R.id.schedule };
		m_txt_List = new TextView[4];
		for (int i = 0; i < 4; i++) {
			m_txt_List[i] = (TextView) findViewById(m_textViewListId[i]);
		}
		
		m_txt_List[0].setBackgroundResource(R.color.zsxyBlue);
	}

	// ΪViewPager�������
	public void setViewPagerAdapter(FragmentPagerAdapter adapter) {
		m_viewPager.setAdapter(adapter);
	}

	// Ϊ�����TextView��Ӽ�����
	public void setOnClickListener(OnClickListener onclickListener) {
		for (int i = 0; i < m_textViewListId.length; i++) {
			m_txt_List[i].setOnClickListener(onclickListener);
		}
	}

	// ΪViewPager��Ӽ�����
	public void setOnPageChangeListener(OnPageChangeListener onPageChangListener) {
		m_viewPager.setOnPageChangeListener(onPageChangListener);
	}

	// ����ҳ�����ת
	public void setCurrentItem(int index) {
		m_viewPager.setCurrentItem(index);
	}

	// ���������TextView�������ɫ
	public void setTitleColor(int index) {
		for (int i = 0; i < 4; i++) {
			if (index == i)
				m_txt_List[i].setBackgroundResource(R.color.zsxyBlue);
			else
				m_txt_List[i].setBackgroundResource(R.color.white);
		}
	}
}
