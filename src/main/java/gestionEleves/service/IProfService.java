package gestionEleves.service;

import java.util.Date;
import java.util.List;

import gestionEleves.bean.Prof;
import gestionEleves.bean.Sexe;

public interface IProfService {
	List<Prof> rechercherProf();
	void creerProf(final String nom, final String prenom, final String adresse, final Date dateNaissance, final Sexe sexe);
	void supprimerProf(final Integer pIdProf);
	void modifierProf(final Prof pProf);
	Prof rechercherIdProf(final Integer pIdProf);
}
