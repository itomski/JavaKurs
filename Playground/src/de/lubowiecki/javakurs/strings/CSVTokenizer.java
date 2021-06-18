package de.lubowiecki.javakurs.strings;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.StringTokenizer;

public class CSVTokenizer {

	public static void main(String[] args) {
		
		StringTokenizer tokens = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
			
			String line = null;
			while((line = br.readLine()) != null) { // Zeilenweise durch Inhalte bewegen
				tokens = new StringTokenizer(line, ";"); // Zeile wird in Einzeldaten zerlegt
				System.out.printf("%-5s | %3$-10s | %2$-10s %n", tokens.nextToken(), tokens.nextToken(), tokens.nextToken());
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
