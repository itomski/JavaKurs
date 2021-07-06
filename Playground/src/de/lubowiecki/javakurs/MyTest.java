package de.lubowiecki.javakurs;

import java.util.Arrays;

public class MyTest {

	public static void main(String [] args){
		int [][] ints = new int[2][]; // [null, null]
		
		// System.out.println(ints[1].toString()); // NullPointerException
		// Arrays.sort(ints[1]); // NullPointerException
		
		System.out.println(Arrays.toString(ints[1]));
	}
}
