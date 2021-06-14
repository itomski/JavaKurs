package vehiclemanagement.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Mapper<T extends AbstractEntity> {
	
	public List<T> find(int start, int num) throws SQLException;
	
	public Optional<T> find(int id) throws SQLException;
	
	public boolean save(T u) throws SQLException;
	
	public boolean delete(T u) throws SQLException;
	
	public T create(ResultSet rs) throws SQLException;
}
