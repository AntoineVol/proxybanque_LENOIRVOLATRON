<%@ include file="header.jsp"%>
<c:set var="connectionStatus" value="Connected" />
<c:set var="clientFirstName" value="${client.firstName}" />
<c:set var="clientLastName" value="${client.lastName}" />
<c:set var="connectionColor" value="green" />
<%@ include file="navbar.jsp"%>
<body>
	<div id=margeHaute></div>

	<!-- RETRAIT -->
	<div class="form-row  container-fluid">
		<h5>Votre solde est actuellement de :</h5>
		<table>
			<thead style="font-variant: small-caps;">
				<tr>
					<th>Solde du Compte</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${compte.balance}</td>
				</tr>
		</table>
		<div
			class="container-fluid d-flex justify-content-center align-items-center">

			<form method="post">
				<legend>Effectuer un retrait</legend>
				<div class="form-group">
					<label for="balance">Quel montant souhaitez vous retirer ?</label>
					<input type="number" class="form-control" name="balance"
						id="balance" min="0" required="required" />
				</div>
				<div class="form-group">
					<label for="withdrawMean">Quel moyen de retrait voulez vous
						utiliser ?</label> <select name="withdrawMean" id="withdrawMean">
						<option value="cash">Cash</option>
						<option value="bankCard">Carte bancaire</option>
						<option value="chequeBook">Chequier</option>
					</select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Valider</button>
				</div>
				<c:if test="${codeResponse==-1}">
					<div class="alert alert-danger" role="alert">Le compte à
						debiter n'est pas assez approvisionner pour ce montant de virement
						!</div>
				</c:if>
				<div class="form-group">
					<input type="hidden" class="form-control" name="idCompte"
						id="idCompte" value="${compte.id}"  required="required" />
				</div>
			</form>
		</div>
	</div>
	<div id=margeHaute></div>
	<%@ include file="footer.jsp"%>
</body>
</html>



