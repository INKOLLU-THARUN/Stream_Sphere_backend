package com.klu.controller;

import com.klu.entity.Movie;
import com.klu.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"}) // Allow frontend requests
public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;

    // Fetch all movies from the database
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Fetch a single movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(movie -> ResponseEntity.ok(movie))
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new movie to the database
    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return ResponseEntity.ok("Movie added successfully!");
    }

    // Delete a movie by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return ResponseEntity.ok("Movie deleted successfully!");
    }
}
