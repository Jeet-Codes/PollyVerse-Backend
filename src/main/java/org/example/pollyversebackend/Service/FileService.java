package org.example.pollyversebackend.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


public interface FileService {
    String uploadFile(String path,MultipartFile file) throws IOException;

    InputStream downloadFile(String path,String fileName) throws IOException;
}
