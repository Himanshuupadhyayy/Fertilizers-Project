package com.fertilizers.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertilizers.dto.LoginDetailDto;
import com.fertilizers.entities.LoginData;
import com.fertilizers.service.LoginDataService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginDataController {

	@Autowired
	private LoginDataService loginDataService;

	@PostMapping("/mobile/{number}")
	public int takeMobile(@PathVariable("number") String mobile) {
		log.info("mobile is under the method at controller ");
		int otpp = this.loginDataService.addMobile(mobile);
		return otpp;
	}
	
	@PostMapping("/data")
	public String loginDetails(@RequestBody LoginDetailDto loginDetailDto) {
		log.info("as"+loginDetailDto.getMobile()+ " "+loginDetailDto.getOtp());
		String addOtp = this.loginDataService.loginDetails(loginDetailDto);
		if(addOtp == "success") {
			return "you are login now";
		}
		return "having some error";
	}
	
}