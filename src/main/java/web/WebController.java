package web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import business.BankAccountBusiness;
import business.ChequeBookBusiness;
import business.ClientBusiness;
import business.CurrentAccountBusiness;
import business.ResearchComponent;
import business.SavingAccountBusiness;
import business.VisaElectronCardBusiness;
import business.VisaPremierCardBusiness;
import business.WithdrawalMethod;
import domain.BankAccount;
import domain.Client;

/**
 * Controller de l'application. Il permet la direction et la gestion des
 * requettes HTTP
 * 
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Controller
public class WebController {

	/**
	 * Url de la jsp d'acceuil
	 */
	final String URL_HOME = "redirect:/Home.html";
	/**
	 * Url de la jsp de contrôle de date de naissance
	 */
	final String URL_BIRTHDAY = "redirect:/Home/Date.html?id=";
	/**
	 * Url de la jsp affichant les comptes du client
	 */
	final String URL_CLIENT = "redirect:/Client.html?idClient=";

	private static final Logger LOGGER = LoggerFactory.getLogger("fr.gtm.proxybanque_LENOIRVOLATRON");

	@Autowired
	ClientBusiness clientBusiness;
	@Autowired
	CurrentAccountBusiness currentAccountBusiness;
	@Autowired
	SavingAccountBusiness savingAccountBusiness;
	@Autowired
	BankAccountBusiness bankAccountBusiness;
	@Autowired
	ChequeBookBusiness chequeBookBusiness;
	@Autowired
	VisaElectronCardBusiness visaElectronCardBusiness;
	@Autowired
	VisaPremierCardBusiness visaPremierCardBusiness;
	@Autowired
	WithdrawalMethod withdrawalMethod;

	/**
	 * Methode MVC d'accées à l'URL de la page d'acceuil de l'application
	 * 
	 * @return Le Model and View de la JSP Home.jsp
	 */

	@GetMapping({ "/Home{idSearch}", "/index{idSearch}" })
	public ModelAndView accessHome(@PathVariable Integer idSearch) {
		ModelAndView mav = new ModelAndView("Home");
		mav.addObject("idSearch", idSearch);
		mav.addObject("clientDate", new Client());
		return mav;
	}

	@PostMapping({ "/Home{idSearch}", "/index" })

	public String searchClient(@RequestParam String name) {
		ResearchComponent researchComponent = null;
		Integer path;
		String[] nameArray = name.split(" ");
		if (nameArray.length == 1) {
			researchComponent = this.clientBusiness.findAllByFirstNameAndLastName(nameArray[0], null);
		} else if (nameArray.length == 2) {
			researchComponent = this.clientBusiness.findAllByFirstNameAndLastName(nameArray[0], nameArray[1]);
		} else {
			return "redirect:/Home-1.html";
		}

		if (researchComponent.getListClient().isEmpty() == true) {
			path = 0;
		} else {
			path = researchComponent.getId();
		}
		return "redirect:/Home" + path + ".html";

	}

	@PostMapping("/Home/Date{idSearch}")
	public String checkDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday,
			@PathVariable Integer idSearch) {
		int idClient = this.clientBusiness.validateClientBirthday(idSearch, birthday);
		if (idClient == 0) {
			return "redirect:/Home" + idSearch + "/Error0" + ".html";
		} else if (idClient < 0) {
			return "redirect:/Home" + idSearch + "/Error1" + ".html";
		} else {
			Client client = this.clientBusiness.findById(idClient);
			return URL_CLIENT + client.getId();
		}

	}

	@GetMapping({ "/Home{idSearch}/Error{codeError}" })
	public ModelAndView accessDateError(@PathVariable Integer idSearch, @PathVariable Integer codeError) {
		ModelAndView mav = new ModelAndView("Home");
		mav.addObject("idSearch", idSearch);
		mav.addObject("clientDate", new Client());
		mav.addObject("clientIdentification", new Client());
		return mav;
	}

	@GetMapping("/Client")
	public ModelAndView listCompte(@RequestParam Integer idClient) {
		List<BankAccount> listCompte = new ArrayList<BankAccount>();
		ModelAndView mav = new ModelAndView("Client");
		Client client = this.clientBusiness.findById(idClient);
		listCompte = this.bankAccountBusiness.getAllByClient(client);
		mav.addObject("listCompte", listCompte);
		mav.addObject("client", client);
		return mav;
	}

	@GetMapping("/Client{idClient}/Withdrawal{codeError}")
	public ModelAndView withdrawal(@PathVariable Integer idClient, @PathVariable Integer codeError,
			@RequestParam Integer idCompte) {
		ModelAndView mav = new ModelAndView("Withdrawal");
		BankAccount account = this.bankAccountBusiness.findById(idCompte);
		Client client = this.clientBusiness.findById(idClient);
		mav.addObject("compte", account);
		mav.addObject("client", client);
		mav.addObject("codeError", codeError);
		return mav;
	}

	@PostMapping("/Client{idClient}/Withdrawal/Cash")
	public String doCashWithdrawal(@PathVariable Integer idClient, @RequestParam long amount,
			@RequestParam Integer idCompte) {
		return withdrawalMethod.doCashWithdrawal(idClient, amount, idCompte);
	}

	@PostMapping("/Client{idClient}/Withdrawal/BankCard")
	public String doBankCardWithdrawal(@PathVariable Integer idClient, @RequestParam String typeBanqueCard,
			@RequestParam Integer idCompte) {
			return withdrawalMethod.doBankCardWithdrawal(idClient, typeBanqueCard, idCompte);
	}
	
	@GetMapping("/Client/MoneyTransfer{codeResponse}")
	public ModelAndView moneyTransfer(@RequestParam Integer idClient, @PathVariable Integer codeResponse) {
		ModelAndView mav = new ModelAndView("MoneyTransfer");
		Client client = this.clientBusiness.findById(idClient);
		List<BankAccount> listAccount = this.bankAccountBusiness.getAllByClient(client);
		mav.addObject("listAccount", listAccount);
		mav.addObject("client", client);
		mav.addObject("codeResponse", codeResponse);
		return mav;
	}

	@PostMapping("/Client/MoneyTransfer{codeError}")
	public String doMoneyTransfer(@RequestParam Integer idWithdrawAccount, @RequestParam Integer idPayedAccount,
			@RequestParam Integer amount, @RequestParam Integer idClient) {
		BankAccount withdrawAccount = this.bankAccountBusiness.findById(idWithdrawAccount);
		BankAccount payedAccount = this.bankAccountBusiness.findById(idPayedAccount);
		if (withdrawAccount.getId() == payedAccount.getId()) {
			return "redirect:/Client/MoneyTransfer0.html?idClient=" + idClient;
		} else if (amount > 900) {
			return "redirect:/Client/MoneyTransfer1.html?idClient=" + idClient;
		} else if (withdrawAccount.getBalance() < amount) {
			return "redirect:/Client/MoneyTransfer-1.html?idClient=" + idClient;
		} else {
			withdrawAccount.setBalance(withdrawAccount.getBalance() - amount);
			payedAccount.setBalance(payedAccount.getBalance() + amount);
			this.bankAccountBusiness.update(withdrawAccount);
			this.bankAccountBusiness.update(payedAccount);
			return "redirect:/Client/MoneyTransfer2.html?idClient=" + idClient;
		}
	}

	@PostMapping("/Client{idClient}/Withdrawal/ChequeBanque")
	public String RequieredChequeBank(@PathVariable Integer idClient, String requestCheque,
			@RequestParam Integer idCompte) {
		return withdrawalMethod.RequieredChequeBank(idClient, requestCheque, idCompte);
	}
}
