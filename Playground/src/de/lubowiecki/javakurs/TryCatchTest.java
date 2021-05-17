package de.lubowiecki.javakurs;

public class TryCatchTest {

	public static void main(String[] args) throws Exception {
		
		System.out.println("START");
		//doSomething(); // Exception bricht die main Methode ab
		//doSomethingElse(); // Exception wurde behandelt und taucht hier nicht mehr auf
		
		try {
			doSomething(); // Exception wurde nicht behandelt und taucht hier auf. Wird aber an das catch weitergegeben
		} 
		catch (Exception e) {
			System.out.println("CATCH: " + e.getMessage()); // Exception ist jetzt behandelt und ist vom Tisch
		}
		
		System.out.println("ENDE");

	}
	
	public static void doSomething() {
		
		try {
			System.out.println("INNER: Start");
			int[] arr = new int[5];
			System.out.println(arr[5]); // Exception tritt auf, Methode wird an dieser Stelle abgebrochen. Exception wird weitergereicht. Aber...
			System.out.println("INNER: Ende"); // Zeile wird nicht mehr erreicht
		}
		finally { // ... vor dem verlassen der Methode muss noch das finally abgearbeitet werden
			System.out.println("FIN");
		}
	}
	
	public static void doSomethingElse() {
		
		try {
			System.out.println("INNER: Start");
			int[] arr = new int[5];
			System.out.println(arr[5]); // Exception tritt auf, Methode wird an dieser Stelle abgebrochen. Exception wird an catch übergeben
			System.out.println("INNER: Ende"); // Zeile wird nicht mehr erreicht
		}
		catch(Exception e) {
			System.out.println("CATCH: " + e.getMessage()); // Exception ist behandelt und wird nicht weitergereicht
		}
		finally { // wird trotzdem ausgeführt
			System.out.println("FIN");
		}
	}

}
