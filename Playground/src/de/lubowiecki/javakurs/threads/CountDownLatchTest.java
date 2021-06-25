package de.lubowiecki.javakurs.threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(4);
		
		Rennwagen r1 = new Rennwagen("Mercedes", latch);
		Rennwagen r2 = new Rennwagen("Renault", latch);
		Rennwagen r3 = new Rennwagen("McLaren", latch);
		
		r1.start();
		r2.start();
		r3.start();
		
		
		try {
			Thread.sleep(1000);
			System.out.println(4 + "...");
			Thread.sleep(1000);
			latch.countDown();
			System.out.println(3 + "...");
			Thread.sleep(1000);
			latch.countDown();
			System.out.println(2 + "...");
			Thread.sleep(1000);
			latch.countDown();
			System.out.println(1 + "...");
			Thread.sleep(1000);
			latch.countDown();
			System.out.println("Start");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Rennwagen extends Thread {
	
	private Random rand = new Random();
	
	private CountDownLatch latch;

	public Rennwagen(String name, CountDownLatch latch) {
		super(name);
		this.latch = latch;
	}
	
	@Override
	public void run() {
		
		try {
			System.out.println(getName() + ": Ist da.");
			
			sleep(rand.nextInt(10) * 100);
			System.out.println(getName() + ": Wagen rollt an die Start-Position.");
			
			
			sleep(rand.nextInt(10) * 100);
			System.out.println(getName() + ": Startet den Motor.");
			
			sleep(rand.nextInt(10) * 100);
			System.out.println(getName() + ": Ist bereit.");
			
			//latch.countDown();
		
			latch.await();
			System.out.println(getName() + ": Rennen startet.");
			
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
