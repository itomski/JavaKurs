package de.lubowiecki.javakurs.a;

public class AndererTest {

	public static void main(String[] args) {
		
		Mutter m = new Mutter();
		System.out.println(m.zahl); // Ok: keine Erbbeziehung, aber gleiches Package

	}
}
