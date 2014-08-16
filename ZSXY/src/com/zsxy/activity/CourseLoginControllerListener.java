package com.zsxy.activity;

import android.content.Context;

/*
 * 定义让Activity实现的接口
 * */

public interface CourseLoginControllerListener {
	public void onLoginSuccess(String studentId, String studentPassword); //登陆成功时调用

	public void onLoginCancel(); // 取消登陆时调用

	public Context getContext();//返回Context对象
}
