package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.BankCard;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Integer> {

}
