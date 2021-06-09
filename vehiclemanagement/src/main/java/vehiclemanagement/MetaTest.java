package vehiclemanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import vehiclemanagement.model.DBHelper;

public class MetaTest {

	public static void main(String[] args) {
		
		try(Connection dbh = DBHelper.getConnection(); Statement stmt = dbh.createStatement()) {
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM vehicles");
			ResultSetMetaData meta = rs.getMetaData();
			
			int count = meta.getColumnCount();
			
			for(int i = 1; i <= count; i++) {
				System.out.println(meta.getColumnName(i) + " " + meta.getColumnTypeName(i));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
