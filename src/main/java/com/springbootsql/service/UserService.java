package com.springbootsql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootsql.model.User;
import com.springbootsql.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User loginUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser;
        } else {
            throw new RuntimeException("Invalid Email or Password");
        }
    }
    public java.util.List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User Deleted Successfully";
    }
    

}