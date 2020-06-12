package com.snacks.salescontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KARDEX")
public class Kardex {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idKardex;
	
	@Column
	private Long idProduct;
	
	@Column
	private String typeTransaction;

	@Column
	private Long idTransaction;

	@Column
	private Long quantity;
	
	@Column
	private Double price;
	
	public Long getIdKardex() {
		return idKardex;
	}

	public void setIdKardex(Long idKardex) {
		this.idKardex = idKardex;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
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
