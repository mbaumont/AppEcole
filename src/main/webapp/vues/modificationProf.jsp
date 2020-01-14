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
<title>Modification Prof </title>
</head>
<body>
<div class="container-fluid m-4">

  
<form:form method="post" modelAttribute="modification"
		action="modifierProf">
		<div class="form border m-1 p-2">
		<div class="form-group">
		<form:input path="id" type="hidden" class="form-control"/>
		<b><i><form:errors path="id" cssclass="error" /></i></b>
		</div>
		<div class="form-group">
		<form:label path="nom"> <spring:message code="creation.elementcourses.nom.libelle" /></form:label>
		<form:input path="nom" />
		
		<b><i><form:errors path="nom" cssclass="error" /></i></b>
		<br>
		</div>
		
		<div class="form-group">
		<spring:message code="creation.elementcourses.prenom.libelle" />
		<form:label path="prenom"><form:input path="prenom" /></form:label>
		<b><i><form:errors path="prenom" cssclass="error" /></i></b>
		<br>
		</div>
		<div class="form-group">
		<spring:message code="creation.elementcourses.adresse.libelle" />
		<form:label path="adresse"><form:input path="adresse"  /></form:label>
		<b><i><form:errors path="adresse" cssclass="error" /></i></b>
		<br>
		</div>
		<div class="form-group">
		<form:label id="sexe" path="sexe"><spring:message code="creation.elementcourses.sexe.libelle" /></form:label>
		<form:select path="sexe" id="sexe"  >
			<form:option value="FEMME">Femme </form:option>
			<form:option value="HOMME">Homme </form:option>
			</form:select>
		<br>
		</div>
		<div class="form-group">
		<form:label path="dateNaissance"><spring:message code="creation.elementcourses.dateNaissance.libelle" /></form:label>
		<form:input type="date"  path="dateNaissance"  />
		<b><i><form:errors path="dateNaissance" cssclass="error" /></i></b>
		<br>
		</div>
		<div class="form-group">
		<button type="submit">Envoyer</button>
		</div>
		</div>
	</form:form>
	
</div>
</body>
</html>