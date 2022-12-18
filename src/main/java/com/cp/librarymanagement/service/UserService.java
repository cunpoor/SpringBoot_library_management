package com.cp.librarymanagement.service;

import com.cp.librarymanagement.entity.Book;
import com.cp.librarymanagement.entity.User;
import com.cp.librarymanagement.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUser() {
        log.info("Get all user");
        return repo.findAll();
    }

    public void saveUser(User entity) {
        log.info("Save user #name: " + entity.getName());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        repo.save(entity);
    }

    public void deleteUser(Long id) {
        log.info("Delete user - #id: " + id);
        repo.deleteById(id);
    }

    public Optional<User> findUserById(Long id) {
        log.info("Find user - #id: " + id);
        Optional<User> user = repo.findById(id);
        return user;
    }

    public User findUserByUsername(String username) {
        log.info("Find user - #username: " + username);
        User user = repo.findUserByUsername(username);
        return user;
    }


}
