package com.fertilizers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fertilizers.dto.CropDto;
import com.fertilizers.entities.Crops;
import com.fertilizers.payloads.ApiResponse;
import com.fertilizers.service.CropService;

@RestController
public class CropController {

	@Autowired
	private CropService cropService;

	@PostMapping("/crop")
	public ResponseEntity<CropDto> addCrop(@RequestBody CropDto cropDto){
		CropDto addCrop = this.cropService.addCrop(cropDto);
		return new ResponseEntity<CropDto>(addCrop, HttpStatus.CREATED);
	}
	
	@GetMapping("/crops")
	public ResponseEntity<List<Crops>> getCrops(){
		List<Crops> crops = this.cropService.getCrops();
		return new ResponseEntity<List<Crops>>(crops, HttpStatus.OK);
	}
	
	@GetMapping("/crop/{crop_id}")
	public ResponseEntity<CropDto> getCrop(@PathVariable ("crop_id") int cropId){
		CropDto crop = this.cropService.getCrop(cropId);
		return new ResponseEntity<CropDto>(crop, HttpStatus.OK);
	}
	
	@PutMapping("/crop/{crop_id}")
	public ResponseEntity<CropDto> updateCrop(@PathVariable("crop_id") int cropId, @RequestBody CropDto cropDto){
		CropDto crop = this.cropService.updateCrop(cropId, cropDto);
		return new ResponseEntity<CropDto>(crop, HttpStatus.OK);
	}
	
	@DeleteMapping("/crop/{crop_id}")
	public ResponseEntity<ApiResponse> deleteCrop(@PathVariable("crop_id") int cropId){
		this.cropService.deleteCrop(cropId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("crop is deleted successsfully !! ", true), HttpStatus.OK);
	}
	
	
	@GetMapping("/crop")
	public ResponseEntity<List<CropDto>> getCropByName(@RequestParam ("param") String cropName){
		List<CropDto> cropByName = this.cropService.getCropByName(cropName); 
		return new ResponseEntity<List<CropDto>>(cropByName, HttpStatus.OK);
	}
	
}