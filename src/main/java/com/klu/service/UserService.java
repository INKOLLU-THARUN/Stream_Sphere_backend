package com.klu.service;

import com.klu.entity.User;
import com.klu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user with a unique email and encrypted password.
     * 
     * @param email the user's email address
     * @param rawPassword the plain text password
     * @return the newly created user
     * @throws Exception if email is already taken
     */
    public User signup(String email, String rawPassword) throws Exception {
        // Check if user with the same email already exists
        if (userRepository.findByEmail(email).isPresent()) {
            throw new Exception("Email already in use");
        }

        // Create new user and encode password
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword)); // bcrypt hash

        // Save to database and return
        return userRepository.save(user);
    }

    /**
     * Validates login credentials.
     * 
     * @param email the email input by user
     * @param rawPassword the raw password input by user
     * @return true if login is successful, false otherwise
     */
    public boolean login(String email, String rawPassword) {
        Optional<User> user = userRepository.findByEmail(email);

        // Check if user exists and password matches
        return user.isPresent() &&
               passwordEncoder.matches(rawPassword, user.get().getPassword());
    }

    /**
     * Register a new user after validating input
     * 
     * @param user the user to register
     * @return the saved user
     * @throws Exception if validation fails
     */
    public User registerUser(User user) throws Exception {
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new Exception("Email is required");
        }
        
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new Exception("Password is required");
        }

        // Check if user with the same email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("Email already in use");
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        return userRepository.save(user);
    }

    /**
     * Find user by email
     * 
     * @param email the email to search for
     * @return Optional containing the user if found
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}