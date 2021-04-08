package de.lubowiecki.javakurs.uebungen.u1;

import java.util.Scanner;

public class RechnerCli {
	
	private Scanner scanner = new Scanner(System.in);
	private Rechner rechner = new Rechner();
	
	private static final String KEYS = "\n---------------------\n"
									+ "  add\n"
									+ "  div\n"
									+ "  minus\n"
									+ "  multi\n"
									+ "  pro\n"
									+ "  exit\n"
									+ "---------------------\n";
	
	public static void main(String[] args) {
		new RechnerCli().start();
	}
	
	private void start() {
		
		System.out.println(KEYS);
		
		app: while(true) {
			
			System.out.print("Operator: ");
			switch(scanner.nextLine().trim().toLowerCase()) {
				
				case "add":
					System.out.println(rechner.add(takeNumber("A:"), takeNumber("B:")));
					break;
					
				case "div":
					System.out.println(rechner.div(takeNumber("A:"), takeNumber("B:")));
					break;
					
				case "minus":
					System.out.println(rechner.minus(takeNumber("A:"), takeNumber("B:")));
					break;
				
				case "multi":
					System.out.println(rechner.multi(takeNumber("A:"), takeNumber("B:")));
					break;
					
				case "exit": break app;
					
				case "pro":
					System.out.println(rechner.getProtocol());
					break;
				
				default:
					System.out.println("Falsche Eingabe.");
					System.out.println(KEYS);
			}
		}
	
		System.out.println("Programmende.");
	}
	
	private double takeNumber(String beschreibungsText) {
		System.out.print(beschreibungsText + " ");
		double val = scanner.nextDouble();
		scanner.nextLine(); // Scanner fix
		return val;
	}
}
