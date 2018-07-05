package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.SavingAccount;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Integer> {

}
