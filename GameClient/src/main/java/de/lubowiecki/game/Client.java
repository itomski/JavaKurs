package de.lubowiecki.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client {
	
	private Connection server;
	private BlockingQueue<Message> messages;
	private Socket socket;
	
	public Client(String host, int port) throws IOException {
		
		socket = new Socket(host, port);
		messages = new LinkedBlockingQueue<>();
		server = new Connection(socket);
		server.listen();
		
		Thread processMessage = new Thread(() -> {
			while(true) {
				try {
					if(messages.isEmpty())
						continue;
					
					Message msg = messages.take();
					System.out.println(msg);
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
		private Socket socket; // Verbindung zum Server
		
		public Connection(Socket socket) throws IOException {
			this.socket = socket;
			in = new ObjectInputStream(socket.getInputStream()); 
			out = new ObjectOutputStream(socket.getOutputStream());
		}
		
		private void listen() {
			Thread read = new Thread(() -> {
				while(true) {
					try {
						Message msg = (Message)in.readObject();
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
				// TODO: Exception anders weitergeben
				e.printStackTrace();
			}
		}
	}
	
	public void send(Message msg) { // send to all
		server.write(msg);
	}
}
