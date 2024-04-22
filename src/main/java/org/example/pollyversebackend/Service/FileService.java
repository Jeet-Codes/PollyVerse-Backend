package org.example.pollyversebackend.Service;

import org.example.pollyversebackend.Entity.FileStorage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public interface FileService {
    String uploadFile(String path,MultipartFile file) throws IOException;

    InputStream downloadFile(String path,String fileName) throws IOException;

    List<FileStorage> listFiles() throws IOException;
}
