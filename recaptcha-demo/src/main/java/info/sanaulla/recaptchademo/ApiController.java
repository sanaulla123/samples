package info.sanaulla.recaptchademo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired UserRepository userRepository;
	@Autowired RecaptchaService captchaService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid User user, 
			@RequestParam(name="g-recaptcha-response") String recaptchaResponse,
			HttpServletRequest request){
		
		String ip = request.getRemoteAddr();
		String captchaVerifyMessage = 
			captchaService.verifyRecaptcha(ip, recaptchaResponse);
		
		if ( StringUtils.isNotEmpty(captchaVerifyMessage)) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", captchaVerifyMessage);
			return ResponseEntity.badRequest()
					.body(response);
		}
		
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> users(){
		return ResponseEntity.ok(userRepository.findAll());
	}
}
