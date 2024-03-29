package incubator.spring_flex.service;

import incubator.spring_flex.domain.CustomerEntity;
import incubator.spring_flex.dto.Customer;
import incubator.spring_flex.mapper.CustomerMapper;
import incubator.spring_flex.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
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

    private static final Logger LOG = Logger.getLogger(CustomerServiceImpl.class.getName());
    
	@Autowired
	private CustomerRepository customerRepository;

    @Autowired
	private CustomerMapper customerMapper;
	
	public boolean existsCustomer(String phoneNumber) {
		return this.customerRepository.existsCustomer(phoneNumber);
	}

	public boolean createDemoUser() {
	    CustomerEntity customerEntity = new CustomerEntity();
	    customerEntity.setFirstname("Demo");
	    customerEntity.setLastname("Demo");
	    customerEntity.setCity("Demo-City");
	    customerEntity.setPhone("11111");
	    customerEntity.setPostal("12121");
	    customerEntity.setStreet("Demo No. 1");
		
	    customerEntity = this.customerRepository.createCustomer(customerEntity);
	    
	    return customerEntity.getKey() != null;
	}

	/**
	 * Transactional read-only method.
	 * 
	 * @see incubator.spring_flex.service.CustomerService#findCustomerByPhoneNumber(String)
	 */
	public Customer findCustomerByPhoneNumber(String phoneNumber) {
		CustomerEntity cusomerEntity = this.customerRepository.findCustomerByPhoneNumber(phoneNumber);
		return this.customerMapper.mapToCustomer(cusomerEntity);
	}

	/**
	 * Transactional method.
	 * 
	 * @see incubator.spring_flex.service.CustomerService#createCustomer(Customer)
	 */
	//@Secured( { "ROLE_USER", "ROLE_SUPERVISOR" })
	public Customer createCustomer(Customer customer) {
	   
//	    System.out.println("createCustomer called:");
//        System.out.println("customer.key: " + customer.getKey());
//        System.out.println("customer.city: " + customer.getCity());
//        System.out.println("customer.firstname: " + customer.getFirstname());
//        System.out.println("customer.lastname: " + customer.getLastname());
//        System.out.println("customer.phone: " + customer.getPhone());
//        System.out.println("customer.postal: " + customer.getPostal());
//        System.out.println("customer.street: " + customer.getStreet());
//        
	    customer.setKey(null);
	    CustomerEntity customerEntity = this.customerMapper.mapToCustomerEntity(customer);
	    
//	    System.out.println("############ 2 " + customerEntity.getFirstname());
	    
	    customerEntity = this.customerRepository.createCustomer(customerEntity);
        
//        System.out.println("############ 3 " + customerEntity.getFirstname());
//
//        System.out.println("saved customer called:");
//        System.out.println("customerEntity.id: " + customerEntity.getKey());
//        System.out.println("customerEntity.city: " + customerEntity.getCity());
//        System.out.println("customerEntity.firstname: " + customerEntity.getFirstname());
//        System.out.println("customerEntity.lastname: " + customerEntity.getLastname());
//        System.out.println("customerEntity.phone: " + customerEntity.getPhone());
//        System.out.println("customerEntity.postal: " + customerEntity.getPostal());
//        System.out.println("customerEntity.street: " + customerEntity.getStreet());

	    Customer result = this.customerMapper.mapToCustomer(customerEntity);

//        System.out.println("result customer called:");
//        System.out.println("result_customer.id: " + result.getKey());
//        System.out.println("result_customer.city: " + result.getCity());
//        System.out.println("result_customer.firstname: " + result.getFirstname());
//        System.out.println("result_customer.lastname: " + result.getLastname());
//        System.out.println("result_customer.phone: " + result.getPhone());
//        System.out.println("result_customer.postal: " + result.getPostal());
//        System.out.println("result_customer.street: " + result.getStreet());
//
//        System.out.println("############ 4 " + result.getFirstname());
        //result.setFirstname("uuuuuuuuuuuuuuuuuuuu");
        return result;
	}
	
	public List<Customer> getAllCustomers(){
	    List<Customer> all = new ArrayList<Customer>();
	    
	    List<CustomerEntity> loadAll = this.customerRepository.loadAll();
	    for(CustomerEntity customerEntity : loadAll){
	        all.add(this.customerMapper.mapToCustomer(customerEntity));
	    }
	    
	    return all;
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
