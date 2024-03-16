package com.example.icebooking.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.icebooking.services.FileStorageService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("files")
@AllArgsConstructor
public class FileController {
    private final FileStorageService fileStorageService;

    // get a specific uploaded file by its path
    @GetMapping("/**")
    public ResponseEntity<?> getFile(HttpServletRequest request) {
        String filePath = request.getRequestURI()
                .split(request.getContextPath() + "/files/")[1];
        return fileStorageService.load(filePath);
    }
}
