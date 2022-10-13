package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.codingbat.entity.User;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping
    public List<User> getInputs(){
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping
    public Result addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public Result editUser(@PathVariable Integer id, @RequestBody User user){
        return userService.editUser(id,user);
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }



}
