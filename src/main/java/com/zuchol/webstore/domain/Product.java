package com.zuchol.webstore.domain;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement
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
	@JsonIgnore
	private MultipartFile productImage;
	@JsonIgnore
	private MultipartFile pdfManual;
	
	public Product() {
		super();
	}
	
	public Product(Integer productId, String name, BigDecimal price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}	
	
	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}
	
	@XmlTransient
	public MultipartFile getPdfManual() {
		return pdfManual;
	}
	
}
