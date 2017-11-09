package info.sanaulla.recaptchademo;

import java.util.HashMap;
import java.util.Map;

public class RecaptchaUtil {

	public static final Map<String, String> RECAPTCHA_ERROR_CODE = new HashMap<>();
    static {
    	RECAPTCHA_ERROR_CODE.put("missing-input-secret", 
    			"The secret parameter is missing");
    	RECAPTCHA_ERROR_CODE.put("invalid-input-secret", 
    			"The secret parameter is invalid or malformed");
    	RECAPTCHA_ERROR_CODE.put("missing-input-response", 
    			"The response parameter is missing");
    	RECAPTCHA_ERROR_CODE.put("invalid-input-response", 
    			"The response parameter is invalid or malformed");
    	RECAPTCHA_ERROR_CODE.put("bad-request", 
    			"The request is invalid or malformed");
    }
}
