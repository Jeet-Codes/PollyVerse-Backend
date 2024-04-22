package org.example.pollyversebackend.Controller;

import jakarta.servlet.http.HttpServletResponse;

import org.example.pollyversebackend.Entity.FileData;
import org.example.pollyversebackend.Entity.FileStorage;
import org.example.pollyversebackend.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileService fileService;

    @Value("${project.file}")
    private String path;

    @PostMapping("/fileupload")
    public ResponseEntity<FileData> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = this.fileService.uploadFile(path, file);
        return new ResponseEntity<>(new FileData(filename,"Image is Successfully Uplaoded"),HttpStatus.OK);

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
