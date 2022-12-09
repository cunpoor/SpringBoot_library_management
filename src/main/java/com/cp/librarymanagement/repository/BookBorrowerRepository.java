package com.cp.librarymanagement.repository;

import com.cp.librarymanagement.entity.BookBorrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowerRepository extends JpaRepository<BookBorrower, Long> {
}
