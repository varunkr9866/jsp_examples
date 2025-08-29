package com.cluster;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("Inside CheckServlet**************");
		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");
		RequestDispatcher rd = null;
		if (strNme.equalsIgnoreCase("Ravi")	&& strPwd.equalsIgnoreCase("Cluster")) {
			rd = req.getRequestDispatcher("./jsp/success.jsp");
			rd.forward(req, res);
		} else {
			rd = req.getRequestDispatcher("./jsp/failure.jsp");
			rd.forward(req, res);
		}
	}
}
