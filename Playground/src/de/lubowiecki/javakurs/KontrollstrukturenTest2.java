package de.lubowiecki.javakurs;

public class KontrollstrukturenTest2 {

	public static void main(String[] args) {
		
		String input = "";
		
		//Kompiletimekonstante
		final String a = "A";
		
		// KEINE Kompiletimekonstante, Laufzeitkonstante
		final String b;
		b = "B";
		
		switch(input) {
		
			default:
				break;
				
			case a: // Muss eine Kompiletimekonstante sein
				break;
				
				
			case "B":
				break;
				
				
			case "C":
				break;
				
			case "D":
				break;
		
		}
		
		byte b2 = 20;
		
		switch(b2) {
		
			default:
				break;
				
			case 20: // Muss eine Kompiletimekonstante sein
				break;
				
				
			case 50:
				break;
				
				
			case 100:
				break;
				
//			case 150: // 150 ist kein byte
//				break;
		
		}
	}
	
	public static String machWas(String input) {
		
		switch(input) {
		
			default:
				return "Nix";
				
			case "A": // Muss eine Kompiletimekonstante sein
				return "A";
				
				
			case "B":
				return "B";
				
				
			case "C":
				return "C";
				
			case "D":
				return "D";
	
		}
		
		//System.out.println("..."); // Unerreichbare Code
	}
	

}
