package info.sanaulla.demo.controller.rest;

import info.sanaulla.demo.service.FileService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("unit-test")
public class FileUploadAPIControllerE2ETest {
    @Autowired
    MockMvc mockMvc;

    @Value("${app.document-root}")String documentRoot;

    List<Path> filesToBeDeleted = new ArrayList<>();

    @Test
    public void test_handleFileUpload() throws Exception {
        String fileName = "sampleFile.txt";
        MockMultipartFile sampleFile = new MockMultipartFile("uploaded-file",
                fileName, "text/plain",
                "This is the file content".getBytes());

        MockMultipartHttpServletRequestBuilder multipartRequest =
                MockMvcRequestBuilders.multipart("/api/files/upload");

        mockMvc.perform(multipartRequest.file(sampleFile))
                .andExpect(status().isOk());

        Path docRootPath = Path.of(documentRoot, fileName);
        filesToBeDeleted.add(docRootPath);
        assertThat(Files.exists(docRootPath)).isTrue();

    }

    @AfterEach
    public void cleanup() {
        filesToBeDeleted.forEach(path -> {
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
