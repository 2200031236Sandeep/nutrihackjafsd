package com.example.dietapp.repository;

import com.example.dietapp.entity.DietaryHabit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietaryHabitRepository extends JpaRepository<DietaryHabit, Long> {
}
