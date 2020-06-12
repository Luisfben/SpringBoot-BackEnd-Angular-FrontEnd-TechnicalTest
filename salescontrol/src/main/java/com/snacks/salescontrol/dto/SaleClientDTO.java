package com.snacks.salescontrol.dto;

import java.io.Serializable;
import java.util.List;

import com.snacks.salescontrol.model.Client;

public class SaleClientDTO implements Serializable {
	
	private static final long serialVersionUID = -8479750766356424606L;
	
	private Client client;
	private List<ProductDTO> products;

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
}
