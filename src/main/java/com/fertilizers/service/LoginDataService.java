package com.fertilizers.service;

import com.fertilizers.dto.LoginDetailDto;

public interface LoginDataService {

	int addMobile(String mobile);

	String loginDetails(LoginDetailDto loginDetailDto);
		
}