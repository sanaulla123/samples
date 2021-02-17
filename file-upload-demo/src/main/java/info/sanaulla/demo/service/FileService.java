package info.sanaulla.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

    public void copyFileUsingCommons(List<CommonsMultipartFile> uploadedFiles) throws IOException{
        try {
            Path docRootPath = Path.of(documentRoot);
            if ( !Files.exists(docRootPath)){
                Files.createDirectory(docRootPath);
            }
            for (CommonsMultipartFile multipartFile : uploadedFiles) {
                log.debug("Multipart storage location {}", multipartFile.getStorageDescription());
                copy(multipartFile);
            }
        } catch (IOException e) {
            log.error("Error occurred while copying file", e);
            throw e;
        }
    }

    public void copyFile(List<MultipartFile> uploadedFiles) throws IOException{

        try {
            Path docRootPath = Path.of(documentRoot);
            if ( !Files.exists(docRootPath)){
                Files.createDirectory(docRootPath);
            }
            for (MultipartFile multipartFile : uploadedFiles) {
                copy(multipartFile);
            }
        } catch (IOException e) {
            log.error("Error occurred while copying file", e);
            throw e;
        }
    }

    private void copy(MultipartFile multipartFile) throws IOException{
        String fileName = multipartFile.getOriginalFilename();
        String normalizedFileName = FilenameUtils.normalize(fileName);
        multipartFile.transferTo(Path.of(documentRoot, normalizedFileName));
    }
}
