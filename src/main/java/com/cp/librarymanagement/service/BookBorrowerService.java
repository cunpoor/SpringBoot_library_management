package com.cp.librarymanagement.service;

import com.cp.librarymanagement.entity.BookBorrower;
import com.cp.librarymanagement.repository.BookBorrowerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookBorrowerService {
    @Autowired
    private BookBorrowerRepository repo;

    public List<BookBorrower> getAllBookBorrower() {
        log.info("Get all book borrower");
        return repo.findAll();
    }

    public void saveBookBrrower(BookBorrower entity) {
        log.info("Save book borrower - #name: " + entity.getName() + " #phone: " + entity.getPhone() + " #email: " + entity.getEmail());
        repo.save(entity);
    }

    public void deleteBookBrrower(Long id) {
        log.info("Delete book borrower - #id: " + id);
        repo.deleteById(id);
    }

    public Optional<BookBorrower> findBookBrrowerById(Long id) {
        log.info("Find book borrower - #id: " + id);
        Optional<BookBorrower> bookBorrower = repo.findById(id);
        return bookBorrower;
    }
}
