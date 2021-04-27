package de.lubowiecki.javakurs.designpatterns.coposite;

//LEAF
public class WordDokument implements Dokument {

	private String inhalt;
	
	public WordDokument(String inhalt) {
		this.inhalt = inhalt;
	}

	
	// Das Interface sichert zu, WAS eingebaut werden MUSS
	// aber nicht WIE es eingebaut wird
	@Override
	public void print() {
		System.out.println("WORD: " + inhalt);
	}
}
