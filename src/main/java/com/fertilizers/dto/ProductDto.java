package com.fertilizers.dto;


import com.fertilizers.entities.SubCategory;

import lombok.Data;

@Data
public class ProductDto {

	private int productId;
	private String productName;
	private String productDesc;;
	private String productPrice;
	private String productImage;
	private String shortDesc;
	
//	private SubCategory subCategory;
	
	
}
