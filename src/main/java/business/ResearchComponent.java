package business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ClientRepository;
import domain.Client;

/**
 * Methode de recherche Client par son nom et prenom
 */
public class ResearchComponent {

	@Autowired
	ClientRepository repo;

	private List<Client> listClient;
	private Integer id;
	private static Integer count=0;
	
	
	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ResearchComponent() {
		this.id=++count;
	}


	public List<Client> searchMethod(String FirstName, String LastName){
		this.listClient = this.repo.findAllByFirstNameAndLastName(FirstName, LastName);
		return this.listClient;
	}
	
}
