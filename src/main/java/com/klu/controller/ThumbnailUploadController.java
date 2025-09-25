package com.klu.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload/thumbnail")
@CrossOrigin(origins = "http://localhost:5173") // Allow frontend requests
public class ThumbnailUploadController {

    private final String UPLOAD_DIR = "src/main/resources/static/thumbnails/";

    @PostMapping
    public ResponseEntity<String> uploadThumbnail(@RequestParam("file") MultipartFile file) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(filePath, file.getBytes());

            return ResponseEntity.ok("Thumbnail uploaded successfully: " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Thumbnail upload failed!");
        }
    }
}
