package com.zsxy.models;

import java.io.Serializable;

public class Score implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *��÷�����Ϣ��ʵ����
	 */
	private int id; // �γ�Id,��������
	private String m_ScoreLessonFromTo = null; // ѧ��
	private String m_ScoreTerm = null; // ѧ��
	private String m_ScoreName = null; // �γ���
	private String m_ScoreValue = null; // �ɼ�
	private String m_ScoreReexamValue = null; // �����ɼ�

	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(int id, String m_ScoreLessonFromTo, String m_ScoreTerm,
			String m_ScoreName, String m_ScoreValue, String m_ScoreReexamValue) {
		super();
		this.id = id;
		this.m_ScoreLessonFromTo = m_ScoreLessonFromTo;
		this.m_ScoreTerm = m_ScoreTerm;
		this.m_ScoreName = m_ScoreName;
		this.m_ScoreValue = m_ScoreValue;
		this.m_ScoreReexamValue = m_ScoreReexamValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getM_ScoreLessonFromTo() {
		return m_ScoreLessonFromTo;
	}

	public void setM_ScoreLessonFromTo(String m_ScoreLessonFromTo) {
		this.m_ScoreLessonFromTo = m_ScoreLessonFromTo;
	}

	public String getM_ScoreTerm() {
		return m_ScoreTerm;
	}

	public void setM_ScoreTerm(String m_ScoreTerm) {
		this.m_ScoreTerm = m_ScoreTerm;
	}

	public String getM_ScoreName() {
		return m_ScoreName;
	}

	public void setM_ScoreName(String m_ScoreName) {
		this.m_ScoreName = m_ScoreName;
	}

	public String getM_ScoreValue() {
		return m_ScoreValue;
	}

	public void setM_ScoreValue(String m_ScoreValue) {
		this.m_ScoreValue = m_ScoreValue;
	}

	public String getM_ScoreReexamValue() {
		return m_ScoreReexamValue;
	}

	public void setM_ScoreReexamValue(String m_ScoreReexamValue) {
		this.m_ScoreReexamValue = m_ScoreReexamValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
