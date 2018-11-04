package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Department;
import com.service.DepartmentService;
import com.service.impl.DepartmentServiceImpl;

public class Controller extends HttpServlet{
	
	DepartmentService deptService = new DepartmentServiceImpl(); 
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
		} else if(dest!=null && dest.equals("addDept")){
			req.getRequestDispatcher("/pages/AddDeptPage.jsp").forward(req, resp);
		} else if(dest!=null && dest.equals("viewDepts")){
			req.setAttribute("deptList", deptService.getAllDepartments());
			req.getRequestDispatcher("/pages/ViewAllDeptPage.jsp").forward(req, resp);
		} else if(dest!=null && dest.equals("addDeptDetails")){
			System.out.println("in if ");
			Department department = new Department();
			department.setDeptCode(Integer.valueOf(req.getParameter("deptCode")));
			department.setDeptName(req.getParameter("deptName"));
			deptService.addDepartment(department);
			req.getRequestDispatcher("/pages/DeptDetails.jsp").forward(req, resp);
		} else if(dest!=null && dest.equals("editDept")){
			req.setAttribute("dept", deptService.getDepartmentById(Integer.valueOf(req.getParameter("deptId"))));
			req.getRequestDispatcher("/pages/EditDeptPage.jsp").forward(req, resp);
		} else if(dest!=null && dest.equals("updateDept")){
			int deptId = Integer.valueOf(req.getParameter("deptId"));
			Department department = deptService.getDepartmentById(deptId);
			department.setDeptCode(Integer.valueOf(req.getParameter(("deptCode"))));
			department.setDeptName(req.getParameter("deptName"));
			deptService.updateDepartment(department);
			req.setAttribute("dept", deptService.getDepartmentById(deptId));
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		doGet(req, resp);
	}
}