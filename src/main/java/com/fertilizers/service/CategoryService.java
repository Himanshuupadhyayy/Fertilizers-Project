package com.fertilizers.service;

import java.util.List;

import com.fertilizers.dto.CategoryDto;
import com.fertilizers.entities.Category;

public interface CategoryService {

	CategoryDto addCategory(CategoryDto categoryDto);
	
	CategoryDto getCategory(int catId);
	
	List<Category> getCategories();
	
	CategoryDto updateCategory(int catId,CategoryDto categoryDto);
	
	void deleteCategory(int catId);

	List<Category> getCategoriesByName(String catName);
}
