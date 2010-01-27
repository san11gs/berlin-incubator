package incubator.weldJsfJee.controller;

import incubator.weldJsfJee.em.WeldEntityManager;
import incubator.weldJsfJee.event.CustomerCreated;
import incubator.weldJsfJee.model.Customer;
import incubator.weldJsfJee.tx.Transactional;
import incubator.weldJsfJee.util.NavigationConstants;
import incubator.weldJsfJee.util.log.MyLogger;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * JSF-Customer-Controller
 * 
 * TODO Implement conversational behavior: not possible at the moment due to
 * missing knowledge about how to begin and end conversations on the
 * non-annotation approach to avoid having more than one customer controller.
 * 
 * @author schuetz
 * @date 18.12.2009
 */
@GuiController
public class CustomerController implements Serializable {

	/**
	 * Use persistence context in CDI style. PLain @PersistenceContext would be
	 * fine here.
	 */
	@Inject
	@WeldEntityManager
	private EntityManager em;

	/** Injects own (wrapped) logger. */
	@Inject
	private MyLogger myLogger;

	/** Injects Event for firing customerCreatedEvent. */
	@Inject
	@CustomerCreated
	private Event<Customer> customerCreatedEvent;

	/**
	 * Injects currently selected customer. <br>
	 * TODO Required due to issues with extended EL.
	 * */
	@Inject
	private Customer customer;

	/** The currently selected customer for detail view etc. */
	private Customer currentCustomer;

	/** Id of selected customer. */
	private Long selectedCustomerId;

	/**
	 * @Out behavior: access list via #{customers}.
	 */
	@Produces
	@Named
	@RequestScoped
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		return em.createQuery("select o from Customer o order by o.name")
				.getResultList();
	}

	/**
	 * Adds a new customer within the boundaries of a transaction. Transactional
	 * behavior is implemented manually, will later be done by Seam3.
	 * 
	 * @see @TransactionInterceptor
	 */
	@Transactional
	public String createCustomer() throws Exception {
		// TODO extended EL does not work, yet
		// TODO Bug?: customer can't be used directly
		// TODO refresh list
		Customer p = new Customer(customer);

		// persists current customer
		em.persist(p);

		// fire event
		customerCreatedEvent.fire(p);

		return NavigationConstants.CUSTOMERS;
	}

	/**
	 * Id of current customer is transferred via JSF directly.
	 */
	public String selectCustomer() {
		myLogger.info("customer selected with id " + selectedCustomerId);

		currentCustomer = (Customer) em.createQuery(
				"select o from Customer o where o.id =:customerId")
				.setParameter("customerId", selectedCustomerId)
				.getSingleResult();

		// no configuration in faces-config.xml required as the String defaults
		// (and redirects) to customerDetail.xhtml
		return NavigationConstants.CUSTOMER_DETAIL;
	}

	/**
	 * Removes customer with selected id.
	 * 
	 * @see @TransactionInterceptor
	 */
	@Transactional
	public String removeCustomer() {

		Customer c = (Customer) em.createQuery(
				"select o from Customer o where o.id =:customerId")
				.setParameter("customerId", selectedCustomerId)
				.getSingleResult();

		em.remove(c);

		myLogger.info("customer removed with id " + selectedCustomerId);
		return NavigationConstants.CUSTOMERS;
	}

	/**
	 * Updates current customer.
	 * 
	 * @see @TransactionInterceptor
	 */
	@Transactional
	public String updateCustomer() {

		em.persist(currentCustomer);

		myLogger.info("customer updated with id " + currentCustomer.getId());

		return NavigationConstants.CUSTOMER_DETAIL;
	}

	public Long getSelectedCustomerId() {
		return selectedCustomerId;
	}

	public void setSelectedCustomerId(Long selectedCustomerId) {
		this.selectedCustomerId = selectedCustomerId;
	}

	public EntityManager getEm() {
		return em;
	}

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
}
