package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.VisaElectronCard;

@Repository
public interface VisaElectronCardRepository extends JpaRepository<VisaElectronCard, Integer> {

}
