package de.lubowiecki.javakurs.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinActionTest {

	public static void main(String[] args) {
		
		final int SIZE = 500_000_000;
		
		long start = System.currentTimeMillis();
		
		int[] rand = new int[SIZE];
		
		ForkJoinPool pool = new ForkJoinPool(); // hat automatisch so viele Worker-Thread wie der Rechner Przessorkerne
		pool.invoke(new RandAction(rand, 0, rand.length));
		
		System.out.println(rand[new Random().nextInt(SIZE)]);
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");
		//System.out.println(RandAction.counter);
	}
}

class RandAction extends RecursiveAction {
	
	//static volatile int counter = 0; 

	int[] rand;
	int start;
	int end;
	
	public RandAction(int[] rand, int start, int end) {
		this.rand = rand;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		
		if(end - start <= 100) {
			Random randGen = new Random();
			for(int i = start; i < end; i++) {
				rand[i] = randGen.nextInt(100) + 1;
			}
		}
		else {
			//counter += 2;
			int range = start + ((end-start) / 2);
			RandAction part1 = new RandAction(rand, start, range);
			RandAction part2 = new RandAction(rand, range, end);
			part1.fork(); // Als Teilafgabe für parallele Abarbeitung abspliten, ruft die compute Methode für diese Teilaufgabe automatisch auf
			part2.compute(); // Der aktuelle Thread kümmert sich um den anderen Teil der Aufgabe
			part1.join(); // Warten auf die Beendigung der abgespliteten Aufgabe
		}
	}
}