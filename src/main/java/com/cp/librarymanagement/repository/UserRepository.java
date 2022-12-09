package com.cp.librarymanagement.repository;

import com.cp.librarymanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
