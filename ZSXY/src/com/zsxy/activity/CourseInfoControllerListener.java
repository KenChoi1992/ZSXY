package com.zsxy.activity;

import android.content.Context;

/*
 * 定义让Activity实现的接口
 * */
public interface CourseInfoControllerListener {
	public void onClickBack(); // 返回按钮的相应函数

	public Context getContext(); // 获得Context
}
