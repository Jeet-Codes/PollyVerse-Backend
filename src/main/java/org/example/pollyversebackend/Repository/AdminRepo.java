package org.example.pollyversebackend.Repository;

import org.example.pollyversebackend.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {

}
