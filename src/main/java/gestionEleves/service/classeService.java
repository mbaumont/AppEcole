package gestionEleves.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gestionEleves.bean.Classe;
import gestionEleves.bean.Prof;
import gestionEleves.dao.IClasseDao;

@Service
public class classeService implements IClasseService {

	@Autowired
	private IClasseDao dao;
	
	@Transactional
	public List<Classe> rechercherClasse() {
		return dao.rechercherClasse();
	}

	@Transactional
	public void creerClasse(String nom, Prof prof) {
		final Classe lclasse = new Classe();
		lclasse.setNom(nom);
		lclasse.setProf(prof);
		dao.creerClasse(lclasse);		
	}

	@Transactional
	public void supprimerClasse(Integer pIdClasse) {
		final Classe lClasse = new Classe();
		lClasse.setId(pIdClasse);
		dao.supprimerClasse(lClasse);
		
	}

	@Transactional
	public void modifierClasse(Classe pClasse) {
		dao.modifierClasse(pClasse);
	}

	@Transactional
	public Classe rechercherIdClasse(Integer pIdClasse) {
		return dao.rechercherIdClasse(pIdClasse);	
	}

}
