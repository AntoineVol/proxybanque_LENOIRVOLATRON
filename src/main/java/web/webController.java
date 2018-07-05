package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Client;

/**
 * Controller de l'application. Il permet la direction et la gestion des requettes HTTP
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Controller
public class webController {
	
	/**
	 * Url de la jsp d'acceuil
	 */
	private final String URL_HOME = "/home.html";
	/**
	 * Url de la jsp affichant les comptes du client
	 */
	private final String URL_CLIENT = "/client.html?id=";
	

	/**
	 * Methode MVC d'accées à l'URL de la page d'acceuil de l'application
	 * @return Le Model and View de la JSP Home.jsp
	 */
	@GetMapping({"/Home","/"})
	public ModelAndView accessHome() {
		ModelAndView mav = new ModelAndView("Home");
		mav.addObject("clientIdentification", new Client());
		return mav;
	}
	
	@PostMapping("/Home")
	public String checkClientIdentity(@ModelAttribute Client clientIdentification) {
		
		return URL_CLIENT+id;
	}
	
	

}
