package info.sanaulla.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files")
public class FileUploadViewController {
    @GetMapping("/upload")
    public String uploadFilePage(){
        return "file-upload";
    }
}
