package com.org.ags.controllers;

import com.org.ags.model.User;
import com.org.ags.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User Controller", description = "Create and Update User details")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Integer userId){
        return userService.getUsersById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody(required = true) User user) {
        return userService.createUser(user);
    }
}
