package org.example.pollyversebackend.Repository;

import org.example.pollyversebackend.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoleRepo extends JpaRepository<Role,String> {

}