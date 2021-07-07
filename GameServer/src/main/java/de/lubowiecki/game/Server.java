package de.lubowiecki.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
					Connection c = new Connection(serverSocket.accept());
					clients.add(c);
					c.start();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		accept.setDaemon(true);
		accept.start();
		
		Thread processMessage = new Thread(() -> {
			while(true) {
				try {
					if(messages.isEmpty())
						continue;
					
					Message msg = messages.take();
					System.out.println(msg);
					send(msg);
				}
				catch(Exception e) {
					e.printStackTrace();
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
		}
		
		public void start() {
			Thread read = new Thread(() -> {
				while(true) {
					try {
						Message msg = (Message) in.readObject(); 
						messages.put(msg);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			});
			read.setDaemon(true);
			read.start();
		}
		
		public void write(Message msg) {
			try {
				out.writeObject(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void send(Message msg, int to) { // send to one
		clients.get(to).write(msg);
	}
	
	public void send(Message msg) { // send to all
		clients.forEach(c -> c.write(msg));
	}
}
