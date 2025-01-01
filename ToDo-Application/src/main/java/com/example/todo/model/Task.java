package com.example.todo.model;

public class Task {
    private int id;
    private String description;
    private boolean completed;

    // Constructors
    public Task() {}
    public Task(int id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    // Getters and Setters
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
}
