package com.cp.librarymanagement.repository;

import com.cp.librarymanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
