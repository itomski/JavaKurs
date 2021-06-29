package de.lubowiecki.javakurs.data;

import java.io.Serializable;

public class Thing implements Serializable {
	
	private static final long serialVersionUID = -5308730016546897609L;
	
	private String name;
	
	public Thing() {
	}
	
	public Thing(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Beschreibt die Konvertierung von Thing in String
	@Override
	public String toString() {
		return "Thing [name=" + name + "]";
	}
}
