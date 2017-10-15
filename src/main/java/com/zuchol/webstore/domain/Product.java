package com.zuchol.webstore.domain;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {

	private Integer productId;
	private String name;
	private BigDecimal price;
	private String description;
	private String manufacturer;
	private String category;
	private Long unitsInStock;
	private Long unitsInOrder;
	private Boolean discontinued;
	private String condition;
	
	public Product() {
		super();
	}
	
	public Product(Integer productId, String name, BigDecimal price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}	
	
	
}
