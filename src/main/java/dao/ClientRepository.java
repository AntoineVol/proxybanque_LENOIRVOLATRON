package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

	@Transactional
	public abstract List<Client> findAllByBirthday(Client client);

	@Transactional
	public abstract List<Client> findAllByFirstNameAndLastName(String FirstName, String LastName);
}
