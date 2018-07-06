package business;

import java.util.List;

import dao.BankAccountRepository;
import domain.BankAccount;
import domain.Client;

/**
 * Classe de service gérant les méthodes génériques concernant les comptes banquaires
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public class BankAccountBusiness extends CrudBusiness<BankAccount>{
	
	/**
	 * @return Le repo préalablement spécifié en tant que repository de Compte bancaire
	 */
	private BankAccountRepository getRepo() {
		return (BankAccountRepository) this.repo;
	}
	
	/**
	 * Permet l'obtention des compte d'un client sous forme de liste
	 * @param client
	 * @return La liste de compte d'un client
	 */
	public List<BankAccount> getAllByClient(Client client){
		return this.getRepo().getAllByClient(client);
	} 

}
