package de.lubowiecki.javakurs.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

	public static void main(String[] args) {
		
		System.out.println("START");
		
		// SingleThreadExecutor: arbeitet mit einem Worker-Thread, der nacheinander seine Aufgaben abarbeitet
		//ExecutorService service = Executors.newSingleThreadExecutor();
		
		// FixedThreadPool: arbeitet mit voregebener Anzahl Worker-Threads, die die Aufgaben parallel abarbeiten
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		Runnable aufgabe = () -> {
			System.out.println(Thread.currentThread().getName() + ": erledigt die Arbeit");
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		// Scheduler: entscheidet welche Threads wie lange Zugriff auf den Prozessor haben
		
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		service.execute(aufgabe);
		
		service.shutdown(); // Der Service muss untergefahren werden
		
		System.out.println("ENDE");
		

	}
}
