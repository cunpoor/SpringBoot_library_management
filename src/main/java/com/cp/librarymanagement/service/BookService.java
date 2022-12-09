package com.cp.librarymanagement.service;

import com.cp.librarymanagement.entity.Book;
import com.cp.librarymanagement.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> getAllBook(){
        log.info("Get all book");
        return repo.findAll();
    }

    public void saveBook(Book entity){
        log.info("Save book #name: " + entity.getName() + " #author: " + entity.getAuthor());
        repo.save(entity);
    }

    public void deleteBook(Long id){
        log.info("Delete book - #id: " + id);
        repo.deleteById(id);
    }

    public Optional<Book> findBookById(Long id) {
        log.info("Find book - #id: " + id);
        Optional<Book> book =  repo.findById(id);
        return book;
    }
}
