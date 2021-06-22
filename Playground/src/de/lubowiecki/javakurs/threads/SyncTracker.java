package de.lubowiecki.javakurs.threads;

public class SyncTracker extends Tracker {
	
	@Override
	public void addStep() {
		
		// LOCK sollte etwas einmaliges sein
		synchronized (this) {
			// Die Threads müssen sich beim Aufruf der addStep abstimmen
			super.addStep();
		}
		
	}
}
