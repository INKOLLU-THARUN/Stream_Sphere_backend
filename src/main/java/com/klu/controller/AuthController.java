package com.klu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.LoginRequest;
import com.klu.entity.User;
import com.klu.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})  
public class AuthController {
	 
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            boolean isAuthenticated = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
            
            if (isAuthenticated) {
                return ResponseEntity.ok(Map.of("message", "Login successful"));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                   .body(Map.of("message", "Invalid email or password"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                               .body(Map.of("message", "Login failed: " + e.getMessage()));
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok(Map.of(
                "message", "User registered successfully",
                "userId", savedUser.getId()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                               .body(Map.of("message", "Registration failed: " + e.getMessage()));
        }
    }
}
