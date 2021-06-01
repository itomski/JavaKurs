package de.lubowiecki.javakurs.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DateStreamTest {

	public static void main(String[] args) {
		
		int count = 0;
		
		// wird für das lesen von primitive verwendet
		
		try(DataInputStream in = new DataInputStream(new FileInputStream("data/count.txt"))) {
			count = in.readInt();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(count);
		count++;
		
		// wird für das schreieben von primitive verwendet
		
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream("data/count.txt"))) {
			out.writeInt(count); // schreibt die Zahl in die Datei
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
