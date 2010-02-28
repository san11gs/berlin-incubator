package incubator.weldGae.action;

import incubator.weldGae.controller.GuiController;
import incubator.weldGae.identity.Credentials;
import incubator.weldGae.identity.LoggedIn;
import incubator.weldGae.model.User;
import incubator.weldGae.util.FacesMessageHandler;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * JSF-Controller for managing login state.
 * 
 * @author schuetz
 * @date 17.01.2010
 */
@GuiController
public class LoginController implements Serializable {

	// @Inject
	// @WeldEntityManager
	// private EntityManager em;

	@Inject
	private Credentials credentials;

	@Inject
	private FacesMessageHandler facesMessage;

	private User user;

	@SuppressWarnings("unchecked")
	public void login() {
		System.out.println("--- login user" + credentials.getUsername());

		// TODO
		facesMessage.add("TODO login user, ");

		// List<User> results = em
		// .createQuery(
		// "select u from User u where u.username=:username and u.password=:password")
		// .setParameter("username", credentials.getUsername())
		// .setParameter("password", credentials.getPassword())
		// .getResultList();
		//
		// Arrays.asList(new User(credentials.getUsername(), "Your Name",
		// credentials.getPassword()));
		//
		// if (!results.isEmpty()) {
		// user = results.get(0);
		// facesMessage.add("Welcome, " + user.getName());
		// } else {
		// facesMessage.add("Falsche Eingabe");
		// }

	}

	public void logout() {

		// TODO
		System.out.println("-- logout");

		// facesMessage.add("Goodbye, " + user.getName());
		// user = null;
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