package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.BankCard;

/**
 * Couche Repository dao des Cartes Bancaires
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Integer> {

}
