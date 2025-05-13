package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.Expense;
public interface ExpenseRepository extends JpaRepository<Expense, Long> {}