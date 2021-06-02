package de.lubowiecki.javakurs.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionTest {

	public static void main(String[] args) {
		
		// R apply(T t);
		Function<Double,String> f1 = (d) -> String.format("%.2f", d);
		
		//Function<Double,Double> eurToUsd = (d) -> d * 1.22;
		UnaryOperator<Double> eurToUsd = (d) -> d * 1.22; // Funktion, wo der Rückgabetyp = dem Eingangstyp ist
		
		// System.out.println(f1.apply(100.99999));
		
		List<Double> preise = new ArrayList<>();
		preise.add(10.2);
		preise.add(15.253);
		preise.add(17.8);
		preise.add(1.99);
		
		preise.stream() // Wandelt die Werte der List in einen Stream um
			.map(eurToUsd) // map verlang eine Function, ruft automatisch die apply-Methode auf
			.map(f1)
			.forEach(System.out::println); // forEach verlangt Consumer, ruft automatisch die accept-Methode auf
		
		
//		System.out.printf("%.2f", 10.2); // Gibt einen formatierten String aus, liefert void zurück
//		System.out.format("%.2f", 10.2); // Gibt einen formatierten String aus, liefert void zurück
//		String s = String.format("%.2f", 10.2); // Gibt einen formatierten String zurück

		Function<Double,Double> eurToUsd2 = (d) -> d * 1.22;
		
		List<Double> erg = changeList(preise, eurToUsd2);
		System.out.println(erg);
		
		erg = changeList(preise, d -> d * 4.46); // Lambda direkt eingegeben
		System.out.println(erg);
		
		erg = changeList(preise, d -> d * d);
		System.out.println(erg);
		
		// Umwandlung von Double auf String
		
		List<String> erg2 = changeList2(preise, d -> d + "...");
		System.out.println(erg2);
		
		
		// andThen: verbindet zwei Funktionen, , linke Funktion wird als erstes ausgeführt
		// 1Func: Double > Double, 2Func: Double > String
		Function<Double, String> newFunc = eurToUsd.andThen(d -> d + " $");
		System.out.println(newFunc.apply(10.2));
		
		// compose: verbindet zwei Funktionen, rechte Funktion wird als erstes ausgeführt
		// d -> d * 2, erg * 1.22 
		Function<Double, Double> newFunc2 = eurToUsd.compose(d -> d * 2);
		System.out.println(newFunc2.apply(10.2));
	}
	
	
	public static List<Double> changeList(List<Double> list, Function<Double, Double> func) {
		
		for(int i = 0; i < list.size(); i++) {
			//list.set(i, func.apply(list.get(i)));
			
			double val = list.get(i); // Wert an Pos i abgefragt
			double newVal = func.apply(val); // Funktion auf abgefragten Wert angewandt
			list.set(i, newVal); // Alten Wert durch den neuen ersetzt
		}
		
		return list;
	}
	
	public static List<String> changeList2(List<Double> list, Function<Double, String> func) {
		
		List<String> erg = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			double val = list.get(i); // Wert an Pos i abgefragt
			String newVal = func.apply(val); // Funktion auf abgefragten Wert angewandt
			erg.add(newVal);
		}
		
		return erg;
	}
	

}
