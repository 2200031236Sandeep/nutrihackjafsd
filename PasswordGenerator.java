package com.example.mypro.config;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        // Create a BCryptPasswordEncoder instance
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // Raw password that you want to encode
        String rawPassword = "admin123";
        
        // Encoding the raw password
        String encodedPassword = encoder.encode(rawPassword);
        
        // Printing the encoded password
        System.out.println("Encoded Password: " + encodedPassword);
    }
}

