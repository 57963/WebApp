package com.webapp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SQL sql = new SQL();
		boolean valid = false;
		ResultSet rs;
		try {
			rs = sql.getResults("SELECT * FROM users WHERE username='"+req.getParameter("username")+"'");
			if(rs != null){
				while(rs.next()){
					if(rs.getString(3).equals(req.getParameter("password"))){
						valid=true;
						req.getSession().setAttribute("id", rs.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			sql.close();
		}
		if(valid){
			req.getSession().setAttribute("loggedIn", true);
			req.getSession().setAttribute("username", req.getParameter("username"));
			res.sendRedirect("/welcome");
		} else{
			req.setAttribute("error", "Invalid login credentials");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
		}
	}
}
