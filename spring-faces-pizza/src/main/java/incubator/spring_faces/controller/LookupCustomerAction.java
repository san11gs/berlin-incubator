package incubator.spring_faces.controller;

import incubator.spring_faces.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;


/**
 * Action to look up a customer. <br/>
 * <br/>
 * Classes which implement the interface {@link Action} can be used to be evaluated within view states as well as
 * transitions. <br/>
 * This action uses the phone number entered by the user to look up the corresponding customer. <br/>
 * <br/>
 * As this class represents a controller it should be (and it is) quite simple. This means that this action is NOT
 * responsible for the search execution. Thus, this action implementation delegates the search to the appertaining
 * service - in this case the {@link CustomerService} which is injected by spring.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Component("lookupCustomerAction")
public class LookupCustomerAction implements Action {

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
         * Fetches the phone number from the request parameters.
         */
        String phoneNumber = requestContext.getRequestParameters().get("phoneInputForm:inputPhoneId");
        
        /*
         * Service call with the previously fetched phone number
         */
        String exists = this.customerService.existsCustomer(phoneNumber);
        return new Event(this, exists);
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
