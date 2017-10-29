package com.zuchol.webstore.exception;

public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -694354952032299587L;
	
	private Integer productId;

	public ProductNotFoundException(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getProductId() {
		return productId;
	}

}
