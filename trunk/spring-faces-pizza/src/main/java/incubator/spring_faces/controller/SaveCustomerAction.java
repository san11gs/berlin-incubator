package incubator.spring_faces.controller;

import incubator.spring_faces.MessageKeys;
import incubator.spring_faces.model.Customer;
import incubator.spring_faces.service.CustomerService;

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
 * Action to save a customer. This action implementation delegates the storage to the appertaining service - in this
 * case the {@link CustomerService} which is injected by spring. <br/>
 * 
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Component("saveCustomerAction")
public class SaveCustomerAction implements Action {

    /**
     * Spring injected customer service
     */
    @Autowired
    private CustomerService customerService;

    /**
     * Executes the action.
     */
    public Event execute(RequestContext requestContext) throws Exception {

        /*
         * Fetch the customer instance from the flow scope.
         */
        Customer customer = (Customer) requestContext.getFlowScope().get("customer");

        if (customer == null) {
            throw new IllegalArgumentException("Customer must not be null!");
        }

        /*
         * Save the customer.
         */
        Exception caught = null;
        try {
            customer = this.customerService.createCustomer(customer);
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

    public CustomerService getCustomerService() {
        return this.customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}
