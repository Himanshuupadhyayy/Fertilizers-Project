package com.fertilizers.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.fertilizers.dto.LoginDetailDto;
import com.fertilizers.entities.LoginData;
import com.fertilizers.repository.LoginRepository;
import com.fertilizers.service.LoginDataService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class LoginDataServiceImpl implements LoginDataService{

	private LoginRepository loginRepository;
	
	@Override
	public int addMobile(String mobile) {
		LoginData data=this.loginRepository.findByMobile(mobile);
		Random random=new Random();
		int otp=random.nextInt(9999);
		log.info("otp is "+otp);
		LoginData loginData=new LoginData(mobile, otp);
		if(data==null) {
			this.loginRepository.save(loginData);
			return otp;
		}else {
			loginData.setId(data.getId());
			this.loginRepository.save(loginData);
		}
		return otp;
	}

	@Override
	public String loginDetails(LoginDetailDto loginDetailDto) {
		LoginData data=this.loginRepository.findByMobile(loginDetailDto.getMobile());
		log.info(data.getMobile()+" "+data.getOtp());
		if(data.getOtp() == loginDetailDto.getOtp()) {
			return "success";
		}
		return "please enter the valid otp";
	}

	
	
}