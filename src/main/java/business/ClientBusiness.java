package business;

import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.ClientRepository;
import domain.Client;

/**
 * @author Volatron et Lenoir
 *
 */

public class ClientBusiness extends CrudBusiness<Client>{
	
	@Autowired
	ObjectFactory<ResearchComponent> clientObjectFactory;
	
	private ClientRepository getRepo() {
		return (ClientRepository) this.repo;
	}
	
	public ResearchComponent findAllByFirstNameAndLastName(String firstName, String lastName){
		ResearchComponent researchComponent  = this.clientObjectFactory.getObject();
		researchComponent.searchMethod(firstName, lastName);
		return researchComponent;
	}
	public List<Client> findAllByBirthday(Client client){
		return this.getRepo().findAllByBirthday(client);
	}
}
