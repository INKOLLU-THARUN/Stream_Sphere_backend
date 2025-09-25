package com.klu.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thumbnails")
@CrossOrigin(origins = "http://localhost:5173")
public class ThumbnailController {

    @Value("${media.thumbnails.path}") // Load from application.properties
    private String thumbnailsDirectory;

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> getThumbnail(@PathVariable String fileName) {
        try {
            Path filePath = Paths.get(thumbnailsDirectory, fileName); // No casting needed
            Resource fileResource = new UrlResource(filePath.toUri()); // Correct import

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Correct MediaType import
                    .body(fileResource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
