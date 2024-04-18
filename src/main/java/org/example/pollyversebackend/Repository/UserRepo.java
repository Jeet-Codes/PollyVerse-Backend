package org.example.pollyversebackend.Repository;
import org.example.pollyversebackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    User findByEmail(String email);
    Optional<User> findOneByEmailAndPassword(String email, String password);
}