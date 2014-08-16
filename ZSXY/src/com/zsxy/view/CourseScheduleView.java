package com.zsxy.view;

import java.util.List;

import com.zsxy.R;
import com.zsxy.models.Courses;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class CourseScheduleView extends LinearLayout {

	private OnClickListener m_onclickListener;

	private int[][] courseScheduleColor;// 课程背景图片数组

	// 定义activity_schedule里面的控件
	private TextView m_txt_Weeks;
	private RelativeLayout mAddLayout;
	private ScrollView m_sclVi_ShowSchedule;
	private ImageView m_imgView_AddSchedule;
	private ImageView m_imgView_User;
	private ImageView m_imgView_Login;

	// 课表每个格子的获得
	private ZsxyTextView[] m_txt_Week;
	private ZsxyTextView[] m_txt_Serial;
	private ZsxyTextView[] m_txt_Mon;
	private ZsxyTextView[] m_txt_Tuse;
	private ZsxyTextView[] m_txt_Wed;
	private ZsxyTextView[] m_txt_Thur;
	private ZsxyTextView[] m_txt_Fri;
	private ZsxyTextView[] m_txt_Sat;
	private ZsxyTextView[] m_txt_Sun;

	private int[] m_int_weekId;
	private int[] m_int_serialId;
	private int[] m_int_monId;
	private int[] m_int_tuesId;
	private int[] m_int_wedId;
	private int[] m_int_thurId;
	private int[] m_int_friId;
	private int[] m_int_satId;
	private int[] m_int_sunId;

	public CourseScheduleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	// 初始化相应的控件和变量
	public void initModule() {

		// 控件的初始化
		m_txt_Weeks = (TextView) findViewById(R.id.weeks);
		m_imgView_User = (ImageView) findViewById(R.id.imageView1);
		m_imgView_Login = (ImageView) findViewById(R.id.imageView3);
		mAddLayout = (RelativeLayout) findViewById(R.id.scheduleInit);
		m_imgView_AddSchedule = (ImageView) findViewById(R.id.addSchedule);
		m_sclVi_ShowSchedule = (ScrollView) findViewById(R.id.schedule);

		// 课程格子ID的初始化
		m_int_weekId = new int[] { R.id.week1, R.id.week2,
				R.id.week3, R.id.week4, R.id.week5, R.id.week6, R.id.week7, R.id.month};
		m_int_serialId = new int[] { R.id.serial1, R.id.serial2, R.id.serial3,
				R.id.serial4, R.id.serial5, R.id.serial6, R.id.serial7,
				R.id.serial8, R.id.serial9, R.id.serial10, R.id.serial11,
				R.id.serial12 };
		m_int_monId = new int[] { R.id.mon1, R.id.mon2, R.id.mon3, R.id.mon4,
				R.id.mon5, R.id.mon6, R.id.mon7, R.id.mon8, R.id.mon9,
				R.id.mon10, R.id.mon11, R.id.mon12 };
		m_int_tuesId = new int[] { R.id.Tues1, R.id.Tues2, R.id.Tues3,
				R.id.Tues4, R.id.Tues5, R.id.Tues6, R.id.Tues7, R.id.Tues8,
				R.id.Tues9, R.id.Tues10, R.id.Tues11, R.id.Tues12 };
		m_int_wedId = new int[] { R.id.Wed1, R.id.Wed2, R.id.Wed3, R.id.Wed4,
				R.id.Wed5, R.id.Wed6, R.id.Wed7, R.id.Wed8, R.id.Wed9,
				R.id.Wed10, R.id.Wed11, R.id.Wed12 };
		m_int_thurId = new int[] { R.id.Thur1, R.id.Thur2, R.id.Thur3,
				R.id.Thur4, R.id.Thur5, R.id.Thur6, R.id.Thur7, R.id.Thur8,
				R.id.Thur9, R.id.Thur10, R.id.Thur11, R.id.Thur12 };
		m_int_friId = new int[] { R.id.Fri1, R.id.Fri2, R.id.Fri3, R.id.Fri4,
				R.id.Fri5, R.id.Fri6, R.id.Fri7, R.id.Fri8, R.id.Fri9,
				R.id.Fri10, R.id.Fri11, R.id.Fri12 };
		m_int_satId = new int[] { R.id.Sat1, R.id.Sat2, R.id.Sat3, R.id.Sat4,
				R.id.Sat5, R.id.Sat6, R.id.Sat7, R.id.Sat8, R.id.Sat9,
				R.id.Sat10, R.id.Sat11, R.id.Sat12 };
		m_int_sunId = new int[] { R.id.Sun1, R.id.Sun2, R.id.Sun3, R.id.Sun4,
				R.id.Sun5, R.id.Sun6, R.id.Sun7, R.id.Sun8, R.id.Sun9,
				R.id.Sun10, R.id.Sun11, R.id.Sun12 };

		// 课程格子的控件的获取
		m_txt_Week = new ZsxyTextView[m_int_weekId.length];
		for (int i = 0; i < m_int_weekId.length; i++) {
			m_txt_Week[i] = (ZsxyTextView) findViewById(m_int_weekId[i]);
		}

		m_txt_Serial = new ZsxyTextView[m_int_serialId.length];
		for (int i = 0; i < m_int_serialId.length; i++) {
			m_txt_Serial[i] = (ZsxyTextView) findViewById(m_int_serialId[i]);
		}

		m_txt_Mon = new ZsxyTextView[m_int_monId.length];
		for (int i = 0; i < m_int_monId.length; i++) {
			m_txt_Mon[i] = (ZsxyTextView) findViewById(m_int_monId[i]);
		}

		m_txt_Tuse = new ZsxyTextView[m_int_tuesId.length];
		for (int i = 0; i < m_int_tuesId.length; i++) {
			m_txt_Tuse[i] = (ZsxyTextView) findViewById(m_int_tuesId[i]);
		}

		m_txt_Wed = new ZsxyTextView[m_int_wedId.length];
		for (int i = 0; i < m_int_wedId.length; i++) {
			m_txt_Wed[i] = (ZsxyTextView) findViewById(m_int_wedId[i]);
		}

		m_txt_Thur = new ZsxyTextView[m_int_thurId.length];
		for (int i = 0; i < m_int_thurId.length; i++) {
			m_txt_Thur[i] = (ZsxyTextView) findViewById(m_int_thurId[i]);
		}

		m_txt_Fri = new ZsxyTextView[m_int_friId.length];
		for (int i = 0; i < m_int_friId.length; i++) {
			m_txt_Fri[i] = (ZsxyTextView) findViewById(m_int_friId[i]);
		}

		m_txt_Sat = new ZsxyTextView[m_int_satId.length];
		for (int i = 0; i < m_int_satId.length; i++) {
			m_txt_Sat[i] = (ZsxyTextView) findViewById(m_int_satId[i]);
		}

		m_txt_Sun = new ZsxyTextView[m_int_sunId.length];
		for (int i = 0; i < m_int_sunId.length; i++) {
			m_txt_Sun[i] = (ZsxyTextView) findViewById(m_int_sunId[i]);
		}

		// 课表背景颜色
		courseScheduleColor = new int[][] {
				{ R.drawable.onege_1, R.drawable.onege_2, R.drawable.onege_3,
						R.drawable.onege_4, R.drawable.onege_5,
						R.drawable.onege_6, R.drawable.onege_7,
						R.drawable.onege_8, R.drawable.onege_9,
						R.drawable.onege_10, R.drawable.onege_11,
						R.drawable.onege_12, R.drawable.onege_13,
						R.drawable.onege_14 },
				{ R.drawable.twoge_1, R.drawable.twoge_2, R.drawable.twoge_3,
						R.drawable.twoge_4, R.drawable.twoge_5,
						R.drawable.twoge_6, R.drawable.twoge_7,
						R.drawable.twoge_8, R.drawable.twoge_9,
						R.drawable.twoge_10, R.drawable.twoge_11,
						R.drawable.twoge_12, R.drawable.twoge_13,
						R.drawable.twoge_14 },
				{ R.drawable.threege_1, R.drawable.threege_2,
						R.drawable.threege_3, R.drawable.threege_4,
						R.drawable.threege_5, R.drawable.threege_6,
						R.drawable.threege_7, R.drawable.threege_8,
						R.drawable.threege_9, R.drawable.threege_10,
						R.drawable.threege_11, R.drawable.threege_12,
						R.drawable.threege_13, R.drawable.threege_14 } };
	}

	// 为控件设定监听器
	public void setOnClickListener(OnClickListener onClickListener) {
		this.m_onclickListener = onClickListener;
		m_txt_Weeks.setOnClickListener(onClickListener);
		m_imgView_AddSchedule.setOnClickListener(onClickListener);
		m_imgView_Login.setOnClickListener(onClickListener);
		m_imgView_User.setOnClickListener(onClickListener);
	}

	// 设置周数的显示
	public void setWeekText(String week) {
		m_txt_Weeks.setText(week);
	}

	// 设置显示课表
	public void showCourseSchedule() {
		mAddLayout.setVisibility(View.GONE);
		m_sclVi_ShowSchedule.setVisibility(View.VISIBLE);
	}

	// 让中间的加号消失
	public void setAddImageVisible(boolean isVisible) {
		if (isVisible == true)
			m_imgView_AddSchedule.setVisibility(VISIBLE);
		else
			m_imgView_AddSchedule.setVisibility(GONE);
	}

	// 清除课程的表格内容并重新设置表格
	public void cleanClass(int width) {
		for (int i = 0; i < m_txt_Mon.length; i++) {
			m_txt_Mon[i].setText("");
			m_txt_Mon[i].setBackgroundResource(R.color.zsxyCourseBackground);
			m_txt_Tuse[i].setText("");
			m_txt_Tuse[i].setBackgroundResource(R.color.zsxyCourseBackground);
			m_txt_Wed[i].setText("");
			m_txt_Wed[i].setBackgroundResource(R.color.zsxyCourseBackground);
			m_txt_Thur[i].setText("");
			m_txt_Thur[i].setBackgroundResource(R.color.zsxyCourseBackground);
			m_txt_Fri[i].setText("");
			m_txt_Fri[i].setBackgroundResource(R.color.zsxyCourseBackground);
			m_txt_Sat[i].setText("");
			m_txt_Sat[i].setBackgroundResource(R.color.zsxyCourseBackground);
			m_txt_Sun[i].setText("");
			m_txt_Sun[i].setBackgroundResource(R.color.zsxyCourseBackground);

			m_txt_Mon[i].setVisibility(View.VISIBLE);
			m_txt_Tuse[i].setVisibility(View.VISIBLE);
			m_txt_Wed[i].setVisibility(View.VISIBLE);
			m_txt_Thur[i].setVisibility(View.VISIBLE);
			m_txt_Fri[i].setVisibility(View.VISIBLE);
			m_txt_Sat[i].setVisibility(View.VISIBLE);
			m_txt_Sun[i].setVisibility(View.VISIBLE);

			m_txt_Mon[i].setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, width, 1));
			m_txt_Tuse[i].setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, width, 1));
			m_txt_Wed[i].setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, width, 1));
			m_txt_Thur[i].setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, width, 1));
			m_txt_Fri[i].setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, width, 1));
			m_txt_Sat[i].setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, width, 1));
			m_txt_Sun[i].setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, width, 1));
			m_txt_Serial[i].setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, width, 1));
		}
	}

	public void setWeekDate(List<String> weekDate) {
		for (int i = 0; i < m_txt_Week.length; i++) {
			m_txt_Week[i].setText(weekDate.get(i));
		}
	}

	// 课表显示课程
	public void setClass(boolean isWeek, int position, List<Courses> query,
			int width) {
		int courseLength;
		for (Courses course : query) {
			if ("Mon".equals(course.getLessonDay())) {
				for (int i = 1; i <= 11; i++) {
					if (course.getLessonStart() == i) {
						courseLength = course.getLessonLength();
						m_txt_Mon[i - 1].setTextColor(0xFFFFFFFF);
						m_txt_Mon[i - 1].setTextSize(
								TypedValue.COMPLEX_UNIT_PX,
								(width - width / 7) / 3);
						m_txt_Mon[i - 1].setText(course.getLessonName() + "\n"
								+ course.getLessonClassroom());
						m_txt_Mon[i - 1].setOnClickListener(m_onclickListener);
						for (int j = 1; j < courseLength; j++) {
							m_txt_Mon[i + j - 1].setVisibility(View.GONE);
						}
						m_txt_Mon[i - 1]
								.setLayoutParams(new LinearLayout.LayoutParams(
										LayoutParams.MATCH_PARENT, width
												* courseLength, courseLength));
						m_txt_Mon[i - 1]
								.setBackgroundResource(courseScheduleColor[courseLength - 1][i - 1]);
					}
				}
			}
			if ("Tue".equals(course.getLessonDay())) {
				for (int i = 1; i <= 11; i++) {
					if (course.getLessonStart() == i) {
						courseLength = course.getLessonLength();
						m_txt_Tuse[i - 1].setTextColor(0xFFFFFFFF);
						m_txt_Tuse[i - 1].setTextSize(
								TypedValue.COMPLEX_UNIT_PX,
								(width - width / 7) / 3);
						m_txt_Tuse[i - 1].setText(course.getLessonName() + "\n"
								+ course.getLessonClassroom());
						m_txt_Tuse[i - 1].setOnClickListener(m_onclickListener);
						for (int j = 1; j < courseLength; j++) {
							m_txt_Tuse[i + j - 1].setVisibility(View.GONE);
						}
						m_txt_Tuse[i - 1]
								.setLayoutParams(new LinearLayout.LayoutParams(
										LayoutParams.MATCH_PARENT, width
												* courseLength, courseLength));
						m_txt_Tuse[i - 1]
								.setBackgroundResource(courseScheduleColor[courseLength - 1][i]);
					}
				}
			}
			if ("Wed".equals(course.getLessonDay())) {
				for (int i = 1; i <= 11; i++) {
					if (course.getLessonStart() == i) {
						courseLength = course.getLessonLength();
						m_txt_Wed[i - 1].setTextColor(0xFFFFFFFF);
						m_txt_Wed[i - 1].setTextSize(
								TypedValue.COMPLEX_UNIT_PX,
								(width - width / 7) / 3);
						m_txt_Wed[i - 1].setText(course.getLessonName() + "\n"
								+ course.getLessonClassroom());
						m_txt_Wed[i - 1].setOnClickListener(m_onclickListener);
						for (int j = 1; j < courseLength; j++) {
							m_txt_Wed[i + j - 1].setVisibility(View.GONE);
						}
						m_txt_Wed[i - 1]
								.setLayoutParams(new LinearLayout.LayoutParams(
										LayoutParams.MATCH_PARENT, width
												* courseLength, courseLength));
						m_txt_Wed[i - 1]
								.setBackgroundResource(courseScheduleColor[courseLength - 1][i + 1]);
					}
				}
			}
			if ("Thu".equals(course.getLessonDay())) {
				for (int i = 1; i <= 11; i++) {
					if (course.getLessonStart() == i) {
						courseLength = course.getLessonLength();
						m_txt_Thur[i - 1].setTextColor(0xFFFFFFFF);
						m_txt_Thur[i - 1].setTextSize(
								TypedValue.COMPLEX_UNIT_PX,
								(width - width / 7) / 3);
						m_txt_Thur[i - 1].setText(course.getLessonName() + "\n"
								+ course.getLessonClassroom());
						m_txt_Thur[i - 1].setOnClickListener(m_onclickListener);
						for (int j = 1; j < courseLength; j++) {
							m_txt_Thur[i + j - 1].setVisibility(View.GONE);
						}
						m_txt_Thur[i - 1]
								.setLayoutParams(new LinearLayout.LayoutParams(
										LayoutParams.MATCH_PARENT, width
												* courseLength, courseLength));
						m_txt_Thur[i - 1]
								.setBackgroundResource(courseScheduleColor[courseLength - 1][i + 2]);
					}
				}
			}
			if ("Fri".equals(course.getLessonDay())) {
				for (int i = 1; i <= 11; i++) {
					if (course.getLessonStart() == i) {
						courseLength = course.getLessonLength();
						m_txt_Fri[i - 1].setTextColor(0xFFFFFFFF);
						m_txt_Fri[i - 1].setTextSize(
								TypedValue.COMPLEX_UNIT_PX,
								(width - width / 7) / 3);
						m_txt_Fri[i - 1].setText(course.getLessonName() + "\n"
								+ course.getLessonClassroom());
						m_txt_Fri[i - 1].setOnClickListener(m_onclickListener);
						for (int j = 1; j < courseLength; j++) {
							m_txt_Fri[i + j - 1].setVisibility(View.GONE);
						}
						m_txt_Fri[i - 1]
								.setLayoutParams(new LinearLayout.LayoutParams(
										LayoutParams.MATCH_PARENT, width
												* courseLength, courseLength));
						if (i > 10)
							i = 0;
						m_txt_Fri[i - 1]
								.setBackgroundResource(courseScheduleColor[courseLength - 1][i + 3]);
					}
				}
			}
			if ("Sat".equals(course.getLessonDay())) {
				for (int i = 1; i <= 11; i++) {
					if (course.getLessonStart() == i) {
						courseLength = course.getLessonLength();
						m_txt_Sat[i - 1].setTextColor(0xFFFFFFFF);
						m_txt_Sat[i - 1].setTextSize(
								TypedValue.COMPLEX_UNIT_PX,
								(width - width / 7) / 3);
						m_txt_Sat[i - 1].setText(course.getLessonName() + "\n"
								+ course.getLessonClassroom());
						m_txt_Sat[i - 1].setOnClickListener(m_onclickListener);
						for (int j = 1; j < courseLength; j++) {
							m_txt_Sat[i + j - 1].setVisibility(View.GONE);
						}
						m_txt_Sat[i - 1]
								.setLayoutParams(new LinearLayout.LayoutParams(
										LayoutParams.MATCH_PARENT, width
												* courseLength, courseLength));
						if (i > 10)
							i = 0;
						m_txt_Sat[i - 1]
								.setBackgroundResource(courseScheduleColor[courseLength - 1][i + 4]);
					}
				}
			}
			if ("Sun".equals(course.getLessonDay())) {
				for (int i = 1; i <= 11; i++) {
					if (course.getLessonStart() == i) {
						courseLength = course.getLessonLength();
						m_txt_Sun[i - 1].setTextColor(0xFFFFFFFF);
						m_txt_Sun[i - 1].setTextSize(
								TypedValue.COMPLEX_UNIT_PX,
								(width - width / 7) / 3);
						m_txt_Sun[i - 1].setText(course.getLessonName() + "\n"
								+ course.getLessonClassroom());
						m_txt_Sun[i - 1].setOnClickListener(m_onclickListener);
						for (int j = 1; j < courseLength; j++) {
							m_txt_Sun[i + j - 1].setVisibility(View.GONE);
						}
						m_txt_Sun[i - 1]
								.setLayoutParams(new LinearLayout.LayoutParams(
										LayoutParams.MATCH_PARENT, width
												* courseLength, courseLength));
						if (i > 10)
							i = 0;
						m_txt_Sun[i - 1]
								.setBackgroundResource(courseScheduleColor[courseLength - 1][i + 5]);
					}
				}
			}
		}
	}

}
