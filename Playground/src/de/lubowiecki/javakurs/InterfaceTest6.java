package de.lubowiecki.javakurs;

public class InterfaceTest6 {

	public static void main(String[] args) {
		
		Tester t1 = (Object o) -> o.equals("");
		Tester t2 = o -> o.equals("");
		
		Tester<String> t3 = s -> s.indexOf('A') > -1;
		
		Iz1 i1 = new Iz1() {};
		//Iz2 i2 = (Iz2) i1; // Mit Casting zum Interface-Typ ist es kompilierbar
		
		Az1 a1 = new Az1();
		//Az2 a2 = (Az2) a1; // Mit Casting zum Klassen-Typ ist es NICHT kompilierbar
		
		int x;
		//System.out.println(x); //
		
	}
}

class Az1 {
	
}

class Az2 {
	
}

interface Iz1 {
	
}

interface Iz2 {
	
}


interface Tester<T> {
	
	boolean test(T s);
	
}

interface NextTester<T> {
	
	T test(int s);
	
}

class MyTester implements Tester<Double> {

	@Override
	public boolean test(Double s) {
		// TODO Auto-generated method stub
		return false;
	}	
}
