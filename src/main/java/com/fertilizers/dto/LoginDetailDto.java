/**
 * 
 */
package com.fertilizers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDetailDto {
	
	private String mobile;
	private int otp;
	
}
