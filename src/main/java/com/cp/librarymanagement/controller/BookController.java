package com.cp.librarymanagement.controller;

import com.cp.librarymanagement.entity.Book;
import com.cp.librarymanagement.service.BookService;
import com.cp.librarymanagement.service.CategoryService;
import com.cp.librarymanagement.service.LocationService;
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
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LocationService locationService;

    @GetMapping
    public String getAllBookPage(ModelMap model, @RequestParam(value = "category", required = false) Long id) {
        if (id != null) {
            model.addAttribute("BOOK_LIST", bookService.getBookbyCatetory(id));
        }else{
            model.addAttribute("BOOK_LIST", bookService.getAllBook());
        }
        return "page/book/index";
    }

    @GetMapping("/add")
    public String getAddBookPage(ModelMap model) {
        log.info("Get add book page");
        model.addAttribute("BOOK", new Book());
        model.addAttribute("CATEGORY_LIST", categoryService.getAllCategory());
        model.addAttribute("LOCATION_LIST", locationService.getAllLocation());
        return "page/book/addOrUpdate";
    }

    @PostMapping("/save")
    public String saveBook(Book entity) {
        bookService.saveBook(entity);
        return "redirect:/book";
    }

    @GetMapping("/update")
    public String getUpdateBookPage(ModelMap model, @RequestParam("id") Long id) {
        log.info("Get update book page - #id: " + id);
        Optional<Book> book = bookService.findBookById(id);
        book.ifPresent(e -> {
            model.addAttribute("BOOK", book);
            model.addAttribute("CATEGORY_LIST", categoryService.getAllCategory());
            model.addAttribute("LOCATION_LIST", locationService.getAllLocation());
        });
        return "page/book/addOrUpdate";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }
}
