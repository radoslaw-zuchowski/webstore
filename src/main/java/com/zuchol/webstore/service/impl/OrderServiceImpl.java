package com.zuchol.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuchol.webstore.data.repository.ProductRepository;
import com.zuchol.webstore.domain.Product;
import com.zuchol.webstore.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private ProductRepository productRepository;

	
	public void processOrder(Integer productId, int count) {
		Product productById = productRepository.getProductById(productId);
		
		if(productById.getUnitsInStock() < count){
			throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie: "+ productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	
	}

}
