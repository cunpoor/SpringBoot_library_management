package com.cp.librarymanagement.controller;

import com.cp.librarymanagement.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@ControllerAdvice
public class CommonController {
    @Autowired
    private CommonService service;

    @ModelAttribute
    public void getCategoryListMenu(ModelMap model) {
        log.info("Get the category list for the menu");
        model.addAttribute("CATEGORY_MENU", service.getCategoryMenu());
    }
}
