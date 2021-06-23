package de.lubowiecki.javakurs.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BackToTheFuture {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(10);

		Callable<Integer> aufgabe = () -> {
			int sum = 0;
			for (int i = 0; i < 100_000_000; i++) {
				sum += i;
			}
			return sum;
		};

		// Future ist ein Objekt, über das ich später an das fertig berechnete Ergebnis
		// rankomme
		// Hier wird nicht auf das Ergebnis gewartet
		Future<Integer> erg1 = service.submit(aufgabe); // Hier liegt das Ergebnis noch nicht vor
		Future<Integer> erg2 = service.submit(aufgabe);
		Future<Integer> erg3 = service.submit(aufgabe);
		Future<Integer> erg4 = service.submit(aufgabe);
		Future<Integer> erg5 = service.submit(aufgabe);

		ScheduledExecutorService check = Executors.newSingleThreadScheduledExecutor();

		Runnable checkErgs = () -> {
			try {
				int ergs = 0;

				if (erg1.isDone()) {
					System.out.println("ERG1: " + erg1.get());
					ergs++;
				}

				if (erg2.isDone()) {
					System.out.println("ERG2: " + erg2.get());
					ergs++;
				}

				if (erg3.isDone()) {
					System.out.println("ERG3: " + erg3.get());
					ergs++;
				}

				if (erg4.isDone()) {
					System.out.println("ERG4: " + erg4.get());
					ergs++;
				}

				if (erg5.isDone()) {
					System.out.println("ERG5: " + erg5.get());
					ergs++;
				}
				
				if(ergs == 5) {
					check.shutdownNow();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("---------------");

		};

		check.scheduleWithFixedDelay(checkErgs, 0, 10, TimeUnit.MILLISECONDS);

//		try {
//			System.out.println("ERG1: " + erg1.get(10, TimeUnit.MILLISECONDS));
//		}
//		catch (Exception e) {
//			System.out.println("ERG1 noch kein Wert!");
//		}

	}
}
