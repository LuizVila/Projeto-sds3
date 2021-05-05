package com.devsuperior.devvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.devvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
