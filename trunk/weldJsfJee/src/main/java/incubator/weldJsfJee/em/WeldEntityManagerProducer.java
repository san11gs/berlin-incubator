package incubator.weldJsfJee.em;

import javax.ejb.Stateless;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Producer for Weld-EntityManager.
 * 
 * @author schuetz
 * @date 11.01.2010
 */
@Stateless
public class WeldEntityManagerProducer {
	// NOTE: cannot use producer field because Weld attempts to close
	// EntityManager
	@PersistenceContext
	private EntityManager em;

	@Produces
	@WeldEntityManager
	public EntityManager retrieveEntityManager() {
		return em;
	}

	public void disposeEntityManager(
			@Disposes @WeldEntityManager EntityManager em) {
		em.close();
	}
}
