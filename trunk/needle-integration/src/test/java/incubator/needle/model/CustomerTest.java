package incubator.needle.model;

import static org.junit.Assert.assertNotNull;

import javax.persistence.PersistenceException;

import org.junit.Test;

import de.akquinet.jbosscc.needle.db.AbstractDbTestcase;

/**
 * Needle unit test for {@link Customer} entity.
 * 
 * @author m.schuetz
 * @date 26.03.2010
 */
public class CustomerTest extends AbstractDbTestcase {

	@Test
	public void testSaveCustomer() throws Exception {
		Customer customer = new Customer("defaultNumber");

		assertNotNull(util.saveObject(customer));
	}

	// TODO (m.schuetz) EntityExistsException.class should be the expected one!
	@Test(expected = PersistenceException.class)
	public void testCustomerNumberIsUnique() throws Exception {
		String customerNumber = "number99";
		Customer customer1 = new Customer(customerNumber);
		Customer customer2 = new Customer(customerNumber);

		util.saveObject(customer1);
		util.saveObject(customer2);
	}
}
