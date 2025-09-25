 package com.klu.repository; // Change to match your project structure

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Custom method to find a user by their email
    Optional<User> findByEmail(String email);
}

