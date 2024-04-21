package org.example.pollyversebackend.Service;


import org.example.pollyversebackend.Dto.LoginDto;
import org.example.pollyversebackend.Entity.User;
import org.example.pollyversebackend.Response.LoginResponse;

public interface UserService {
    User saveUser(User user);
    LoginResponse loginstudent(LoginDto loginDto);
    User getUserByUsername(String username);
}
