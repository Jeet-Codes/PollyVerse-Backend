package org.example.pollyversebackend.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class JsFileController {

    @GetMapping("/js-code")
    public ResponseEntity<String> getJsCode() {
        try {
            // Path to your JavaScript file inside src/main/resources/static
            Resource resource = new ClassPathResource("static/file.js");
            byte[] jsFileContent = Files.readAllBytes(Paths.get(resource.getURI()));
            String jsCode = new String(jsFileContent);
            return new ResponseEntity<>(jsCode, HttpStatus.OK);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Failed to read the file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
