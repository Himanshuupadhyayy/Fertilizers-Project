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
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int catId;
	private String catName;
	private String catDescription;
	private String catImage;
	
	@CreationTimestamp	
	private Date catCreatedDate;
	
	@UpdateTimestamp
	private Date catModifiedDate;
	
	@CreatedBy
	private String catCreatedBy;  
	
	private String catModifiedBy;

	@Transient
	@OneToMany(cascade =CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
	private List<SubCategory> subCategory=new ArrayList<>();
	
}
