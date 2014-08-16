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

import com.zsxy.models.Score;

public class GetScoreHttp {

	private String m_ResultString;
	private List<Score> m_ScoreList;

	public GetScoreHttp() {
		m_ScoreList = new ArrayList<Score>();
	}

	public void getScoreHttp(final String studentId,
			final String studentPassword) throws JSONException {

		Thread thread = new Thread() {
			@Override
			public void run() {

				String l_ScoreUriAPI = "http://192.168.1.120/test.php?type=score&xh="
						+ studentId + "&pwd=" + studentPassword;
				// String l_ScoreUriAPI =
				// "http://192.168.1.108:8080/test.php?type=score&xh=201230675086&pwd=093317";
				HttpGet l_ScoreHttpGet = new HttpGet(l_ScoreUriAPI);

				HttpResponse l_ScoreResponse;
				try {
					l_ScoreResponse = new DefaultHttpClient()
							.execute(l_ScoreHttpGet);
					// progressDialog.cancel();
					if (l_ScoreResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity l_ScoreEntity = l_ScoreResponse.getEntity();
						m_ResultString = EntityUtils.toString(l_ScoreEntity,
								HTTP.UTF_8);
					}

					try {
						JSONObject jsonObject = new JSONObject(m_ResultString);
						GetScoreJson tolist = new GetScoreJson();
						m_ScoreList = tolist.getScores(jsonObject);
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

	public List<Score> getM_ScoreList() {
		return m_ScoreList;
	}

	public void setM_ScoreList(List<Score> m_ScoreList) {
		this.m_ScoreList = m_ScoreList;
	}

}
