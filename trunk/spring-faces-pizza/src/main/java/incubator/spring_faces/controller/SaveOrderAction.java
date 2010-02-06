package incubator.spring_faces.controller;

import incubator.spring_faces.MessageKeys;
import incubator.spring_faces.model.Order;
import incubator.spring_faces.service.OrderService;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;


/**
 * Action to save an order. This action implementation delegates the storage to the appertaining service - in this case
 * the {@link OrderService} which is injected by spring.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Component("saveOrderAction")
public class SaveOrderAction implements Action {

    /**
     * Spring injected order service
     */
    @Autowired
    private OrderService orderService;

    /**
     * Executes the action.
     */
    public Event execute(RequestContext requestContext) throws Exception {

        /*
         * Fetch the order instance from the flow scope.
         */
        Order order = (Order) requestContext.getFlowScope().get("order");

        if (order == null) {
            throw new IllegalArgumentException("Order must not be null!");
        }

        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must not be null!");
        }

        /*
         * Save the order.
         */
        Exception caught = null;
        try {
            order = this.orderService.saveOrder(order);
            return new Event(this, "saved");

        } catch (PersistenceException e) {
            caught = e;
        } catch (HibernateException e) {
            caught = e;
        }

        /*
         * Add an error message to the message context
         */
        MessageContext messages = requestContext.getMessageContext();
        MessageResolver msg = new MessageBuilder().error().code(MessageKeys.ERROR_USER_PERSIST_FAILED).build();
        messages.addMessage(msg);

        /*
         * Forward exception.
         */
        throw caught;
    }

    /*
     * getter & setter
     */

    public OrderService getOrderService() {
        return this.orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

}
