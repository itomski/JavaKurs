package de.lubowiecki.javafxtest.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
	
	public String getCreatedAt() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return createdAt.format(f);
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
