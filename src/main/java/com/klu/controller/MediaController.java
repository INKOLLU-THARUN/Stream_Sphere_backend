package com.klu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/media")
public class MediaController {
    @PostMapping("/upload")
    public ResponseEntity<String> uploadMedia(@RequestParam("file") MultipartFile file) {
        // Save file to backend storage and database
        return ResponseEntity.ok("File uploaded successfully!");
    }

    @GetMapping("/{id}")
    public void getMedia(@PathVariable Long id) {
        // Retrieve video/image from backend storage
    }
}
