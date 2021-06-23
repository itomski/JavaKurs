package de.lubowiecki.javakurs.threads;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RitterTurnier {

	public static void main(String[] args) {
		
		Ritter r1 = new Ritter("Parceval");
		Ritter r2 = new Ritter("Lancelott");
		Ritter r3 = new Ritter("Bob");

		r1.setGegner(r2);
		r2.setGegner(r1);
		r3.setGegner(r1);
		
		r1.start();
		r2.start();
		r3.start();
	}
}

class Ritter extends Thread {
	
	private int lp = 20;
	
	// Zufallsgenerator
	private Random rand;
	
	private Ritter gegner;
	
	// ReentrantLock bietet mehr Flexibilität beim Synchronisieren
	private final ReentrantLock LOCK = new ReentrantLock(true); 
	
	public Ritter(String name) {
		super(name);
		rand = new Random();
	}

	@Override
	public void run() {
		
		// Wiederholen solange Ritter nicht KO und Gegner auch nicht KO
		while(!isKO() && !gegner.isKO()) {
			
			switch(rand.nextInt(3)) {
				
				case 0:
					System.out.println(getName() + ": überlegt");
					break;
					
				case 1:
					kick();
					break;
					
				case 2:
					punch();
					break;
			}
		}
		if(isKO())
			System.out.println(getName() + ": ist KO gegangen");
		else
			System.out.println(getName() + ": gewonnen");
	}
	
	public void setGegner(Ritter gegner) {
		this.gegner = gegner;
	}

	void kick() {
		if(gegner == null)
			System.out.println(getName() + ": niemand zum verkloppen da!");
		
		System.out.println(getName() + ": kick");
		gegner.changeLP(rand.nextInt(4));
		
		try {
			sleep((rand.nextInt(10) + 1) * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void punch() {
		if(gegner == null)
			System.out.println(getName() + ": niemand zum verkloppen da!");
		
		System.out.println(getName() + ": punch");
		gegner.changeLP(rand.nextInt(4));
		
		try {
			sleep((rand.nextInt(10) + 1) * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public void changeLP(int points) {
//		synchronized (this) {
//			lp -= points;
//		}
		
		// Alternative
		try {
			LOCK.lock(); // Nimmt den LOCK für die nächsten Zeilen auf
			lp -= points;
		}
		finally {
			LOCK.unlock(); // Gibt den LOCK wieder frei
		}
	}
	
	public boolean isKO() {
		return lp <= 0;
	}
}