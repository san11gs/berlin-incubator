package incubator.spring_faces.service;

import incubator.spring_flex.domain.Order;

/**
 * Business interface of the order services.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
public interface OrderService {

    /**
     * Saves a new order.
     * 
     * @param order
     *            the new order to be saved/created.
     * @return the created order
     */
     Order saveOrder(Order order);
}
