package incubator.weldJsfJee.event;

import incubator.weldJsfJee.model.Customer;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Event handler for thrown events.
 * 
 * @author schuetz
 * @date 20.01.2010
 */
public class EventHandler implements Serializable {

	@Inject
	private Logger log;

	/**
	 * Handles event "CustomerCreated".
	 */
	public void afterCustomerCreated(@Observes @CustomerCreated Customer customer) {
		log.info("-- added customer with name " + customer.getName());
	}
}
