package business;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import domain.BankAccount;

public class WithdrawalMethod {
	
	
	public String doCashWithdrawal(Integer idClient, long amount,  Integer idCompte, BankAccountBusiness bankAccountBusiness) {
		BankAccount withdrawAccount = bankAccountBusiness.findById(idCompte);
		if(amount>300) {
			return "redirect:/Client"+idClient+"/Withdrawal0.html?idCompte="+idCompte;
		}else if(withdrawAccount.getBalance()<amount) {
			return "redirect:/Client"+idClient+"/Withdrawal1.html?idCompte="+idCompte;
		}
		withdrawAccount.setBalance(withdrawAccount.getBalance()-amount);
		bankAccountBusiness.update(withdrawAccount);
		return "redirect:/Client"+idClient+"/Withdrawal3.html?idCompte="+idCompte;
	}

}
