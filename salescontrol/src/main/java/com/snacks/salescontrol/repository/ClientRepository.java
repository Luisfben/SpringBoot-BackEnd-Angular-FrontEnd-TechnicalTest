package com.snacks.salescontrol.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.snacks.salescontrol.model.Client;

@Repository 
public interface ClientRepository extends JpaRepository<Client, Long> {

}
