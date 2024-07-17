package com.rajlee.creatingwhatsappapi.controller;

import com.rajlee.creatingwhatsappapi.model.User;
import com.rajlee.creatingwhatsappapi.service.ApiWhatsappService;
import com.rajlee.creatingwhatsappapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return userService.saveUsers(users);
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
