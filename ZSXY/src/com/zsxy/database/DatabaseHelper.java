package com.zsxy.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "zsxy.db";

	public static final String COURSE_TABLE = "CourseTable";
	public static final String SCORE_TABLE = "ScoreTable";

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@SuppressLint("NewApi")
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
	}

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// 创建课程的数据表
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("CREATE TABLE [" + COURSE_TABLE + "] (");

		sBuffer.append("[id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
		sBuffer.append("[lessonTime] TEXT,");
		sBuffer.append("[lessonStart] INTEGER,");
		sBuffer.append("[lessonLength] INTEGER,");
		sBuffer.append("[lessonType] TEXT,");
		sBuffer.append("[lessonTeachBy] TEXT,");
		sBuffer.append("[lessonWeeks] TEXT,");
		sBuffer.append("[lessonClassroom] TEXT,");
		sBuffer.append("[lessonName] TEXT,");
		sBuffer.append("[lessonDay] TEXT)");
		// 执行创建表的SQL语句
		db.execSQL(sBuffer.toString());

		// 创建分数的数据表
		StringBuffer sBuffer1 = new StringBuffer();
		sBuffer1.append("CREATE TABLE [" + SCORE_TABLE + "] (");
		sBuffer1.append("[id] INTEGER PRIMARY KEY, ");
		sBuffer1.append("[scoreLessonFromTo] TEXT, ");
		sBuffer1.append("[scoreTerm] TEXT,");
		sBuffer1.append("[scoreName] TEXT,");
		sBuffer1.append("[scoreValue] TEXT,");
		sBuffer1.append("[scoreReexamValue] TEXT)");
		db.execSQL(sBuffer1.toString());

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + SCORE_TABLE);
		onCreate(db);
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		super.onOpen(db);
	}

}
