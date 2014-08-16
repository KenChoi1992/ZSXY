package com.zsxy.activity;

import android.content.Context;

/*
 * ������Activityʵ�ֵĽӿ�
 * */

public interface CourseScheduleControllerListener {
	public Context getContext(); // ����Context����

	public void showUserWindow(); // ��ʾ�û��ĵ�������

	public void showLoginWindow(int which); // ��ʾ��½�ĵ�������

	public void showWeekWindow(); // ��ʾ���ڵĵ�������

	public void startScoreInfoActivity();// ��ת���ɼ���ʾ��ҳ��

	public void dismissWeekWindow();// dismiss weekPopupWindow

	public void dismissUserWindow();// dismiss userPopupWindow

	public void startSourseInfoActivity(int startTime, String week);// ��ʾ�γ̵���ϸ��Ϣ

}
