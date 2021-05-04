package de.lubowiecki.javakurs;

public class ZahlensystemTest {

	public static void main(String[] args) {
		
		int a = 015; // 13 // oktal, Erlaubte Zahlen 0-7
		System.out.println(a);
		
		a = 0b10110; // 22 // binär, Erlaubte Zahlen 0,1
		System.out.println(a);
		
		a = 10 & 5; // binär and
		System.out.println(a);
		//10: 1010
		// 5: 0101 &, AND bedeutet beides muss eine 1 haben, damit erg eine 1 ergibt
		// 0: 0000
		
		a = 10 | 5; // binär or
		System.out.println(a);
		//10: 1010
		// 5: 0101 |, OR es muss mind. eine seite eine 1 haben, damit erg eine 1 ergibt
		// 0: 1111
		
		System.out.println(Integer.toBinaryString(15));
		
		a = 0xabc123; // hex, Erlaubte Zahlen 0-9abcdef
		a = 0x2a; // 42
		
		System.out.println("-----------");
		
		a = 12_506_132;
		System.out.println(Integer.toHexString(a));
		double d = 12_506_132.10;
		long l = 12_506_132l;
		
		double d1 = 100 / 105 / 205;

	}

}
