package de.lubowiecki.javakurs.threads;

public class Ausflug {

	public static void main(String[] args) {
		
		System.out.println("Start");
		
		//Tracker t = new Tracker();
		Tracker t = new SyncTracker();
		
		
		//Vor dem start: NEW
		Scout s1 = new Scout("Peter", t);
		Scout s2 = new Scout("Max", t);
		Scout s3 = new Scout("Bob", t);
		Scout s4 = new Scout("Anna", t);
		Scout s5 = new Scout("Christin", t);
		Scout s6 = new Scout("Berta", t);
		
		// Nach dem start: RUNNABLE 
		s1.start(); // s1 führt seine run-Methode unabhängig von main und den anderen Threads aus
		s2.start();
		s3.start();
		s4.start();
		s5.start();
		s6.start();
		
		// Der Thread, der diese Code ausführt (main), wartet darauf, dass s1 bis s6 ihre run-Mthoden beenden
		try {
			s1.join();
			s2.join();
			s3.join();
			s4.join();
			s5.join();
			s6.join();
			// Sobald irgendwo ein Thread wartet, muss eine InterruptedException behandelt werden
			// InterruptedException: Ein Thread wird während er wartet abgebrochen
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Tracker: " + t.getSteps());
		
		// Nach Abarbeitung der run-Methode: TERMINATED
		System.out.println("Ende");

	}

}
