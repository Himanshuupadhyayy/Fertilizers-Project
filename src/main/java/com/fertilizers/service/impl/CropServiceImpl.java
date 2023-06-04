package com.fertilizers.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fertilizers.dto.CropDto;
import com.fertilizers.entities.Category;
import com.fertilizers.entities.Crops;
import com.fertilizers.exception.ResourceNotFoundException;
import com.fertilizers.repository.CropRepository;
import com.fertilizers.service.CropService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Slf4j
public class CropServiceImpl implements CropService{

	
	private CropRepository cropRepository;
	private ModelMapper modelMapper;
	
	@Override
	public CropDto addCrop(CropDto cropDto) {
		Crops crops = this.modelMapper.map(cropDto, Crops.class);
		crops = this.cropRepository.save(crops);
		return this.modelMapper.map(crops, CropDto.class);
	}

	@Override
	public List<Crops> getCrops() {
		List<Crops> crops = this.cropRepository.findAll();
		return crops;
	}

	@Override
	public CropDto getCrop(int cropId) {
		Crops crop = this.cropRepository.findById(cropId).orElseThrow(() -> new ResourceNotFoundException("crop", "crop id", cropId));
		return this.modelMapper.map(crop, CropDto.class);
	}

	@Override
	public CropDto updateCrop(int cropId, CropDto cropDto) {
		Crops crop = this.modelMapper.map(cropDto, Crops.class);
		Crops crop1 = this.cropRepository.findById(cropId).orElseThrow(() -> new ResourceNotFoundException("crop", "crop id", cropId));
		crop1.setCropId(cropId);
		crop1.setCreateBy(crop.getCreateBy());
		crop1.setCropDesc(crop.getCropDesc());
		crop1.setCropName(crop.getCropName());
		crop1.setUpdateBy(crop.getUpdateBy());
		crop1 = this.cropRepository.save(crop1);
		return this.modelMapper.map(crop1, CropDto.class);
	}

	@Override
	public void deleteCrop(int cropId) {
		Crops crop = this.cropRepository.findById(cropId).orElseThrow(() -> new ResourceNotFoundException("crop", "crop id", cropId));
		this.cropRepository.delete(crop);
	}

//	@Override
//	public CropDto getCropByName(String cropName) {
//		Crops name = this.cropRepository.findByCropName(cropName);
//		return this.modelMapper.map(name, CropDto.class);
//	}

	@Override
	public List<CropDto> getCropByName(String cropName) {
		List<Crops> name = this.cropRepository.findByCropNameContaining(cropName);
		List<CropDto> cropDto = (List<CropDto>) this.modelMapper.map(name, CropDto.class);
		 return cropDto;
	}

	
}