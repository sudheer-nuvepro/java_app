package com.example.todo.controller;

import com.example.todo.dto.TaskDTO;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Fetch all tasks
    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Add a new task
    @PostMapping
    public TaskDTO addTask(@RequestBody TaskDTO taskDTO) {
        return taskService.addTask(
            taskDTO.getDescription(),
            taskDTO.getPriority(),
            LocalDate.parse(taskDTO.getDueDate())
        );
    }

    // Edit an existing task
    @PutMapping("/{id}")
    public TaskDTO editTask(@PathVariable int id, @RequestBody TaskDTO taskDTO) {
        taskService.updateTask(
            id,
            taskDTO.getDescription(),
            taskDTO.isCompleted(),
            taskDTO.getPriority(),
            LocalDate.parse(taskDTO.getDueDate())
        );
        return taskDTO;
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }

    // Search tasks
    @GetMapping("/search")
    public List<TaskDTO> searchTasks(@RequestParam String query) {
        return taskService.searchTasks(query);
    }
}
