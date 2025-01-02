package com.example.todo.service;

import com.example.todo.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public List<Task> getAllTasks() {
        return tasks.stream().sorted((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate())).collect(Collectors.toList());
    }

    public Task getTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    public Task addTask(String description, String priority, LocalDate dueDate) {
        Task newTask = new Task(nextId++, description, false, priority, dueDate);
        tasks.add(newTask);
        return newTask;
    }

    public boolean updateTask(int id, String description, boolean completed, String priority, LocalDate dueDate) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setDescription(description);
            task.setCompleted(completed);
            task.setPriority(priority);
            task.setDueDate(dueDate);
            return true;
        }
        return false;
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public List<Task> searchTasks(String query) {
        return tasks.stream()
                .filter(task -> task.getDescription().contains(query))
                .collect(Collectors.toList());
    }
}
