package de.lubowiecki.javakurs.designpatterns.command;

public class JsonData extends Data {

	@Override
	public String save() {
		return "JSON Daten gespeichert";
	}

	@Override
	public String remove() {
		return "JSON Daten entfernt";
	}

	@Override
	public String update() {
		return "JSON Daten geändert";
	}	
}
