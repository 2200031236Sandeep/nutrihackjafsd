package com.example.dietapp.controller;

import com.example.dietapp.entity.DietaryHabit;
import com.example.dietapp.service.DietaryHabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class DietaryHabitController {
    private final DietaryHabitService dietaryHabitService;

    public DietaryHabitController(DietaryHabitService dietaryHabitService) {
        this.dietaryHabitService = dietaryHabitService;
    }

    @PostMapping("/add")
    public DietaryHabit addHabit(@RequestBody DietaryHabit habit) {
        return dietaryHabitService.saveDietaryHabit(habit);
    }

    @GetMapping("/all")
    public List<DietaryHabit> getAllHabits() {
        return dietaryHabitService.getAllHabits();
    }
}
