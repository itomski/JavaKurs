package de.lubowiecki.javakurs;

public class ArrayDebugTest {

	public static void main(String[] args) {
		
		int outer[][] = {{1,0},{-4},{3,1}};
		
		 f1: for(int[] inner : outer) {
			 for (int pos = 0; pos < inner.length; pos++) { // Inhalt von Inner wird durchlaufen
				 int zahl = inner[pos];
			 } 
		 }
		
		System.out.println();
		
		for(int[] inner : outer) {
			 for (int zahl : inner) { // Inhalt von Inner wird durchlaufen
				 System.out.println(zahl);
			 } 
		 }
		
		
		int arr[][][] = {   //Ebene1
							{	//Ebene 2
								{	//Ebene 3
									1,
									2
								},
								{
									3,
									4
								}
							},
							{
								{
									5,
									6
								},
								{
									7,
									8
								}
							},
							{
								{
									9,
									10
								},
								{
									11,
									12
								}
							}
						};
		
		for(int[][] a : arr) { // Ebene 1
			for(int[] b : a) { // Ebene 2
				for(int c : b) { // Ebene 3
					
				}
			}
		}
		
		if(true);
			System.out.println("ABC");
		
	}

}
