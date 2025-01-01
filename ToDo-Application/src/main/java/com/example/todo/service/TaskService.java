package com.example.todo.service;

import com.example.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final Map<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;

    public List<Task> getAllTasks(String sortBy, String filter, int page, int size) {
        List<Task> taskList = new ArrayList<>(tasks.values());

        if (filter != null && !filter.isBlank()) {
            taskList = taskList.stream()
                    .filter(task -> task.getDescription().toLowerCase().contains(filter.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if ("description".equalsIgnoreCase(sortBy)) {
            taskList.sort(Comparator.comparing(Task::getDescription));
        } else if ("completed".equalsIgnoreCase(sortBy)) {
            taskList.sort(Comparator.comparing(Task::isCompleted));
        }

        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, taskList.size());
        return taskList.subList(fromIndex, toIndex);
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void addTask(String description) {
        Task newTask = new Task(nextId++, description, false);
        tasks.put(newTask.getId(), newTask);
    }

    public void updateTask(int id, String description, boolean completed) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setDescription(description);
            task.setCompleted(completed);
        } else {
            throw new IllegalArgumentException("Task not found with ID: " + id);
        }
    }

    public void deleteTask(int id) {
        if (tasks.remove(id) == null) {
            throw new IllegalArgumentException("Task not found with ID: " + id);
        }
    }
}
