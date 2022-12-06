package remedium.dao;

import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import remedium.entities.User;

import java.util.List;

@Stateless 
public class UserDAO {
	private final static String UNIT_NAME = "remedium";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(User user) {
		em.persist(user);
	}
	
	public User update(User user) {
		return em.merge(user);
	}
	
	public void delete(User user) {
		em.remove(em.merge(user));
	}
	
	public User get(Object id) {
		return em.find(User.class, id);
	}
	
	public List<User> getAllUsers() {
		List<User> list = null;
		
		Query query = em.createQuery("select u from User u");
		
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
