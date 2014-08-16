package com.zsxy.activity;

import android.content.Context;

/*
 * 定义让Activity实现的接口
 * */

public interface CourseScheduleControllerListener {
	public Context getContext(); // 返回Context变量

	public void showUserWindow(); // 显示用户的弹出窗口

	public void showLoginWindow(int which); // 显示登陆的弹出窗口

	public void showWeekWindow(); // 显示星期的弹出窗口

	public void startScoreInfoActivity();// 跳转到成绩显示的页面

	public void dismissWeekWindow();// dismiss weekPopupWindow

	public void dismissUserWindow();// dismiss userPopupWindow

	public void startSourseInfoActivity(int startTime, String week);// 显示课程的详细信息

}
