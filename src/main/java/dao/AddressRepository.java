package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Address;
/**
 * Couche Repository dao des adresses
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
