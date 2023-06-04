package com.fertilizers.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fertilizers.dto.SubCategoryDto;
import com.fertilizers.entities.Category;
import com.fertilizers.entities.SubCategory;
import com.fertilizers.exception.ResourceNotFoundException;
import com.fertilizers.repository.CategoryRepository;
import com.fertilizers.repository.SubCategoryRepository;
import com.fertilizers.service.SubCategoryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SubCategoryServiceImpl implements SubCategoryService{

	private SubCategoryRepository subCategoryRepository;
	private ModelMapper modelMapper;
	private CategoryRepository categoryRepository;
	
	@Override
	public SubCategoryDto addSubCategory(int catId, SubCategoryDto subCategoryDto)throws ResourceNotFoundException {
		Category category=null;
		try {
			category = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category ", "category Id", catId));
		}catch (ResourceNotFoundException e) {
			log.info("category with the category id is not exist " +catId);
			e.printStackTrace();
			throw new ResourceNotFoundException("category ", "category id", catId);
		}
		SubCategory category1 = this.modelMapper.map(subCategoryDto, SubCategory.class);
	
		category1.setCategory(category);
		category1=this.subCategoryRepository.save(category1);
		return this.modelMapper.map(category1, SubCategoryDto.class);
	}

	@Override
	public SubCategoryDto getSubCategory(int catId, int subCatId) {
	Category category = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category", "Category id", catId));
	
	SubCategory subCategory = this.subCategoryRepository.findById(subCatId).orElseThrow(() -> new ResourceNotFoundException("Sub Category", "category id", subCatId));
		return this.modelMapper.map(subCategory, SubCategoryDto.class);
	}

	@Override
	public List<SubCategory> getSubCategories(int catId) {
		Category category = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category", "Category id", catId));
		List<SubCategory> categories = this.subCategoryRepository.findAll();
		return categories;
	}

	@Override
	public void deleteSubCategory(int catId, int subCatId)throws ResourceNotFoundException {
		Category category = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category", "Category id", catId));

		SubCategory subCategory = this.subCategoryRepository.findById(subCatId).orElseThrow(() -> new ResourceNotFoundException("sub Category", "category id", subCatId));
		this.subCategoryRepository.delete(subCategory);
	}

	@Override
	public SubCategoryDto updateSubCategory(int catId, int subCatId, SubCategoryDto subCategoryDto) {
		Category category = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category", "Category id", catId));
		SubCategory category1 = this.subCategoryRepository.findById(subCatId).orElseThrow(() -> new ResourceNotFoundException("sub category", "sub Category id", catId));

		SubCategory subCategory = this.modelMapper.map(subCategoryDto, SubCategory.class);
		subCategory.setSubCatId(subCatId);
		subCategory.setCategory(category);
		subCategory.setCreatedBy(category1.getCreatedBy());
		subCategory.setSubCatDesctiption(category.getCatDescription());
		
		SubCategory save = this.subCategoryRepository.save(subCategory);
		return this.modelMapper.map(save, SubCategoryDto.class);
	}

	
}