package de.lubowiecki.javakurs.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MySimpleClient {
	
	private String name;
	
	public static void main(String[] args) {
		
		if(args.length > 0) {
			new MySimpleClient().init(args[0]);
		}
		else {
			System.out.println("Gib einen Namen vor.");
		}
		
	}
	
	private void init(String name) {
		
		this.name = name;
		
		try(Socket server = new Socket("localhost", 5000);
				BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
				PrintWriter out = new PrintWriter(server.getOutputStream());
				Scanner scanner = new Scanner(System.in)) {
			
			System.out.println(in.readLine()); // Empfängt eine Zeile vom Server
			
			while(true) {
				System.out.print("#: ");
				String input = scanner.nextLine();
				out.println(name + ":" + input); // String wird an den Server geschickt
				out.flush();
				
				String fromServer = in.readLine();
				if(fromServer.equals("EXIT")) {
					System.out.println("Du darfst das nicht!");
					break;
				}	
				
				System.out.println(in.readLine()); // Fragt Daten vom Server ab
			}
			System.out.println("Client ende");
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
