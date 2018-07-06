package test;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import business.BankAccountBusiness;
import business.ChequeBookBusiness;
import business.ClientBusiness;
import business.CurrentAccountBusiness;
import business.SavingAccountBusiness;
import business.VisaElectronCardBusiness;
import business.VisaPremierCardBusiness;
import domain.BankAccount;
import domain.ChequeBook;
import domain.CurrentAccount;
import domain.TypeBankCard;
import domain.VisaElectronCard;
import domain.VisaPremierCard;

public class TestApp {
	
	/**
	 * Urls
	 */
	final String URL_HOME = "redirect:/Home.html";
	final String URL_BIRTHDAY = "redirect:/Home/Date.html?id=";
	final String URL_CLIENT = "redirect:/Client.html?idClient=";

	ClientBusiness clientBusiness;
	CurrentAccountBusiness currentAccountBusiness;
	SavingAccountBusiness savingAccountBusiness;
	BankAccountBusiness bankAccountBusiness;
	ChequeBookBusiness chequeBookBusiness;
	VisaElectronCardBusiness visaElectronCardBusiness;
	VisaPremierCardBusiness visaPremierCardBusiness;

	public String doCashWithdrawal(@PathVariable Integer idClient, @RequestParam long amount,
			@RequestParam Integer idCompte) {
		BankAccount withdrawAccount = this.bankAccountBusiness.findById(idCompte);
		if (amount > 300) {
			return "redirect:/Client" + idClient + "/Withdrawal0.html?idCompte=" + idCompte;
		} else if (withdrawAccount.getBalance() < amount) {
			return "redirect:/Client" + idClient + "/Withdrawal1.html?idCompte=" + idCompte;
		}
		withdrawAccount.setBalance(withdrawAccount.getBalance() - amount);
		this.bankAccountBusiness.update(withdrawAccount);
		return ("redirect:/Client" + idClient + "/Withdrawal3.html?idCompte=" + idCompte).toString();
	}

	public String doBankCardWithdrawal(@PathVariable Integer idClient, @RequestParam String typeBanqueCard,
			@RequestParam Integer idCompte) {
		CurrentAccount withdrawAccount = this.currentAccountBusiness.findById(idCompte);
		LocalDate today = LocalDate.now();
		if (withdrawAccount.getBankCard() != null && withdrawAccount.getBankCard().getExpirationDate().isAfter(today)) {
			return "redirect:/Client" + idClient + "/Withdrawal4.html?idCompte=" + idCompte;
		} else {
			if (typeBanqueCard.equals("VISA_ELECTRON")) {
				VisaElectronCard cbElectron = new VisaElectronCard();
				cbElectron.setTypeBankCard(TypeBankCard.VISA_ELECTRON);
				cbElectron.setCurrentAccount(withdrawAccount);
				cbElectron.setExpirationDate(today.plusYears(1));
				cbElectron.setNumBankCard((idCompte + idClient) * 3);
				this.visaElectronCardBusiness.create(cbElectron);
			} else if (typeBanqueCard.equals("VISA_PREMIER")) {
				VisaPremierCard cbPremier = new VisaPremierCard();
				cbPremier.setTypeBankCard(TypeBankCard.VISA_PREMIER);
				cbPremier.setCurrentAccount(withdrawAccount);
				cbPremier.setExpirationDate(today.plusYears(1));
				cbPremier.setNumBankCard((idCompte + idClient) * 3);
				this.visaPremierCardBusiness.create(cbPremier);
			}
			return ("redirect:/Client" + idClient + "/Withdrawal5.html?idCompte=" + idCompte).toString();
		}
	}

	public String RequieredChequeBank(@PathVariable Integer idClient, String requestCheque,
			@RequestParam Integer idCompte) {
		ChequeBook reqChequeBook = null;
		reqChequeBook = this.chequeBookBusiness.findById(idCompte);
		CurrentAccount withdrawAccount = this.currentAccountBusiness.findById(idCompte);
		LocalDate today = LocalDate.now();
		if (reqChequeBook != null && today.minusMonths(3).isBefore(reqChequeBook.getReceptionDate())) {
			return "redirect:/Client" + idClient + "/Withdrawal6.html?idCompte=" + idCompte;
		}
		ChequeBook chequeBook = new ChequeBook();
		chequeBook.setReceptionDate(today.plusDays(7));
		chequeBook.setSendDate(today);
		chequeBook.setBankAccount(withdrawAccount);
		this.chequeBookBusiness.create(chequeBook);
		return ("redirect:/Client" + idClient + "/Withdrawal7.html?idCompte=" + idCompte).toString();
	}
}
