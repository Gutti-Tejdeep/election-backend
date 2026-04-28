package com.springbootsql.repository;

import com.springbootsql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Add this line to fix the error in UserService
    Optional<User> findByEmail(String email);
}