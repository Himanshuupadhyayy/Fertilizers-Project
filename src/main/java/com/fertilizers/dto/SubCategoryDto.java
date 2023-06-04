package com.fertilizers.dto;

import lombok.Data;

@Data
public class SubCategoryDto {

	private int subCatId;
	private String subCatName;
	private String subCatDesctiption;
	private String subCatImage;
	
	private CategoryDto categoryDto;
	
	
}