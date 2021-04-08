package de.lubowiecki.javakurs.uebungen.u1;

public class RechnerTest {

	public static void main(String[] args) {
		
		Rechner r1 = new Rechner();
		System.out.println(r1.add(10.5, 11.25));
		System.out.println(r1.minus(10.5, 11.25));
		System.out.println(r1.multi(10.5, 11.25));
		System.out.println(r1.div(10.5, 11.25));
		
		Rechner r3 = new Rechner();
		System.out.println(r3.add(10, 11));
		System.out.println(r3.minus(10, 11));
		System.out.println(r3.multi(10, 11));
		System.out.println(r3.div(10, 11));
		
		System.out.println();
		
		System.out.println(r1.getProtocol());
		System.out.println();
		
		System.out.println(r3.getProtocol());
		System.out.println();
		
		System.out.println("-----------");
		
		System.out.println(StaticRechner.add(10.5, 11.25));
		System.out.println(StaticRechner.minus(10.5, 11.25));
		System.out.println(StaticRechner.multi(10.5, 11.25));
		System.out.println(StaticRechner.div(10, 11));
		
		System.out.println();
		
//		StaticRechner r2 = new StaticRechner();
//		System.out.println(r2.add(10.5, 11.25));
//		System.out.println(r2.minus(10.5, 11.25));
//		System.out.println(r2.multi(10.5, 11.25));
//		System.out.println(r2.div(10.5, 11.25));

	}
}
