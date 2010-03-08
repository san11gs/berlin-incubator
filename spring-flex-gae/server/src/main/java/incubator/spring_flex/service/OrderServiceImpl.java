package incubator.spring_flex.service;

import incubator.spring_flex.domain.Order;
import incubator.spring_flex.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;


/**
 * Service for saving orders (business delegate pattern! We delegate to the manager).
 *  
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Service("orderService")
@RemotingDestination(channels = { "my-amf" })
@Secured( {"ROLE_USER", "ROLE_SUPERVISOR"} )
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository; 
	
    /**
     * Transactional method.
     * 
     * @see incubator.spring_flex.service.OrderService#saveOrder(Order)
     */
	@Secured("ROLE_USER")
    public Order saveOrder(Order order) {
    	return this.orderRepository.saveOrder(order);
    }

    /*
     * Getter & Setter
     */
    
	public OrderRepository getOrderManager() {
		return this.orderRepository;
	}

	public void setOrderManager(OrderRepository orderManager) {
		this.orderRepository = orderManager;
	}
}
