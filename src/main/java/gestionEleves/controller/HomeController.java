package gestionEleves.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/Menu", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		return "Menu";
	}
}
