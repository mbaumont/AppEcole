package gestionEleves.dao;

import java.util.List;

import gestionEleves.bean.Classe;

public interface IClasseDao {
	List<Classe> rechercherClasse();
	void creerClasse(final Classe pClasse);
	void supprimerClasse(final Classe pClasse);
	void modifierClasse(final Classe pClasse);
	Classe rechercherIdClasse(Integer IdClasse);
}
