package gestionEleves.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gestionEleves.bean.Prof;
import gestionEleves.bean.Sexe;
import gestionEleves.dao.IProfDao;


@Service
public class profService implements IProfService {

		@Autowired
		private IProfDao dao;

		
		@Transactional
		public List<Prof> rechercherProf() {
			return dao.rechercherProf();
		}
		@Transactional
		public Prof rechercherIdProf(Integer pIdProf) {
			return dao.rechercherIdProf(pIdProf);	
		}
		
		@Transactional
		public void supprimerProf(Integer pIdProf) {
			final Prof lProf = new Prof();
			lProf.setId(pIdProf);
			dao.supprimerProf(lProf);		
		}
		
		@Transactional
		public void modifierProf(Prof pProf) {
			dao.modifierProf(pProf);		
		}
		
		@Transactional
		public void creerProf(String nom, String prenom, String adresse, Date dateNaissance, Sexe sexe) {
			final Prof lprof = new Prof();
			lprof.setNom(nom);
			lprof.setPrenom(prenom);
			lprof.setAdresse(adresse);
			lprof.setDateNaissance(dateNaissance);
			lprof.setSexe(sexe);
			dao.creerProf(lprof);		
			
		}
}
