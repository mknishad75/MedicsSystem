<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  <h1><a href="/uploadExcel.jlc">Upload Your Execel Sheet</a></h1>  -->
<h1><a href="<c:url value="add"/>">Upload Your Excel Sheet</a></h1>
<h1><a href="<c:url value="addadmin" />">admin panel</a></h1>
<h1><a href="<c:url value="SendMailPage"/>">Send Mail </a></h1>

<a href="admin.jsp">Display All Room Value</a>
</body>
</html>