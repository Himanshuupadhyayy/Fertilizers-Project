package com.fertilizers.service;

import java.util.List;

import com.fertilizers.dto.CropDto;
import com.fertilizers.entities.Crops;

public interface CropService {

	CropDto addCrop(CropDto cropDto);
	
	List<Crops> getCrops();
	
	CropDto getCrop(int cropId);
	
	CropDto updateCrop(int cropId, CropDto cropDto);
	
	void deleteCrop(int cropId);

	
	List<CropDto> getCropByName(String cropName);
	
}
