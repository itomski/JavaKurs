package vehiclemanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vehiclemanagement.model.DBHelper;

public class ResultSetTest {

	public static void main(String[] args) {
		
		// Nicht jeder DB-Treiber unterstützt die spezielle Konfiguration für das ResultSet
		// wie z.B. ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATEABLE etc.
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
			
			// Ergebnis-Menge: Jede SELECT-Anweisung liefert ein ResultSet
			// Inhalt des ResultSets hängt von den Parametern der Select-Anweisung
			// Es gibt noch das RowSet, was ein ResultSet um weitere Fähigkeiten erweitert
			ResultSet rs = stmt.executeQuery("SELECT lastname, firstname FROM user");
			
			// Datensätze sind im ResultSet als Zeilen hinterlegt.
			// Bevor ich eine Zeile lesen kann, muss der Cursor darauf gesetzt werden
			// Der Cursor zeigt am Anfang auf eine Position vor der ersten Zeile 
//			while(rs.next()) { // next versetzt den Curor auf die nächste Zeile
//				System.out.println(rs.getString(2));
//			}
			
			//rs.next();
			
			// Diese Methoden verlangen ResultSet.TYPE_SCROLL_INSENSITIVE oder ResultSet.TYPE_SCROLL_SENSITIVE
			//rs.absolute(3); // bewegt den Cursor auf eine bestimmte Zeile im ResultSet
			rs.relative(2); // bewegt den Cursor um zwei Zeilen weiter von der aktuellen Zeile (Minus-Werte bewegen rückwärts)
			//rs.previous(); // bewegt den Cursor um eine Zeile zurück
//			rs.beforeFirst(); // Cursor springt vor die erste Zeile
//			rs.afterLast(); // Cursor springt ans Ende, hinter die letzte Zeile
			
			
			// LOW-LEVEL - Wird heute kaum benutzt
			// Geht nur, wenn das ResultSet CONCUR_UPDATEABLE ist
			rs.updateString("firstname", "Peter"); // Spalten-Wert an aktueller Position wird geändert
			rs.refreshRow(); // Die geänderte Zeile wird an die DB geschickt
			
			System.out.println(rs.getString(2));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
