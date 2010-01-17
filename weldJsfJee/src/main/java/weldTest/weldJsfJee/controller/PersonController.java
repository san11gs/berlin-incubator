package weldTest.weldJsfJee.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import weldTest.weldJsfJee.controller.tx.Transactional;
import weldTest.weldJsfJee.em.WeldEntityManager;
import weldTest.weldJsfJee.model.Person;
import weldTest.weldJsfJee.stereotype.GuiController;

/**
 * JSF-Person-Controller
 * 
 * @author schuetz
 * @date 18.12.2009
 */
@GuiController
public class PersonController implements Serializable {

	// Verwendung des PersistenceContext's im CDI-Style, @PersistenceContext
	// haette hier auch ausgereicht!
	@Inject
	@WeldEntityManager
	private EntityManager em;

	/**
	 * Logger-Injection
	 */
	@Inject
	private Logger log;

	/**
	 * Injected das aktuell gewaehlte Person-Objekt.
	 */
	@Inject
	private Person person;

	/**
	 * Id der ausgewaehlten Person
	 */
	private Long selectedPersonId;

	/**
	 * @Out-Verhalten: Zugriff auf die Liste erfolgt via #{personen}
	 */
	@Produces
	@Named
	@RequestScoped
	@SuppressWarnings("unchecked")
	public List<Person> getPersonen() {
		return em.createQuery("select o from Person o order by o.name")
				.getResultList();
	}

	/**
	 * Anlegen einer neuen Person. Haendische Verwendung der
	 * Transaktions-Steuerung - Wird spaeter von Seam 3 erledigt.
	 * 
	 * 
	 * @see @TransactionInterceptor
	 */
	@Transactional
	public void createPerson() throws Exception {
		// TODO Bug?: person kann nicht direkt verwendet werden
		Person p = new Person(person);

		// persistiert die aktuelle Person
		em.persist(p);
	}

	/**
	 * Uebergibt die ID der gewaehlten Person
	 */
	public void selectPerson() {
		log.info("person selected with id " + selectedPersonId);

	}

	public Long getSelectedPersonId() {
		return selectedPersonId;
	}

	public void setSelectedPersonId(Long selectedPersonId) {
		this.selectedPersonId = selectedPersonId;
	}

	public EntityManager getEm() {
		return em;
	}

}
