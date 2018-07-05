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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import business.BankAccountBusiness;
import business.ClientBusiness;
import business.CurrentAccountBusiness;
import business.ResearchComponent;
import business.SavingAccountBusiness;
import domain.BankAccount;
import domain.Client;
import domain.CurrentAccount;

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


	/**
	 * Methode MVC d'accées à l'URL de la page d'acceuil de l'application
	 * 
	 * @return Le Model and View de la JSP Home.jsp
	 */


	@GetMapping({"/Home{idSearch}","/index{idSearch}"})
	public ModelAndView accessHome(@PathVariable Integer idSearch) {
		ModelAndView mav = new ModelAndView("Home");
		mav.addObject("idSearch", idSearch);
		mav.addObject("clientDate", new Client());
		mav.addObject("clientIdentification", new Client());
		return mav;
	}

	@PostMapping({ "/Home{idSearch}", "/index" })
	public String searchClient(@ModelAttribute Client clientIdentification) {
			Integer path;
			ResearchComponent researchComponent = this.clientBusiness.findAllByFirstNameAndLastName(
					clientIdentification.getFirstName(), clientIdentification.getLastName());
			if (researchComponent.getListClient().isEmpty() == true) {
				path=0;
			}else {
				path=researchComponent.getListClient().get(0).getId();
			}
			return "redirect:/Home"+path+".html";

	}
	
	@PostMapping("/Home/Date{idSearch}")
	public String checkDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate birthday, @PathVariable Integer idSearch) {
		int idClient = this.clientBusiness.validateClientBirthday(idSearch, birthday);
		if(idClient<1) {
			return "redirect:/Home"+idSearch+".html";
		} else if(idClient==0){
			return "redirect:/Home"+idSearch+".html";
		} else {
			Client client = this.clientBusiness.findById(idSearch);
			return URL_CLIENT+client.getId();
		}

	}
	
	@PostMapping("/Home/Date")
	public String accessAccount(){
		
		return URL_CLIENT + 3;
	}
	
	@GetMapping("/Client")
	public ModelAndView listCompte(@RequestParam Integer idClient){
		List<BankAccount> listCompte = new ArrayList<BankAccount>();
		//LOGGER.debug("Je suis làààààààààààààààààà");
		ModelAndView mav = new ModelAndView("Client");
		Client client = this.clientBusiness.findById(idClient);
		listCompte = this.bankAccountBusiness.getAllByClient(client);
		mav.addObject("listCompte", listCompte);
		return mav;

	}
}
