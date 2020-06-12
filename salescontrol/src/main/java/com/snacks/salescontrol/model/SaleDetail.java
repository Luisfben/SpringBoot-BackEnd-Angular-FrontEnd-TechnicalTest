package com.snacks.salescontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALES_DETAIL")
public class SaleDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSaleDetail;
	
	@Column
	private Long idSale;
	
	@Column
	private Long IdProduct;
	
	@Column
	private Long quantity;
	
	@Column
	private Double price;

	public Long getIdSaleDetail() {
		return idSaleDetail;
	}

	public void setIdSaleDetail(Long idSaleDetail) {
		this.idSaleDetail = idSaleDetail;
	}

	public Long getIdSale() {
		return idSale;
	}

	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}

	public Long getIdProduct() {
		return IdProduct;
	}

	public void setIdProduct(Long idProduct) {
		IdProduct = idProduct;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
