package incubator.spring_faces.service;

import incubator.spring_faces.manager.OrderManager;
import incubator.spring_flex.dto.Order;

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
	private OrderManager orderManager; 
	
    /**
     * Transactional method.
     * 
     * @see incubator.spring_faces.service.OrderService#saveOrder(Order)
     */
	@Secured("ROLE_USER")
    public Order saveOrder(Order order) {
    	return this.orderManager.saveOrder(order);
    }

    /*
     * Getter & Setter
     */
    
	public OrderManager getOrderManager() {
		return this.orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
}
