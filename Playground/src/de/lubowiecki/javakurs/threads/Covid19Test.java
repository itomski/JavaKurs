package de.lubowiecki.javakurs.threads;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Covid19Test {

	public static void main(String[] args) {
		
		Laden kiosk = new Laden("Kiosk", 5);
		
		new Kunde("Bruce", kiosk).start();
		new Kunde("Steve", kiosk).start();
		new Kunde("Natasha", kiosk).start();
		new Kunde("Peter", kiosk).start();
		new Kunde("Carol", kiosk).start();
		new Kunde("Tony", kiosk).start();
		new Kunde("Tomek", kiosk).start();
	}
}

class Kunde extends Thread {
	
	private Laden laden;
	private Random rand;

	public Kunde(String name, Laden laden) {
		super(name);
		this.laden = laden;
	}
	
	@Override
	public void run() {
		
		rand = new Random();
		
		System.out.println(getName() + ": will in " + laden.getName() + " rein.");
		
		if(laden.nimmTicket()) {
			System.out.println(getName() + ": kauft bei " + laden.getName() + " ein.");
			try {
				sleep(rand.nextInt(10) * 1000);
				System.out.println(getName() + ": fertig mit dem Einkauf bei " + laden.getName());
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			laden.gibTicketZurück();
			System.out.println(getName() + ": verlässt " + laden.getName());
			
		}
	}
}

class Laden {
	
	private Semaphore tickets;
	
	private final String name;

	public Laden(String name, int anzahlTickets) {
		this.name = name;
		tickets = new Semaphore(anzahlTickets);
	}
	
	public boolean nimmTicket() {
		try {
			if(Thread.currentThread().getName().equals("Bruce")) {
				tickets.acquire(5);
			}
			else {
				tickets.acquire();
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void gibTicketZurück() {
		if(Thread.currentThread().getName().equals("Bruce")) {
			tickets.release(5);
		}
		else {
			tickets.release();
		}
	}

	public String getName() {
		return name;
	}
}
