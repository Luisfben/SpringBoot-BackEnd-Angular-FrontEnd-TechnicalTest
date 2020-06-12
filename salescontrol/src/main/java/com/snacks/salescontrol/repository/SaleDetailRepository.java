package com.snacks.salescontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.snacks.salescontrol.model.SaleDetail;

@Repository 
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

}
