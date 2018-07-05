<%@ include file="header.jsp"%>
<body>
	<div id=margeHaute></div>
	
	<!-- Liste d'URL -->
	<c:url value="/Retrait.html?idCompte=" var="retraitUrl" />
	<c:url value="/Virement.html?idCompte=" var="virementsUrl" />
	
	<div class="container-fluid d-flex justify-content-center align-items-center">
		<h5>Comptes du Client </h5>
		<table id="liste" class="listCompte">
			<thead style="font-variant: small-caps;">
				<tr>
					<th>Id du Compte</th>
					<th>Numéro de Compte</th>
					<th>Type de Compte</th>
					<th>Date de Création</th>
					<th>Solde du Compte</th>
					<th></th>
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
						<td><a href="${retraitUrl}${bankAccount.id}"
							class="btn btn-info">Effectuer un retrait</a></td>
						<td><a href="${virementsUrl}${bankAccount.id}"
							class="btn btn-primary">Effectuer un virements</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id=margeHaute></div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>