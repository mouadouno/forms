<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="entities.Projet" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Projet mod = (Projet)request.getAttribute("mod"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= request.getAttribute("s")%>
<%= mod.getNom() %>
<form action="/testServlet" method="post">
	<table>
		<tr>
			<td>Nom : </td>
			<td><input type="text" name="nom"/></td>
		</tr>
		<tr>
			<td>Nom : </td>
			<td><input type="date" name="date_debut"/></td>
		</tr>
		<tr>
			<td>Nom : </td>
			<td><input type="date" name="date_fin"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="test"/></td>
		</tr>
	</table>
</form>
</body>
</html>