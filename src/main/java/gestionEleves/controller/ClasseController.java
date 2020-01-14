package gestionEleves.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gestionEleves.bean.Classe;
import gestionEleves.bean.Prof;
import gestionEleves.bean.Sexe;
import gestionEleves.controllerForm.ClasseForm;
import gestionEleves.controllerForm.CreationProfForm;
import gestionEleves.service.IClasseService;
import gestionEleves.service.IProfService;

@Controller
public class ClasseController {

	@Autowired
	private IClasseService service;
	@Autowired
	private IProfService serviceProf;
	
	@RequestMapping(value = "/affClasse", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Classe> lListeClasse = service.rechercherClasse();
		pModel.addAttribute("listeClasse", lListeClasse);
		return "affichageClasse";
	}
	
	@RequestMapping(value = "/suppClasse", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "id") final Integer pIdClasse, final ModelMap pModel) {
		service.supprimerClasse(pIdClasse);
		return afficher(pModel);
		
	}
	
	@RequestMapping(value="/creerFormClasse", method=RequestMethod.GET)
	public String affFormCreation(final ModelMap pModel) {
		final List<Prof> ListeProfs = serviceProf.rechercherProf();
		pModel.addAttribute("listeProfs", ListeProfs);
		pModel.addAttribute("creation", new ClasseForm());
		return "creationClasse";
	}
	
	@RequestMapping(value="/creerClasse",method=RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value = "creation") final ClasseForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {	
			Prof pProf = serviceProf.rechercherIdProf(pCreation.getIdProf());
			
			service.creerClasse(pCreation.getNom(),pProf);
		}
		return afficher(pModel);
	}
	
	@RequestMapping(value="modifClasse", method=RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value="modification") final ClasseForm pModif,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {
			Classe pClasse = new Classe();
			Prof pProf = serviceProf.rechercherIdProf(pModif.getIdProf());
			pClasse.setId(pModif.getId());
			pClasse.setNom(pModif.getNom());
			pClasse.setProf(pProf);		
			service.modifierClasse(pClasse);
		}
		return afficher(pModel);
		
	}
	
		
	
	@RequestMapping(value="modifFormClasse", method=RequestMethod.GET)
	public String affFromModif(@RequestParam(value = "id") final Integer pIdClasse, final ModelMap pModel) {
		final List<Prof> ListeProfs = serviceProf.rechercherProf();
		Classe classe = service.rechercherIdClasse(pIdClasse);
		ClasseForm cf = new ClasseForm();
		cf.setId(pIdClasse);
		cf.setIdProf(classe.getProf().getId());
		cf.setNom(classe.getNom());
		pModel.addAttribute("listeProfs", ListeProfs);
		pModel.addAttribute("modification", cf);
		return "modificationClasse";
	}
	
	
	
}
