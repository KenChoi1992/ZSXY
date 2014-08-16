package com.zsxy.webservices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.zsxy.models.Courses;

public class GetCourseHttp {
	private String m_ResultString;
	private List<Courses> m_CourseList;

	public GetCourseHttp() {
		m_CourseList = new ArrayList<Courses>();
	}

	public void getCourseHttp(final String studentId,
			final String studentPassword) throws JSONException {
		Thread thread = new Thread() {
			@Override
			public void run() {

				String uriAPI = "http://192.168.1.120/test.php?type=table&xh="
						+ studentId + "&pwd=" + studentPassword;
				// String uriAPI =
				// "http://192.168.1.108:8080/test.php?type=table&xh=201230675086&pwd=093317";
				HttpGet httpGet = new HttpGet(uriAPI);

				HttpResponse response;
				try {
					response = new DefaultHttpClient().execute(httpGet);
					if (response.getStatusLine().getStatusCode() == 200) {
						HttpEntity entity = response.getEntity();
						m_ResultString = EntityUtils.toString(entity,
								HTTP.UTF_8);
					}
					try {
						JSONObject jsonObject = new JSONObject(m_ResultString);
						GetCourseJson tolist = new GetCourseJson();
						m_CourseList = tolist.getLessons(jsonObject);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Courses> getM_CourseList() {
		return m_CourseList;
	}

	public void setM_CourseList(List<Courses> m_CourseList) {
		this.m_CourseList = m_CourseList;
	}

}
