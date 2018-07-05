package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import business.ClientBusiness;
import business.CurrentAccountBusiness;
import business.ResearchComponent;
import domain.Client;
import domain.CurrentAccount;
import domain.TypeBankAccount;

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
	final String URL_CLIENT = "redirect:/client.html?id=";
	

	@Autowired
	ClientBusiness clientBusiness;
	
	@Autowired
	CurrentAccountBusiness currentAccountBusiness;

	/**
	 * Methode MVC d'accées à l'URL de la page d'acceuil de l'application
	 * 
	 * @return Le Model and View de la JSP Home.jsp
	 */


	@GetMapping({"/Home{idSearch}","/index{idSearch}"})
	public ModelAndView accessHomeError(@PathVariable Integer idSearch) {
		CurrentAccount compte = new  CurrentAccount();
		compte.setBalance(500.00);
		compte.setTypeBankAccount(TypeBankAccount.CURRENT_ACCOUNT);
		this.currentAccountBusiness.create(compte);
		ModelAndView mav = new ModelAndView("Home");
		mav.addObject("idSearch", idSearch);
		mav.addObject("clientDate", new Client());
		mav.addObject("clientIdentification", new Client());
		return mav;
	}

	@PostMapping({ "/Home{idSearch}", "/index" })
	public String searchClientName(@ModelAttribute Client clientIdentification) {
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

	
	@PostMapping("/Home{idSearch}")
	public String searchDateClient(@ModelAttribute Client clientDate, @PathVariable Integer idSearch) {
		int idClient = this.clientBusiness.validateClientBirthday(idSearch, clientDate.getBirthday());
		if(idClient<1) {
			return "redirect:/Home"+idSearch+".html";
		} else if(idClient==0){
			return "redirect:/Home"+idSearch+".html";
		} else {
			Client client = this.clientBusiness.findById(idSearch);
			return URL_CLIENT+client.getId();
		}
		
	}

}
