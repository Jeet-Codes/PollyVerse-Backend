package org.example.pollyversebackend.Repository;

import org.example.pollyversebackend.Entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<FileStorage,String> {
}
