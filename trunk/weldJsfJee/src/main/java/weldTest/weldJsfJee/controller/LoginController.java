package weldTest.weldJsfJee.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import weldTest.weldJsfJee.em.WeldEntityManager;
import weldTest.weldJsfJee.identity.Credentials;
import weldTest.weldJsfJee.identity.LoggedIn;
import weldTest.weldJsfJee.model.User;
import weldTest.weldJsfJee.stereotype.GuiController;
import weldTest.weldJsfJee.util.FacesMessageHandler;

@GuiController
public class LoginController implements Serializable {

	@Inject
	@WeldEntityManager
	private EntityManager em;

	@Inject
	private Credentials credentials;

	@Inject
	private FacesMessageHandler facesMessage;

	private User user;

	@SuppressWarnings("unchecked")
	public void login() {

		List<User> results = em
				.createQuery(
						"select u from User u where u.username=:username and u.password=:password")
				.setParameter("username", credentials.getUsername())
				.setParameter("password", credentials.getPassword())
				.getResultList();

		Arrays.asList(new User(credentials.getUsername(), "Your Name",
				credentials.getPassword()));

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

	@Produces
	@LoggedIn
	public User getCurrentUser() {
		return user;
	}

}