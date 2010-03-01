package incubator.weldGae.controller;

import incubator.weldGae.em.EMF;
import incubator.weldGae.model.User;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * CDI-Controller for administration and initial test data..
 * 
 * @author m.schuetz
 * @date 01.03.2010
 */
@Named
@RequestScoped
public class AdminController {
	private EntityManager em = EMF.get().createEntityManager();

	/**
	 * @Out behavior: access list via #{users}.
	 */
	@Produces
	@Named
	@RequestScoped
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return em.createQuery("select o from User o order by o.username")
				.getResultList();
	}

	/**
	 * TODO (m.schuetz) As there is no initial sql import at the moment for GAE
	 * app, test data will be inserted if required for admin user.
	 */
	public void createAdminUser() {
		User user = new User("admin", "Administrator", "admin");

		try {
			em.persist(user);
		} finally {
			em.close();
		}
	}

}