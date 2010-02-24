package incubator.spring_faces.service;

import incubator.spring_faces.manager.CustomerManager;
import incubator.spring_flex.dto.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;


/**
 * Service for loading and saving customers (business delegate pattern!!).
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Service("customerService")
@RemotingDestination(channels = { "my-amf" })
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerManager customerManager;
	
    public boolean existsCustomer(String phoneNumber) {
        return this.customerManager.existsCustomer(phoneNumber);
    }

    /**
     * Transactional read-only method.
     * 
     * @see incubator.spring_faces.service.CustomerService#findCustomerByPhoneNumber(String)
     */
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
    	return this.customerManager.findCustomerByPhoneNumber(phoneNumber);
    }

    /**
     * Transactional method.
     * 
     * @see incubator.spring_faces.service.CustomerService#createCustomer(Customer)
     */
    @Secured( {"ROLE_USER", "ROLE_SUPERVISOR"} )
    public Customer createCustomer(Customer customer) {    	
        return this.customerManager.createCustomer(customer);
    }

    /*
     * Getter & Setter
     */
    
    public CustomerManager getCustomerManager() {
    	return this.customerManager;
    }
    
    public void setCustomerManager(CustomerManager customerManager) {
    	this.customerManager = customerManager;
    }
    
}
