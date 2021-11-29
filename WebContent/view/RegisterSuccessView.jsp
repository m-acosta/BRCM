<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receipt</title>
</head>

<body>
<table>
		<tr>
		<td>
			<c:out value="Name: ${requestScope.Name}" />
			</td>
		</tr>
		<tr>
		<td>
			<c:out value="Bronco Id: ${requestScope.Bronco_Id}" />
			</td>
		</tr>
		<tr>
		<td>
			<c:out value="Date: ${requestScope.Date} Time: ${requestScope.Time}" />
			</td>
		</tr>
		<tr>
		<td>
			<c:out value="Activities" />
			</td>
		</tr>
		<tr>
		<td>
			<c:out value="${requestScope.Activity1}" />
			</td>
			</tr>
		<tr>
		<td>
			<c:out value="${requestScope.Activity2}" />
			</td>
		<tr>
		<tr>
		<td>
			<c:out value="${requestScope.Activity3}" />
			</td>
		</tr>
		<tr>
		<td>
			<c:out value="Total Cost:$ ${requestScope.Total}" />
			</td>
		</tr>
</table>
</body>

</html>