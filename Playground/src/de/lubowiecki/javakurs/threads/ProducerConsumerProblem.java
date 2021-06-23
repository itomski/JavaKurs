package de.lubowiecki.javakurs.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		
		Lager<Holz> holzLager = new Lager<>(100);
		
		new Holzfaeller(holzLager, "Peter").start();
		new Holzfaeller(holzLager, "Bruce").start();
		new Holzfaeller(holzLager, "Carol").start();
		
		new Haendler(holzLager, "Tony").start();
		new Haendler(holzLager, "Steve").start();
		new Haendler(holzLager, "Natasha").start();
	}
}

class Lager<T> {
	
	private final int MAX_SIZE;
	
	private Queue<T> lagergut = new LinkedList<>();
	
	public Lager(int size) {
		MAX_SIZE = size;
	}
	
	public synchronized void einlagern(T t) {
		System.out.println(Thread.currentThread().getName() + ": Einlagern START");
		//lagergut.offer(t);
		
		// Thread hängt hier drin, bis Lagerbestand wieder kleiner als 100, erst dan kann was neues hinzugrfügt werden
		while(lagergut.size() >= MAX_SIZE) {
			System.out.println(Thread.currentThread().getName() + ": Einlagern WARTET");
			try {
				this.wait(); // Wenn MAX_SIZE erreicht ist, soll der Thread warten, aber den LOCK freigeben
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		lagergut.add(t);
		this.notifyAll(); // Alle, die auf den Lock warten werden darüber informiert, dass sich der Zustand des Lagers
		// verändert hat und sie erneut ihre Aktion versuchen können
		System.out.println(Thread.currentThread().getName() + ": Einlagern FERTIG, Bestand: " + lagergut.size());
		
	}
	
	public synchronized T abholen() {
		System.out.println(Thread.currentThread().getName() + ": Abholen START");
		//T t = lagergut.poll();
		
		// Thread hängt hier drin, bis Lagerbestand wieder größer als 0, erst dan kann etwas entnommen werden
		while(lagergut.size() == 0) {
			System.out.println(Thread.currentThread().getName() + ": Abholen WARTET");
			try {
				this.wait();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		T t = lagergut.remove();
		this.notifyAll();
		System.out.println(Thread.currentThread().getName() + ": Abholen FERTIG, Bestand: " + lagergut.size());
		return t;
	}
}

class Holzfaeller extends Thread {
	
	private Lager<Holz> lager;

	public Holzfaeller(Lager<Holz> lager, String name) {
		super(name);
		this.lager = lager;
	}
	
	@Override
	public void run() {
		while(true) {
			lager.einlagern(new Holz());
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Haendler extends Thread {
	
	private Lager<Holz> lager;

	public Haendler(Lager<Holz> lager, String name) {
		super(name);
		this.lager = lager;
	}
	
	@Override
	public void run() {
		while(true) {
			lager.abholen();
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Holz {
	
}