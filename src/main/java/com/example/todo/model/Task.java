package com.example.todo.model;

import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private boolean completed;
    private String priority;  // New attribute for task priority
    private LocalDate dueDate;  // New attribute for task due date

    // Constructors
    public Task() {}

    public Task(int id, String description, boolean completed, String priority, LocalDate dueDate) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
