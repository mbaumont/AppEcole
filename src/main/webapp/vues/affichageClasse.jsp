<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="../WEB-INF/header.jsp">
<c:param name="title" value="Menu" />
</c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Classes</title>
</head>
<body>
<div class="container-fluid m-4">
	<table class="table w-auto" border="1">
		<thead>
			<tr>
				<th><spring:message code="classe.Identifiant" /></th>
				<th><spring:message code="classe.Classe" /></th>
				<th><spring:message code="classe.Prof" /></th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listeClasse}" var="classe">
				<tr>
					<td><c:out value="${classe.id}" /></td>
					<td><c:out value="${classe.nom}" /></td>
					<td><c:out value="${classe.prof.nom}" /></td>
					<td><c:url value="/suppClasse" var="url">
							<c:param name="id" value="${classe.id}" />
						</c:url> <a href="${url}"> <spring:message
								code="suppression.supprimer.libelle" />
					</a></td>	
					<td><c:url value="/modifFormClasse" var="url">
							<c:param name="id" value="${classe.id}" />
						</c:url> <a href="${url}"> <spring:message
								code="suppression.modif.libelle" />
					</a></td>
							
				</tr>
			</c:forEach>

		</tbody>

	
	</table>
	<br/>
	<c:url value="/creerFormClasse" var="url">
	</c:url> <a href="${url}" class="btn btn-info"> <spring:message
			code="suppression.creation.libelle" /></a>
</div>
</body>
</html>