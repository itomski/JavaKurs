package de.lubowiecki.javakurs;

public class ServiceTest {

	public static void main(String[] args) {
		
		// Instanzmethoden sind dann nötig, wenn der aktuelle Zustand des Objektes
		// auswirkungen auf die Ausführung der Methode hat
		WelcomeService ser1 = new WelcomeService("Guten Tag");
		ser1.welcome("Peter Parker");
		ser1.welcome("Bruce Banner");
		
		WelcomeService ser2 = new WelcomeService("Tach auch,");
		ser2.welcome("Peter Parker");
		
		System.out.println();
		
		// Klassenmethoden sind zu verwenden, wenn der Zustand des Objektes keinen Einfluß auf die
		// Ausführung der Methode hat
		
//		HtmlHelper helper = new HtmlHelper();
//		helper.htmlHeadline("Das ist das Haus von Nikigraus...");
		HtmlHelper.htmlHeadline("Das ist das Haus von Nikigraus...");
		
	}
}
