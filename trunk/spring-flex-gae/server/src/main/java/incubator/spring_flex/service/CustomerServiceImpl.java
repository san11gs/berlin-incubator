package incubator.spring_flex.service;

import incubator.spring_flex.domain.Customer;
import incubator.spring_flex.repository.CustomerRepository;

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
	private CustomerRepository customerRepository;
	
    public boolean existsCustomer(String phoneNumber) {
        return this.customerRepository.existsCustomer(phoneNumber);
    }

    /**
     * Transactional read-only method.
     * 
     * @see incubator.spring_flex.service.CustomerService#findCustomerByPhoneNumber(String)
     */
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
    	return this.customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }

    /**
     * Transactional method.
     * 
     * @see incubator.spring_flex.service.CustomerService#createCustomer(Customer)
     */
    @Secured( {"ROLE_USER", "ROLE_SUPERVISOR"} )
    public Customer createCustomer(Customer customer) {    	
        return this.customerRepository.createCustomer(customer);
    }

    /*
     * Getter & Setter
     */
    
    public CustomerRepository getCustomerManager() {
    	return this.customerRepository;
    }
    
    public void setCustomerManager(CustomerRepository customerManager) {
    	this.customerRepository = customerManager;
    }
    
}