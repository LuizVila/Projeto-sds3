package com.devsuperior.devvendas.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.devvendas.dto.SaleDTO;
import com.devsuperior.devvendas.dto.SaleSuccessDTO;
import com.devsuperior.devvendas.dto.SaleSumDTO;
import com.devsuperior.devvendas.entities.Sale;
import com.devsuperior.devvendas.repositories.SaleRepository;
import com.devsuperior.devvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
			return result.map(x -> new SaleDTO(x));
		}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amoutGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.succesGroupedBySeller();
	}
}