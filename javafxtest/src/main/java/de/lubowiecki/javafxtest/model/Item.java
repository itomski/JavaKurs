package de.lubowiecki.javafxtest.model;

import java.time.LocalDateTime;

public class Item extends AbstractEntity {
	
	private String name;
	
	private int count;
	
	private LocalDateTime createdAt;
	
	public Item() {
	}
	
	public Item(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public Item(int id, String name, int count, LocalDateTime createdAt) {
		this(name, count);
		setId(id);
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
