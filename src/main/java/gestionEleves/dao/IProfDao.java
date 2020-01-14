package gestionEleves.dao;

import java.util.List;

import gestionEleves.bean.Prof;


public interface IProfDao {
	List<Prof> rechercherProf();
	void creerProf(final Prof pProf);
	void supprimerProf(final Prof pProf);
	void modifierProf(final Prof pProf);
	Prof rechercherIdProf(Integer IdProf);
}
