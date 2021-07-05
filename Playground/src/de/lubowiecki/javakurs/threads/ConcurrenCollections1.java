package de.lubowiecki.javakurs.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrenCollections1 {

	public static void main(String[] args) {
		
		try {
			//List<Integer> zahlen = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
			List<Integer> zahlen = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
			
			for(Integer zahl : zahlen) {
				System.out.println(zahl);
				zahlen.remove(zahl);
			}
		}
		catch(ConcurrentModificationException ex) {
			System.out.println("ConcurrentModificationException");
		}
	}

}
