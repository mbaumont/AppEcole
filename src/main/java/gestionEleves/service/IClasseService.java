package gestionEleves.service;


import java.util.List;

import gestionEleves.bean.Classe;
import gestionEleves.bean.Prof;


public interface IClasseService {
	List<Classe> rechercherClasse();
	void creerClasse(final String nom, final Prof prof);
	void supprimerClasse(final Integer pIdClasse);
	void modifierClasse(final Classe pClasse);
	Classe rechercherIdClasse(final Integer pIdClasse);
}


