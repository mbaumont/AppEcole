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

import gestionEleves.bean.Classe;


@Repository
public class classeDao implements IClasseDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Classe> rechercherClasse() {
		final CriteriaBuilder eCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Classe> eCriteriaQuery = eCriteriaBuilder.createQuery(Classe.class);
		final Root<Classe> eRoot = eCriteriaQuery.from(Classe.class);
		eCriteriaQuery.select(eRoot);
		final TypedQuery<Classe> eTypedQuery = entityManager.createQuery(eCriteriaQuery);
		return eTypedQuery.getResultList();
		}

	public void creerClasse(Classe pClasse) {
		entityManager.persist(pClasse);
		
	}

	public void supprimerClasse(Classe pClasse) {
		final Classe eclasse = entityManager.getReference(Classe.class, pClasse.getId());
		entityManager.remove(eclasse);
	}

	public void modifierClasse(Classe pClasse) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaUpdate<Classe> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Classe.class);
		final Root<Classe> lRoot = lCriteriaUpdate.from(Classe.class);
		final Path<Classe> lPath = lRoot.get("id");
		final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pClasse.getId());
		lCriteriaUpdate.where(lExpression);
		lCriteriaUpdate.set("nom", pClasse.getNom());
		lCriteriaUpdate.set("prof", pClasse.getProf());
		final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
		final int lRowCount = lQuery.executeUpdate();
		if (lRowCount != 1) {
			System.err.println(lRowCount);
		}
	}

	public Classe rechercherIdClasse(Integer IdClasse) {
		List<Classe> listClasse = rechercherClasse();
		for(Classe classe:listClasse) {
			if(IdClasse.equals(classe.getId())){
				return classe;
			}
		}
		return null;
	}

}
