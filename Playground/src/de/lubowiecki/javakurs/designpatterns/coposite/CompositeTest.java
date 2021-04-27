package de.lubowiecki.javakurs.designpatterns.coposite;

public class CompositeTest {

	public static void main(String[] args) {
		
		WordDokument doc = new WordDokument("Das ist ein Haus von Nikigraus");
		//doc.print();
		
		DokumentenStapel stapel = new DokumentenStapel();
		stapel.hinzufuegen(doc);
		stapel.hinzufuegen(new OpenOfficeDocument("Von Nichts kommt Nichts."));
		stapel.hinzufuegen(new WordDokument("Bla bla bla bla bla..."));
		
		
		//stapel.print();
		
		DokumentenStapel nextStapel = new DokumentenStapel();
		nextStapel.hinzufuegen(new OpenOfficeDocument("A B C D"));
		nextStapel.hinzufuegen(stapel);
		nextStapel.hinzufuegen(new WordDokument("Nichts wichtiges..."));
		
		nextStapel.print();
		
	}
}
