package com.zsxy.activity;

import android.content.Context;

/*
 * ������Activityʵ�ֵĽӿ�
 * */

public interface CourseLoginControllerListener {
	public void onLoginSuccess(String studentId, String studentPassword); //��½�ɹ�ʱ����

	public void onLoginCancel(); // ȡ����½ʱ����

	public Context getContext();//����Context����
}
