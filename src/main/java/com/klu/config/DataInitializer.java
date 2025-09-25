package com.klu.config;

import com.klu.entity.Movie;
import com.klu.entity.User;
import com.klu.repository.MovieRepository;
import com.klu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Initialize movies if none exist
        if (movieRepository.count() == 0) {
            Movie movie1 = new Movie();
            movie1.setTitle("MARCO (Backend)");
            movie1.setThumbnail("/thumbnails/1738472442795_MARCO-Gun_2feb_landscape_thumb.jpg");
            movie1.setVideoUrl("/movies/MARCO.mp4");

            Movie movie2 = new Movie();
            movie2.setTitle("MAHAAN (Backend)");
            movie2.setThumbnail("/thumbnails/mahaan-movie-review-1.jpg");
            movie2.setVideoUrl("/movies/MAHAAN.mp4");

            Movie movie3 = new Movie();
            movie3.setTitle("SARIPODAA SANIVAARAM (Backend)");
            movie3.setThumbnail("/thumbnails/Saripodhaa-Sanivaaram-first-show.jpg");
            movie3.setVideoUrl("/movies/SARIPODHAA SANIVAARAM.mp4");

            Movie movie4 = new Movie();
            movie4.setTitle("GREATEST OF ALL TIME (Backend)");
            movie4.setThumbnail("/thumbnails/goat-vijay-1600.avif");
            movie4.setVideoUrl("/movies/GOAT.mp4");

            movieRepository.save(movie1);
            movieRepository.save(movie2);
            movieRepository.save(movie3);
            movieRepository.save(movie4);

            System.out.println("Sample movies initialized!");
        }

        // Initialize users if none exist
        if (userRepository.count() == 0) {
            User user1 = new User();
            user1.setEmail("raghavendrakumar478@gmail.com");
            user1.setPassword(passwordEncoder.encode("raghav1234"));

            User user2 = new User();
            user2.setEmail("tharun.inkollu2005@gmail.com");
            user2.setPassword(passwordEncoder.encode("15987430"));

            userRepository.save(user1);
            userRepository.save(user2);

            System.out.println("Sample users initialized!");
        }
    }
}