package com.webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/messages")
public class MessagesServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SQL sql = new SQL();
		req.setAttribute("messages", sql.messages());
		req.getRequestDispatcher("/WEB-INF/views/messages.jsp").forward(req, res);
		sql.close();
	}

}
