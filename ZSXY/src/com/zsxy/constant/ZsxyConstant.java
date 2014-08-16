package com.zsxy.constant;

public class ZsxyConstant {
	public final static int ADD_REQUEST_CODE = 1; // 点击增加课表按钮的Tag
	public final static int REFRESH_REQUEST_CODE = 2;// 点击更新按钮的Tag

	public final static int COURSE_CANCEL_RESULT_CODE = 1;
	public final static int SCORE_CANCEL_RESULT_CODE = 2;
	public final static int CANCEL_REQUEST_CODE = 1;
	public final static int COURSE_SURE_RESULT_CODE = 3;
	public final static int SCORE_SURE_RESULT_CODE = 4;
	public final static int SURE_REQUEST_CODE = 2;

	public final static String COURSE_BROADCAST = "course";// 确定了学号和密码发送的获得课程的广播
	public final static String SCORE_BROADCAST = "score";// 确定了学号和密码发送的获得成绩的广播
	public final static String COURSE_CANCEL_BROADCAST = "courseCancel";// 取消登陆时发送的广播
	public final static String SCORE_CANCEL_BROADCAST = "scoreCancel";// 取消登陆时发送的广播
	public final static String CANCEL_BROADCAST = "scoreCancel";// 登陆消失时发送的广播
	

	// 参数传递的Tag
	public final static String IS_SHOW = "isShow";
	public final static String STUDENT_ID = "studentId";
	public final static String STUDENT_PASSWORD = "studentPassword";

	// 启动CourseInfoActivity传递的参数
	public final static String WEEK_NUM = "weekNum";
	public final static String START_TIME = "startTime";
	public final static String WEEK = "week";

	public final static String LOGIN_FOR_WHICH = "which";
}
