package com.app.todo.services;

import com.app.todo.model.Task;
import com.app.todo.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TodoServices {

    @Autowired
    TaskRepository taskRepository;


    public List<Task> getalltasks() {
       return taskRepository.findAll();
    }

    public void createtask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deletetask(long id) {

        taskRepository.deleteById(id);
    }

    public void toggletask(long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task"));
         task.setCompleted(!task.isCompleted());
taskRepository.save(task);

    }
}
