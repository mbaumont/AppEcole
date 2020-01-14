<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="../WEB-INF/header.jsp">
<c:param name="title" value="Menu" />
</c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><spring:message code="titre.suppression.prof" /></title>
</head>
<body>
<div class="container-fluid m-4">
	<table class="table w-auto" border="1">
		<thead>
			<tr>
				<th><spring:message code="colonne.identifiant" /></th>
				<th><spring:message code="colonne.nom" /></th>
				<th><spring:message code="colonne.prenom" /></th>
				<th><spring:message code="colonne.adresse" /></th>
				<th><spring:message code="colonne.sexe" /></th>
				<th><spring:message code="colonne.date_naissance" /></th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listeProf}" var="prof">
				<tr>
					<td><c:out value="${prof.id}" /></td>
					<td><c:out value="${prof.nom}" /></td>
					<td><c:out value="${prof.prenom}" /></td>
					<td><c:out value="${prof.adresse}" /></td>
					<td><c:out value="${prof.sexe}" /></td>
					<td><c:out value="${prof.dateNaissance}" /></td>
					<td><c:url value="/suppProf" var="url">
							<c:param name="id" value="${prof.id}" />
						</c:url> <a href="${url}"> <spring:message
								code="suppression.supprimer.libelle" />
					</a></td>
					<td><c:url value="/modifFormProf" var="url">
							<c:param name="id" value="${prof.id}" />
						</c:url> <a href="${url}"> <spring:message
								code="suppression.modif.libelle" />
					</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
	<c:url value="/creerFormProf" var="url">
	</c:url> <a class="btn btn-info" href="${url}"> <spring:message
			code="suppression.creation.libelle" /></a>
</div>
</body>
</html>