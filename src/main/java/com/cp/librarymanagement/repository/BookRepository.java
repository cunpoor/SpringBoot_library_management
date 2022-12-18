package com.cp.librarymanagement.repository;

import com.cp.librarymanagement.entity.Book;
import com.cp.librarymanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findBookByCategory_Id(Long id);

    public List<Book> findBookByLocation_Id(Long id);

    public List<Book> findBookByBookBorrower_Id(Long id);
}
