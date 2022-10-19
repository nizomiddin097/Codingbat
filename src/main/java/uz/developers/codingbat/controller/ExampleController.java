package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.codingbat.entity.Example;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.payload.ExampleDto;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.payload.TaskDto;
import uz.developers.codingbat.service.ExampleService;

import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    ExampleService exampleService;

    @GetMapping
    public ResponseEntity<List<Example>> getExamples(){
        List<Example> examples = exampleService.getExamples();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(examples);
    }
    @GetMapping("/{id}")
    public Example getExample(@PathVariable Integer id){
        return exampleService.getExample(id);
    }

    @PostMapping
    public ResponseEntity<Result> addExample(@RequestBody ExampleDto exampleDto){
        Result result = exampleService.addExample(exampleDto);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editExample(@PathVariable Integer id, @RequestBody ExampleDto exampleDto){
        Result result = exampleService.editExample(id, exampleDto);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteExample(@PathVariable Integer id){
        Result result = exampleService.deleteExample(id);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }
}
