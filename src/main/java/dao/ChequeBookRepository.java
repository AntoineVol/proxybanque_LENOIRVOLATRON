package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.ChequeBook;

@Repository
public interface ChequeBookRepository extends JpaRepository<ChequeBook, Integer> {

}
