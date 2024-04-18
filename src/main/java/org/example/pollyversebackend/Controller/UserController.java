package org.example.pollyversebackend.Controller;

import org.example.pollyversebackend.Dto.LoginDto;
import org.example.pollyversebackend.Entity.User;
import org.example.pollyversebackend.Response.LoginResponse;
import org.example.pollyversebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
