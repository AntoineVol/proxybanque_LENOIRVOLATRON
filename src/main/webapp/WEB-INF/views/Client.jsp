<%@ include file="header.jsp"%>
<c:set var="connectionStatus" value="Connected" />
<c:set var="clientFirstName" value="${client.firstName}" />
<c:set var="clientLastName" value="${client.lastName}" />
<c:set var="connectionColor" value="green" />
<%@ include file="navbar.jsp"%>
<body>
	<div id=margeHaute></div>

	<!-- Liste d'URL -->
	<c:url value="/Client${client.id}/Withdrawal.html?idCompte=" var="retraitUrl" />
	<c:url value="/Client/MoneyTransfer.html?idClient=${client.id}" var="virementsUrl" />

	<div
		class="container-fluid d-flex justify-content-center align-items-center">
		<div>
			<h5>Comptes du Client</h5>

			<table id="liste" class="listCompte">
				<thead style="font-variant: small-caps;">
					<tr>
						<th>Id du Compte</th>
						<th>Numéro de Compte</th>
						<th>Type de Compte</th>
						<th>Date de Création</th>
						<th>Solde du Compte</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bankAccount" items="${listCompte}">
						<tr>
							<td>${bankAccount.id}</td>
							<td>${bankAccount.numAccount}</td>
							<td>${bankAccount.typeBankAccount}</td>
							<td>${bankAccount.creationDate}</td>
							<td>${bankAccount.balance}</td>
							<c:choose>
								<c:when
									test="${bankAccount.typeBankAccount == 'CURRENT_ACCOUNT'}">
									<td><a href="${retraitUrl}${bankAccount.id}"
										class="btn btn-info">Effectuer un retrait</a></td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>

			</table>
			<a href="${virementsUrl}${bankAccount.id}" class="btn btn-primary">Effectuer
				un virements</a>
		</div>
		<div id=margeHaute></div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>