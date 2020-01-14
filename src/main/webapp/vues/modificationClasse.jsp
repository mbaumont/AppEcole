<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="../WEB-INF/header.jsp">
<c:param name="title" value="Menu" />
</c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes école</title>
</head>
<body>
<div class="container-fluid m-4">
<form:form method="post" modelAttribute="modification"
		action="modifClasse">
		<form:input path="id" type="hidden"/>
		<b><i><form:errors path="id" cssclass="error" /></i></b>
		<spring:message code="classe.Nom" />
		<form:input path="nom" />
		<b><i><form:errors path="nom" cssclass="error" /></i></b>
		<br>
		<spring:message code="classe.Prof" />
		<form:select path="idProf"  >
			<c:forEach items="${listeProfs}" var="profs" >
				<form:option value="${profs.id}">${profs.nom} </form:option>
			</c:forEach>
			</form:select>
		<input type="submit" />
	</form:form>
</div>
</body>
</html>