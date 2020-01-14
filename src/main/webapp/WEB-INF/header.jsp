<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<meta charset="ISO-8859-1">


<title>Menu</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
 <c:url value="/Menu" var="url"></c:url> 
  <a class="navbar-brand" href="${url}">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item dropdown">
      	
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gestion des classes
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <c:url value="/affClasse" var="url"></c:url> 
          <a class="dropdown-item" href="${url}">Affichage</a>
          <c:url value="/creerFormClasse" var="url"></c:url> 
          <a class="dropdown-item" href="${url}">Creation</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gestion des professeurs
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <c:url value="/affProf" var="url"></c:url> 
          <a class="dropdown-item" href="${url}">Affichage</a>
          <c:url value="/creerFormProf" var="url"></c:url> 
          <a class="dropdown-item" href="${url}">Creation</a>
        </div>
      </li>
    </ul>
  </div>
</nav>

</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</html>