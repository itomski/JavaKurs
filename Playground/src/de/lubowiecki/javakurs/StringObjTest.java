package de.lubowiecki.javakurs;

public class StringObjTest {

	public static void main(String[] args) {
		
		Object o = new String("aaa");
		Object arr[] = new Object[1];
		arr[0] = o;
		o = null;
		arr[0] = null;
		System.out.println(o);
		

	}

}


class Ax {
	
	public Ax(int x) {
	}
	
}

class Bx extends Ax {
	
	public Bx(int a, int b) {
		super(a + b);
	}
	
	public Bx(int x) {
		this(x, x); // this() ersetzt super()
	}
	
}