package de.lubowiecki.javakurs.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncTest2 {
	
	public static void main(String[] args) {
		
		Syncer s1 = new Syncer();
		
		Runnable r = () -> {
			for(int i = 0; i < 10_000; i++) {
				//s1.countA();
				//s1.countB();
				s1.countC();
			}
		};
		
		Thread t1 = new Thread(r);
		t1.start();
		
		Thread t2 = new Thread(r);
		t2.start();
		
		Thread t3 = new Thread(r);
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//System.out.println(s1.getA());
		//System.out.println(s1.getB());
		System.out.println(s1.getC());
	}
}

// Atomare Aktionen: werden bei Ausführung durch Threads nicht unterbrochen, wenn die Zeitscheibe des Threads zuende ist

class Syncer {
	
	private static int a;
	
	private int b;
	
	// Die Variable kümmert sich selbst um Sequenzielle-Integrität
	private AtomicInteger c = new AtomicInteger(); // Ein Container für Zahlen
	
	private int d;
	
	// Eine Synchronisation ist nicht nötig
	private volatile int e;
	
	// Jedes Objekt (auch alles was von Object angeleitet ist) kann als LOCK verwendet werden
	private Object readLock = new Object();
	private Object writeLock = new Object();
	
	// diese Methode synchronisiert auf class
	// Alle aufrufe synchronisierter statischer Methoden werden über das gleich Lock (Syncer.class) verwaltet
	// und können daher nicht gleichzeitig ausgeführt werden
	public synchronized static void countA() {
		// Syncer.class ist ein Objekt das die Klasse beschriebt
		// class existiert nur 1x pro Klasse
		a += 1;
	}
	
	// Synchronisiert auf this - kann vom Entwickler nicht geändert werden
	// Auf diesem Syncer-Objekt darf immer nur ein Thread gleichzeitig diese Methode benutzen
	// Die ganze Methode wird gesperrt.
	public synchronized void countB() {
		b += 1; // Ist nicht atomar d.h. diese Aktion kann mitten din unterbrochen werden
	}
	
	public void countC() {
		c.incrementAndGet(); // ist atomar d.h. kann nicht mitten drin unterbrochen werden
	}
	
	public void countE() {
		e += 1;
	}
	
	public void countD() {
		// es wird nur der Block synchronisiert. Der Rest der Methode kann parallel abgearbeitet werden
		// Bei dem Sync-Block kann der Entwickler selbst das Lock wählen
		synchronized (writeLock) {
			d++; // ist keine atomare Aktion
		}
	}
	
	public static int getA() {
		return a;
	}
	
	// Lesen und Schreiben kann nicht gleichzeitig erfolgen. Beide Methoden verwenden this als Schlüssel
	public synchronized int getB() {
		return b;
	}
	
	public int getC() {
		return c.get();
	}
	
	public int getD() {
		// Da countD und getD unterschiedliche Locks verwenden, können diese Aktionen gleichzeitig durchgeführt werden
		synchronized (readLock) {
			return d;
		}
	}
	
	public int getE() {
		return e;
	}
}
