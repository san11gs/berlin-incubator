package incubator.spring_faces.manager;

import incubator.spring_flex.dto.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


/**
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Component("customerManager")
public class CustomerManager {

	private Map<Long, Customer> customerMap = new HashMap<Long, Customer>();
	
	private int currentId = 1;
	
	public CustomerManager() {
		Customer customer = new Customer();
		customer.setId(Long.valueOf(currentId++));
		customer.setCity("Rom");
		customer.setFirstname("Mario");
		customer.setLastname("Zerrani");
		customer.setPhone("1111");
		customer.setPostal("12345");
		customer.setStreet("Romstr.");
		
		this.customerMap.put(customer.getId(), customer);		
	}
	
	public boolean existsCustomer(String phoneNumber) {
        return findCustomerByPhoneNumber(phoneNumber) != null;
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
    	List<Customer> customers = new ArrayList<Customer>(this.customerMap.values());
		for(Customer customer : customers){
			if(customer.getPhone().equals(phoneNumber)){
				return customer;
			}
		}
    	return null;
    }

    public Customer createCustomer(Customer customer) {
    	customer.setId(Long.valueOf(this.currentId++));
    	this.customerMap.put(customer.getId(), customer);
        return customer;
    }
}
