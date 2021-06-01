package de.lubowiecki.javakurs.io;

import java.io.Console;

public class ConsoleTest {

	public static void main(String[] args) {
		
		Console cmd = System.console();
		
		String s = cmd.readLine();
		System.out.println(s);
		
		System.out.println();
		
		s = cmd.readLine("Input: ");
		System.out.println(s);

	}

}
