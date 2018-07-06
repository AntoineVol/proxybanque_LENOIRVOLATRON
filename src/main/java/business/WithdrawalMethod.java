package business;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import domain.BankAccount;
import domain.ChequeBook;
import domain.CurrentAccount;
import domain.TypeBankCard;
import domain.VisaElectronCard;
import domain.VisaPremierCard;


public class WithdrawalMethod {

	@Autowired
	BankAccountBusiness bankAccountBusiness;
	@Autowired
	CurrentAccountBusiness currentAccountBusiness;
	@Autowired
	VisaElectronCardBusiness visaElectronCardBusiness;
	@Autowired
	VisaPremierCardBusiness visaPremierCardBusiness;
	@Autowired
	ChequeBookBusiness chequeBookBusiness;
	
	public String doCashWithdrawal(Integer idClient, long amount, Integer idCompte) {
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

	public String doBankCardWithdrawal( Integer idClient,  String typeBanqueCard, Integer idCompte) {
		int idCard;
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
				idCard = this.visaElectronCardBusiness.create(cbElectron).getId();
				withdrawAccount.setBankCard(this.visaElectronCardBusiness.findById(idCard));
				
			} else if (typeBanqueCard.equals("VISA_PREMIER")) {
				VisaPremierCard cbPremier = new VisaPremierCard();
				cbPremier.setTypeBankCard(TypeBankCard.VISA_PREMIER);
				cbPremier.setCurrentAccount(withdrawAccount);
				cbPremier.setExpirationDate(today.plusYears(1));
				cbPremier.setNumBankCard((idCompte + idClient) * 3);
				idCard = this.visaPremierCardBusiness.create(cbPremier).getId();
				withdrawAccount.setBankCard(this.visaPremierCardBusiness.findById(idCard));
			}
			this.bankAccountBusiness.update(withdrawAccount);
			return ("redirect:/Client" + idClient + "/Withdrawal5.html?idCompte=" + idCompte).toString();
		}
	}
	
	public String RequieredChequeBank( Integer idClient, String requestCheque,
			Integer idCompte) {
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
