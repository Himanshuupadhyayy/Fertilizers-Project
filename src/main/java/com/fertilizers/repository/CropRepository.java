package com.fertilizers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fertilizers.entities.Crops;

public interface CropRepository extends JpaRepository<Crops, Integer>{
	
	List<Crops> findByCropName (String cropName);
	List<Crops> findByCropNameContaining(String cropName);

}
