package com.cp.librarymanagement.service;

import com.cp.librarymanagement.dto.CategoryDTO;
import com.cp.librarymanagement.entity.Category;
import com.cp.librarymanagement.repository.BookRepository;
import com.cp.librarymanagement.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private BookRepository bookRepo;

    public List<CategoryDTO> getAllCategory() {
        log.info("Get all category");
        return categoryRepo.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private CategoryDTO convertEntityToDTO(Category entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCountBook(bookRepo.findBookByCategory_Id(entity.getId()).size());
        return dto;
    }

    public void saveCategory(Category entity) {
        log.info("Save category #name: " + entity.getName());
        categoryRepo.save(entity);
    }

    public void deleteCategory(Long id) {
        log.info("Delete location - #id: " + id);
        categoryRepo.deleteById(id);
    }

    public Optional<Category> findCategoryById(Long id) {
        log.info("Find location - #id: " + id);
        Optional<Category> category = categoryRepo.findById(id);
        return category;
    }
}
