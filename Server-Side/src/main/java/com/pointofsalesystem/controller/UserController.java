package com.pointofsalesystem.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pointofsalesystem.entity.User;
import com.pointofsalesystem.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);

    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User saveUser = userService.createUser(user);

        return ResponseEntity.status(201).body(saveUser);

    }

    @PutMapping("user/{id}")
    public User updatUser(@PathVariable long id, @RequestBody User user) {

        return userService.updateUser(user, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/findUser/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);

        if (user == null) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(user);
        }

    }

}
