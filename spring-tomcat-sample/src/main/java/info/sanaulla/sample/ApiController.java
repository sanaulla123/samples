package info.sanaulla.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class ApiController {

	@Autowired PersonDAO personDao;
	
	@GetMapping
	public ResponseEntity<?> getPersons(){
		return ResponseEntity.ok(personDao.getPersons());
	}
}
