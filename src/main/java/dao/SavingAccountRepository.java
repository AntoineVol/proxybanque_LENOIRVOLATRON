package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.SavingAccount;

/**
 * Couche Repository dao des Comptes Epargnes
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Integer> {

}
