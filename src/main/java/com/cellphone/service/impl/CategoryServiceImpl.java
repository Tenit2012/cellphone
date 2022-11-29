package com.cellphone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cellphone.base.impl.BaseServiceImpl;
import com.cellphone.dto.CategoryDTO;
import com.cellphone.entities.Category;
import com.cellphone.repository.CategoryRepository;
import com.cellphone.service.CategoryService;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super(categoryRepository, Category.class, CategoryDTO.class);
	}
}
