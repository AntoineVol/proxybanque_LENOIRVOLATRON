package business;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import domain.Client;

/**
 * @author Volatron et Lenoir
 *
 */

public class ClientBusiness extends CrudBusiness<Client>{
	
	private Map<Integer, ResearchComponent> listResearchComponant= new HashMap<Integer, ResearchComponent>();
	
	@Autowired
	ObjectFactory<ResearchComponent> clientObjectFactory;
		
	public ResearchComponent findAllByFirstNameAndLastName(String firstName, String lastName){
		ResearchComponent researchComponent  = this.clientObjectFactory.getObject();
		researchComponent.searchMethod(firstName, lastName);
		listResearchComponant.put(researchComponent.getId(), researchComponent);
		return researchComponent;
	}

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
