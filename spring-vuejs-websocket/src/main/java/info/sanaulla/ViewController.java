package info.sanaulla;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/websocket")
    public String websocketView(){
        return "websocket";
    }
}
