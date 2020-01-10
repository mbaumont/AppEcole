package gestionEleves.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gestionEleves.bean.Prof;


@Service
public class profService implements IProfService {

		@Autowired
		private IProfDao dao;

		
		@Transactional
		public List<Prof> rechercherProf() {
			return dao.rechercherProf();
		}
		@Transactional
		public void creerProf(Prof pProf) {
			// TODO Auto-generated method stub
			
		}
		
		@Transactional
		public void supprimerProf(Integer pIdProf) {
			final Prof lProf = new Prof();
			lProf.setId(pIdProf);
			dao.supprimerProf(lProf);
			
		}
		
		@Transactional
		public void modifierProf(Prof pProf) {
			// TODO Auto-generated method stub
			
		}
}