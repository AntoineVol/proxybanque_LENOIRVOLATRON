<%@ include file="header.jsp"%>
<body>
	<div id=margeHaute></div>

	<!-- RETRAIT -->
	<div class="container-fluid d-flex justify-content-center align-items-center">
		<div class="form-row align-items-center">
			<div class="form-group">
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
			</div>
			<form:form modelAttribute="compte" method="post">
				<legend>Effectuer un retrait</legend>
				<div class="form-group">
					<h5>Quel montant souhaitez vous retirer ?</h5>
					<form:input type="number" 
					class="form-control" 
					path="${compte.balance}" 
					id="balance" 
					min="0"
					 required="required" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Valider</button>
				</div>
			</form:form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>



