package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import business.ClientBusiness;
import business.ResearchComponent;
import domain.Client;

/**
 * Controller de l'application. Il permet la direction et la gestion des
 * requettes HTTP
 * 
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Controller
public class webController {

	/**
	 * Url de la jsp d'acceuil
	 */
	final String URL_HOME = "redirect:/home.html";
	/**
	 * Url de la jsp de contrôle de date de naissance
	 */
	final String URL_BIRTHDAY = "redirect:/home/date.html?id=";
	/**
	 * Url de la jsp affichant les comptes du client
	 */
	final String URL_CLIENT = "redirect:/client.html?id=";

	@Autowired
	ClientBusiness clientBusiness;

	/**
	 * Methode MVC d'accées à l'URL de la page d'acceuil de l'application
	 * 
	 * @return Le Model and View de la JSP Home.jsp
	 */

	@GetMapping({ "/Home", "/" })
	public ModelAndView accessHome() {
		ModelAndView mav = new ModelAndView("Home");
		mav.addObject("clientIdentification", new Client());
		return mav;
	}

	@PostMapping("/Home")
	public String searchClientName(@ModelAttribute Client clientIdentidfication) {
		ResearchComponent researchComponent = this.clientBusiness.findAllByFirstNameAndLastName(
				clientIdentidfication.getFirstName(), clientIdentidfication.getLastName());
		if (researchComponent.getListClient().isEmpty() == true) {
			return URL_HOME;
		} else {
			return URL_BIRTHDAY + researchComponent.getId();
		}
	}

	@GetMapping("Date")
	public ModelAndView accessDate() {
		ModelAndView mav = new ModelAndView("Date");
		mav.addObject("clientDate", new Client());
		return mav;
	}

}
