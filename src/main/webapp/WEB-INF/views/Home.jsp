<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/home.css" />
<title>ProxiBanque</title>

<!-- LISTE DES URLs -->
<c:url value="/Home.html=" var="homeUrl" />

</head>

<body>
	<!-- Header-->
	<nav class="navbar fixed-top navbar-dark bg-dark">
		<!-- Logo banque-->
		<div class="col-md-2">
			<div class="navbar-brand">
				<a id="ListeClientColor" href="${homeUrl}" class="col-sm-3"> <img
					name="logo"
					src="${pageContext.request.contextPath}/images/logo-banque.jpg"
					alt="LOGO"></a>

			</div>
		</div>
		<!-- Titre page-->
		<div class="col-md-6 d-flex justify-content-center align-items-center">
			<h1>
				<font color="white">ProxiBanque</font>
			</h1>
		</div>
		<!-- UserName -->
		<div class="Connexion col-md-2">
			<h4>
				<font color="red" style="font-variant: small-caps;"><b>Client
						non identifié</b></font>
			</h4>
			<h5>
				<font color="green" style="font-variant: small-caps;"><b>Disconnected</b></font>
			</h5>
		</div>
		<!--  Logo déconnection -->
		<div class="col-md-2">
			<div class="navbar-brand">
				<a href="${homeUrl}"><img name="logo"
					src="${pageContext.request.contextPath}/images/Logout.png"
					alt="Logout"></a>
			</div>
		</div>
	</nav>
	<!-- Fin entête -->

	<!-- Contenu page -->
	<div class="container-fluid">
		<form:form modelAttribute="clientIdentification" method="post">
			<legend>Identification</legend>
			<div class="form-row">
				<div class="col">
					<form:input type="text" class="form-control" path="firstName"
						id="firstName" required="required" />
				</div>
				<div class="col">
					<form:input type="text" class="form-control" path="lastName"
						id="lastName" required="required" />
				</div>
				<div class="col">
					<form:input type="date" class="form-control" path="birthday"
						id="birthday" required="required" />
				</div>
				<div class="col">
					<button type="submit" class="btn btn-success">Modifier</button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- Fin du contenu page -->

	<!-- Pied de page -->
	<br>
	<br>
	<br>
	<br>
	<nav class="navbar fixed-bottom navbar-dark bg-dark">
		<footer class="container">
			<p>
				<font color="white"> 2018 © ProxiBanque. Tous droits
					réservés. </font>
			</p>
		</footer>
	</nav>
	<!-- Fin de pied de page -->	
</body>
</html>