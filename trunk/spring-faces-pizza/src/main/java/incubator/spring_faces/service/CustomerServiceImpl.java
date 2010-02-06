package incubator.spring_faces.service;

import incubator.spring_faces.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * A JPA based implementations of the {@link CustomerService}.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Service("customerService")
@Repository
public class CustomerServiceImpl implements CustomerService {

    /*
     * This entity manager is provided and injected by spring.
     */
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Transactional read-only method.
     * 
     * @see incubator.spring_faces.service.CustomerService#existsCustomer(java.lang.String)
     */
    @Transactional(readOnly = true)
    public String existsCustomer(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() == 0) {
            return String.valueOf(false);
        }
        return String.valueOf(findCustomerByPhoneNumber(phoneNumber) != null);
    }

    /**
     * Transactional read-only method.
     * 
     * @see incubator.spring_faces.service.CustomerService#findCustomerByPhoneNumber(String)
     */
    @Transactional(readOnly = true)
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        Query query = this.em.createQuery("select c from Customer c where c.phone = :phone").setParameter("phone",
                phoneNumber);
        Customer customer = null;
        try {
            customer = (Customer) query.getSingleResult();
        } catch (NoResultException e) {
            // In diesem Fall wird null zurück geliefert
        }
        return customer;
    }

    /**
     * Transactional method.
     * 
     * @see incubator.spring_faces.service.CustomerService#createCustomer(Customer)
     */
    @Transactional
    public Customer createCustomer(Customer customer) {
        this.em.persist(customer);
        return customer;
    }
}
