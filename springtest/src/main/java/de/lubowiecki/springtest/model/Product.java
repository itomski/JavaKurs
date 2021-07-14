package de.lubowiecki.springtest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1239869214818948111L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 250)
	private String description;
	
	private double price;
	
	public Product() {
	}
	
	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setPrice(String price) {
		this.price = Double.parseDouble(price.replace(",", "."));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
