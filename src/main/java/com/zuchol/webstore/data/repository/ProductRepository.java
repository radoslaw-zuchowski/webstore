package com.zuchol.webstore.data.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zuchol.webstore.domain.Product;


public interface ProductRepository {

	List<Product> getAllProducts();
	
	Product getProductById(Integer productId);

	List<Product> getProductsByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	List<Product> getProductsByManufacturer(String manufacturer);
	
	Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);
	
	
}
