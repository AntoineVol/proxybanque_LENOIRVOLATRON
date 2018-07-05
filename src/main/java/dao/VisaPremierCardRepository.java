package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.VisaPremierCard;

@Repository
public interface VisaPremierCardRepository extends JpaRepository<VisaPremierCard, Integer>{

}
