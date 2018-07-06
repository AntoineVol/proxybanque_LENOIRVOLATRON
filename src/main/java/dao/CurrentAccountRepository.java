package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.CurrentAccount;

/**
 * Couche Repository dao des Comptes Courants
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Integer> {

}
