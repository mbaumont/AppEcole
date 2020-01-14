package gestionEleves.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
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
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaUpdate<Prof> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Prof.class);
		final Root<Prof> lRoot = lCriteriaUpdate.from(Prof.class);
		final Path<Prof> lPath = lRoot.get("id");
		final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pProf.getId());
		lCriteriaUpdate.where(lExpression);
		lCriteriaUpdate.set("nom", pProf.getNom());
		lCriteriaUpdate.set("adresse", pProf.getAdresse());
		lCriteriaUpdate.set("prenom", pProf.getPrenom());
		lCriteriaUpdate.set("sexe", pProf.getSexe());
		lCriteriaUpdate.set("dateNaissance", pProf.getDateNaissance());
		final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
		final int lRowCount = lQuery.executeUpdate();
		if (lRowCount != 1) {
			System.err.println(lRowCount);
		}
	}

	public Prof rechercherIdProf(Integer IdProf) {
		List<Prof> listProf = rechercherProf();
		for(Prof prof:listProf) {
			if(IdProf.equals(prof.getId())){
				return prof;
			}
		}
		return null;
		
	}



}
