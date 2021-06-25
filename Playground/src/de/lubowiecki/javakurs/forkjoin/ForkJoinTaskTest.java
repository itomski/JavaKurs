package de.lubowiecki.javakurs.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskTest {

	public static void main(String[] args) {
		
		final int SIZE = 100_000;
		
		long start = System.currentTimeMillis();
		
		ForkJoinPool pool = new ForkJoinPool(); // hat automatisch so viele Worker-Thread wie der Rechner Przessorkerne
		List<Integer> rands = pool.invoke(new RandTask(SIZE));
		
		System.out.println(rands.get(new Random().nextInt(SIZE)));
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");

	}

}


class RandTask extends RecursiveTask<List<Integer>> {
	
	private int size;
	
	public RandTask (int size) {
		this.size = size;
	}

	@Override
	protected List<Integer> compute() {
		
		if(size <= 100) {
			Random randGen = new Random();
			List<Integer> list = new ArrayList<>(size); 
			// erzeugt eine ArrayList mit passender capacity
			// Führt dazu, dass der Vergrößerung nicht mehrmals durchgeführt werden muss d.h. bessere Performance
			
			for(int i = 0; i < size; i++) {
				list.add(randGen.nextInt(100) + 1);
			}
			return list;
		}
		else {
			int partSize = size / 2;
			RandTask task1 = new RandTask(partSize);
			RandTask task2 = new RandTask(partSize);
			task1.fork(); // Hältfe der Aufgabe abspliten
			List<Integer> rands = task2.compute(); // Die andere Hälfte abarbeiten
			rands.addAll(task1.join()); // Ergebnisse der abgesplitenen Aufgabe zu den anderen hinzufügen
			return rands; // Beide Ergebnis-Teile els ein Ergebnis zurückgeben
		}
	}
}