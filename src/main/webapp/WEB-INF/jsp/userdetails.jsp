<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spring MVC form handling</title>
</head>>
<body>
	<h2>User Information</h2>
	<form:form method="POST" action="UserDetails/add">
		<table>
		 <tr>
		 	<td><form:label path="name">Name</form:label></td>
		 	<td><form:input path="name"/></td>
		 </tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Submit">
			</td>
		</tr> 
		</table>
	</form:form>
</body>
</html>