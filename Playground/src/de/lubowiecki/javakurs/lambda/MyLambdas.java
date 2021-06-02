package de.lubowiecki.javakurs.lambda;

import java.util.function.Consumer;

// Utility-Klasse
public final class MyLambdas {
	
	public static Consumer<Double> CONS_PRICE = d -> System.out.printf("%.2f%n", d);
	
	private MyLambdas() {
	}
}
