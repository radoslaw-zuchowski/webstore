package com.zuchol.webstore.data.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.zuchol.webstore.data.repository.ProductRepository;
import com.zuchol.webstore.domain.Product;
import com.zuchol.webstore.exception.ProductNotFoundException;

@Repository
public class InMemoryProductRepository implements ProductRepository{

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	
	public InMemoryProductRepository() {
		Product iphone = new Product(1,"iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczości 640x1136 i 8-megapikselowym aparatem");
		iphone.setCategory("Telefon");
		iphone.setUnitsInStock(500L);
		iphone.setUnitsInOrder(0L);
		iphone.setManufacturer("Apple");
		iphone.setDiscontinued(false);
		iphone.setCondition("Nowy");
		
		Product laptop_dell = new Product(2,"Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorem Intel Core 3. generacji");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setUnitsInStock(300L);
		laptop_dell.setUnitsInOrder(0L);
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setDiscontinued(false);
		laptop_dell.setCondition("Nowy");
		
		Product tablet_Nexus = new Product(3,"Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm SnapdragonTM S4 Pro");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setUnitsInStock(100L);
		tablet_Nexus.setUnitsInOrder(0L);
		tablet_Nexus.setManufacturer("Nexus");
		tablet_Nexus.setDiscontinued(false);
		tablet_Nexus.setCondition("Nowy");
		
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);	
	}

	
	
	
	
	
	public List<Product> getAllProducts() {
		return listOfProducts;
	}
	
	
	
	public Product getProductById(Integer productId) {
		Product productById = null;
		for (Product product : listOfProducts) {
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		if (productById == null) {
			throw new ProductNotFoundException(productId);
		}
		return productById;
		
	}
	
	
	public List<Product> getProductsByCategory(String category) {
		List<Product> productsBycategory = new ArrayList<Product>();
		for(Product product : listOfProducts) {
			if(category.equalsIgnoreCase(product.getCategory())) {
				productsBycategory.add(product);
			}
		}
		return productsBycategory;
	}
	
	
	
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		
		if (criterias.contains("brand")) {
			for (String brandName : filterParams.get("brand")) {
				for (Product product : listOfProducts) {
					if (brandName.equalsIgnoreCase(product.getManufacturer())) {
						productsByBrand.add(product);
					}
				}
			}
		}
		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		
		return productsByCategory;

	}
	
	public List<Product> getProductsByManufacturer(String manufacturer) {
		
		List<Product> productsByManufacturer = new ArrayList<Product>();
		for(Product product : listOfProducts) {
			if(manufacturer.equalsIgnoreCase(product.getManufacturer())) {
				productsByManufacturer.add(product);
			}
		}
	
		return productsByManufacturer;
	}
	
	
	
	
	
	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByLowPrice = new HashSet<Product>();
		Set<Product> productsByHighPrice = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		
		if (criterias.contains("low")) {
			for (String low : filterParams.get("low")) {
				for (Product product : listOfProducts) {
					Integer resultLow = new BigDecimal(low).compareTo(product.getPrice());
					if ((resultLow < 0) || (resultLow == 0)) {
						productsByLowPrice.add(product);
					}
				}
			}
			for (String high : filterParams.get("high")) {
				for (Product product : listOfProducts) {
					Integer resultHigh = new BigDecimal(high).compareTo(product.getPrice());
					if ((resultHigh > 0) || (resultHigh == 0)) {
						productsByHighPrice.add(product);
					}
				}
			}
		}

		productsByHighPrice.retainAll(productsByLowPrice);
		return productsByHighPrice;

	}
	
	
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
	
	
}
