package business;

import java.util.List;

import dao.BankAccountRepository;
import domain.BankAccount;
import domain.Client;

public class BankAccountBusiness extends CrudBusiness<BankAccount>{
	
	private BankAccountRepository getRepo() {
		return (BankAccountRepository) this.repo;
	}
	
	public List<BankAccount> getAllByClient(Client client){
		return this.getRepo().getAllByClient(client);
	} 

}
