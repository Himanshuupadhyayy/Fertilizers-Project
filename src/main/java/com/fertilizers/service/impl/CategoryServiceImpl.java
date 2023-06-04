package com.fertilizers.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertilizers.dto.CategoryDto;
import com.fertilizers.entities.Category;
import com.fertilizers.exception.ResourceNotFoundException;
import com.fertilizers.repository.CategoryRepository;
import com.fertilizers.service.CategoryService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	private ModelMapper modelMapper;
	private CategoryRepository categoryRepository;
	
	
	@Override
	public CategoryDto addCategory(CategoryDto CategoryDto) {
		Category category=this.modelMapper.map(CategoryDto, Category.class);
		category=this.categoryRepository.save(category);
		return this.modelMapper.map(category, CategoryDto.class);
	}


	@Override
	public CategoryDto getCategory(int catId) {
		Category category = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category", "Category Id", catId));
		return this.modelMapper.map(category, CategoryDto.class);
	}


	@Override
	public List<Category> getCategories() {
	return this.categoryRepository.findAll();
	}


	@Override
	public CategoryDto updateCategory(int catId, CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		
		Category category1 = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category", "Category Id", catId));
		category1.setCatId(category.getCatId());
		category1.setCatDescription(category.getCatDescription());
		category1.setCatModifiedBy(category.getCatModifiedBy());
		Category updateCategory = this.categoryRepository.save(category1);
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}


	@Override
	public void deleteCategory(int catId) {
		Category category1 = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category", "Category Id", catId));
		this.categoryRepository.delete(category1);
		
	}


	@Override
	public List<Category> getCategoriesByName(String catName) {
		List<Category> categories = this.categoryRepository.findByCatName(catName);
		return categories;
	}

}
