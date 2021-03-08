package info.sanaulla.demo.controller.rest;

import info.sanaulla.demo.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/files")
public class FileUploadAPIController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(
            @RequestParam("uploaded-file") List<MultipartFile> uploadedFiles)
        throws IOException {
        log.debug("Uploaded files size : {}", uploadedFiles.size());
        fileService.copyFile(uploadedFiles);
        return ResponseEntity.ok().build();
    }
}
