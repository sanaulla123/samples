package info.sanaulla;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ViewController {

	@GetMapping({"/", "/countries"})
	public ModelAndView countries(ModelAndView model) {
		model.setViewName("countries");
		return model;
	}
}
