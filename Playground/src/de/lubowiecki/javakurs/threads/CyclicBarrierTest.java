package de.lubowiecki.javakurs.threads;

import java.awt.Point;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		
		CyclicBarrier b = new CyclicBarrier(2, () -> System.out.println("Barriere bricht..."));
		
		Point target = new Point(15, 22);
		
		new Animal("Watson", b, target).start();
		new Animal("Marcie", b, target).start();
		new Animal("Stanly", b, new Point(5,32),  target).start();
	}
}

class Animal extends Thread {
	
	private CyclicBarrier barrier;
	
	private Point curPos = new Point(); // x: 0, y: 0
	
	private Point target;
	
	public Animal(String name, CyclicBarrier barrier, Point target) {
		super(name);
		this.barrier = barrier;
		this.target = target;
	}
	
	public Animal(String name, CyclicBarrier barrier, Point curPos, Point target) {
		this(name, barrier, target);
		this.curPos = curPos;
	}
	
	private boolean move() {
		
		System.out.println(getName() + " ist auf dem weg von " + curPos + " zu " + target);
		
		if(curPos.x < target.x)
			 curPos.x++;
		
		if(curPos.y < target.y)
			 curPos.y++;
		
		if(curPos.x > target.x)
			 curPos.x--;
		
		if(curPos.y > target.y)
			 curPos.y--;
		
		return curPos.equals(target);
	}
	
	@Override
	public void run() {
		
		try {
			while(!move()) {
				sleep(500);
			}
			
			System.out.println(getName() + ": Wartet auf die anderen.");
			barrier.await();
			
			target = new Point();
			
			while(!move()) {
				sleep(1000);
			}
			
			System.out.println(getName() + ": Ausflug beendet.");
		} 
		catch (InterruptedException | BrokenBarrierException e) {
			System.out.println(e.getMessage());
		}
	}
}
