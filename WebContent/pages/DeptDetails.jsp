<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dept Details</title>
</head>
<body>
	<%
		out.println(request.getAttribute("page"));
	%>
	<form action="<%out.print(request.getContextPath());%>/controller">
		<input type="hidden" name="dest" value="addDept"> 
		<input type="submit" value="Add Department">
	</form>
	<form>
		<input type="hidden" name="dest" value="viewDepts">
		<input type="submit" value="View All Departments">
	</form>
</body>
</html>