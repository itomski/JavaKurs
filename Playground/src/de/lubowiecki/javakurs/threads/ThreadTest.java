package de.lubowiecki.javakurs.threads;

public class ThreadTest {

	public static void main(String[] args) {
		
		// Thread.currentThread() liefert eine Referenz auf den Thread, der diese Code aktuell ausführt
		System.out.println(Thread.currentThread().getName() + ": Start");
		
		
		Runnable aufgabe = () -> {
			System.out.println(Thread.currentThread().getName() + ": Start");
			int j;
			for(int i = 0; i < 1_000_000_000; i++) {
				j = i;
			}
			System.out.println(Thread.currentThread().getName() + ": Ende");
		};
		
		// Thread ist ein Container für eine Aufgabe
		// Thread t = new Thread();
		
		// Die Aufgabe eine Threads wird als Runnable an den Konstruktor übergeben, oder muss durch
		// Überschreiben der run-Methode erfolgen
		Thread t = new Thread(aufgabe);
		
		t.start(); // Damit ein Thread parallel laufen kann muss er nach der Instanzierung gestartet werden
		// die start-Methode führt dabei die run-Methode des Threads aus
		// Der zweite Thread ist von main entkoppelt und kann ggfl. später als der main-Thread beendet werden
		
		// Das Programm endet, wenn alle Threads ihre run-Methode abgearbeitet haben.
		
		// Runnable ist ein Interface, dass eine Aufgabe beschreibt, die imp0lementiert werden sollte
		
		System.out.println(Thread.currentThread().getName() + ": Ende");

	}
}
