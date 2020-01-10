package gestionEleves.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import gestionEleves.bean.Prof;



@Repository
public class profDao implements IProfDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Prof> rechercherProf() {
		final CriteriaBuilder eCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Prof> eCriteriaQuery = eCriteriaBuilder.createQuery(Prof.class);
		final Root<Prof> eRoot = eCriteriaQuery.from(Prof.class);
		eCriteriaQuery.select(eRoot);
		final TypedQuery<Prof> eTypedQuery = entityManager.createQuery(eCriteriaQuery);
		return eTypedQuery.getResultList();
	}

	public void creerProf(Prof pProf) {
		entityManager.persist(pProf);
		
	}

	public void supprimerProf(Prof pProf) {
		final Prof eProf = entityManager.getReference(Prof.class, pProf.getId());
		entityManager.remove(eProf);
		
	}

	public void modifierProf(Prof pProf) {

	}

}
