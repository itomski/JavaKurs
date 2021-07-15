package de.lubowiecki.javakurs.designpatterns.command;

public class SaveToDbOperation implements Operation {

	private Data data;
	
	public SaveToDbOperation(Data data) {
		this.data = data;
	}

	@Override
	public String execute() {
		if(!data.isDone()) {
			data.setDone(true);
			return "SAVE: " + data.save();
		}
		return "Bereits erledigt!";
	}
}
