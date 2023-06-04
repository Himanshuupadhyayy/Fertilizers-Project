package com.fertilizers.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Crops {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cropId;
	private String cropName;
	private String cropDesc;
	private String cropImage;
	private String createBy;
	private String updateBy;
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;
	
	
	
}
