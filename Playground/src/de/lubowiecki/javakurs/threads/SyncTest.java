package de.lubowiecki.javakurs.threads;

public class SyncTest {
	
	public static void main(String[] args) {
		
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		
		new Thread(() -> c1.coutTo(100)).start();
		new Thread(() -> c1.coutTo(100)).start();
		new Thread(() -> c1.coutTo(100)).start();
		
	}
}

class Counter {
	
	private int count;
	
	// synchronisiert auf dem this
	synchronized void coutTo(int size) {
		for(; count <= size; count++)
		System.out.println(Thread.currentThread().getName() + ": " + count);
	}
}
