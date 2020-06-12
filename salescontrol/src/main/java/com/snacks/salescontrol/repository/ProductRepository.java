package com.snacks.salescontrol.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.snacks.salescontrol.dto.ProductInStockDTO;
import com.snacks.salescontrol.model.Product;


@Repository 
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT S.ID_PRODUCT AS id,\r\n" + 
			"       P.DESCRIPTION AS description,\r\n" + 
			"       P.PRICE AS price,\r\n" + 
			"       S.STOCK AS quantity\r\n" + 
			"FROM\r\n" + 
			"  (SELECT ID_PRODUCT,\r\n" + 
			"          SUM(QUANTITY) AS STOCK\r\n" + 
			"   FROM KARDEX\r\n" + 
			"   GROUP BY ID_PRODUCT\r\n" + 
			"   HAVING SUM(QUANTITY) > 0) S\r\n" + 
			"INNER JOIN PRODUCTS P ON S.ID_PRODUCT = P.ID_PRODUCT", nativeQuery=true)
	List<ProductInStockDTO> productInStock();
    }
