package com.webapp;

public class Child{
	public int ID;
	public String firstName;
	public String surname;
	public int childOf;
	public Child(int ID, String firstName, String surname, int childOf){
		this.ID = ID;
		this.firstName = firstName;
		this.surname = surname;
		this.childOf = childOf;
	}
	
	public String getFirstName(){
		return firstName;
	}

	public int getID() {
		return ID;
	}
	
	public int getChildOf() {
		return childOf;
	}

	public String getSurname() {
		return surname;
	}
	
	public String getFullName(){
		return firstName + " " + surname;
	}
}
