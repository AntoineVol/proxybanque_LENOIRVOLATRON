package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

//import javax.swing.SpringLayout.Constraints;

import org.junit.Before;
//import org.junit.FixMethodOrder;
import org.junit.Test;
//import org.junit.runners.MethodSorters;

public class RetraitTest {

	private TestApp app;
	
	@Before
	public void TestApp() {
		this.app = new TestApp();
	}
	
	// Un retrait en liquide ne dépasse pas la somme de 300€
	@Test
	public void doCashWithdrawalTEST() {
		assertThat(this.app.doCashWithdrawal(1, (long)450, 1), containsString("Withdrawal0.html"));
	}
	
	//Un retrait de carte pour un compte n’ayant pas encore de carte associée est validé immédiatement
	
	//Un retrait de carte pour un compte ayant déjà une carte associée est validé immédiatement si l’ancienne carte est expirée
	@Test
	public void doBankCardWithdrawal1TEST(){
		assertThat(this.app.doBankCardWithdrawal(1, null, 1), containsString("Withdrawal5.html"));
	}
	
	//Un retrait de carte pour un compte ayant déjà une carte associée est refusé avec le message « Impossible d’effectuer le retrait, votre ancienne carte est encore valide »
	@Test
	public void doBankCardWithdrawalTEST(){
		assertThat(this.app.doBankCardWithdrawal(1, "1", 1), containsString("Withdrawal4.html"));
	}

	// Un retrait de chéquier pour un compte n’ayant pas de chéquier est validé immédiatement
	@Test
	public void RequieredChequeBankTEST(){
		assertThat(this.app.RequieredChequeBank(1, "true", 1), containsString("Withdrawal7"));
	}
	
	//Un retrait de chéquier pour un compte ayant déjà un chéquier est validé immédiatement si le chéquier précédent a été reçu il y a au moins 3 mois
	@Test
	public void RequiredChequeBankMin3monthsTEST(){
		assertThat(this.app.RequieredChequeBank(1, "true", 3), containsString("Withdrawal7"));
	}
	//Un retrait de chéquier pour un compte ayant déjà un chéquier est refusé avec le message
	@Test
	public void RequiredChequeBankFALSE(){
		assertThat(this.app.RequieredChequeBank(1, null, 3), containsString("Withdrawal6"));
	}
}
