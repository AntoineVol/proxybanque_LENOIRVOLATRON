package test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.WithdrawalMethod;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/test-dispatcher-servlet.xml"})
public class RetraitTest {

	@Autowired
	WithdrawalMethod app;
	
	// Un retrait en liquide ne dépasse pas la somme de 300€
	@Test
	public void testRetraitSOLDE450() {
		assertThat(this.app.doCashWithdrawal(5, (long)450, 9), containsString("Withdrawal0.html"));
	}
	
	//Un retrait de carte pour un compte ayant déjà une carte associée est validé immédiatement si l’ancienne carte est expirée
	@Test
	public void testCarteExpiree(){
		assertThat(this.app.doBankCardWithdrawal(1, "VISA_PREMIER", 2), containsString("Withdrawal5.html"));
	}
	
	//Un retrait de carte pour un compte ayant déjà une carte associée est refusé avec le message « Impossible d’effectuer le retrait, votre ancienne carte est encore valide »
	@Test
	public void testRetraitCarteSurCompteAvecDejaCarte(){
		assertThat(this.app.doBankCardWithdrawal(5, "CURRENT_ACCOUNT", 5), containsString("Withdrawal4.html"));
	}

	// Un retrait de chéquier pour un compte n’ayant pas de chéquier est validé immédiatement
	@Test
	public void testRetraitChequierSiPasDeChequier(){
		assertThat(this.app.RequieredChequeBank(5, "true", 6), containsString("Withdrawal7"));
	}
	
	//Un retrait de chéquier pour un compte ayant déjà un chéquier est validé immédiatement si le chéquier précédent a été reçu il y a au moins 3 mois
	@Test
	public void testRetraitChequierSiAncienPlus3Mois(){
		assertThat(this.app.RequieredChequeBank(1, "true", 1), containsString("Withdrawal7"));
	}
	//Un retrait de chéquier pour un compte ayant déjà un chéquier est refusé avec le message
	@Test
	public void testRetraitChequierCompteAvecChequier(){
		assertThat(this.app.RequieredChequeBank(9, null, 6), containsString("Withdrawal6"));
	}
}
