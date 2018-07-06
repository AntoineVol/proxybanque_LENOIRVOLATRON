package business;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import domain.Client;

/**
 * Service gérant les fonctionnalitées liés au client
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */

public class ClientBusiness extends CrudBusiness<Client>{
	
	/**
	 * Liste des requêtes d'identification effectuées
	 */
	private Map<Integer, ResearchComponent> listResearchComponant= new HashMap<Integer, ResearchComponent>();
	
	@Autowired
	ObjectFactory<ResearchComponent> clientObjectFactory;
		
	/**
	 * Methode de recherche d'une ou plusieurs correspondance entre la saisi d'identifiant utilisateur et l'existance d'un utilisateur en BDD
	 * La recherche peut être faite le nom, le prenom, le nom et prenom séparé par un espace mais pas forcement ordonné
	 * @param firstPartName Première chaine de caractère reperé dans le champs de formulaire
	 * @param secondPartName Seconde chaine de caractère reperé dans le champs de formulaire, null si non presente
	 * @return L'element de requête constitué par la recherche
	 */
	public ResearchComponent findAllByFirstNameAndLastName(String firstPartName, String secondPartName){
		ResearchComponent researchComponent  = this.clientObjectFactory.getObject();
		if(secondPartName==null) {
			researchComponent.searchMethod(firstPartName);
		}else {
			researchComponent.searchMethod(firstPartName, secondPartName);
		}
		if(researchComponent.getListClient().size()==0) {
			researchComponent.searchMethod(secondPartName,firstPartName);
		}
		listResearchComponant.put(researchComponent.getId(), researchComponent);
		return researchComponent;
	}

	/**
	 * Methode de validation de la correspondance entre la date de naissance d'un client remonté par une requête et la date renseigné dans le formulaire
	 * @param idResearchComponant id de la requête effectuée lors du renseignement du nom
	 * @param birthday	Date de naissance renseignée dans le formulaire
	 * @return 0 si aucune correspondance n'est trouvée, -1 si il y a plusieurs coorespondances entre les clients trouvés précedement et la date de naissance, id du client si une seule correspondance est trouvée 
	 */
	public int validateClientBirthday(Integer idResearchComponant,LocalDate birthday){
		int matchAccount=0;
		int resultId=0;
		for(Client client : listResearchComponant.get(idResearchComponant).getListClient()){
			if(client.getBirthday().equals(birthday)) {
				
				matchAccount++;
				resultId = client.getId();
			}
		}
		if(matchAccount>1) {
			return -1;
		}else {
			return resultId;
		}
		
	}

}
