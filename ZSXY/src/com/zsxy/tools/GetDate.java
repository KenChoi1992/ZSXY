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
		// ���ں����ڳ�ʼ��
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
		if (week.contains("һ")) {
			weekDate.add(Day + "\n��һ");
			c.set(Calendar.DATE, day + 1);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n�ܶ�");
			c.set(Calendar.DATE, day + 2);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n����");
			c.set(Calendar.DATE, day + 3);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n����");
			c.set(Calendar.DATE, day + 4);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n����");
			c.set(Calendar.DATE, day + 5);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n����");
			c.set(Calendar.DATE, day + 6);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n����");
		} else if (week.contains("��")) {
			c.set(Calendar.DATE, day - 1);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n��һ");
			weekDate.add(Day + "\n�ܶ�");
			c.set(Calendar.DATE, day + 1);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n����");
			c.set(Calendar.DATE, day + 2);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n����");
			c.set(Calendar.DATE, day + 3);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n����");
			c.set(Calendar.DATE, day + 4);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n����");
			c.set(Calendar.DATE, day + 5);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n����");
		} else if (week.contains("��")) {
			c.set(Calendar.DATE, day - 2);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n��һ");
			c.set(Calendar.DATE, day - 1);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n�ܶ�");
			weekDate.add(Day + "\n����");
			c.set(Calendar.DATE, day + 1);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n����");
			c.set(Calendar.DATE, day + 2);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n����");
			c.set(Calendar.DATE, day + 3);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n����");
			c.set(Calendar.DATE, day + 4);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n����");
		} else if (week.contains("��")) {
			c.set(Calendar.DATE, day - 3);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n��һ");
			c.set(Calendar.DATE, day - 2);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n�ܶ�");
			c.set(Calendar.DATE, day - 1);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n����");
			weekDate.add(Day + "\n����");
			c.set(Calendar.DATE, day + 1);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n����");
			c.set(Calendar.DATE, day + 2);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n����");
			c.set(Calendar.DATE, day + 3);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n����");
		} else if (week.contains("��")) {
			c.set(Calendar.DATE, day - 4);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n��һ");
			c.set(Calendar.DATE, day - 3);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n�ܶ�");
			c.set(Calendar.DATE, day - 2);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n����");
			c.set(Calendar.DATE, day - 1);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n����");
			weekDate.add(Day + "\n����");
			c.set(Calendar.DATE, day + 1);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n����");
			c.set(Calendar.DATE, day + 2);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n����");
		} else if (week.contains("��")) {
			c.set(Calendar.DATE, day - 5);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n��һ");
			c.set(Calendar.DATE, day - 4);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n�ܶ�");
			c.set(Calendar.DATE, day - 3);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n����");
			c.set(Calendar.DATE, day - 2);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n����");
			c.set(Calendar.DATE, day - 1);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n����");
			weekDate.add(Day + "\n����");
			c.set(Calendar.DATE, day + 1);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sun + "\n����");
		} else if (week.contains("��")) {
			c.set(Calendar.DATE, day - 6);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Mon + "\n��һ");
			c.set(Calendar.DATE, day - 5);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Tue + "\n�ܶ�");
			c.set(Calendar.DATE, day - 4);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Web + "\n����");
			c.set(Calendar.DATE, day - 3);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Thu + "\n����");
			c.set(Calendar.DATE, day - 2);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Fri + "\n����");
			c.set(Calendar.DATE, day - 1);
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			weekDate.add(Sat + "\n����");
			weekDate.add(Day + "\n����");
		}
		weekDate.add(month + "\n��");
		return weekDate;
	}

	public int getWeekNum() {
		Calendar c = Calendar.getInstance();
		c.set(2014, 7, 11);// ����2014-8-11Ϊ��ʼ����
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
			//����2014��8��11��Ϊ��ʼ����
			Date date = sdf.parse("2014-08-011");
			c.setTime(date);
			c.add(c.DATE, position * 7);
			String Mon = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Mon + "\n��һ");
			c.add(c.DATE, 1);
			String Tue = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Tue + "\n�ܶ�");
			c.add(c.DATE, 1);
			String Web = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Web + "\n����");
			c.add(c.DATE, 1);
			String Thu = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Thu + "\n����");
			c.add(c.DATE, 1);
			String Fri = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Fri + "\n����");
			c.add(c.DATE, 1 );
			String Sat = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Sat + "\n����");
			c.add(c.DATE, 1);
			String Sun = new SimpleDateFormat("dd").format(c.getTime());
			changeDate.add(Sun + "\n����");
			SimpleDateFormat dateformatMonth = new SimpleDateFormat("MM");
			String Month = dateformatMonth.format(c.getTime());
			changeDate.add(Month + "\n��");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return changeDate;
	}
}
