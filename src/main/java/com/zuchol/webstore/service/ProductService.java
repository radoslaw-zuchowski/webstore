package com.zuchol.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zuchol.webstore.domain.Product;


public interface ProductService {

	List<Product> getAllProducts();
	
	Product getProductById(Integer productId);
	
	List<Product> getProductsByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	List<Product> getProductsByManufacturer(String manufacturer);
	
	Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);
}
