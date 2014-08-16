package com.zsxy.view;

import com.zsxy.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CourseLoginView extends RelativeLayout {
	private TextView m_txt_title = null;
	private EditText m_edtTxt_studentId = null;
	private EditText m_edtTxt_studentPassword = null;
	private Button m_btn_login_submit = null;
	private Button m_btn_login_cancel = null;

	public CourseLoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void initModule() {
		m_txt_title = (TextView) findViewById(R.id.login_title);
		m_edtTxt_studentId = (EditText) findViewById(R.id.studentId);
		m_edtTxt_studentPassword = (EditText) findViewById(R.id.studentPassword);
		m_btn_login_submit = (Button) findViewById(R.id.login_submit);
		m_btn_login_cancel = (Button) findViewById(R.id.login_cancel);
	}

	public void setListeners(OnClickListener onClickListener) {
		m_edtTxt_studentId.setOnClickListener(onClickListener);
		m_edtTxt_studentPassword.setOnClickListener(onClickListener);
		m_btn_login_submit.setOnClickListener(onClickListener);
		m_btn_login_cancel.setOnClickListener(onClickListener);
	}

	public void setTitleText(String title) {
		m_txt_title.setText(title);
	}

	// �õ�ѧ��
	public String getStudentId() {
		return m_edtTxt_studentId.getText().toString();
	}

	// �õ�����
	public String getStudentPassword() {
		return m_edtTxt_studentPassword.getText().toString();
	}

	// ѧ��Ϊ�յ��ô˷���
	public void studentIdError(Context context) {
		Toast l_toast = Toast.makeText(context, "ѧ�Ų���Ϊ��", Toast.LENGTH_SHORT);
		l_toast.show();
	}

	// ����Ϊ�յ��ô˷���
	public void studentPasswordError(Context context) {
		Toast l_toast = Toast.makeText(context, "���벻��Ϊ��", Toast.LENGTH_SHORT);
		l_toast.show();
	}

}
