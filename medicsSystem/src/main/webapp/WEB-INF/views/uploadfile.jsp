<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Excel File</title>
</head>
<body>
<h1>welcome to excel file uplod</h1>
<form:form action="processExcel" method="post"	enctype="multipart/form-data">
		<div>Excel File 2003:</div>
		<input name="excelfile" type="file" />
		<input type="submit" value="processExcel" />
	</form:form>
</body>
</html>