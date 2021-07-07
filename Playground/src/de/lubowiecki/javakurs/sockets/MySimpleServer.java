package de.lubowiecki.javakurs.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MySimpleServer extends Thread {
	
	private Socket client;
	
	private Set<String> erlaubt = new HashSet<>(Arrays.asList("peter", "anna", "hans"));
	
	public MySimpleServer(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		
		try(BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream())) {
			
			out.println("SERVER: Moin Moin"); // Schreiben in den Stream den Clients
			out.flush();
			
			String line = null;
			String name = null;
			
			while((line = in.readLine()) != null) { // Lesen aus dem Stream des Clients
				
				name = line.split(":")[0].toLowerCase();
				if(!erlaubt.contains(name)) {
					out.println("EXIT");
					break;
				}
				System.out.println("CLIENT: " + line);
				out.println("SERVER: OK..."); // Schreiben in den Stream den Clients
				out.flush();
			}
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		try(ServerSocket server = new ServerSocket(5000)) {
			
			System.out.println("Serverstart...");
			while(true) {
				new MySimpleServer(server.accept()).start(); // Liefert ein client Socket
			}
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Serverende...");
	}
}
