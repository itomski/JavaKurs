package de.lubowiecki.javakurs.threads;

public class Tracker {
	
	private int stepCount = 0;
	
	public void addStep() {
		stepCount += 1;
	}
	
	public int getSteps() {
		return stepCount;
	}

}
