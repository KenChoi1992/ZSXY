package com.zsxy.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class GetDate {
	private List<String> weekDate;
	
	public GetDate(){
		weekDate = new ArrayList<String>();
	}
	
	public List<String> initDate() {
		// 星期和日期初始化
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateformatMonth = new SimpleDateFormat("MM");
		String month = dateformatMonth.format(date);
		SimpleDateFormat dateformatWeek = new SimpleDateFormat("E");
		String week = dateformatWeek.format(date);
		SimpleDateFormat dateformatDay = new SimpleDateFormat("dd");
		String Day = dateformatDay.format(date);
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		if (week.contains("一")) {
			weekDate.add(Day + "\n周一");
			c.set(Calendar.DATE, day + 1);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n周二");
			c.set(Calendar.DATE, day + 2);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n周三");
			c.set(Calendar.DATE, day + 3);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n周四");
			c.set(Calendar.DATE, day + 4);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n周五");
			c.set(Calendar.DATE, day + 5);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n周六");
			c.set(Calendar.DATE, day + 6);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n周日");
		} else if (week.contains("二")) {
			c.set(Calendar.DATE, day - 1);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n周一");
			weekDate.add(Day + "\n周二");
			c.set(Calendar.DATE, day + 1);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n周三");
			c.set(Calendar.DATE, day + 2);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n周四");
			c.set(Calendar.DATE, day + 3);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n周五");
			c.set(Calendar.DATE, day + 4);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n周六");
			c.set(Calendar.DATE, day + 5);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n周日");
		} else if (week.contains("三")) {
			c.set(Calendar.DATE, day - 2);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n周一");
			c.set(Calendar.DATE, day - 1);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n周二");
			weekDate.add(Day + "\n周三");
			c.set(Calendar.DATE, day + 1);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n周四");
			c.set(Calendar.DATE, day + 2);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n周五");
			c.set(Calendar.DATE, day + 3);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n周六");
			c.set(Calendar.DATE, day + 4);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n周日");
		} else if (week.contains("四")) {
			c.set(Calendar.DATE, day - 3);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n周一");
			c.set(Calendar.DATE, day - 2);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n周二");
			c.set(Calendar.DATE, day - 1);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n周三");
			weekDate.add(Day + "\n周四");
			c.set(Calendar.DATE, day + 1);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n周五");
			c.set(Calendar.DATE, day + 2);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n周六");
			c.set(Calendar.DATE, day + 3);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n周日");
		} else if (week.contains("五")) {
			c.set(Calendar.DATE, day - 4);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n周一");
			c.set(Calendar.DATE, day - 3);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n周二");
			c.set(Calendar.DATE, day - 2);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n周三");
			c.set(Calendar.DATE, day - 1);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n周四");
			weekDate.add(Day + "\n周五");
			c.set(Calendar.DATE, day + 1);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n周六");
			c.set(Calendar.DATE, day + 2);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n周日");
		} else if (week.contains("六")) {
			c.set(Calendar.DATE, day - 5);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n周一");
			c.set(Calendar.DATE, day - 4);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n周二");
			c.set(Calendar.DATE, day - 3);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n周三");
			c.set(Calendar.DATE, day - 2);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n周四");
			c.set(Calendar.DATE, day - 1);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n周五");
			weekDate.add(Day + "\n周六");
			c.set(Calendar.DATE, day + 1);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n周日");
		} else if (week.contains("日")) {
			c.set(Calendar.DATE, day - 6);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n周一");
			c.set(Calendar.DATE, day - 5);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n周二");
			c.set(Calendar.DATE, day - 4);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n周三");
			c.set(Calendar.DATE, day - 3);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n周四");
			c.set(Calendar.DATE, day - 2);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n周五");
			c.set(Calendar.DATE, day - 1);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n周六");
			weekDate.add(Day + "\n周日");
		}
		weekDate.add(month + "\n月");
		return weekDate;
	}

	public int getWeekNum() {
		Calendar c = Calendar.getInstance();
		c.set(2014, 7, 11);// 设置2014-8-11为开始日期
		int StartDay = c.get(Calendar.DAY_OF_YEAR);
		Date date = new Date();
		c.setTime(date);
		int Today = c.get(Calendar.DAY_OF_YEAR);
		int weekNum = (7 + Today - StartDay) / 7;
		return weekNum;
	}
	
	public List<String> changeWeekDate(int position) {
		List<String> changeDate = new ArrayList<String>();
		Calendar c = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//设置2014年8月11日为开始日期
			Date date = sdf.parse("2014-08-011");
			c.setTime(date);
			c.add(c.DATE, position * 7);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Mon + "\n周一");
			c.add(c.DATE, 1);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Tue + "\n周二");
			c.add(c.DATE, 1);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Web + "\n周三");
			c.add(c.DATE, 1);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Thu + "\n周四");
			c.add(c.DATE, 1);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Fri + "\n周五");
			c.add(c.DATE, 1 );
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Sat + "\n周六");
			c.add(c.DATE, 1);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Sun + "\n周日");
			SimpleDateFormat dateformatMonth = new SimpleDateFormat("MM");
			String Month = dateformatMonth.format(c.getTime());
			changeDate.add(Month + "\n月");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return changeDate;
	}
}
