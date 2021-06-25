package de.lubowiecki.javakurs.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BackToTheFuture2 {

	private ExecutorService service = Executors.newFixedThreadPool(10);
	
	public static void main(String[] args) {
		new BackToTheFuture2().init();
	}

	private void init() {
		
		Integer i = 10;
		Double d = 20.0;
		Double d2 = d + i; // Zum Rechnen werden komplexe Typen ausgepackt
		System.out.println(d2);
		
		
		// Anzahl der Prozessorkerne abfragen
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		Callable<Integer> rand = () -> {
			return (int)(Math.random() * 6 + 1); 
		};
		
		try {
			// Wartet bis alle Ergebnisse vorliegen und liefert diese als eine Liste zurück
			List<Future<Integer>> ergs = service.invokeAll(Arrays.asList(rand, rand, rand, rand, rand, rand, rand, rand, rand, rand));
			
			ergs.forEach(f -> {
				try {
					System.out.println(f.get());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			});
			
			System.out.println("---------");
			
			// Wartet bis ein Ergebnis vorliegt und liefert dieses zurück
			Integer singleErgs = service.invokeAny(Arrays.asList(rand, rand, rand, rand, rand, rand, rand, rand, rand, rand));
			System.out.println(singleErgs);
			
		} 
		catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
