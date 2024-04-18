package org.example.pollyversebackend.Response;


import lombok.*;
import org.example.pollyversebackend.Entity.User;


import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponse {
    String message;
    Boolean status;
    Optional<User> user;
}
