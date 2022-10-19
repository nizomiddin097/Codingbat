package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Task>> getTasks(){
        List<Task> tasks = taskService.getTasks();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tasks);
    }
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id){
        return taskService.getTask(id);
    }

    @PostMapping
    public ResponseEntity<Result> addTask(@RequestBody TaskDto taskDto){
        Result result = taskService.addTask(taskDto);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editTask(@PathVariable Integer id, @RequestBody TaskDto taskDto){
        Result result = taskService.editTask(id, taskDto);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteTask(@PathVariable Integer id){
        Result result = taskService.deleteTask(id);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }
}
