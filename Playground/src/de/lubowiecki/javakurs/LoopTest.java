package de.lubowiecki.javakurs;

public class LoopTest {
	
	public static void main(String[] args) {
		
		
		xyz: for(int i = 0; i < 10; i++) {
			
			System.out.println("outer: " + i);
			
			for(int j = 0; j < 10; j++) {
				System.out.println("\tinner before: " + j);
				
				//if(j == 5) break; // break bezieht sich auf das innere for
				//if(j == 5) break xyz; // break bezieht sich auf das mit xyz markierte for
				
				//if(j == 5) continue; // bei 5 wird der durchlauf abgebrochen und der nächste durchlauf ausgeführt
				if(j == 5) continue xyz; // bei 5 wird der durchlauf abgebrochen, und mit dem nächsten der outer fortgesetzt
				
				System.out.println("\tinner after: " + j);
				
				int[][] arr1 = new int[3][2]; // [{0,0},{0,0},{0,0}]
				int[][] arr2 = new int[3][]; // [null,null,null]
				arr2[0] = new int[3];
				arr2[1] = new int[]{};
				arr2[2] = new int[2];
				// [{0,0,0},{},{0,0}]
				
				int[][] arr3 = {{0,0},{0,0,0},{5}, {}, {1,2}};
				
				int[][][] arr4 = new int[3][][]; // Bei der Array-Erzeugung MUSS nur die größe der 1dim sofort vorgegeben werden
			}
		}   
	}
}
