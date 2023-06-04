package com.fertilizers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fertilizers.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	List<Category> findByCatName(String catName);
}
