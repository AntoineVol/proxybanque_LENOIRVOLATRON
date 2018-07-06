package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.ChequeBook;

/**
 * Couche Repository dao des Cheques
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface ChequeBookRepository extends JpaRepository<ChequeBook, Integer> {

}
