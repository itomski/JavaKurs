package jpafirststeps;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
}
