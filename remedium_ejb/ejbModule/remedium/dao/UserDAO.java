package remedium.dao;

@Stateless 
public class UserDAO {
	private final static String UNIT_NAME = "jsfcourse-remediumPU";

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

}
