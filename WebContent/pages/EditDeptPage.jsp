<%@page import="com.dto.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Dept Page</title>
</head>
<body>
	<%Department dept = (Department)request.getAttribute("dept");%>
	<form action="<%out.print(request.getContextPath());%>/controller?deptId=<%out.print(dept.getDeptId());%>">
		<input type="hidden" name="dest" value="updateDept">
		<input type="text" name="deptName" value=<%out.print(dept.getDeptName());%> title="dept name">
		<input type="text" name="deptCode" value="<%out.print(dept.getDeptCode());%>" title="dept code">
		<input type="submit" value="Update">
	</form>
</body>
</html>