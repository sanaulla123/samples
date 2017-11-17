package info.sanaulla.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

	@Autowired PersonDAO personDao;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("persons", personDao.getPersons());
		return "index";
	}
}
