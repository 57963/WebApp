package com.webapp;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/display")
public class DisplayServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		SQL sql = new SQL();
		ResultSet rs;
		try {
			rs = sql.getResults("SELECT * FROM users");
			while(rs.next()){
				res.getWriter().print(rs.getString(1)+"  ");
				res.getWriter().print(rs.getString(2)+"  ");
				res.getWriter().println(rs.getString(3));
			}
			res.getWriter().println("-----------");
			rs = sql.getResults("SELECT * FROM children");
			while(rs.next()){
				res.getWriter().print(rs.getString(1)+"  ");
				res.getWriter().print(rs.getString(2)+"  ");
				res.getWriter().print(rs.getString(3)+"  ");
				res.getWriter().println(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
