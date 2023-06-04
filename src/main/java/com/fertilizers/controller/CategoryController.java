package com.fertilizers.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilizers.dto.CategoryDto;
import com.fertilizers.entities.Category;
import com.fertilizers.payloads.ApiResponse;
import com.fertilizers.service.CategoryService;

@RestController
@RequestMapping("/catalogue")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<CategoryDto> addCategory( @RequestBody CategoryDto categoryDto){
		CategoryDto addCategory = this.categoryService.addCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(addCategory, HttpStatus.CREATED);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> categories = this.categoryService.getCategories();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/category/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable int catId){
		CategoryDto category = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
	}
	
	@PutMapping("/category/{catId}")
	public ResponseEntity<CategoryDto> updateCategory( @PathVariable int catId, @RequestBody CategoryDto categoryDto){
		CategoryDto updateCategory = this.categoryService.updateCategory(catId, categoryDto);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
	}

	@DeleteMapping("/category/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int catId){
		this.categoryService.deleteCategory(catId); 
		return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted successfully", true), HttpStatus.OK);
	}
	
	@GetMapping("/categories/{param}")
	public ResponseEntity<List<Category>> getCategoriesByName(@PathVariable ("param") String catName){
		List<Category> categoriesByName = this.categoryService.getCategoriesByName(catName);
		return new ResponseEntity<List<Category>>(categoriesByName, HttpStatus.OK);
	}
	
	
}