<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un projet</title>
<c:set var="cxt" value="${pageContext.request.contextPath}" /> 
</head>
<body>

<form:form method="POST" action="saveProjet" modelAttribute="p" >
<p> Titre : <form:input path="titre"/> </p>
<p>Etat : <form:select path="etat" items="${listeEtats}"   />
<p> Département : <form:select path="dep.id" items="${listedep}" itemValue="id" itemLabel="nom" />
<p> <input type="submit" value="Ajouter" />
</form:form>
<a href="${cxt }/home">liste des départements</a>
</body>
</html>