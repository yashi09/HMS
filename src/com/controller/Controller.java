package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		super.init();
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("in doGet");
		String dest = req.getParameter("dest");
		System.out.println(dest);
		if(dest!=null && dest.equals("roomDetails") ){
			req.setAttribute("page", "room");
			req.getRequestDispatcher("/pages/RoomDetails.jsp").forward(req, resp);
		}else if(dest!=null && dest.equals("staffDetails")){
			req.setAttribute("page", "staff");
			req.getRequestDispatcher("/pages/StaffDetails.jsp").forward(req, resp);
		} else if(dest!=null && dest.equals("deptDetails")){
			req.setAttribute("page", "dept");
			req.getRequestDispatcher("/pages/DeptDetails.jsp").forward(req, resp);
		} else if(dest!=null && dest.equals("guestDetails")){
			req.setAttribute("page", "guest");
			req.getRequestDispatcher("/pages/GuestDetails.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		doGet(req, resp);
	}
}