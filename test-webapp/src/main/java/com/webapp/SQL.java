package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQL {
	Connection conn;
	ResultSet rs;
	public SQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testwebapp", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getResults(String req){
		try {
			rs= conn.prepareStatement(req).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void doUpdate(String req){
		try {
			conn.prepareStatement(req).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Message> messages(String... conds){
		ArrayList<Message> messages = new ArrayList<>();
		getAll("messages",conds);
		try {
			while(rs.next()){
				messages.add(new Message(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5),rs.getBoolean(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}
	
	public Message message(int ID){
		return messages("ID = '"+ID+"'").get(0);
	}
	
	public void getAll(String table, String... conds){
		String req = "SELECT * FROM "+table+" WHERE 1=1";
		for(String s:conds){
			req+= ", "+s;
		}
		getResults(req);
	}
	
	public void close(){
		if (null != rs) {
			try { rs.close();} catch(Exception ex) {};
        }
		if (null != conn) {
			try { conn.close();} catch(Exception ex) {};
        }
	}
}
