package weldTest.weldJsfJee.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import weldTest.weldJsfJee.em.WeldEntityManager;
import weldTest.weldJsfJee.model.Person;

/**
 * JSF-Person-Controller
 * 
 * @author schuetz
 * @date 18.12.2009
 */
@Named
@SessionScoped
public class PersonController implements Serializable {

	// Verwendung des PersistenceContext's im CDI-Style, @PersistenceContext
	// haette hier auch ausgereicht!
	@Inject
	@WeldEntityManager
	private EntityManager em;

	// manuelle JTA-Transaktionsverwaltung
	@Inject
	private UserTransaction tx;

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
		List<Person> sdf;
		return em.createQuery("select o from Person o order by o.name")
				.getResultList();
	}

	/**
	 * Anlegen einer neuen Person. Haendische Verwendung der
	 * Transaktions-Steuerung - Wird spaeter von Seam 3 erledigt.
	 * 
	 * TODO dummy - alles Exceptions werden durchgereicht <br>
	 * TODO sofortiges Refresh der Liste bei Veraenderungen<br>
	 * TODO TX-Handling in Interceptor
	 */
	@Transactional
	public void createPerson() throws Exception {
		// TODO Bug?: person kann nicht direkt verwendet werden
		Person p = new Person(person);

		// startet JTA UserTransaction
//		tx.begin();

		// verwendet die aktuelle TX
		em.joinTransaction();

		// persistiert die aktuelle Person
		em.persist(p);

		// Committed die aktuelle TX
//		tx.commit();
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

}
