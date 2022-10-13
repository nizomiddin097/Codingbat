package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public Result addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public Result editCategory(@PathVariable Integer id, @RequestBody Category category){
        return categoryService.editCategory(id,category);
    }

    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }
}
