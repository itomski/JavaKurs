package de.lubowiecki.javakurs;

public class ExceptionTest2 {

	public static void main(String[] args) {
		new ExceptionTest2().init();
	}

	private void init() {
//		try {
//			m1();
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Code nach der Exception von m3");
		
		m4(); // ist unchecked, d.h. handle or declare ist optional
		System.out.println("Code nach der Exception von m4");
	}
	
	private void m1() throws Exception {
		m2();
	}
	
	private void m2() throws Exception {
		m3();
	}
	
	private void m3() throws Exception {
		throw new Exception("Problem in m3"); // ist checked, d.h. handle or declare
	}
	
	private void m4() throws RuntimeException {
		throw new RuntimeException("Problem in m4"); // ist unchecked, d.h. handle or declare ist optional
	}
}
