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
<c:url value="/Home.html" var="homeUrl" />

<!-- Header-->
<nav class="navbar fixed-top navbar-dark bg-dark">
	<!-- Logo banque-->
	<div class="col-md-3">
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
			<font color="${connectionColor}" style="font-variant: small-caps;"><b>${clientFirstName} ${clientLastName}</b></font>
		</h4>
		<h5>
			<font color="${connectionColor}" style="font-variant: small-caps;"><b>${connectionStatus}</b></font>
		</h5>
	</div>
	<!--  Logo déconnection -->
	<div class="col-md-1">
		<div class="navbar-brand">
			<a href="${homeUrl}"><img name="logo"
				src="${pageContext.request.contextPath}/images/Logout.png"
				alt="Logout"></a>
		</div>
	</div>
</nav>
<!-- Fin entête -->
</head>