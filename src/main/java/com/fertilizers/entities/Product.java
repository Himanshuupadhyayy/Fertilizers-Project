package com.fertilizers.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String productDesc;;
	private String productPrice;
	private String productImage;
	private String shortDesc;
	private String createdBy;
	private String modifiedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SubCategory subCategory;
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date updateDate;
	
	
	
	
}
