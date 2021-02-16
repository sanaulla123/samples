package info.sanaulla.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
public class FileService {
    @Value("${app.document-root}")String documentRoot;

    public void copyFile(List<MultipartFile> uploadedFiles) throws IOException{

        try {
            Path docRootPath = Path.of(documentRoot);
            if ( !Files.exists(docRootPath)){
                Files.createDirectory(docRootPath);
            }
            for (MultipartFile multipartFile : uploadedFiles) {
                String fileName = multipartFile.getOriginalFilename();
                multipartFile.transferTo(Path.of(documentRoot, fileName));
            }
        } catch (IOException e) {
            log.error("Error occurred while copying file", e);
            throw e;
        }
    }
}
