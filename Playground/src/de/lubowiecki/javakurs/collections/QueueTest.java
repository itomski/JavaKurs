package de.lubowiecki.javakurs.collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class QueueTest {

	public static void main(String[] args) throws InterruptedException {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(10); // wird von Collection geerbt und kann eine Exception werfen
		q.offer(20); // wirft keine Exception
		q.offer(30);
		
//		for(Integer i : q) {
//			System.out.println(i);
//		}
		
		System.out.println("SIZE: " + q.size());
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		System.out.println(q.poll()); // // Wenn es nicht geht, wird die Aktion ignoriert
		//System.out.println(q.remove()); // Wirft eine Exception, wenn q leer ist
		
		System.out.println("SIZE: " + q.size());
		
		System.out.println();
		
		SynchronousQueue<Integer> zahlen = new SynchronousQueue<>(); // hat nur Platz für ein Element
		
//		new Thread(() -> System.out.println(zahlen.poll())).start();
//		Thread.sleep(1000);
//		zahlen.add(1);
		
//		zahlen.add(2); // Wirft eine Exception, wenn zahlen voll ist
//		zahlen.offer(1);
		//zahlen.offer(2); // Wenn es nicht geht, wird die Aktion ignoriert
		
		
		
		
	}
}
