package vehiclemanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import vehiclemanagement.model.DBHelper;

public class TransactionTest {

	public static void main(String[] args) {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			// Hier ggfl. Savepoints-Referenzen anlegen
			
			try { // Will man Savepoints und Rollback benutzen, dann sollten die execute-Methoden einen eigenen try-catch-block bekommen
				dbh.setAutoCommit(false); // AutoCommit: Jede Anweisung wird sofort an die Datenbank geschickt
				stmt.executeUpdate("DELETE FROM user WHERE id = 5");
				stmt.executeUpdate("DELETE FROM user_to_vehicles_ WHERE user = 5");
				// Überträgt alle Anweisungen an die DB als einen Befehl. Scheitert ein Teil des Befehls, 
				// dann wird der Rest auch nicht ausgeführt
				// Beim Fehler schmeißt die execute-Methode eine Exception
				dbh.commit();
			}
			catch(SQLException innerE) {
				// z.B. rollback + commit
			}
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("----------- NEXT ----------");
		
		// OLD SCHOOL
		Connection dbh = null;
		Savepoint save1 = null; 
		
		try { 
			dbh = DBHelper.getConnection(); 
			Statement stmt = dbh.createStatement();
			
			dbh.setAutoCommit(false); // AutoCommit: Jede Anweisung wird sofort an die Datenbank geschickt
			stmt.executeUpdate("DELETE FROM user WHERE id = 5");
			save1 = dbh.setSavepoint();
			stmt.executeUpdate("DELETE FROM user_to_vehicles_ WHERE user = 5");
			// Überträgt alle Anweisungen an die DB als einen Befehl. Scheitert ein Teil des Befehls, 
			// dann wird der Rest auch nicht ausgeführt
			// Beim Fehler schmeißt die execute-Methode eine Exception
			dbh.commit();
			
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			
			try {
				//dbh.rollback(); // Entfernt alle Anweisungen aus der Befehlt-Queue
				dbh.rollback(save1); // Entfernt alle Anweisungen bis zu dem Savepoint
				dbh.commit(); // Danach muss noch mal mit commit der gewüschte Teil der Anweisungen ausgeführt werden
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally {
			if(dbh != null) {
				try {
					dbh.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}

}
