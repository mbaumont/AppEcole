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
<title>Creation Prof</title>
</head>
<body>
<div class="container m-4">
<form:form method="post" modelAttribute="creation"
		action="creerProf" >
		<div  class="d-flex flex-column">
		<spring:message code="creation.elementcourses.nom.libelle" />
		<form:input path="nom" />
		<b><i><form:errors path="nom" cssclass="error" /></i></b>
		<br>
		<spring:message code="creation.elementcourses.prenom.libelle" />
		<form:input path="prenom" />
		<b><i><form:errors path="prenom" cssclass="error" /></i></b>
		<br>
		<spring:message code="creation.elementcourses.adresse.libelle" />
		<form:input path="adresse" />
		<b><i><form:errors path="adresse" cssclass="error" /></i></b>
		<br>
		<spring:message code="creation.elementcourses.sexe.libelle" />
		<form:select path="sexe"  >
			<form:option value="FEMME">Femme </form:option>
			<form:option value="HOMME">Homme </form:option>
			</form:select>
		<spring:message code="creation.elementcourses.dateNaissance.libelle" />
		<form:input type="date"  path="dateNaissance" />
		<b><i><form:errors path="dateNaissance" cssclass="error" /></i></b>
		<br/>
		</div>
		<br/>
		<button type="submit">Envoyer</button>
	</form:form>
</div>
</body>
</html>