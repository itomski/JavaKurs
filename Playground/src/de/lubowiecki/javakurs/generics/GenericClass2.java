package de.lubowiecki.javakurs.generics;

public class GenericClass2<T> {
	
	private T xyz; // Hier wird der generisch Typ der Klasse/Objektes genutzt
	
	// Hier wird der generisch Typ der Klasse/Objektes genutzt
	public T machWasAnderes(T s) {
		return null;
	}
	
	// Methode verwendet einen eigenen generischen Typ
	// Lokaler generischer Typ überlagert den generischen Typ der Klasse
	// Generische Methoden sind meistens statische Methoden
	public <T> T machWas(T s) {
		return null;
	}
}
