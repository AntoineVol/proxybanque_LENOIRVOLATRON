<%@ include file="header.jsp"%>
<body>
	<div id=margeHaute></div>
	<div
		class="container-fluid d-flex justify-content-center align-items-center">
		<c:choose>
			<c:when test="${empty idSearch or idSearch==0}">
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
					<c:if test="${idSearch==0}">
						<div class="alert alert-danger" role="alert">Le prenom ou le
							nom est erroné !</div>
					</c:if>
				</form:form>

			</c:when>
			<c:otherwise>
				<form:form modelAttribute="clientDate" method="post"
					>
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
			</c:otherwise>
		</c:choose>
		<div id=margeHaute></div>
		<%@ include file="footer.jsp"%>
</body>
</html>