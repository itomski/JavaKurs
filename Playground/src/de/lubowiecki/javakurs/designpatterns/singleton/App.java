package de.lubowiecki.javakurs.designpatterns.singleton;

public class App {
	
	public static void main(String[] args) {
		new App().start();
		new NextApp().machWas();
		
		LoggerSingleton.getInstance().show();
		
		
	}

	private void start() {
		LoggerSingleton.getInstance().log("start");
		a();
	}
	
	private void a() {
		LoggerSingleton.getInstance().log("a");
		b();
	}
	
	private void b() {
		LoggerSingleton.getInstance().log("b");
	}

}
