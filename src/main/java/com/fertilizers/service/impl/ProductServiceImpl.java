package com.fertilizers.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fertilizers.dto.ProductDto;
import com.fertilizers.entities.Category;
import com.fertilizers.entities.Product;
import com.fertilizers.entities.SubCategory;
import com.fertilizers.exception.ResourceNotFoundException;
import com.fertilizers.repository.CategoryRepository;
import com.fertilizers.repository.ProductRepository;
import com.fertilizers.repository.SubCategoryRepository;
import com.fertilizers.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

	private CategoryRepository categoryRepository;
	private SubCategoryRepository subCategoryRepository;
	private ProductRepository productRepository;
	private ModelMapper modelMapper;
	
	@Override
	public ProductDto createProduct(int catId, int subCatId, ProductDto productDto) {
		Category category = this.categoryRepository.findById(catId).orElseThrow(() -> new ResourceNotFoundException("category", "category id", catId));
		SubCategory subCategory = this.subCategoryRepository.findById(subCatId).orElseThrow(() -> new ResourceNotFoundException("sub category", "sub category id", subCatId));
		Product product = this.modelMapper.map(productDto, Product.class);
		product.setSubCategory(subCategory);
		Product save = this.productRepository.save(product);
		return this.modelMapper.map(save, ProductDto.class);
	}

	@Override
	public ProductDto getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDto updateProduct(int productId, ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
