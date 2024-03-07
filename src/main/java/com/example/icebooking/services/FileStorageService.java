package com.icekiwi.vanisharing.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.icekiwi.vanisharing.exceptions.StorageFileNotFoundException;

@Service
public class FileStorageService {
    private final Path uploadDirectory = Paths.get("uploads");

    public ResponseEntity<?> load(String file) {
        try {
            System.out.println(file);
            Path p = uploadDirectory.resolve(file);
            System.out.println(p);
            Resource resource = new UrlResource(p.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                String.format("attachement; filename=\"%s\"", resource.getFilename()))
                        .body(resource);
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + file);

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String saveFile(String path, MultipartFile multipartFile) {
        Path p = uploadDirectory.resolve(path);
        if (!Files.exists(p))
            try {
                Files.createDirectories(p);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path filePath = p.resolve(multipartFile.getOriginalFilename()).normalize();
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return String.format("%s/%s", path, multipartFile.getOriginalFilename());
        } catch (IOException e) {
        }

        return null;
    }
}
