package org.example.pollyversebackend.Service.ServiceImp;


import org.example.pollyversebackend.Service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService implements FileService {



    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

        //File Name
        String name=file.getOriginalFilename();
        //Fullpath

        //Random Generator
        String randomID= UUID.randomUUID().toString();
        String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));

        String filePath=path+ File.separator+name;
        //Create Folder if not Created
        File f=new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        //File Copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return name;
    }

    @Override
    public InputStream downloadFile(String path, String fileName) throws IOException {
        String fullPath=path+File.separator+fileName;
        InputStream is=new FileInputStream(fullPath);
//        DB login to return inputStream


        return is;
    }
}
