package com.fertilizers.controller;

import java.util.List;

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

import com.fertilizers.dto.SubCategoryDto;
import com.fertilizers.entities.SubCategory;
import com.fertilizers.payloads.ApiResponse;
import com.fertilizers.service.SubCategoryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/catalogue/category/{category_id}")
@Slf4j
@AllArgsConstructor
public class SubCategoryController {

	private SubCategoryService subCategoryService;
	
	@PostMapping("/subcategory")
	public ResponseEntity<SubCategoryDto> addSubCategory(@PathVariable ("category_id") int catId, @RequestBody SubCategoryDto subCategoryDto){
		log.info("inside the add sub category method");
		SubCategoryDto addSubCategory = this.subCategoryService.addSubCategory(catId, subCategoryDto);
		return new ResponseEntity<SubCategoryDto>(addSubCategory, HttpStatus.CREATED);
	}
	
	@GetMapping("/subcategory/{subcategory_id}")
	public ResponseEntity<SubCategoryDto> getSubCategory(@PathVariable ("category_id") int catId, @PathVariable("subcategory_id") int subCatId){
		log.info("inside the get sub category method");
		SubCategoryDto getSubCategory = this.subCategoryService.getSubCategory(catId, subCatId);
		return new ResponseEntity<SubCategoryDto>(getSubCategory, HttpStatus.OK);
	}
	
	@GetMapping("/subcategories")
	public ResponseEntity<List<SubCategory>> getSubCategories(@PathVariable ("category_id") int catId){
		log.info("inside the list of sub category method");
		List<SubCategory> getSubCategories = this.subCategoryService.getSubCategories(catId);
		return new ResponseEntity<List<SubCategory>>(getSubCategories, HttpStatus.OK);
	}
	
	@DeleteMapping("/subcategory/{subcategory_id}")
	public ResponseEntity<ApiResponse> deleteSubCategory(@PathVariable("subcategory_id") int subCatId, @PathVariable ("category_id") int catId){
		log.info("inside the delete category method");
		this.subCategoryService.deleteSubCategory(catId, subCatId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("sub category deleted Successfully ", true), HttpStatus.OK);
	}
	
	@PutMapping("/subcategory/{subcategory_id}")
	public ResponseEntity<SubCategoryDto> updateSubCategory(@PathVariable ("category_id") int catId, @PathVariable("subcategory_id") int subCatId, @RequestBody SubCategoryDto subCategoryDto){
		log.info("inside the update category method");
		SubCategoryDto addSubCategory = this.subCategoryService.updateSubCategory(catId, subCatId, subCategoryDto);
		return new ResponseEntity<SubCategoryDto>(addSubCategory, HttpStatus.OK);
	}
	
	
}
