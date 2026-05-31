package com.app.todo.controller;

import com.app.todo.model.Task;
import com.app.todo.services.TodoServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@NoArgsConstructor
@AllArgsConstructor
//@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TodoServices todoServices;

    Task task;

@GetMapping
    public String gettaks(Model model) {
    List<Task> tasks = todoServices.getalltasks();
    model.addAttribute("tasks", tasks);
    return "tasks";



}

    @PostMapping
    public String createtask(@RequestParam  String title) {
        todoServices.createtask(title);

        return "redirect:/";

    }

    @GetMapping("/{id}/delete")
    public String deletetask(@PathVariable long id) {
todoServices.deletetask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggletask(@PathVariable long id) {
        todoServices.toggletask(id);
        return "redirect:/";
    }
}
