package incubator.spring_faces.service;

import incubator.spring_faces.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * A JPA based implementations of the {@link OrderService}.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Service("orderService")
@Repository
public class OrderServiceImpl implements OrderService {

    /*
     * This entity manager is provided and injected by spring.
     */
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Transactional method.
     * 
     * @see incubator.spring_faces.service.OrderService#saveOrder(Order)
     */
    @Transactional(readOnly = false)
    public Order saveOrder(Order order) {
        if (order == null) {
            return null;
        }
        this.em.persist(order);
        return order;
    }
}
