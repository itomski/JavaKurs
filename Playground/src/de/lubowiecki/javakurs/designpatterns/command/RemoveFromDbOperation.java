package de.lubowiecki.javakurs.designpatterns.command;

public class RemoveFromDbOperation implements Operation {

private Data data;
	
	public RemoveFromDbOperation(Data data) {
		this.data = data;
	}
	
	@Override
	public String execute() {
		if(!data.isDone()) {
			data.setDone(true);
			return "DELETE: " + data.remove();
		}
		return "Bereits erledigt!";
	}
}
