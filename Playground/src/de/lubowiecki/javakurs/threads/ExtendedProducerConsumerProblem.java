package de.lubowiecki.javakurs.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ExtendedProducerConsumerProblem {

		public static void main(String[] args) {
			
			ExLager<ExHolz> holzLager = new ExLager<>(100);
			
			new ExHolzfaeller(holzLager, "Peter").start();
			new ExHolzfaeller(holzLager, "Bruce").start();
			new ExHolzfaeller(holzLager, "Carol").start();
			
			new ExHaendler(holzLager, "Tony").start();
			new ExHaendler(holzLager, "Steve").start();
			new ExHaendler(holzLager, "Natasha").start();
		}
	}

class ExLager<T> {
	
	private final int MAX_SIZE;
	
	private Queue<T> lagergut = new LinkedList<>();
	
	private final String addLock = "WRITE";
	private final String takeLock = "READ"; 
	
	
	public ExLager(int size) {
		MAX_SIZE = size;
	}
	
	public void einlagern(T t) {
		System.out.println(Thread.currentThread().getName() + ": Einlagern START");
		//lagergut.offer(t);
		
		synchronized (addLock) {
			// Thread hängt hier drin, bis Lagerbestand wieder kleiner als 100, erst dan kann was neues hinzugrfügt werden
			while(lagergut.size() >= MAX_SIZE) {
				System.out.println(Thread.currentThread().getName() + ": Einlagern WARTET");
				try {
					addLock.wait(); // Wenn MAX_SIZE erreicht ist, soll der Thread warten, aber den LOCK freigeben
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lagergut.add(t);
		}
		synchronized (takeLock) {
			takeLock.notifyAll();
		}
		
		// verändert hat und sie erneut ihre Aktion versuchen können
		System.out.println(Thread.currentThread().getName() + ": Einlagern FERTIG, Bestand: " + lagergut.size());
		
	}
	
	public T abholen() {
		System.out.println(Thread.currentThread().getName() + ": Abholen START");
		//T t = lagergut.poll();
		
		T t = null;
		synchronized (takeLock) {
			// Thread hängt hier drin, bis Lagerbestand wieder größer als 0, erst dan kann etwas entnommen werden
			while(lagergut.size() == 0) {
				System.out.println(Thread.currentThread().getName() + ": Abholen WARTET");
				try {
					takeLock.wait();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			t = lagergut.remove();
		}
		synchronized (addLock) {
			addLock.notifyAll();
		}
		
		System.out.println(Thread.currentThread().getName() + ": Abholen FERTIG, Bestand: " + lagergut.size());
		return t;
	}
}

class ExHolzfaeller extends Thread {
	
	private ExLager<ExHolz> lager;

	public ExHolzfaeller(ExLager<ExHolz> lager, String name) {
		super(name);
		this.lager = lager;
	}
	
	@Override
	public void run() {
		while(true) {
			lager.einlagern(new ExHolz());
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ExHaendler extends Thread {
	
	private ExLager<ExHolz> lager;

	public ExHaendler(ExLager<ExHolz> lager, String name) {
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

class ExHolz {
	
}
