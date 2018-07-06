package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import business.ResearchComponent;

/**
 * Couche Repository dao des Comptes Courants
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface ResearchComponentRepository extends JpaRepository<ResearchComponent, Integer>{

}
