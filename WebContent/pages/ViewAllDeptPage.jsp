
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dto.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	List<Department> deptList = ((ArrayList<Department>) request
			.getAttribute("deptList"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View All Dept Page</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Dept Code</th>
				<th>Dept Name</th>
				<th colspan="3">Operation</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Department dept : deptList) {
			%>
			<tr>
				<td>
					<%
						out.print(dept.getDeptCode());
					%>
				</td>
				<td>
					<%
						out.print(dept.getDeptName());
					%>
				</td>
				<td><a
					href="<%out.print(request.getContextPath());%>/controller?dest=editDept&deptId=<%out.print(dept.getDeptId());%>">Edit</a>
					<!-- edit --></td>
				<td>
				<a href="<%out.print(request.getContextPath());%>/controller?dest=viewStaffOfDept&deptCode=<%out.print(dept.getDeptCode());%>">Working Staff</a>
						<!-- view staff -->
				</td>
				<td>
					<a href="<%out.print(request.getContextPath());%>/controller?dest=deleteDept&deptId=<%out.print(dept.getDeptId());%>">Delete</a>
						<!-- delete -->
					
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>