package de.lubowiecki.javakurs.generics;

import java.util.List;

public class UserRepository implements Repository<User> {

	@Override
	public boolean insert(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

// Geht nicht, da LocalDate nicht von AbstractEntity abgeleitet ist
//class LocalDateRepository implements Repository<LocalDate> {
//	//...
//}




