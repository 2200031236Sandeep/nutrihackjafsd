package com.example.dietapp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role; // Can be "Admin" or "User"

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DietaryHabit> dietaryHabits;

    // Getters and Setters
}
