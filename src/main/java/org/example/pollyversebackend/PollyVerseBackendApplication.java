package org.example.pollyversebackend;

import org.example.pollyversebackend.Entity.Role;
import org.example.pollyversebackend.Entity.User;
import org.example.pollyversebackend.Repository.RoleRepo;
import org.example.pollyversebackend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class PollyVerseBackendApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Value("${admin.role.id}")
    private String adminRoleId;
    @Value("${normal.role.id}")
    private String normalRoleId;

    public static void main(String[] args) {
        SpringApplication.run(PollyVerseBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Role admin = Role.builder().roleId(adminRoleId).roleName("admin").build();
        User build = User.builder().username("admin").password("admin").roles(Set.of(admin)).email("admin@gmail.com").userid("AD01").build();
        userRepo.save(build);

        Role normal = Role.builder().roleId(normalRoleId).roleName("user").build();
        roleRepo.save(normal);
        roleRepo.save(admin);
    }
}
