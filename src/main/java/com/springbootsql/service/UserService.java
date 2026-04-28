package com.springbootsql.service;

import com.springbootsql.model.User;
import com.springbootsql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public User saveUser(User user) {
        // Generate 6-digit OTP
        String otp = String.format("%06d", new java.util.Random().nextInt(999999));
        
        Optional<User> existingUserOpt = userRepository.findByEmail(user.getEmail());
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            if (existingUser.isVerified()) {
                throw new RuntimeException("User with this email already exists and is verified.");
            } else {
                // Update existing unverified user with new OTP and details
                existingUser.setOtp(otp);
                existingUser.setPassword(user.getPassword());
                existingUser.setName(user.getName());
                existingUser.setRole(user.getRole());
                userRepository.save(existingUser);
                emailService.sendOtpEmail(existingUser.getEmail(), otp);
                return existingUser;
            }
        }
        
        user.setOtp(otp);
        user.setVerified(false);
        User savedUser = userRepository.save(user);
        
        // Send email
        emailService.sendOtpEmail(savedUser.getEmail(), otp);
        
        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean verifyOtp(String email, String otp) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
                
        if (user.getOtp() != null && user.getOtp().equals(otp)) {
            user.setVerified(true);
            user.setOtp(null); // Clear OTP after successful verification
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
                
        if (!user.isVerified()) {
            throw new RuntimeException("Email not verified. Please verify your email first.");
        }
        return user;
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    // New Update Method for Profile Editing
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        // Update fields (ensure these getters/setters exist in User.java)
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        
        // Only update password if it's provided in the request
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(userDetails.getPassword());
        }

        return userRepository.save(user);
    }
}