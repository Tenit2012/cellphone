package com.cellphone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cellphone.constant.ServiceMapping;
import com.cellphone.dto.BaseDTO;
import com.cellphone.dto.CategoryDTO;
import com.cellphone.dto.FilterRequest;
import com.cellphone.service.CategoryService;

@RestController
@RequestMapping(ServiceMapping.CATEGORIES)
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void create(CategoryDTO category) {
        categoryService.save(category);
    }

    @PutMapping
    public void update(CategoryDTO category) {
        categoryService.update(category);
    }

    @DeleteMapping(ServiceMapping.ID)
    public void updateFlag(@PathVariable("id") Long id,
                           @RequestParam(value = "deleteFlag", required = false, defaultValue = "false") boolean deleteFlag) {
        categoryService.updateFlag(id, deleteFlag);
    }

    @GetMapping
    public Page<BaseDTO> search(FilterRequest filterRequest) {
        return categoryService.search(filterRequest);
    }
}
