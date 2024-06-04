package com.example.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private double price;
	private String description;
	private boolean inStock;
	private Integer quantity;
	private String barcode;
	
	@ManyToOne
	@JoinColumn(name="cat_id",nullable=false)
	private Category category;
	
	@OneToMany(mappedBy="product")
	private List<Review> reviews;
	

}
