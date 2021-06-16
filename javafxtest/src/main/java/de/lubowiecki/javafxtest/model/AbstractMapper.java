package de.lubowiecki.javafxtest.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Abstrakte Klassen müssen die Methoden eines Interface nicht einbauen, können aber
public abstract class AbstractMapper<T extends AbstractEntity> implements Mapper<T> {
	
	public final String TABLE;
	
	public AbstractMapper(String table) {
		this.TABLE = table;
	}
	
	@Override
	// Liefert einen Datensatz als Objekt
	public Optional<T> find(int id) throws SQLException {
		
		String sql  = "SELECT * FROM " + TABLE + " WHERE id = ?";
		
		List<T> list = executeSelect(sql, Arrays.asList(id));
		
		if(list.size() > 0) {
			return Optional.of(list.get(0));
		}
		return Optional.empty();
		
//		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
//			
//			String sql  = "SELECT * FROM " + TABLE + " WHERE id = " + id;
//			ResultSet results = stmt.executeQuery(sql);
//			
//			if(results.next()) {
//				return create(results); 
//			}
//			
//			return null;
//		}
	}
	
	// Liefert alle Datensätze als Objekte die ein bestimmtes Merkmal aufweisen
	List<T> findBy(String colName, String val) throws SQLException {
		
		String sql  = "SELECT * FROM " + TABLE + " WHERE " + colName + " = ?";
		return executeSelect(sql, Arrays.asList(val));
		
//		try(Connection dbh = DBHelper.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql)) {
//			
//			stmt.setString(1, val);
//			ResultSet results = stmt.executeQuery(sql);
//			
//			List<T> objs = new ArrayList<>();
//			
//			while(results.next()) {
//				objs.add(create(results)); 
//			}
//			
//			return objs;
//		}
	}
	
	// Eine wiederverwendbare Select-Methode, die SQL und Parameter entegennimmt.
	// Sollte nur von anderen Mappern oder direkt hier verwendet werden
	List<T> executeSelect(String sql, List<Object> values) throws SQLException {
		
		try(Connection dbh = DBHelper.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql)) {
			
			for(int i = 1; i <= values.size(); i++) {
				stmt.setObject(i, values.get(i));
			}
			
			ResultSet results = stmt.executeQuery(sql);
			
			List<T> objs = new ArrayList<>();
			
			while(results.next()) {
				objs.add(create(results)); 
			}
			
			return objs;
		}
	}
	
	boolean execute(String sql) throws SQLException {
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			stmt.execute(sql);
			return stmt.getUpdateCount() > 0;
		}
	}
	
	/**
	 * @param start Wo soll begonnen werden. Anfang der Tabelle beginnt bei 0
	 * @param num Anzahl der gewünschten Datensätze
	 */
	// num Anzahl von Datensätze als Objekte zückgeben, angefangen bei start 
	public List<T> find(int start, int num) throws SQLException {
		
		
		String sql  = "SELECT * FROM " + TABLE + " LIMIT " + start + ", " + num;
		return executeSelect(sql, new ArrayList<>());
		
		// executeSelect übernimmt jetzt genau diese Aufgabe
//		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
//			
//			String sql  = "SELECT * FROM " + TABLE + " LIMIT " + start + ", " + num;
//			ResultSet results = stmt.executeQuery(sql);
//			
//			List<T> objs = new ArrayList<>();
//			
//			while(results.next()) { // next springt zu der nächsten Zeile in der Ergebnis-Menge (ResultSet)
//				objs.add(create(results)); 
//			}
//			
//			return objs;
//		}
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
