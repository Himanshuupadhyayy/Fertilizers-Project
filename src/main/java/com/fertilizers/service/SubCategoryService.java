
package com.fertilizers.service;

import java.util.List;

import com.fertilizers.dto.SubCategoryDto;
import com.fertilizers.entities.SubCategory;

public interface SubCategoryService {

	SubCategoryDto addSubCategory(int catId, SubCategoryDto subCategoryDto);
	
	SubCategoryDto getSubCategory(int catId, int subCatId);
	
	List<SubCategory> getSubCategories(int catId);
	
	void deleteSubCategory(int catId, int subCatId);
	
	SubCategoryDto updateSubCategory(int catId, int subCatId, SubCategoryDto subCategoryDto);
	
}
