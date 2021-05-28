package de.lubowiecki.javakurs.generics;

import java.util.List;

// extends AbstractEntity ist ein Bound
// die zu verwendenen generische Typen müssen von AbstractEntity abgeleitet sein
// Der RawType ist durch den Bound eine AbstractEntity
// Mehoden können die Methoden des RawTyps nutzen
public interface Repository<T extends AbstractEntity> {
	
	boolean insert(T u);
	
	boolean update(T u);
	
	boolean delete(T u);
	
	default boolean save(T t) {
		if(t.getId() > 0) { // Ohne Bound wäre die getId-Methode nicht sichtbar
			return update(t);
		}
		else {
			return insert(t);
		}
	}
	
	T findOne(int id);
	
	List<T> findAll();
	
	default List<T> sort(List<T> list) {
		// TODO muss sortiert werden
		return null;
	}
}
