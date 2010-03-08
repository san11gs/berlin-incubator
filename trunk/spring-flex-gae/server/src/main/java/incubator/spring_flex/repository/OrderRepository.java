package incubator.spring_flex.repository;

import incubator.spring_flex.domain.Order;
import incubator.spring_flex.persistence.JpaGenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Repository("orderManager")
public class OrderRepository {

    private JpaGenericDAO<Order, Long> orderDao = null;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.orderDao = new JpaGenericDAO<Order, Long>(entityManager, Order.class);
    }

    @Transactional
    public Order saveOrder(Order order) {
    	return this.orderDao.persist(order);
    }
}
