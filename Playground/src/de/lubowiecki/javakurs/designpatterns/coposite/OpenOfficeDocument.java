package de.lubowiecki.javakurs.designpatterns.coposite;

// LEAF
public class OpenOfficeDocument implements Dokument {
	
	private StringBuilder content;
	
	public OpenOfficeDocument(String content) {
		this.content = new StringBuilder(content);
	}

	@Override
	public void print() {
		System.out.println("OpenOffice: " + content);
	}
}
