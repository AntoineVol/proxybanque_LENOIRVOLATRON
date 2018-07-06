package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.VisaPremierCard;

/**
 * Couche Repository dao des Cartes Visa PREMIER
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface VisaPremierCardRepository extends JpaRepository<VisaPremierCard, Integer>{

}
