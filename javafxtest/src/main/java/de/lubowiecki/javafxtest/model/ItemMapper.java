package de.lubowiecki.javafxtest.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper extends AbstractMapper<Item> {

	public ItemMapper() throws SQLException {
		super("items");
		createTable();
	}

	@Override
	public Item create(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean insert(Item u) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean update(Item u) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean createTable() throws SQLException {
		
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE + " ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "name CHAR(50) NOT NULL, "
					+ "count INTEGER(3) NOT NULL, "
					+ "created_at DATETIME NOT NULL"
					+ ")";
		
		
		return execute(sql);
	}

}
