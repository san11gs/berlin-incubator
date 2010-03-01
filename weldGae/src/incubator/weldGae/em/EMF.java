package incubator.weldGae.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Factory class for accessing EntityManager. Static hook required for user with
 * GAE. Use EMD this way: <br/>
 * <code>private EntityManager em = EMF.get().createEntityManager();</code/
 * 
 * @author m.schuetz
 * @date 09.02.2010
 */
public final class EMF {
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	private EMF() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
