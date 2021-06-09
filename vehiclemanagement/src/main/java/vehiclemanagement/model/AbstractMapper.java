package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Abstrakte Klassen müssen die Methoden eines Interface nicht einbauen, können aber
public abstract class AbstractMapper<T extends AbstractEntity> implements Mapper<T> {
	
	public final String TABLE;
	
	public AbstractMapper(String table) {
		this.TABLE = table;
	}
	
	@Override
	public T find(int id) throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			String sql  = "SELECT * FROM " + TABLE + " WHERE id = " + id;
			ResultSet results = stmt.executeQuery(sql);
			
			if(results.next()) {
				return create(results); 
			}
			
			return null;
		}
	}
	
	/**
	 * @param start Wo soll begonnen werden. Anfang der Tabelle beginnt bei 0
	 * @param num Anzahl der gewünschten Datensätze
	 */
	public List<T> find(int start, int num) throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			String sql  = "SELECT * FROM " + TABLE + " LIMIT " + start + ", " + num;
			ResultSet results = stmt.executeQuery(sql);
			
			List<T> objs = new ArrayList<>();
			
			while(results.next()) { // next springt zu der nächsten Zeile in der Ergebnis-Menge (ResultSet)
				objs.add(create(results)); 
			}
			
			return objs;
		}
	}
	
	public boolean save(T t) throws SQLException {
			
		if(t.getId() > 0) {
			// User ist bereits in der DB gespeichert
			return update(t);
		}
		else {
			// User ist noch nicht in der DB gespeichert
			return insert(t);
		}
	}
	
	// Löscht einen Datensatz, verlangt ein User-Objekt als Attribut
	public boolean delete(T t) throws SQLException {
		if(delete(t.getId())) {
			t.setId(0);
			return true;
		}
		return false;
	}
		
	// Löscht einen Datensatz, verlangt nur die User-ID als Attribut
	public boolean delete(int id) throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			String sql  = "DELETE FROM " + TABLE + " WHERE id = " + id;
			return stmt.executeUpdate(sql) > 0; // executeUpdate aktuallisiert Tabellen und Daten, liefert die Anzahl betrofferen Datensätze
		}
	}
	
	// Interface kann nur public abstrakte Methoden enthalten
	// Eine abstrakte Klasse kann aber auch protected und package-private abstrakte Methoden enthalten
	abstract boolean insert(T u) throws SQLException;
	
	abstract boolean update(T u) throws SQLException;

}
