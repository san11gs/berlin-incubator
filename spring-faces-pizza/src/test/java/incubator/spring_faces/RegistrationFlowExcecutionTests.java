package incubator.spring_faces;

import incubator.spring_faces.controller.SaveCustomerAction;
import incubator.spring_faces.model.Customer;
import incubator.spring_faces.service.CustomerService;

import org.easymock.EasyMock;
import org.springframework.faces.model.converter.FacesConversionService;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;


/**
 * This test implementation illustrates how we can test spring webflow application - particularly how we can write junit
 * tests for our flows.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
public class RegistrationFlowExcecutionTests extends AbstractXmlFlowExecutionTests {

    private CustomerService customerService;
    private SaveCustomerAction saveCustomerAction;

    /**
     * Set up the test.<br/>
     */
    protected void setUp() {
        /*
         * mock the customer service.
         */
        this.customerService = EasyMock.createMock(CustomerService.class);

        /*
         * create a customer action and pass the mock service to it.
         */
        this.saveCustomerAction = new SaveCustomerAction();
        this.saveCustomerAction.setCustomerService(this.customerService);
    }

    /**
     * Tell spring where to load the flow configuration from.
     */
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/flows/registration/registration-flow.xml");
    }

    /**
     * Configure the flow context by registering the beans used by the flow / used by the test implementations in this
     * class.
     */
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
        builderContext.registerBean("customerService", this.customerService);
        builderContext.registerBean("saveCustomerAction", this.saveCustomerAction);
        builderContext.getFlowBuilderServices().setConversionService(new FacesConversionService());
    }

    /*
     * Here we go - the test methods:
     */

    /**
     * Test the registration flow.
     */
    public void testRegistrationFlow() {

        MutableAttributeMap input = new LocalAttributeMap();
        input.put("phoneNumber", "123456789");

        MockExternalContext context = new MockExternalContext();
        // "log in"
        context.setCurrentUser("mario");

        startFlow(input, context);

        assertCurrentStateEquals("registerCustomer");
        assertResponseWrittenEquals("registerCustomer", context);
        assertTrue(getRequiredFlowAttribute("customer") instanceof Customer);

        Customer customer = (Customer) getRequiredFlowAttribute("customer");
        customer.setCity("Berlin");

        context.setEventId("next");
        resumeFlow(context);

        assertCurrentStateEquals("confirmNewCustomer");
        assertEquals("123456789", customer.getPhone());
        assertEquals("Berlin", customer.getCity());
        assertSame(customer, getFlowAttribute("customer"));

        /*
         * Im nächsten Schritt wird "save" aufgerufen. Dadurch wird ein Action-State erreicht, in welchem die
         * saveCustomerAction aufgerufen wird. Diese wiederum benutzt den CustomerService.
         */
        EasyMock.expect(this.customerService.createCustomer(customer)).andReturn(customer);
        EasyMock.replay(this.customerService);

        context.setEventId("save");
        // hier wird die Action "saveNewCustomer" ausgeführt
        resumeFlow(context);

        EasyMock.verify(this.customerService);
        assertCurrentStateEquals("newCustomerConfirmation");
    }

}
