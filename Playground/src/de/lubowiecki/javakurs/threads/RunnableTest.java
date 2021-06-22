package de.lubowiecki.javakurs.threads;

public class RunnableTest {

	public static void main(String[] args) {
		
		new Thread(new Aufgabe()).start(); // startet die Aufgabe des Threads (run-Methode) unabhängig von main
		new Thread(new Aufgabe()).run(); // startet die Aufgabe des Threads (run-Methode) abhängig von main
		
		// Intanziert eine namenlose (anonyme) Klasse, die von Runnable abgeleitet ist
		Runnable aufgabe = new Runnable() {

			@Override
			public void run() {
				
				try {
					// Verzügert künstlich die Ausführung des Programms
					Thread.sleep(5000); // es wird 5 sek gewartet. 
					// InterruptedException muss behandelt werden, weil der Thread während des Wartes abgebrochen werden könnte
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + ": do something else");
			}
		};
		
		Thread t = new Thread(aufgabe);
		t.setDaemon(true); // t wird automatisch beendet, wenn main abgearbeitet ist
		t.setPriority(Thread.MAX_PRIORITY);
		//t.setPriority(10);
		t.start();
		
		// void run()
		new Thread(() -> System.out.println(Thread.currentThread().getName() + ": do something else...")).start();
		
		System.out.println("ENDE");
	}

}

class Aufgabe implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": do something");
	}
}
