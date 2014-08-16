package com.zsxy.activity;

import android.content.Context;

/*
 * 定义让Activity实现的接口
 * */

public interface ScoreInfoControllerListener {
	public Context getContext();// 获得Context对象

	public void scoreFinish();// 解锁Activity的生命周期
}
