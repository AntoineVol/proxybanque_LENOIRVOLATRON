<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="connectionStatus" value="Disconnected" />
<c:set var="clientFirstName" value="Client" />
<c:set var="clientLastName" value="non identifié" />
<c:set var="connectionColor" value="red" />
<%@ include file="navbar.jsp"%>
<body>

	<div id=margeHaute></div>
	<div
		class="container-fluid d-flex justify-content-center align-items-center">
		<c:choose>
			<c:when test="${empty idSearch or idSearch==0 or idSearch==-1}">
				<form method="post">
					<legend>Identification</legend>
					<div class="form-group">
						<input type="text" class="form-control" name="name" id="name"
							placeholder="Prenom Nom" required="required" /> <small
							id="nameHelpInline" class="text-muted"> Les prenom
							composés doivent être lié par un "-" </small>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">Valider</button>
					</div>
					<c:if test="${idSearch==0}">
						<div class="alert alert-danger" role="alert">Le prenom ou le
							nom est erroné !</div>
					</c:if>
					<c:if test="${idSearch==-1}">
						<div class="alert alert-danger" role="alert">Il ne peut y avoir 3 parties de nom. Pour les nom composés, utilisé les "-" !</div>
					</c:if>
				</form>

			</c:when>
			<c:otherwise>
				<c:url value="/Home/Date${idSearch}.html" var="dateUrl" />
				<form method="post" action="${dateUrl}">
					<legend>Renseigner votre date de naissance</legend>
					<div class="form-group">
						<input type="date" class="form-control" name="birthday"
							id="birthday" required="required" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">Valider</button>
					</div>
					<c:if test="${codeError==0}">
						<div class="alert alert-danger" role="alert">Aucun résultat,
							veuillez vous adresser à un conseiller!</div>
					</c:if>
					<c:if test="${codeError==1}">
						<div class="alert alert-danger" role="alert">Il existe
							plusieurs clients identique pour ce couple (nom/prenom/date de
							naissance) !</div>
					</c:if>
				</form>
				<div class="dropdown-menu"></div>
				<div id=margeHaute></div>
			</c:otherwise>
		</c:choose>
		<div id=margeHaute></div>
		<%@ include file="footer.jsp"%>
</body>
</html>