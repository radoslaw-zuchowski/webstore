package com.zuchol.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuchol.webstore.data.repository.ProductRepository;
import com.zuchol.webstore.domain.Product;
import com.zuchol.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	
	public Product getProductById(Integer productId) {
		return productRepository.getProductById(productId);
	}
	
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}
	
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}
	
	public List<Product> getProductsByManufacturer(String manufacturer) {
		return productRepository.getProductsByManufacturer(manufacturer);
	}

	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByPriceFilter(filterParams);
	}
	
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}
}
