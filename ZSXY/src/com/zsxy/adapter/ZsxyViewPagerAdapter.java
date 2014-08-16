package com.zsxy.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class ZsxyViewPagerAdapter extends FragmentPagerAdapter {

	//private FragmentManager m_fragmentManager;
	private List<Fragment> m_fragmList;

	public ZsxyViewPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
		//m_fragmentManager = fm;
	}

	public ZsxyViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
		super(fm);
		//this.m_fragmentManager = fm;
		this.m_fragmList = fragmentList;
	}

	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		return m_fragmList.get(index);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return m_fragmList.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		return super.instantiateItem(container, position);
	}

}
