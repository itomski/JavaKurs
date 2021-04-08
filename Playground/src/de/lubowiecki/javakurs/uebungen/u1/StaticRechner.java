package de.lubowiecki.javakurs.uebungen.u1;

public class StaticRechner {
	
	private StaticRechner() {
	}
	
	public static double add(double a, double b) {
//		double erg = a + b;
//		return erg;
		return a + b;
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static double minus(double a, double b) {
		double erg = a - b;
		return erg;
	}
	
	public static double multi(double a, double b) {
		double erg = a * b;
		return erg;
	}
	
	public static double div(double a, double b) {
		double erg = a / b;
		return erg;
	}

}
