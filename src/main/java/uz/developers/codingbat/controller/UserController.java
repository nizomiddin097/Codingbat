package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getInputs(){
        List<User> users = userService.getUsers();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<Result> addUser(@RequestBody User user){
        Result result = userService.addUser(user);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editUser(@PathVariable Integer id, @RequestBody User user){
        Result result = userService.editUser(id, user);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteUser(@PathVariable Integer id){
        Result result = userService.deleteUser(id);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }



}
