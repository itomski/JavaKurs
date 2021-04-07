package de.lubowiecki.javakurs;

public class WelcomeService {
	
	private String welcomeText;

	public WelcomeService(String welcomeText) {
		// super();
		this.welcomeText = welcomeText;
	}
	
	public void welcome(String name) {
		System.out.println(welcomeText + " " + name);
	}
}
