package gestionEleves.dao;

import java.util.List;

import gestionEleves.bean.Prof;

public interface IProfService {
	List<Prof> rechercherProf();
	void creerProf(final Prof pProf);
	void supprimerProf(final Integer pIdProf);
	void modifierProf(final Prof pProf);
	
}
