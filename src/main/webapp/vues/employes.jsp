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
<h2>Liste des Employes</h2>

<c:forEach items="${liste}" var="e" >
<p>Département:  ${e.dep.nom }</p>
</c:forEach>

<table border="1">
<tr><th>Id</th><th>Nom</th><th>Fonction</th>
<c:forEach items="${liste}" var="e" >
	<tr>
	<td>${e.id }</td><td>${e.nom }</td>
	<td>${e.fonction }</td>
	
	</tr>
</c:forEach>

</table>
<p><a href="${cxt }/home">liste des départements</a> </p>
<p><a href="${cxt}/ajoutEmploye">Ajouter Employe</a></p>
</body>
</html>