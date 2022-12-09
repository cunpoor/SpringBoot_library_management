package com.cp.librarymanagement.controller;

import com.cp.librarymanagement.entity.BookBorrower;
import com.cp.librarymanagement.service.BookBorrowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Slf4j
@Controller
@RequestMapping("/bookborrower")
public class BookBorrowerController {
    @Autowired
    private BookBorrowerService service;

    @GetMapping
    public String getBookborrowerPage(ModelMap model) {
        model.addAttribute("BOOK_BORROWER_LIST", service.getAllBookBorrower());
        return "page/book_borrower/index";
    }

    @GetMapping("/add")
    public String getAddBookborrower(ModelMap model) {
        log.info("Get add book borrower page");
        model.addAttribute("BOOK_BORROWER", new BookBorrower());
        return "page/book_borrower/addOrUpdate";
    }

    @PostMapping("/save")
    public String saveBookborrower(BookBorrower entity) {
        service.saveBookBrrower(entity);
        return "redirect:/bookborrower";
    }

    @GetMapping("/update")
    public String getUpdateBookborrower(@RequestParam("id") Long id, ModelMap model) {
        log.info("Get update book borrower page - #id: " + id);
        Optional<BookBorrower> bookBorrower = service.findBookBrrowerById(id);
        bookBorrower.ifPresent(e -> model.addAttribute("BOOK_BORROWER", bookBorrower));
        return "page/book_borrower/addOrUpdate";
    }

    @GetMapping("/delete")
    public String deleteBookborrower(@RequestParam("id") Long id) {
        service.deleteBookBrrower(id);
        return "redirect:/bookborrower";
    }

}
