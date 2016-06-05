package com.webapp;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class Day {
	public Date date;
	public Time start;
	public Time end;
	public Day(Date date){
		this.date=date;
	}
	public Date getDate() {
		return date;
	}
	public Calendar getCDate(){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		return c;
	}
	public Time getStart() {
		return start;
	}
	public Time getEnd() {
		return end;
	}
}
