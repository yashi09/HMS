<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="com.dto.Staff" %>
<%@page import="com.dto.Department" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff Of Dept Page</title>
<%List<Staff> staffList = (ArrayList<Staff>)request.getAttribute("staffList"); %>
<%Department dept = (Department)request.getAttribute("dept"); %>
</head>
<body>
	<table border="1"> 
	<caption><%out.println(dept.getDeptName());%></caption>
		<thead>
		<tr>
			<th>Name</th>
			<th>Designation</th>
			<th>Contact No.</th>
			<th>Age</th>
			<th>Permanent Address</th>
			<th colspan="2">Operation</th>
		</tr>
		</thead>
		<tbody>
		<%for(Staff staff:staffList){ %>
			<tr>
			<td><%out.println(staff.getName());%></td>
			<td><%out.println(staff.getRole());%></td>
			<td><%out.println(staff.getContact()); %></td>
			<td><%out.println(staff.getAge());%></td>
			<td><%out.println(staff.getAddress());%></td>
			<td><a href="<%out.println(request.getContextPath());%>/controller?dest=editStaff&staffId=<%out.println(staff.getStaffId());%>">Edit</a></td>
			<td><a href="<%out.println(request.getContextPath());%>/controller?dest=deleteStaff&staffId=<%out.println(staff.getStaffId());%>&deptCode=<%out.println(dept.getDeptCode());%>">Delete</a></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>