package incubator.weldGae.em;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Factory class for accessing EntityManager.
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
