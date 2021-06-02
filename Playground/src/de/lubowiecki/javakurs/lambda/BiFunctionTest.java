package de.lubowiecki.javakurs.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BiFunctionTest {

	public static void main(String[] args) {
		
		// BiFunction<T,U,R>
		// R apply(T t, U u);
		BiFunction<Integer, String, Double> biFunc1 = (i, s) -> (double)(i + Integer.parseInt(s));
		
		BiFunction<Integer, Integer, Integer> op1 = (i1, i2) -> i1 + i2;
		BinaryOperator<Integer> op2 = (i1, i2) -> i1 + i2; // Rückgabetyp gleich Eingangstyp
		
		
		BiFunction<List<String>, List<String>, Map<String, String>> func2 = (l1, l2) -> {
				
				Map<String, String> m = new HashMap<>();
				
				if(l1.size() != l2.size()) {
					return m;
				}
				
				for(int i = 0; i < l1.size(); i++) {
					m.put(l1.get(i), l2.get(i));
				}
				
				return m;
		};
		
		Function<List<String>,Map<String, String>> func3 = (l1) -> {
			
			Map<String, String> m = new HashMap<>();
			
			for(int i = 0; i < l1.size(); i++) {
				m.put(l1.get(i).charAt(0) + "", l1.get(i));
			}
			
			return m;
		};
		
		List<String> keys = Arrays.asList("A", "B", "C", "D");
		List<String> namen = Arrays.asList("Peter", "Anna", "Carol", "Hans");
		
		Map<String, String> m =  func2.apply(keys, namen);
		System.out.println(m);
		
		m =  func3.apply(namen);
		System.out.println(m);
		
		Double d1 = (double) 10; // primitiv widening von int auf double, double AutoBoxing zu Double
		//Double d2 = (Double) 10; // AutoBoxing von int zu Integer, widening von Integer auf Double (geht nicht!)

		
		
		
		
	}

}
