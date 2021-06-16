package de.lubowiecki.javafxtest.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemMapper extends AbstractMapper<Item> {

	public ItemMapper() throws SQLException {
		super("items");
		createTable();
	}

	@Override
	public Item create(ResultSet rs) throws SQLException {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(rs.getString("created_at"), f);
		return new Item(rs.getInt("id"), rs.getString("name"), rs.getInt("count"), ldt);
	}

	@Override
	boolean insert(Item u) throws SQLException {
		String sql = "INSERT INTO " + TABLE + " (name, count, created_at) VALUES(?, ?, ?)";
		try(Connection dbh = DBHelper.getConnection(); PreparedStatement stmt = dbh.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, u.getName());
			stmt.setInt(2, u.getCount());
			u.setCreatedAt(LocalDateTime.now());
			stmt.setString(3, u.getCreatedAt());
			stmt.execute();
			
			ResultSet keys = stmt.getGeneratedKeys();
			if(keys.next()) {
				u.setId(keys.getInt(1));
				return true;
			}
			return false;
		}
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
