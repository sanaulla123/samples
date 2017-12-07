package info.sanaulla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import info.sanaulla.repos.CountryRepository;
import info.sanaulla.service.CountryService;

@Controller
@RequestMapping("/")
public class ViewController {

	@Autowired CountryService countryService;
	
	
	@GetMapping({"/", "/countries"})
	public ModelAndView countries(ModelAndView model) {
		model.getModel().put("continents", countryService.getContinents());
		model.getModel().put("regions", countryService.getRegions());
		model.setViewName("countries");
		return model;
	}
}
