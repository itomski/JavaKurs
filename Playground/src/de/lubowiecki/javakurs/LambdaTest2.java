package de.lubowiecki.javakurs;

public class LambdaTest2 {
	
	public static void main(String[] args) {
		
		Operation add = (a, b) -> a + b;
		System.out.println(add.exe(10, 15));
		
		// Operation ist ein Funktionals Interface
		Operation multi = (a, b) -> a * b;
		System.out.println(multi.exe(10, 15));
		
		show(add, 1,2,3);
		show(multi, 1,2,3);
		
	}
	
	public static void show(Operation op, int... val) {
		
		// VarArg wird in der Methode als Array behandelt
		
		int erg = 0;
		for(int i : val) {
			// exe ist die Implementierung der exe-Methode, die als Lambda bei Methodenaufruf übergeben wurde (add oder multi)
			erg = op.exe(erg, i); // z.B. exe = (a, b) -> a * b;
		}
		System.out.println(erg);
	}
}


interface Operation {
	
	int exe(int a, int b);
	
}
