package incubator.spring_flex.service;

import java.util.ArrayList;
import java.util.Collection;

import incubator.spring_flex.domain.OrderEntity;
import incubator.spring_flex.dto.Order;
import incubator.spring_flex.mapper.OrderMapper;
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
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository; 
	
	@Autowired
	private OrderMapper orderMapper;
	
    /**
     * Transactional method.
     * 
     * @see incubator.spring_flex.service.OrderService#saveOrder(Order)
     */
	//@Secured("ROLE_USER")
    public Order saveOrder(Order order) {
        try {
    	    OrderEntity orderEntity = this.orderMapper.mapToOrderEntity(order);
    	    orderEntity = this.orderRepository.saveOrder(orderEntity);
    	    return this.orderMapper.mapToOrder(orderEntity);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;

    }

    public Collection<Order> getAllOrders() {
        Collection<OrderEntity> list = this.orderRepository.loadAll();
        Collection<Order> orders = new ArrayList<Order>();
        for(OrderEntity orderEntity : list){
            orders.add(this.orderMapper.mapToOrder(orderEntity));
        }
        return orders;
    }

}
