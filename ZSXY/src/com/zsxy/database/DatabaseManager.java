package com.zsxy.database;

import java.util.ArrayList;
import java.util.List;

import com.zsxy.models.Courses;
import com.zsxy.models.Score;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseManager {

	private DatabaseHelper dataBaseHelper;
	private SQLiteDatabase db;

	public DatabaseManager(Context context) {
		dataBaseHelper = new DatabaseHelper(context);
		db = dataBaseHelper.getWritableDatabase();
	}

	// ���ӳɼ���¼
	public void AddScore(List<Score> scores) {
		db.beginTransaction();
		try {
			for (Score score : scores) {
				db.execSQL(
						"INSERT INTO " + DatabaseHelper.SCORE_TABLE
								+ " VALUES(null, ?, ?, ?, ?, ?)",
						new Object[] { score.getM_ScoreLessonFromTo(),
								score.getM_ScoreTerm(), score.getM_ScoreName(),
								score.getM_ScoreValue(),
								score.getM_ScoreReexamValue() });
			}
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
	}

	// ���ӿγ̼�¼
	public void AddCourse(List<Courses> courses) {
		db.beginTransaction();
		try {
			for (Courses course : courses) {
				db.execSQL(
						"INSERT INTO " + DatabaseHelper.COURSE_TABLE
								+ " VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
						new Object[] { course.getLessonTime(),
								course.getLessonStart(),
								course.getLessonLength(),
								course.getLessonType(),
								course.getLessonTeachBy(),
								course.getLessonWeeks(),
								course.getLessonClassroom(),
								course.getLessonName(), course.getLessonDay() });
			}
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
	}

	// ɾ����¼�ɼ��ͷ���������
	public void deleteAll() {
		db.execSQL("delete from " + DatabaseHelper.COURSE_TABLE);
		db.execSQL("delete from " + DatabaseHelper.SCORE_TABLE);
	}

	public void deleteCourses() {
		db.execSQL("delete from " + DatabaseHelper.COURSE_TABLE);
	}

	public void deleteScore() {
		db.execSQL("delete from " + DatabaseHelper.SCORE_TABLE);
	}

	// ���¼�¼
	public void update() {

	}

	// ����һ������������
	public List<Courses> queryCourseByTime(int startTime, String week) {
		ArrayList<Courses> courses = new ArrayList<Courses>();
		Cursor c = db.rawQuery("SELECT * FROM " + DatabaseHelper.COURSE_TABLE
				+ " WHERE lessonStart = ? AND lessonDay like ? ", new String[] {
				startTime + "", week });
		if (c.getCount() == 0)
			Log.i("��ѯ���", "���Ϊ��");
		while (c.moveToNext()) {
			Courses course = new Courses();
			course.setLessonTime(c.getString(c.getColumnIndex("lessonTime")));
			Log.i(c.getString(c.getColumnIndex("lessonName")),
					c.getString(c.getColumnIndex("lessonName")));
			course.setLessonStart(c.getInt(c.getColumnIndex("lessonStart")));
			course.setLessonLength(c.getInt(c.getColumnIndex("lessonLength")));
			course.setLessonType(c.getString(c.getColumnIndex("lessonType")));
			course.setLessonTeachBy(c.getString(c
					.getColumnIndex("lessonTeachBy")));
			course.setLessonWeeks(c.getString(c.getColumnIndex("lessonWeeks")));
			course.setLessonClassroom(c.getString(c
					.getColumnIndex("lessonClassroom")));
			course.setLessonName(c.getString(c.getColumnIndex("lessonName")));
			course.setLessonDay(c.getString(c.getColumnIndex("lessonDay")));
			courses.add(course);
		}
		return courses;
	}

	// �������ڲ�ѯ�����ؿα�
	public List<Courses> queryCourseByWeek(int position) {
		ArrayList<Courses> courses = new ArrayList<Courses>();
		Cursor c = queryCourseCursor();
		String week = position + "";// �����������õ�week
		while (c.moveToNext()) {
			String str = c.getString(c.getColumnIndex("lessonWeeks"));
			if (str.contains(week)) {
				Courses course = new Courses();
				course.setLessonTime(c.getString(c.getColumnIndex("lessonTime")));
				course.setLessonStart(c.getInt(c.getColumnIndex("lessonStart")));
				course.setLessonLength(c.getInt(c
						.getColumnIndex("lessonLength")));
				course.setLessonType(c.getString(c.getColumnIndex("lessonType")));
				course.setLessonTeachBy(c.getString(c
						.getColumnIndex("lessonTeachBy")));
				course.setLessonWeeks(c.getString(c
						.getColumnIndex("lessonWeeks")));
				course.setLessonClassroom(c.getString(c
						.getColumnIndex("lessonClassroom")));
				course.setLessonName(c.getString(c.getColumnIndex("lessonName")));
				course.setLessonDay(c.getString(c.getColumnIndex("lessonDay")));
				courses.add(course);
			}
		}
		return courses;
	}

	// ��ѯ��¼
	public List<Courses> queryAllCourse() {
		ArrayList<Courses> courses = new ArrayList<Courses>();
		Cursor c = queryCourseCursor();
		while (c.moveToNext()) {
			Courses course = new Courses();
			course.setLessonTime(c.getString(c.getColumnIndex("lessonTime")));
			course.setLessonStart(c.getInt(c.getColumnIndex("lessonStart")));
			course.setLessonLength(c.getInt(c.getColumnIndex("lessonLength")));
			course.setLessonType(c.getString(c.getColumnIndex("lessonType")));
			course.setLessonTeachBy(c.getString(c
					.getColumnIndex("lessonTeachBy")));
			course.setLessonWeeks(c.getString(c.getColumnIndex("lessonWeeks")));
			course.setLessonClassroom(c.getString(c
					.getColumnIndex("lessonClassroom")));
			course.setLessonName(c.getString(c.getColumnIndex("lessonName")));
			course.setLessonDay(c.getString(c.getColumnIndex("lessonDay")));
			courses.add(course);
		}
		return courses;
	}

	// ����α�
	public Cursor queryCourseCursor() {
		Cursor c = db.rawQuery("SELECT * FROM " + DatabaseHelper.COURSE_TABLE,
				null);
		return c;
	}

	// ��ѯ���гɼ�
	public List<Score> queryAllScore() {
		ArrayList<Score> scores = new ArrayList<Score>();
		Cursor c = queryScoreCursor();
		while (c.moveToNext()) {
			Score score = new Score();
			score.setM_ScoreLessonFromTo(c.getString(c
					.getColumnIndex("scoreLessonFromTo")));
			score.setM_ScoreTerm(c.getString(c.getColumnIndex("scoreTerm")));
			score.setM_ScoreName(c.getString(c.getColumnIndex("scoreName")));
			score.setM_ScoreValue(c.getString(c.getColumnIndex("scoreValue")));
			score.setM_ScoreReexamValue(c.getString(c
					.getColumnIndex("scoreReexamValue")));
			scores.add(score);
		}
		return scores;
	}

	// ��ò�ѯ�ɼ����α�
	public Cursor queryScoreCursor() {
		Cursor c = db.rawQuery("SELECT * FROM " + DatabaseHelper.SCORE_TABLE,
				null);
		return c;
	}
}
