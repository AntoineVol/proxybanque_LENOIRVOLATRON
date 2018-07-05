<%@ include file="header.jsp"%>
<body>
	<div id=margeHaute></div>
	<div
		class="container-fluid d-flex justify-content-center align-items-center">
		<form:form modelAttribute="clientIdentification" method="post">
			<legend>Identification</legend>
			<div class="form-group">
				<form:input type="text" class="form-control" path="firstName"
					id="firstName" placeholder="Prenom" required="required" />
			</div>
			<div class="form-group">
				<form:input type="text" class="form-control" path="lastName"
					id="lastName" placeholder="Nom" required="required" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">Valider</button>
			</div>
		</form:form>
		<div class="dropdown-menu"></div>
		<div id=margeHaute></div>
		<%@ include file="footer.jsp"%>
</body>
</html>