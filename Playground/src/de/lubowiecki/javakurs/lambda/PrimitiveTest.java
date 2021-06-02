package de.lubowiecki.javakurs.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.Function;

public class PrimitiveTest {

	public static void main(String[] args) {
		
		Consumer<Integer> c1 = (i) -> System.out.println(i.doubleValue()); // i ist Integer-Object
		IntConsumer c2 = (i) -> System.out.println(i); // i ist primitiv int
		
		Function<Integer, Double> f1 = (i) -> i.doubleValue(); // i ist Integer-Object
		IntFunction<Double> f2 = (i) -> i + 0.0; // i ist primitiv int, addition führt zu double, AutoBoxing zu Double
		
		// Wandelt primitive ints in primitive doubles
		IntToDoubleFunction f3 = (i) -> i; // i ist primitiv int, primitive widening zu double
		
		double d = f3.applyAsDouble(10); // int zu double, 10 wird zu 10.0
	}

}
