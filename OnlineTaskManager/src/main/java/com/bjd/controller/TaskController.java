package com.bjd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bjd.model.Task;
import com.bjd.service.*;

import java.security.Principal;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @GetMapping({"/", "/display-tasks"})
    public String showAllTasks(ModelMap model, Principal principal) {
        Iterable<Task> tasks = taskService.GetAllTasks();
        model.put("tasks", tasks);
        model.put("user", userService.getUserByName(principal.getName()));
        return "display-tasks";
    }

    @GetMapping("/create-task")
    public String newTaskForm(ModelMap model) {
        return "create-task";
    }

    @PostMapping("/create-task")
    public RedirectView createNewTask(ModelMap model, Principal principal, Task task) {
        task.setUser(userService.getUserByName(principal.getName()));
        taskService.AddTask(task);
        return new RedirectView("display-tasks");
    }

    @GetMapping("/edit-task/{id}")
    public String updateTaskForm(ModelMap model, @PathVariable("id") Integer id) {
        Task task = taskService.GetTaskById(id);
        model.put("task", task);
        return "update-task";
    }

    @PostMapping("/edit-task/{id}")
    public RedirectView updateTask(Principal principal, Task task, @PathVariable("id") Integer id) {
        return new RedirectView("/display-tasks");
    }

    @GetMapping("delete-task/{id}")
    public ModelAndView deleteTask(ModelMap model, @PathVariable("id") Integer id) {
        Task task = taskService.GetTaskById(id);
        taskService.DeleteTask(task);
        model.put("deleted", task.getName());
        return new ModelAndView("redirect:/display-tasks", model);
    }
}
