package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.codingbat.entity.Category;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.payload.TaskDto;
import uz.developers.codingbat.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categories);
    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public ResponseEntity<Result> addCategory(@RequestBody Category category){
        Result result = categoryService.addCategory(category);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editCategory(@PathVariable Integer id, @RequestBody Category category){
        Result result = categoryService.editCategory(id, category);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteCategory(@PathVariable Integer id){
        Result result = categoryService.deleteCategory(id);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }
}
