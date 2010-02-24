package incubator.spring_faces.manager;

import org.springframework.stereotype.Component;

import incubator.spring_flex.dto.Order;


/**
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Component("orderManager")
public class OrderManager {

	private int currentId = 1;
	
    public Order saveOrder(Order order) {
    	if(order != null){
    		order.setId(Long.valueOf(currentId++));
    	}
    	return order;
    }
}
