package business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ClientRepository;
import domain.Client;

/**
 * Element de requête
 * Celui-ci est généré à chaque requête faite sur un nom d'utilisateur*
 * Les instances sont constituées d'un id pour l'identifier, de la liste de client correspondant à la recherche
 * L'élement contient également un compteur statique pour la génération d'id
 */
/**
 * @author Adminl
 *
 */
public class ResearchComponent {

	@Autowired
	ClientRepository repo;

	private List<Client> listClient;
	private Integer id;
	private static Integer count=0;
	
	
	/**
	 * Getter de la liste de client correspondant à la requete
	 * @return La liste de client correspondant à la requete
	 */
	public List<Client> getListClient() {
		return listClient; 
	}

	/**
	 * Setter de la liste de client
	 * @param listClientListe de client remontée par la recherche dans la base
	 */
	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	/**
	 * Getter de l'id de la requête
	 * @return id de la requete
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter de l'id
	 * @param id id de la requête
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	/**
	 * Constructeur par defaut
	 * L'id est auto généré par le compteur de la classe 
	 */
	public ResearchComponent() {
		this.id=++count;
	}


	/**
	 * Methode de recherche de correspondance entre le champs de formulaire et les client en BDD.
	 * Cette méthode est utilisé dans le cas ou l'utilisateur à indiqué deux chaines de caractères séparées par un espace
	 * @param FirstName Prénom du client recherché
	 * @param LastName Nom du client recherché
	 * @return La liste de client trouvé
	 */
	public List<Client> searchMethod(String FirstName, String LastName){
		this.listClient = this.repo.findAllByFirstNameAndLastName(FirstName, LastName);
		return this.listClient;
	}
	/**
	 * Methode de recherche de correspondance entre le champs de formulaire et les client en BDD.
	 * Cette méthode est utilisé dans le cas ou l'utilisateur à indiqué une seule chaine de caractère
	 * La recherche se base sur les prenom et sur les nom
	 * @param name Prénom ou nom du client recherché
	 * @return La liste de client ayant le prenom ou le nom correspondant au champs du formulaire
	 */
	public List<Client> searchMethod(String name){
		this.listClient = this.repo.findAllByFirstName(name);
		this.listClient.addAll(this.repo.findAllByLastName(name));
		return this.listClient;
	}
}
