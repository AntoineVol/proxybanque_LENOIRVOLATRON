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
	
	/**
	 * Effectue la création ou la mise à jour dans le repo
	 * @param entity Object générique
	 * @return L'entité créer/mis à jour
	 */
	public ENTITY save(ENTITY entity) {
		return this.repo.save(entity);
	}
	/**
	 * Lance la procédure de création
	 * @param entity Object générique
	 * @return L'entité créer
	 */
	public ENTITY create(ENTITY entity){
		return this.save(entity);
	}
	/**
	 * Supprime une entité à partir de son id
	 * @param id id de l'entité à supprimer
	 */
	public void delete(Integer id){
		this.repo.deleteById(id);
	}
	/**
	 * Retourne une liste de toutes les entités
	 * @return La liste de toutes les entitées
	 */
	public List<ENTITY> findAll(){
		return this.repo.findAll();
	}
	/**
	 * Retourne une entité en fonction de son id
	 * @param id id de l'entité à trouver
	 * @return L'entité correspondant à l'id
	 */
	public ENTITY findById(Integer id){
		ENTITY result = null;
		final Optional<ENTITY> entity = this.repo.findById(id);
		if(entity.isPresent()) {
			result = entity.get();
		}
		return result;
	}
	/**
	 * Lance la procédure de mise à jour d'une entité. 
	 * Si l'id est null, c'est que l'entité n'existe pas, il n'est donc pas possible de la mettre à jour. Une exception est levée dans ce cas
	 * @param entity entité à mettre à jour
	 * @return L'entité mise à jour
	 */
	public ENTITY update(ENTITY entity){
		if (entity.getId()== null){
			throw new IllegalArgumentException("L'élement ne peut pas être mis à jour car il n'existe pas en BDD");
		}
		return this.repo.save(entity);
	}
	
}
		