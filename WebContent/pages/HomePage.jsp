<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
	<form action="<% out.print(request.getContextPath());%>/controller" method="get">
		<input type="hidden" name="dest" value="roomHome" /> <input type="submit" value="Rooms">
	</form>
	<form action="<%out.println(request.getContextPath());%>/controller">
		<input type="hidden" name="dest" value="staffHome" /> <input type="submit" value="Staff">
	</form>
	<form action="<%out.println(request.getContextPath());%>/controller">
		<input type="hidden" name="dest" value="viewDepts" /> <input type="submit" value="Departments">
	</form>
	<form action="<%out.println(request.getContextPath());%>/controller">
		<input type="hidden" name="dest" value="guestsHome"> <input type="submit" value="Guests">
	</form>
</body>
</html>