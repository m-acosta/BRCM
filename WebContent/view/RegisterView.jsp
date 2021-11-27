<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BRCM REGISTRATION</title>
	</head>
	<body>


	<form action="login" method="post">
		<table bgcolor="#00ffff" width="500" height="80" align="center">
			    <tr>
			      <td><c:out value="Bronco Id: "></c:out></td>
				  <td><input type="text" name="bronco_id"></td>
				</tr>
		</table>
				<table bgcolor="#00ffff" width="500" height="80" align="center">
	        <tr>
	            <td><input type="checkbox" id="Basketball" name="basketball" value="Basketball"></td>
	            <td><c:out value="Basketball" /></td>
	             </tr>
	             <tr>
	            <td><input type="checkbox" id="Football" name="football" value="Football"></td>
	            <td><c:out value="Football" /></td>
	             </tr>
	             <tr>
	            <td><input type="checkbox" id="Soccer" name="soccer" value="Soccer"></td>
	            <td><c:out value="Soccer" /></td>
	
	        </tr>
		</table>
		<table bgcolor="#00ffff" width="500" height="80" align="center" border="0">		
				<tr>
				  <td></td>
				  <td align="right"><input type="submit" name="Checkout" value="Checkout"></td>
				  <td></td>
				  <td><input type="reset" name="Cancel" value="Cancel"></td>
				  <td></td>
				</tr>  
		</table>
	</form>
	
	<h1 style="color: red;"> <c:out value="${requestScope.ErrorLogin}" /></h1>
	
	</body>
	
</html>