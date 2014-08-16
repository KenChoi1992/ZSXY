package com.zsxy.models;

import java.io.Serializable;

public class Courses implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *��ÿγ���Ϣ��ʵ����
	 */

	private int LessonId; // �γ�Id,��������
	private String lessonTime = null; // �ڼ��ڿ�
	private int lessonStart;// �γ̴ӵڼ��ڿο�ʼ
	private int lessonLength;// �γ̳������ٽ�
	private String lessonType = null; // ���޻�ѡ��
	private String lessonTeachBy = null; // ��ʦ
	private String lessonWeeks = null; // �Ͽ���
	private String lessonClassroom = null; // ����
	private String lessonName = null; // �γ���
	private String lessonDay = null; // ����

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(int lessonId, String lessonTime, int lessonStart,
			int lessonLength, String lessonType, String lessonTeachBy,
			String lessonWeeks, String lessonClassroom, String lessonName,
			String lessonDay) {
		super();
		LessonId = lessonId;
		this.lessonTime = lessonTime;
		this.lessonStart = lessonStart;
		this.lessonLength = lessonLength;
		this.lessonType = lessonType;
		this.lessonTeachBy = lessonTeachBy;
		this.lessonWeeks = lessonWeeks;
		this.lessonClassroom = lessonClassroom;
		this.lessonName = lessonName;
		this.lessonDay = lessonDay;
	}

	public int getLessonStart() {
		return lessonStart;
	}

	public void setLessonStart(int lessonStart) {
		this.lessonStart = lessonStart;
	}

	public int getLessonLength() {
		return lessonLength;
	}

	public void setLessonLength(int lessonLength) {
		this.lessonLength = lessonLength;
	}

	public int getLessonId() {
		return LessonId;
	}

	public void setLessonId(int lessonId) {
		LessonId = lessonId;
	}

	public String getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(String lessonTime) {
		this.lessonTime = lessonTime;
	}

	public String getLessonType() {
		return lessonType;
	}

	public void setLessonType(String lessonType) {
		this.lessonType = lessonType;
	}

	public String getLessonTeachBy() {
		return lessonTeachBy;
	}

	public void setLessonTeachBy(String lessonTeachBy) {
		this.lessonTeachBy = lessonTeachBy;
	}

	public String getLessonWeeks() {
		return lessonWeeks;
	}

	public void setLessonWeeks(String lessonWeeks) {
		this.lessonWeeks = lessonWeeks;
	}

	public String getLessonClassroom() {
		return lessonClassroom;
	}

	public void setLessonClassroom(String lessonClassroom) {
		this.lessonClassroom = lessonClassroom;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonDay() {
		return lessonDay;
	}

	public void setLessonDay(String lessonDay) {
		this.lessonDay = lessonDay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
