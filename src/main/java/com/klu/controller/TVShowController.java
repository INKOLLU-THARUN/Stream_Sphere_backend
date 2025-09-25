package com.klu.controller;

import com.klu.entity.TVShow;
import com.klu.repository.TVShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tvshows")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"}) // Allow frontend requests
public class TVShowController {
    
    @Autowired
    private TVShowRepository tvShowRepository;

    // Fetch all TV shows from the database
    @GetMapping
    public List<TVShow> getAllTVShows() {
        return tvShowRepository.findAll();
    }

    // Fetch a single TV show by ID
    @GetMapping("/{id}")
    public ResponseEntity<TVShow> getTVShowById(@PathVariable Long id) {
        return tvShowRepository.findById(id)
                .map(show -> ResponseEntity.ok(show))
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new TV show to the database
    @PostMapping("/add")
    public ResponseEntity<String> addTVShow(@RequestBody TVShow tvShow) {
        tvShowRepository.save(tvShow);
        return ResponseEntity.ok("TV show added successfully!");
    }

    // Delete a TV show by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTVShow(@PathVariable Long id) {
        tvShowRepository.deleteById(id);
        return ResponseEntity.ok("TV show deleted successfully!");
    }
}
