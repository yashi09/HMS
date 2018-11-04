<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Dept Page</title>
</head>
<body>
	<form action="<%out.print(request.getContextPath());%>/controller">
	<input type="hidden" name="dest" value="addDeptDetails"/>
	
	<input type="text" name="deptCode" value="department code"><br>
	<input type="text" name="deptName" value="department name"><br>
	
	<input type="submit" name="submit" value="submit">
	</form>
</body>
</html>


<!-- 
CREATE TABLE department (dept_id INT NOT NULL AUTO_INCREMENT,
dept_code INT NOT NULL UNIQUE,
dept_name VARCHAR(30) NOT NULL,
PRIMARY KEY (dept_id));
 -->