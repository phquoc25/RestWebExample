<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC form handling</title>
</head>
<body>
	<h2>User Information</h2>
	<form:form method="POST" action="/MyWebApp/userdetails/add">
		<table>
			<tr>
				<td><form:label path="userName">Name</form:label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td><form:label path="joinedDate">Joined Date</form:label></td>
				<td><form:input path="joinedDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>