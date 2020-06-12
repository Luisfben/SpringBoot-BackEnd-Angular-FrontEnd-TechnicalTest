package com.snacks.salescontrol.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = -8316369824894516034L;
	
	private Long id;
	private String description;
	private Double price;
	private Long quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	

}
