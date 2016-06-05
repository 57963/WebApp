package com.webapp;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Session {
	public int ID;
	public Date date;
	public Time start;
	public Time end;
	public Child[] booked = new Child[8];
	public Child[] reserve = new Child[2];
	public Session(int ID,Date date, Time start, Time end){
		this.ID = ID;
		this.date = date;
		this.start = start;
		this.end = end;
	}
	public Date getDate() {
		return date;
	}
	public Time getStart() {
		return start;
	}
	public Time getEnd() {
		return end;
	}
	public Child[] getBooked() {
		return booked;
	}
	public Child[] getReserve() {
		return reserve;
	}
	public int getID() {
		return ID;
	}
	
	public boolean allInSession(ArrayList<Child> children){
		boolean allInSession = true;
		for(Child c: children){
			if(!inSession(c)){
				allInSession = false;
			}
		}
		return allInSession;
	}
	
	public boolean inSession(Child child){
		boolean inSession = false;
		for(Child c: booked){
			if(c!=null){
				if(c.ID == child.ID){
					inSession = true;
				}
			}
		}
		for(Child c: reserve){
			if(c!=null){
				if(c.ID == child.ID){
					inSession = true;
				}
			}
		}
		return inSession;
	}
}