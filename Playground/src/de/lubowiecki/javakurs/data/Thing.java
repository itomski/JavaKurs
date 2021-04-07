package de.lubowiecki.javakurs.data;

// immutable
public class Thing {
	
	private final String name;
	
	public Thing(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
