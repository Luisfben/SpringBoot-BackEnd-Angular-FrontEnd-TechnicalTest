package com.snacks.salescontrol.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.snacks.salescontrol.dto.ProductDTO;
import com.snacks.salescontrol.dto.ProductInStockDTO;
import com.snacks.salescontrol.dto.SaleClientDTO;
import com.snacks.salescontrol.model.Client;
import com.snacks.salescontrol.model.Kardex;
import com.snacks.salescontrol.model.Sale;
import com.snacks.salescontrol.model.SaleDetail;
import com.snacks.salescontrol.repository.ClientRepository;
import com.snacks.salescontrol.repository.KardexRepository;
import com.snacks.salescontrol.repository.ProductRepository;
import com.snacks.salescontrol.repository.SaleDetailRepository;
import com.snacks.salescontrol.repository.SaleRepository;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
public class SalesControlController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private KardexRepository kardexRepository;

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private SaleDetailRepository saleDetailRepository;

	@GetMapping("/api/v1/client")
	public List<Client> getClientAll() {
		return clientRepository.findAll();
	}

	@GetMapping("/api/v1/productinstock")
	public List<ProductInStockDTO> getProductInStock() {
		return productRepository.productInStock();
	}

	@PostMapping("/api/v1/saleclient")
	public SaleClientDTO setSaleClient(@RequestBody SaleClientDTO saleClient) {
		return this.saveSaleClient(saleClient);
	}
	
	private SaleClientDTO saveSaleClient(SaleClientDTO saleClient) {
		/*client*/
		clientRepository.save(saleClient.getClient());
		
		/*sale*/
		Sale sale = new Sale();
		sale.setIdClient(saleClient.getClient().getId());
		java.util.Date date = new Date();
		sale.setDate(date);
		saleRepository.save(sale);

		for(ProductDTO product : saleClient.getProducts()) {
			/*sale detail*/
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setIdSale(sale.getIdSale());
			saleDetail.setIdProduct(product.getId());
			saleDetail.setQuantity(product.getQuantity());
			saleDetail.setPrice(product.getPrice());
			saleDetailRepository.save(saleDetail);

			/*kardex*/
			Kardex kardex = new Kardex();
			kardex.setIdProduct(product.getId());
			kardex.setTypeTransaction("SAL");
			kardex.setIdTransaction(sale.getIdSale());
			kardex.setQuantity(product.getQuantity() * -1);
		    kardex.setPrice(product.getPrice() * -1);
			kardexRepository.save(kardex);
		}
		return saleClient;
	} 

}
