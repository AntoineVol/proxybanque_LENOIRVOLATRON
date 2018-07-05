package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Integer> {

}
