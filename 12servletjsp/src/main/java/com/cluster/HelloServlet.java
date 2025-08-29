package com.cluster;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
		public void service(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
			System.out.println("Inside HelloServlet**************");
			RequestDispatcher rd = req.getRequestDispatcher("./jsp/hello.jsp");
			rd.forward(req, res);
		}
}
