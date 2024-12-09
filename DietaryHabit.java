package com.example.dietapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dietary_habits")
public class DietaryHabit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodItem;
    private int quantity; // Quantity in grams

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and Setters
}
