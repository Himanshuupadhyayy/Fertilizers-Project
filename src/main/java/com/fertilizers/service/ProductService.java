package com.fertilizers.service;

import java.util.List;

import com.fertilizers.dto.ProductDto;

public interface ProductService {

	ProductDto createProduct(int catId, int subCatId, ProductDto productDto);
	
	ProductDto getProduct(int productId);
	
	List<ProductDto> getProducts();
	
	void deleteProduct(int productId);
	
	ProductDto updateProduct(int productId, ProductDto productDto);
	
}
