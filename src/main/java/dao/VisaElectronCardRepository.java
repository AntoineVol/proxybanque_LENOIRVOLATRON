package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.VisaElectronCard;

/**
 * Couche Repository dao des Cartes Visa ELECTRON
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface VisaElectronCardRepository extends JpaRepository<VisaElectronCard, Integer> {

}
