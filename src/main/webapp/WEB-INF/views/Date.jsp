<%@ include file="header.jsp"%>
<body>
	<c:url value="/Home/Date/${idResearchComponent}.html" var="postDateUrl" />
	<div id=margeHaute></div>
	<div
		class="container-fluid d-flex justify-content-center align-items-center">
		<form:form modelAttribute="clientDate" method="post" action=postDateUrl>
			<legend>Renseigner votre date de naissance</legend>
			<div class="form-group">
				<form:input type="date" class="form-control" path="birthday"
					id="birthday" required="required" />
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