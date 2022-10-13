package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.entity.User;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.payload.TaskDto;
import uz.developers.codingbat.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id){
        return taskService.getTask(id);
    }

    @PostMapping
    public Result addTask(@RequestBody TaskDto taskDto){
        return taskService.addTask(taskDto);
    }

    @PutMapping("/{id}")
    public Result editTask(@PathVariable Integer id, @RequestBody TaskDto taskDto){
        return taskService.editTask(id,taskDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask(@PathVariable Integer id){
        return taskService.deleteTask(id);
    }
}
