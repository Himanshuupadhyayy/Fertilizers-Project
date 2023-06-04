package com.fertilizers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilizers.dto.ProductDto;
import com.fertilizers.service.ProductService;

@RestController
@RequestMapping("/catalogue/category/{category_id}/subcategory/{subcategory_id}")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<ProductDto> addProduct(@PathVariable ("category_id") int catId, @PathVariable ("subcategory_id") int subCatId, @RequestBody ProductDto productDto){
		ProductDto createProduct = this.productService.createProduct(catId, subCatId, productDto);
		return new ResponseEntity<ProductDto>(createProduct, HttpStatus.CREATED);
	}
	
	
}
