package com.fertilizers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fertilizers.entities.LoginData;

public interface LoginRepository extends JpaRepository<LoginData, Integer>{

	 LoginData findByMobile(String mobile);
	
}