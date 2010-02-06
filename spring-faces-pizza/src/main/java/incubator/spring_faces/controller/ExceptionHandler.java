package incubator.spring_faces.controller;

import incubator.spring_faces.MessageKeys;

import java.io.IOException;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.stereotype.Component;
import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.engine.ViewState;
import org.springframework.webflow.execution.FlowExecutionException;


/**
 * This exception handler can be used to handle exceptions thrown within a flow execution. You can add exception
 * handlers by adding the exception-handler element as part of a view.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
@Component("exceptionHandler")
public class ExceptionHandler implements FlowExecutionExceptionHandler {

    /**
     * This generic exception handler example can handle all types of exceptions.
     */
    public boolean canHandle(FlowExecutionException exception) {
        return true;
    }

    /**
     * Handles the thrown exception.
     */
    public void handle(FlowExecutionException exception, RequestControlContext context) {

        /*
         * We do not much right here. 
         */
        
        /*
         * Fetch the message context and add a message to it.
         */
        MessageContext messages = context.getMessageContext();
        MessageResolver msg = new MessageBuilder().error().code(MessageKeys.ERROR_UNEXPECTED).build();
        messages.addMessage(msg);

        Object currentState = context.getCurrentState();

        /*
         * This part is not necessary. On the contrary, the following code fragment is just a way to show that it is
         * possible to force the rendering of a view. Whether it is possible to render the view depends on the handled
         * exception.
         */
        if (currentState instanceof ViewState) {
            ViewState viewState = (ViewState) currentState;
            try {
                viewState.getViewFactory().getView(context).render();
            } catch (IOException e) {
                // Properly handle rendering errors here
            }
        }
    }

}
