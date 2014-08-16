package com.zsxy.view;

import java.util.List;

import com.zsxy.R;
import com.zsxy.models.Courses;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourseInfoView extends LinearLayout {

	private ImageView m_imgView_back = null;
	private TextView m_txt_title = null;
	private TextView m_txt_lesson_name = null;
	private TextView m_txt_classroom = null;
	private TextView m_txt_teacher = null;
	private TextView m_txt_lesson_number = null;
	private TextView m_txt_week_number = null;
	private String m_week;

	public CourseInfoView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	// 初始化相应的控件和变量
	public void initModule() {
		m_imgView_back = (ImageView) findViewById(R.id.back);
		m_txt_title = (TextView) findViewById(R.id.title);
		m_txt_lesson_name = (TextView) findViewById(R.id.lesson_name);
		m_txt_classroom = (TextView) findViewById(R.id.classroom);
		m_txt_teacher = (TextView) findViewById(R.id.teacher);
		m_txt_lesson_number = (TextView) findViewById(R.id.lesson_number);
		m_txt_week_number = (TextView) findViewById(R.id.week_number);
	}

	// 点击课表上某个TextView时调用，设置课表的显示信息
	public void ShowInfo(List<Courses> query, String weekNum) {
		for (Courses course : query) {
			m_txt_title.setText(course.getLessonName());
			m_txt_lesson_name.setText(course.getLessonName());
			m_txt_classroom.setText(course.getLessonClassroom());
			m_txt_teacher.setText(course.getLessonTeachBy());
			m_txt_lesson_number.setText(JudgeWeek(m_week) + " 第"
					+ course.getLessonTime() + "节");
			m_txt_week_number.setText(weekNum);
		}
	}

	// 根据传过来的参数选择要显示的周几
	private String JudgeWeek(String week) {
		if ("Mon".equals(week))
			return "周一";
		if ("Tue".equals(week))
			return "周二";
		if ("Wed".equals(week))
			return "周三";
		if ("Thu".equals(week))
			return "周四";
		if ("Fri".equals(week))
			return "周五";
		if ("Sat".equals(week))
			return "周六";
		if ("Sun".equals(week))
			return "周日";
		return null;
	}

	// 监听点击事件
	public void setListener(OnClickListener onClickListener) {
		m_imgView_back = (ImageView) findViewById(R.id.back);
		m_imgView_back.setOnClickListener(onClickListener);
	}

}
