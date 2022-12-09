package com.cp.librarymanagement.service;

import com.cp.librarymanagement.entity.Category;
import com.cp.librarymanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> getCategoryMenu(){
        return categoryRepo.findAll();
    }
}
