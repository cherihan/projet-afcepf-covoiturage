<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Premiere Action cov (MVC2)</title>
</head>
<body>
	<form action="/affichage.cov">
		saisie : <input type="text" value="saisie" />
		<input type="submit" value="Valider" />
	</form>
	<c:if test="${paffichage.label != null }">${paffichage.label }</c:if>
</body>
</html>
