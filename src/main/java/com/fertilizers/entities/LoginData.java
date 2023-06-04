package com.fertilizers.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LoginData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mobile;
	private int otp;
	private boolean status =false;
	private String type;
	
	private String createdBy;
	
	private String modifiedBy;
	
	@CreationTimestamp
	private Date loginDate;
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date modifiedDate;

	public LoginData(String mobile, int otp) {
		super();
		this.mobile = mobile;
		this.otp = otp;
	}
	
	
	
	
	
}
