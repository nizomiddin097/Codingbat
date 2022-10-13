package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Example> getExamples(){
        return exampleService.getExamples();
    }
    @GetMapping("/{id}")
    public Example getExample(@PathVariable Integer id){
        return exampleService.getExample(id);
    }

    @PostMapping
    public Result addExample(@RequestBody ExampleDto exampleDto){
        return exampleService.addExample(exampleDto);
    }

    @PutMapping("/{id}")
    public Result editExample(@PathVariable Integer id, @RequestBody ExampleDto exampleDto){
        return exampleService.editExample(id,exampleDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteExample(@PathVariable Integer id){
        return exampleService.deleteExample(id);
    }
}
