<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Champs de test avec bouton submit !</title>
</head>
<body>
	<form action="affichage.cov" method="get">
		<table border="0" align="center">
			<tr>
				<td align="right">Utilisateur :</td>
				<td align="left"><input type="text" id="nomUtilisateur" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right">Mot de Passe :</td>
				<td align="left"><input type="password" id="mdpUtilisateur" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="Valider" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
