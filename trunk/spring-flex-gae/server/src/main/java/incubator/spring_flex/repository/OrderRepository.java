package incubator.spring_flex.repository;

import java.util.Collection;
import java.util.List;

import incubator.spring_flex.domain.CustomerEntity;
import incubator.spring_flex.domain.OrderEntity;
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

    private JpaGenericDAO<OrderEntity, Long> orderDao = null;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.orderDao = new JpaGenericDAO<OrderEntity, Long>(entityManager, OrderEntity.class);
    }

    @Transactional
    public OrderEntity saveOrder(OrderEntity order) {
    	return this.orderDao.persist(order);
    }

    @Transactional
    public Collection<OrderEntity> loadAll() {
        List<OrderEntity> list = this.orderDao.findByNamedQuery("OrderEntity.loadAll");
        System.out.println("---list.size: " + list.size());
        return list;
    }
}
