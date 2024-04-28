package org.example.pollyversebackend.Controller;

import org.example.pollyversebackend.Dto.LoginDto;
import org.example.pollyversebackend.Entity.User;
import org.example.pollyversebackend.Response.LoginResponse;
import org.example.pollyversebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User saved = userService.saveUser(user);
        return ResponseEntity.ok(saved);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto)  {
        LoginResponse loginResponse=userService.loginstudent(loginDto);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserById(@PathVariable String username) {
        User userByUsername = userService.getUserByUsername(username);
        return ResponseEntity.ok(userByUsername);
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.FOUND).getBody();
    }
}
