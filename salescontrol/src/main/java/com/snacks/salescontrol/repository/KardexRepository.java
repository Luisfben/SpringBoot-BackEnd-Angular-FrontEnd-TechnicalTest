package com.snacks.salescontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.snacks.salescontrol.model.Kardex;

@Repository 
public interface KardexRepository extends JpaRepository<Kardex, Long> {

}
