package gestionEleves.controller;

import java.text.SimpleDateFormat;
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

import gestionEleves.bean.Prof;
import gestionEleves.bean.Sexe;
import gestionEleves.controllerForm.CreationProfForm;
import gestionEleves.service.IProfService;


@Controller
public class ProfController {

	@Autowired
	private IProfService service;

	@RequestMapping(value = "/affProf", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Prof> lListeProf = service.rechercherProf();
		pModel.addAttribute("listeProf", lListeProf);
		return "affichageProf";
	}

	@RequestMapping(value = "/suppProf", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "id") final Integer pIdProf, final ModelMap pModel) {
		service.supprimerProf(pIdProf);
		return afficher(pModel);
		
	}
	@RequestMapping(value="/creerFormProf", method=RequestMethod.GET)
	public String affFormCreation(final ModelMap pModel) {
		pModel.addAttribute("creation", new CreationProfForm());
		return "creationProf";
	}
	
	@RequestMapping(value="/modifFormProf", method=RequestMethod.GET)
	public String affFormModif(@RequestParam(value = "id") final Integer pIdProf, final ModelMap pModel) {
		Prof prof = service.rechercherIdProf(pIdProf);
		CreationProfForm pf = new CreationProfForm();
		pf.setId(pIdProf);
		pf.setAdresse(prof.getAdresse());
		pf.setNom(prof.getNom());
		pf.setSexe(prof.getSexe().name());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(prof.getDateNaissance());  
		pf.setDateNaissance(strDate);
		pf.setPrenom(prof.getPrenom());
		pModel.addAttribute("modification", pf);
		return "modificationProf";
	}
	
	@RequestMapping(value = "/creerProf", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value = "creation") final CreationProfForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {			
			Date dateNaissance = new Date();
			try {
				dateNaissance = convertDate(pCreation.getDateNaissance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Sexe sexe = Sexe.FEMME;
			System.out.println(pCreation.getSexe());
			
			if(pCreation.getSexe().equalsIgnoreCase("HOMME")) sexe = Sexe.HOMME;
			
			service.creerProf(pCreation.getNom(),pCreation.getPrenom(),pCreation.getAdresse(), dateNaissance,sexe);
		}
		return afficher(pModel);
	}
	@RequestMapping(value="/modifierProf",method=RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value="modification") final CreationProfForm pModif,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {
			Prof pProf = new Prof();
			Integer id = pModif.getId();
			pProf.setId(id);
			pProf.setAdresse(pModif.getAdresse());
			pProf.setNom(pModif.getNom());
			pProf.setPrenom(pModif.getPrenom());
			Date dateNaissance = new Date();
			try {
				dateNaissance = convertDate(pModif.getDateNaissance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			pProf.setDateNaissance(dateNaissance);
			Sexe sexe = Sexe.FEMME;
			System.out.println(pModif.getSexe());
			
			if(pModif.getSexe().equalsIgnoreCase("HOMME")) sexe = Sexe.HOMME;
			pProf.setSexe(sexe);
			
			System.out.println(pProf.getAdresse());
			service.modifierProf(pProf);
		}
		return afficher(pModel);
		
	}
	
	
	public Date convertDate(String date) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaissance = sdf.parse(date);
		return dateNaissance;
	}
}
