package de.lubowiecki.javakurs.generics;

//Hier ist durch den Bound der Standard RawType Number
public class Rechner<T extends Number> {
	
	public double add(T t1, T t2) {
		return t1.doubleValue() + t2.doubleValue();
	}
}

class DoubleRechner extends Rechner<Double> {
	
}

// Rechts können konkrete Typen verwendet werden oder Platzhalter, die links neben der Klasse vorgestellt wurden

/**
 * 
 * @author tlubowiecki
 *
 * @param <T>
 * @param <U>
 */
class SpecialRechner<T, U extends Number> extends Rechner<U> {
	
}
