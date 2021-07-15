package de.lubowiecki.javakurs.designpatterns.command;

public abstract class Data {
	
	private boolean done;
	
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public abstract String save();
	public abstract String remove();
	public abstract String update();
}
