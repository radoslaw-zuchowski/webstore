package com.zuchol.webstore.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer {

	private Integer customerId;
	private String name;
	private String address;
	private Integer noOfOrdersMade;
	
	
	public Customer() {
		super();
	}
	
	
	public Customer(Integer customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}
}
