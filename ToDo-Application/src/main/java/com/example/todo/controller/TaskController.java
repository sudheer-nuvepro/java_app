package com.example.todo.controller;

import com.example.todo.dto.TaskDTO;
import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(@RequestParam(required = false) String sortBy, 
                              @RequestParam(required = false) String filter, 
                              @RequestParam(defaultValue = "0") int page, 
                              @RequestParam(defaultValue = "5") int size, Model model) {
        List<Task> tasks = taskService.getAllTasks(sortBy, filter, page, size);
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/add")
    public String showAddTaskForm() {
        return "add-task";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String description) {
        taskService.addTask(description);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable int id, Model model) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            throw new IllegalArgumentException("Task not found with ID: " + id);
        }
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/edit")
    public String editTask(@RequestParam int id, 
                           @RequestParam String description, 
                           @RequestParam(required = false, defaultValue = "false") boolean completed) {
        taskService.updateTask(id, description, completed);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
