package com.zsxy.webservices;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.zsxy.models.Courses;


public class GetCourseJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long count;
	private List<Courses> lessons;
	private Courses courses;

	public GetCourseJson() {

	}

	public List<Courses> getLessons(JSONObject json) throws JSONException {

		count = json.getJSONArray("lessons").length();
		lessons = new ArrayList<Courses>();
		for (int i = 0; i < count; i++) {
			courses = new Courses();
			courses.setLessonTime(json.getJSONArray("lessons").getJSONObject(i)
					.getString("lesson_time").toString());
			String lessonsTime = json.getJSONArray("lessons").getJSONObject(i)
					.getString("lesson_time").toString();
			String[] as = lessonsTime.split(",");
			courses.setLessonStart(Integer.parseInt(as[0]));
			courses.setLessonLength(as.length);
			courses.setLessonType(json.getJSONArray("lessons").getJSONObject(i)
					.getString("lesson_type").toString());
			courses.setLessonTeachBy(json.getJSONArray("lessons")
					.getJSONObject(i).getString("lesson_teach_by").toString());
			courses.setLessonWeeks(json.getJSONArray("lessons")
					.getJSONObject(i).getString("lesson_weeks").toString());
			courses.setLessonClassroom(json.getJSONArray("lessons")
					.getJSONObject(i).getString("lesson_classroom").toString());
			courses.setLessonName(json.getJSONArray("lessons").getJSONObject(i)
					.getString("lesson_name").toString());
			courses.setLessonDay(json.getJSONArray("lessons").getJSONObject(i)
					.getString("lesson_day").toString());
			lessons.add(courses);
		}
		return lessons;
	}

}
