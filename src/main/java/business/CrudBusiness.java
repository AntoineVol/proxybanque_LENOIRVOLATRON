package business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import domain.Entity;

/**
 * La classe CrudBusiness définis les méthodes typiques du CRUD en lien avec la JPA Repository
 * @author Fabien LENOIR & Antoine VOLATRON
 *
 */
public abstract class CrudBusiness<ENTITY extends Entity>{
	
	@Autowired
	JpaRepository<ENTITY, Integer> repo;
	
	public ENTITY save(ENTITY entity) {
		return this.repo.save(entity);
	}
	public ENTITY create(ENTITY entity){
		return this.repo.save(entity);
	}
	public void delete(Integer id){
		this.repo.deleteById(id);
	}
	public List<ENTITY> findAll(){
		return this.repo.findAll();
	}
	public ENTITY findById(Integer id){
		ENTITY result = null;
		final Optional<ENTITY> entity = this.repo.findById(id);
		if(entity.isPresent()) {
			result = entity.get();
		}
		return result;
	}
	public ENTITY update(ENTITY entity){
		if (entity.getId()== null){
			throw new IllegalArgumentException("L'élement ne peut pas être mis à jour car il n'existe pas en BDD");
		}
		return this.repo.save(entity);
	}
}
		