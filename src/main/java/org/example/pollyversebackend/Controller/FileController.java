package org.example.pollyversebackend.Controller;

import jakarta.servlet.http.HttpServletResponse;

import org.example.pollyversebackend.Entity.FileData;
import org.example.pollyversebackend.Entity.FileStorage;
import org.example.pollyversebackend.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileService fileService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${project.file}")
    private String path;

    @PostMapping("/fileupload")
    public ResponseEntity<FileData> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = this.fileService.uploadFile(path, file);
        return new ResponseEntity<>(new FileData(filename,"Image is Successfully Uplaoded"),HttpStatus.OK);

    }

    @GetMapping("/viewfile/{filename}")
    public ResponseEntity<Resource> viewFile(@PathVariable String filename) throws IOException {
        // Construct the file path based on the Files folder
        String filePath = "file:Files/" + filename; // Point to the Files directory

        Resource resource = resourceLoader.getResource(filePath);

        // Check if the resource exists
        if (!resource.exists()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Return the resource with the appropriate headers
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"") // Inline view
                .contentType(MediaType.parseMediaType(Files.probeContentType(Paths.get("Files/" + filename))))
                .body(resource);
    }



    @PostMapping("/multipleFileUpload")
    public ResponseEntity<List<FileData>> uploadFiles(@RequestParam("files") MultipartFile[] files) throws IOException {

        List<FileData> fileDataList = new ArrayList<>();

        for (MultipartFile file : files) {
            String filename = this.fileService.uploadFile(path, file);
            fileDataList.add(new FileData(filename, "File is Successfully Uploaded"));
        }

        return new ResponseEntity<>(fileDataList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public void DownloadFile(@PathVariable String name, HttpServletResponse response) throws IOException {

        InputStream resourse=this.fileService.downloadFile(path,name);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        StreamUtils.copy(resourse,response.getOutputStream());

    }

    @GetMapping
    public List<FileStorage> getall() throws IOException {
        List<FileStorage> allPaths=fileService.listFiles();
        return allPaths;
    }
}
