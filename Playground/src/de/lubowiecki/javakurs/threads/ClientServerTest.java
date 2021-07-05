package de.lubowiecki.javakurs.threads;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ClientServerTest {
	
	public static void main(String[] args) {
		
		BlockingQueue<Request> requests = new ArrayBlockingQueue<>(5);
		
		Client c1 = new Client(requests);
		Client c2 = new Client(requests);
		Client c3 = new Client(requests);
		Server s = new Server(requests);
		
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
		new Thread(s).start();
	}
}

class Client implements Runnable {

	private BlockingQueue<Request> q;
	
	public Client(BlockingQueue<Request> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				q.put(new Request());
				System.out.println("Added...");
			} 
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Server implements Runnable {

	private BlockingQueue<Request> q;
	
	public Server(BlockingQueue<Request> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				System.out.println("Process: " + q.take());
			} 
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Request {
	
	private final String text;
	private final LocalDateTime createdAt;
	
	public Request(String text) {
		this.text = text;
		createdAt = LocalDateTime.now();
	}
	
	public Request() {
		this(null);
	}
	
	public String show() {
		return createdAt + ": " + text;
	}
	
	@Override
	public String toString() {
		return show();
	}
}
