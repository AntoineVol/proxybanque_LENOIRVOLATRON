<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="connectionStatus" value="Connected" />
<c:set var="clientFirstName" value="${client.firstName}" />
<c:set var="clientLastName" value="${client.lastName}" />
<c:set var="connectionColor" value="green" />
<%@ include file="navbar.jsp"%>
<body>
	<div id=margeHaute></div>

	<!-- RETRAIT -->
	<c:url value="/Client${client.id}/Withdrawal/Cash.html"
		var="cashWithdrawalUrl"></c:url>
	<c:url value="/Client${client.id}/Withdrawal/BankCard.html"
		var="bankCardWithdrawalUrl"></c:url>
	<c:url value="/Client${client.id}/Withdrawal/ChequeBanque.html"
		var="chequeBanquelUrl"></c:url>
	<div class="form-row  container-fluid">
		<div
			class="container-fluid d-flex justify-content-center align-items-center">

			<form method="post" action="${cashWithdrawalUrl}">
				<legend>Effectuer un retrait d'argent</legend>
				<div class="form-group">
					<label for="balance">Quel montant souhaitez vous retirer ?</label>
					<input type="number" class="form-control" name="amount"
						id="balance" min="0" required="required" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Valider</button>
				</div>
				<c:choose>
					<c:when test="${codeError==0}">
						<div class="alert alert-danger" role="alert">Il n'est pas
							permit de retirer plus de 300€ !</div>
					</c:when>
					<c:when test="${codeError==1}">
						<div class="alert alert-danger" role="alert">Le compte à
							debiter n'est pas assez approvisionner pour ce montant de
							virement !</div>
					</c:when>
					<c:when test="${codeError==2}">
						<div class="alert alert-danger" role="alert">Le compte à
							debiter n'est pas assez approvisionner pour ce montant de
							virement !</div>
					</c:when>
					<c:when test="${codeError==3}">
						<div class="alert alert-success" role="alert">Retrait
							effectuer !</div>
					</c:when>
				</c:choose>
				<div class="form-group">
					<input type="hidden" class="form-control" name="idCompte"
						id="idCompte" value="${compte.id}" required="required" />
				</div>
			</form>
		</div>
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<h3>---------------------------------------------</h3>
		</div>
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<form method="post" action="${bankCardWithdrawalUrl}">
				<legend>Effectuer un retrait de carte bancaire</legend>
				<div class="form-group">
					<label for="typeBanqueCard">Quel carte bancaire souhaitez
						vous?</label> <select name="typeBanqueCard" id="typeBanqueCard">
						<option value="VISA_PREMIER">VISA_PREMIER</option>
						<option value="VISA_ELECTRON">VISA_ELECTRON</option>
					</select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Valider</button>
				</div>
				<c:choose>
					<c:when test="${codeError==4}">
						<div class="alert alert-danger" role="alert">Impossible de
							retirer une nouvelle carte banquaire, il y en a déjà une en cours
							de validité !</div>
					</c:when>
					<c:when test="${codeError==5}">
						<div class="alert alert-success" role="alert">Nouvelle carte retirée !</div>
					</c:when>
				</c:choose>
				<div class="form-group">
					<input type="hidden" class="form-control" name="idCompte"
						id="idCompte" value="${compte.id}" required="required" />
				</div>
			</form>
		</div>
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<h3>---------------------------------------------</h3>
		</div>
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<form method="post" action="${chequeBanquelUrl}">
				<legend>Effectuer un retrait de chèque</legend>
				<input type="hidden" class="form-control" name="requestCheque"
						id="requestCheque" value="true" required="required" />
				<div class="form-group">
					<button type="submit" class="btn btn-success">Valider</button>
				</div>
				<c:choose>
					<c:when test="${codeError==6}">
						<div class="alert alert-danger" role="alert">Impossible de retirer un nouveau chéquier, votre dernier retrait date de moins de 3 mois</div>
					</c:when>
					<c:when test="${codeError==7}">
						<div class="alert alert-success" role="alert">Nouvelle chéquier retiré !</div>
					</c:when>
				</c:choose>
				<div class="form-group">
					<input type="hidden" class="form-control" name="idCompte"
						id="idCompte" value="${compte.id}" required="required" />
				</div>
			</form>
		</div>
	</div>
	<div id=margeHaute></div>
	<%@ include file="footer.jsp"%>
</body>
</html>



