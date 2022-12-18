package com.cp.librarymanagement.service;

import com.cp.librarymanagement.dto.BookBorrowerDTO;
import com.cp.librarymanagement.entity.BookBorrower;
import com.cp.librarymanagement.repository.BookBorrowerRepository;
import com.cp.librarymanagement.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookBorrowerService {
    @Autowired
    private BookBorrowerRepository bookBorrowerRepo;

    @Autowired
    private BookRepository bookRepo;

    public List<BookBorrowerDTO> getAllBookBorrower() {
        log.info("Get all book borrower");
        return bookBorrowerRepo.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private BookBorrowerDTO convertEntityToDTO(BookBorrower entity){
        BookBorrowerDTO dto = new BookBorrowerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setCountBook(bookRepo.findBookByBookBorrower_Id(entity.getId()).size());
        return dto;
    }

    public void saveBookBrrower(BookBorrower entity) {
        log.info("Save book borrower - #name: " + entity.getName() + " #phone: " + entity.getPhone() + " #email: " + entity.getEmail());
        bookBorrowerRepo.save(entity);
    }

    public void deleteBookBrrower(Long id) {
        log.info("Delete book borrower - #id: " + id);
        bookBorrowerRepo.deleteById(id);
    }

    public Optional<BookBorrower> findBookBrrowerById(Long id) {
        log.info("Find book borrower - #id: " + id);
        Optional<BookBorrower> bookBorrower = bookBorrowerRepo.findById(id);
        return bookBorrower;
    }
}
