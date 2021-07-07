package de.lubowiecki.game;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server {
	
	private List<Connection> clients;
	private BlockingQueue<Message> messages;
	private ServerSocket serverSocket; 
	
	public Server(int port) throws IOException {
		clients = new ArrayList<>();
		messages = new LinkedBlockingQueue<>();
		serverSocket = new ServerSocket(port);
		
		Thread accept = new Thread(() -> {
			while(true) {
				try {
					clients.add(new Connection(serverSocket.accept()));
				}
				catch(Exception e) {
					System.err.println(e.getMessage());
				}
			}
		});
		accept.setDaemon(true);
		accept.start();
		
		Thread processMessage = new Thread(() -> {
			while(true) {
				try {
					System.out.println(messages.take());
				}
				catch(Exception e) {
					System.err.println(e.getMessage());
				}
			}
		});
		processMessage.setDaemon(true);
		processMessage.start();
	}
	
	private class Connection {
		
		private ObjectInputStream in;
		private ObjectOutputStream out;
		private Socket client; // Verbindung zum Client
		
		public Connection(Socket client) throws IOException {
			this.client = client;
			in = new ObjectInputStream(client.getInputStream()); 
			out = new ObjectOutputStream(client.getOutputStream());
			
			Thread read = new Thread(() -> {
				while(true) {
					try {
						messages.put((Message)in.readObject());
					}
					catch(Exception e) {
						System.err.println(e.getMessage());
					}
				}
			});
			read.setDaemon(true);
			read.start();
		}
		
		public void write(Message msg) throws IOException {
			out.writeObject(msg);
		}
	}
	
	public void send(Message msg, int to) { // send to one
		
	}
	
	public void send(Message msg) { // send to all
		
	}
	
}
