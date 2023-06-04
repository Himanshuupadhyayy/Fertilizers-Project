package com.fertilizers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fertilizers.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
