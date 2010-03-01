package incubator.weldGae.action;

import incubator.weldGae.controller.GuiController;
import incubator.weldGae.em.EMF;
import incubator.weldGae.identity.Credentials;
import incubator.weldGae.identity.LoggedIn;
import incubator.weldGae.model.User;
import incubator.weldGae.util.FacesMessageHandler;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * JSF-Controller for managing login state.
 * 
 * @author schuetz
 * @date 17.01.2010
 */
@GuiController
public class LoginController implements Serializable {

	@Inject
	private FacesMessageHandler facesMessage;

	@Inject
	private Credentials credentials;

	private User user;

	@SuppressWarnings("unchecked")
	public void login() {

		EntityManager em = EMF.get().createEntityManager();
		
		List<User> results = em
				.createQuery(
						"select u from User u where u.username=:username and u.password=:password")
				.setParameter("username", credentials.getUsername())
				.setParameter("password", credentials.getPassword())
				.getResultList();

		if (!results.isEmpty()) {
			user = results.get(0);
			facesMessage.add("Welcome, " + user.getName());
		} else {
			facesMessage.add("Falsche Eingabe");
		}
	}

	public void logout() {
		facesMessage.add("Goodbye, " + user.getName());
		user = null;
	}

	public boolean isLoggedIn() {
		return user != null;
	}

	@Named
	@Produces
	@LoggedIn
	public User getCurrentUser() {
		return user;
	}
}