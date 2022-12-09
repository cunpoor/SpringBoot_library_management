package com.cp.librarymanagement.controller;

import com.cp.librarymanagement.entity.Category;
import com.cp.librarymanagement.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public String getCategoryPage(ModelMap model) {
        model.addAttribute("CATEGORY_LIST", service.getAllCategory());
        return "page/category/index";
    }

    @GetMapping("/add")
    public String getAddCategoryPage(ModelMap model) {
        log.info("Get add location page");
        model.addAttribute("CATEGORY", new Category());
        return "page/category/addOrUpdate";
    }

    @PostMapping("/save")
    public String saveCategory(Category entity) {
        service.saveCategory(entity);
        return "redirect:/category";
    }

    @GetMapping("/update")
    public String getUpdateCategoryPage(ModelMap model, @RequestParam("id") Long id) {
        log.info("Get update category page - #id: " + id);
        Optional<Category> category = service.findCategoryById(id);
        category.ifPresent(e -> model.addAttribute("CATEGORY", category));
        return "page/category/addOrUpdate";
    }

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam("id") Long id) {
        service.deleteCategory(id);
        return "redirect:/category";
    }
}
