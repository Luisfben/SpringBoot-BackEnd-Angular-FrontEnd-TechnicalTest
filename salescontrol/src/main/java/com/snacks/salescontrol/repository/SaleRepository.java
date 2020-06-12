package com.snacks.salescontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.snacks.salescontrol.model.Sale;

@Repository 
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
