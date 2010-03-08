package incubator.spring_flex.repository;

import incubator.spring_flex.domain.Customer;
import incubator.spring_flex.persistence.JpaGenericDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Repository("customerManager")
public class CustomerRepository {

    private JpaGenericDAO<Customer, Long> customerDao = null;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.customerDao = new JpaGenericDAO<Customer, Long>(entityManager, Customer.class);
    }

    public boolean existsCustomer(String phoneNumber) {
        return findCustomerByPhoneNumber(phoneNumber) != null;
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("phone", phoneNumber);
        List<Customer> resultList = this.customerDao.findByNamedQuery("Customer.findCustomerByPhoneNumber", parameters);
        if(resultList != null && resultList.size() > 0){
            resultList.get(0);
        }
        return null;
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        return this.customerDao.persist(customer);
    }

//	private Map<Long, Customer> customerMap = new HashMap<Long, Customer>();
//	
//	private int currentId = 1;
//	
//	public CustomerManager() {
//		Customer customer = new Customer();
//		customer.setId(Long.valueOf(currentId++));
//		customer.setCity("Rom");
//		customer.setFirstname("Mario");
//		customer.setLastname("Zerrani");
//		customer.setPhone("1111");
//		customer.setPostal("12345");
//		customer.setStreet("Romstr.");
//		
//		this.customerMap.put(customer.getId(), customer);		
//	}
//	
//	public boolean existsCustomer(String phoneNumber) {
//        return findCustomerByPhoneNumber(phoneNumber) != null;
//    }
//
//    public Customer findCustomerByPhoneNumber(String phoneNumber) {
//    	List<Customer> customers = new ArrayList<Customer>(this.customerMap.values());
//		for(Customer customer : customers){
//			if(customer.getPhone().equals(phoneNumber)){
//				return customer;
//			}
//		}
//    	return null;
//    }
//
//    public Customer createCustomer(Customer customer) {
//    	customer.setId(Long.valueOf(this.currentId++));
//    	this.customerMap.put(customer.getId(), customer);
//        return customer;
//    }
}
