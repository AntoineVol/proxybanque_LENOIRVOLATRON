package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Client;

/**
 * Couche Repository dao des Clients
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

	/**
	 * Methode méthode transactionnel qui créé une liste de client par date d'anniversaire
	 * @param client est un client déjà enregitré
	 * @return La liste des clients qui ont la même date d'anniversaire
	 */	
	@Transactional
	public abstract List<Client> findAllByBirthday(Client client);
	/**
	 * Methode méthode transactionnel qui créé une liste de client par Prénom ET Nom
	 * @param client est un client déjà enregitré
	 * @return La liste des clients qui ont le même Prénom ET Nom
	 */	
	@Transactional
	public abstract List<Client> findAllByFirstNameAndLastName(String FirstName, String LastName);
	/**
	 * Methode méthode transactionnel qui créé une liste de client par Prénom 
	 * @param client est un client déjà enregitré
	 * @return La liste des clients qui ont le même Prénom
	 */	
	@Transactional
	public abstract List<Client> findAllByFirstName(String FirstName);
	/**
	 * Methode méthode transactionnel qui créé une liste de client par Nom
	 * @param client est un client déjà enregitré
	 * @return La liste des clients qui ont le même Nom
	 */	
	@Transactional
	public abstract List<Client> findAllByLastName(String LastName);
}
