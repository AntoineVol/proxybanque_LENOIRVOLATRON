package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.BankAccount;
import domain.Client;

/**
 * Couche Repository dao des Comptes Bancaires
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

	@Transactional
	public List<BankAccount> getAllByClient(Client client);
	

}

