package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.Expense;
import com.example.ghibli.companion.backend.repository.ExpenseRepository;
@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository repository;
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }
    public Optional<Expense> getExpenseById(Long id) {
        return repository.findById(id);
    }
    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }
    public Expense updateExpense(Long id, Expense expense) {
        if (repository.existsById(id)) {
            expense.setId(id);
            return repository.save(expense);
        }
        return null;
    }
    public boolean deleteExpense(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}