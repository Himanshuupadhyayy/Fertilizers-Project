package com.fertilizers.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class SubCategory {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int subCatId;
	private String subCatName;
	private String subCatDesctiption;
	private String subCatImage;
	
	private String createdBy;
	private String modifiedBy;
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date modifiedDate;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "subCategory")
	private List<Product> products=new ArrayList<>();
	
	
	
}