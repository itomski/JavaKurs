package vehiclemanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractMapper<T extends AbstractEntity> implements Mapper<T> {
	
	public final String TABLE;
	
	public AbstractMapper(String table) {
		this.TABLE = table;
	}
	
	@Override
	public Optional<T> find(int id) throws SQLException {
		
		String sql  = "SELECT * FROM " + TABLE + " WHERE id = ?";
		
		List<T> list = executeSelect(sql, Arrays.asList(id));
		
		if(list.size() > 0) {
			return Optional.of(list.get(0));
		}
		return Optional.empty();
	}
	
	List<T> findBy(String colName, String val) throws SQLException {
		
		String sql  = "SELECT * FROM " + TABLE + " WHERE " + colName + " = ?";
		return executeSelect(sql, Arrays.asList(val));
	}
	
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
	
	/**
	 * Methode für Ausführung beliebiger Queries, außer SELECT
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
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
	public List<T> find(int start, int num) throws SQLException {
		String sql  = "SELECT * FROM " + TABLE + " LIMIT " + start + ", " + num;
		return executeSelect(sql, new ArrayList<>());
	}
	
	public boolean save(T t) throws SQLException {
			
		if(t.getId() > 0) {
			return update(t);
		}
		else {
			return insert(t);
		}
	}
	
	public boolean delete(T t) throws SQLException {
		if(delete(t.getId())) {
			t.setId(0);
			return true;
		}
		return false;
	}
		
	public boolean delete(int id) throws SQLException {
		String sql  = "DELETE FROM " + TABLE + " WHERE id = " + id;
		return execute(sql);
	}
	
	abstract boolean insert(T u) throws SQLException;
	
	abstract boolean update(T u) throws SQLException;

}
