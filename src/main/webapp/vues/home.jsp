<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:set var="cxt" value="${pageContext.request.contextPath}" /> 
</head>
<body>
<h2>Liste des departements</h2>
<table border="1">
<tr><th>Id</th> <th>nom</th></tr>
<c:forEach var="d" items="${liste }">
<tr>
<td>${d.id}</td>
<td>${d.nom}</td>
<td><a href="projet/${d.id}">liste des projets</a>
<td><a href="employe/${d.id}">liste des employes</a>

</tr>
</c:forEach>
</table>
<p><a href="${cxt}/ajoutProjet">Ajouter Projet</a></p>
<p><a href="${cxt}/ajoutEmploye">Ajouter Employe</a></p>
</body>
</html>