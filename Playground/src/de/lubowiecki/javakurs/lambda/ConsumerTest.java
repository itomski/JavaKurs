package de.lubowiecki.javakurs.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		
		// void accept(T t);
		Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c2 = s -> machWas(s);
		Consumer<String> c3 = s -> System.err.println(s);
		
		Consumer<Integer> c4 = i -> System.err.println(i);
		
		Consumer<Double> consPreis = d -> System.out.printf("%.2f%n", d);
		
		c1.accept("Hallo");
		c4.accept(1000);
		consPreis.accept(100.2345);
		MyLambdas.CONS_PRICE.accept(100.2345);
		
		List<Double> preise = new ArrayList<>();
		preise.add(10.2);
		preise.add(15.253);
		preise.add(17.8);
		preise.add(1.99);
		
		System.out.println("------");
		
		preise.forEach(consPreis);
		
		System.out.println("------");
		
		preise.forEach(MyLambdas.CONS_PRICE);
		
		System.out.println("------");
		
		preise.forEach(d -> System.out.printf("%.2f%n", d));
		
		System.out.println("------");
		
		// Statt ein Lambda zu übergeben, verweist man auf eine Methode, die
		// gleiches Verhalten (gleiche Eingangs-Parameter und Rückgabetyp) aufweist
		preise.forEach(ConsumerTest::showPrice); // Methoden-Referenz
		
		System.out.println("------");
		
		Consumer<Integer> c5 = i -> System.out.println(i);
		
		// andThen: zwei Consumer werden zu einem verbunden
		// zuerst wird c5 ausgeführt und danach i -> System.out.println(i * 2)
		Consumer<Integer> c6 = c5.andThen(i -> System.out.println(i * i)); 
		
		c6.accept(5);
		
		System.out.println("------");
		
		Consumer<Double> consEUR = d -> System.out.printf("%.2f EUR ", d);
		Consumer<Double> consUSD = d -> System.out.printf("%.2f USD ", d * 1.22);
		Consumer<Double> consPLN = d -> System.out.printf("%.2f Zloty %n", d * 4.46);
		
		// andThen verbindet zwei Consumer und liefert einen neuen Consumer, 
		// der wieder mit einem anderen verbunden werden kann
		preise.forEach(consEUR.andThen(consUSD).andThen(consPLN));

	}
	
	public static void machWas(String s) {
		
	}
	
	public static void showPrice(Double d) {
		System.out.printf("%.2f%n", d);
	}

}
