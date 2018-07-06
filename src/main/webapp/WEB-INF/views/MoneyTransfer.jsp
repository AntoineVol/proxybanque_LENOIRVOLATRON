<%@ include file="header.jsp"%>
<c:set var="connectionStatus" value="Connected" />
<c:set var="clientFirstName" value="${client.firstName}" />
<c:set var="clientLastName" value="${client.lastName}" />
<c:set var="connectionColor" value="green" />
<%@ include file="navbar.jsp"%>

<body>

	<div id=margeHaute></div>
	<div
		class="container-fluid d-flex justify-content-center align-items-center">

		<form method="post">
			<c:url value="/Client.html?idClient=${client.id}" var="listeClientsUrl" />
			<a class="btn btn-warning" href="${listeClientsUrl} ">Retour
				à la liste des comptes</a>
			<legend>Effectuer un virement</legend>
			<div class="form-group">
				<label for="withdrawAccount">Compte à debiter</label> <select
					name="idWithdrawAccount" id="idWithdrawAccount">
					<c:forEach var="bankAccount" items="${listAccount}">
						<option value="${bankAccount.id} ">n° :
							${bankAccount.numAccount} | Solde : ${bankAccount.balance}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="payedAccount">Compte à crediter</label> <select
					name="idPayedAccount" id="idPayedAccount">
					<c:forEach var="bankAccount" items="${listAccount}">
						<option value="${bankAccount.id} ">n° :
							${bankAccount.numAccount} | Solde : ${bankAccount.balance}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="amount">Montant</label>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text" id="amountSign">€</span>
					</div>
					<input type="number" class="form-control" name="amount" id="amount"
						placeholder="Montant"
						aria-describedby="validationTooltipUsernamePrepend" required />

				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">Effectuer le
					virement</button>
			</div>
			<c:if test="${codeResponse==-1}">
				<div class="alert alert-danger" role="alert">Le compte à
					debiter n'est pas assez approvisionner pour ce montant de virement
					!</div>
			</c:if>
			<c:if test="${codeResponse==0}">
				<div class="alert alert-danger" role="alert">Il n'est pas
					possible d'effectuer un virement d'un compte sur lui-même !</div>
			</c:if>
			<c:if test="${codeResponse==1}">
				<div class="alert alert-danger" role="alert">Les virements
					sont limités à 900€!</div>
			</c:if>
			<c:if test="${codeResponse==2}">
				<div class="alert alert-success" role="alert">Virement
					effectué !</div>
			</c:if>
			<div class="form-group">
				<input type="hidden" class="form-control" name="idClient"
					id="idClient" value="${client.id}" />
			</div>
		</form>
		<div id=margeHaute></div>
		<%@ include file="footer.jsp"%>
</body>
</html>