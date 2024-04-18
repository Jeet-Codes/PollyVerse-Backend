package org.example.pollyversebackend.Repository;
import org.example.pollyversebackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User,String> {
}