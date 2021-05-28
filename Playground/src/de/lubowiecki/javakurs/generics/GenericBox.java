package de.lubowiecki.javakurs.generics;

// Standard RawType ist Object
public class GenericBox<T> { // <T> Vorstellung des generischen Typs
	
	// Java kennt hier nur den RawType
	
	private T content; // T Verwendung des generischen Typs
	
	public GenericBox() {
	}
	
	public GenericBox(T t) { // Generischer Konstruktor
		content = t;
	}
	
	public void set(T t) {
		content = t;
	}
	
	public T get() {
		return content;
	}
}
