package com.cp.librarymanagement;

import com.cp.librarymanagement.entity.User;
import com.cp.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Autowired
    private UserService service;

    @Override
    public void run(String... args) throws Exception {
        User user = service.findUserByUsername("admin");
        if (user == null) {
            User u = new User();
            u.setUsername("admin");
            u.setPassword("admin");
            u.setName("Admin");
            service.saveUser(u);
        }

    }
}
