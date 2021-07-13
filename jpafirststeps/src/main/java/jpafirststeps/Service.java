package jpafirststeps;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Service {
	
	private EntityManager em;
	
	public Service() {
		em = Persistence.createEntityManagerFactory("jpaFirstStepsPU").createEntityManager();
	}
	
	public void addUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public Optional<User> getUserById(int id) {
		User u = em.find(User.class, id);
		if(u != null) {
			return Optional.of(u);
		}
		return Optional.empty();
	}
	
	public List<User> getAllUsers() {
		// JPQL-Query
		Query q = em.createQuery("SELECT u FROM User u"); // u ist ein Kürzel für User
		return q.getResultList();
	}
	
	public Stream<User> getAllUsersAsStream() {
		Query q = em.createQuery("SELECT u FROM User u");
		return q.getResultStream();
	}
	
	public void updateUser(User u) {
		em.getTransaction().begin();
		em.getTransaction().commit();
	}	
}
