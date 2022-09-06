package com.example.homeworkmusic.controller;

import com.example.homeworkmusic.model.User;
import com.example.homeworkmusic.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping
    public List<User> getUserByLetter(String letter){
        return userService.getUserByLetter(letter);
    }

    @GetMapping
    public List<User> getUserByNumberOfSong(){
        return userService.getUserByNumberOfSong();
    }

    @PostMapping
    public User createUser(User user){
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(Long id,User newUser){
        return userService.updateUser(id, newUser);
    }

    @DeleteMapping
    public User deleteUser(User user){
        return userService.deleteUser(user);
    }

}
