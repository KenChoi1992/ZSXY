package com.zsxy.webservices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import com.zsxy.models.Score;

public class GetScoreJson implements Serializable {

	private static final long serialVersionUID = 1L;
	private long count;
	private List<Score> scores;
	private Score score;

	public GetScoreJson() {

	}

	public List<Score> getScores(JSONObject json) throws JSONException {

		count = json.getJSONArray("scores").length();
		scores = new ArrayList<Score>();
		for (int i = 0; i < count; i++) {
			score = new Score();
			score.setM_ScoreLessonFromTo(json.getJSONArray("scores").getJSONObject(i)
					.getString("score_lesson_from_to").toString());
			score.setM_ScoreTerm(json.getJSONArray("scores").getJSONObject(i)
					.getString("score_term").toString());
			score.setM_ScoreName(json.getJSONArray("scores").getJSONObject(i)
					.getString("score_name").toString());
			score.setM_ScoreValue(json.getJSONArray("scores")
					.getJSONObject(i).getString("score_value").toString());
			score.setM_ScoreReexamValue(json.getJSONArray("scores").getJSONObject(i)
					.getString("score_reexam_value").toString());
			scores.add(score);
		}
		return scores;
	}

}
