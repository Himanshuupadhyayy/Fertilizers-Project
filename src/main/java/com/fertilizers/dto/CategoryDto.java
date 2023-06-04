package com.fertilizers.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CategoryDto {

	private int catId;
	@NotNull
	@NotBlank(message = "cat name must be alleast 3 character")
	@Min(3)
	@Max(15)
	private String catName;
	
	@Min(10)
	@Max(150)
	@NotBlank(message = "description must be min 10 and max 15")
	private String catDescription;
	
	@NotBlank
	@NotNull
	private String catImage;
	
	@NotBlank
	@NotNull
	private String catCreatedBy;
	
	@NotBlank
	@NotNull
	private String catModifiedBy;
	
	
}
