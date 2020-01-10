package gestionEleves.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gestionEleves.bean.Prof;
import gestionEleves.dao.IProfService;

@Controller
public class SupprimerProfController {

	@Autowired
	private IProfService service;

	@RequestMapping(value = "/affSuppProf", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Prof> lListeProf = service.rechercherProf();
		pModel.addAttribute("listeProf", lListeProf);
		return "suppression";
	}

	@RequestMapping(value = "/suppProf", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "id") final Integer pIdProf, final ModelMap pModel) {
		service.supprimerProf(pIdProf);
		return afficher(pModel);
	}
	
}
