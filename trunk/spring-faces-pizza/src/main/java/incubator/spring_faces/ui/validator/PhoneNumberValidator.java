package incubator.spring_faces.ui.validator;

import incubator.spring_faces.MessageKeys;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


/**
 * Implementation of a JSF validator for phone numbers.
 * 
 * @author iwaszkiewicz
 * @date 06.02.2010
 */
public class PhoneNumberValidator implements Validator {

    /**
     * [0-9]+ bedeutet: ein oder mehrere Zeichen aus der vorstehenden Menge <br/>
     * [ ]? bedeutet: ein oder kein Leerzeichen <br/>
     * [/]? bedeutet: ein oder kein Schraegstrich <br/>
     * 
     * <br/>
     * Zulaessige Telefonnummern sind z.B.: <br/>
     * 01231221431 <br/>
     * 0123 1221431 <br/>
     * 0123/1221431 <br/>
     * 0123/ 1221431 <br/>
     * 0123 /1221431 <br/>
     * 0123 / 1221431 <br/>
     */
    private static final String PHONE_EXPRESSION = "[0-9]+[ ]?[/]?[ ]?[0-9]+";

    /**
     * Validates the passed values. Is this a valid phone number?
     */
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        Pattern mask = Pattern.compile(PHONE_EXPRESSION);
        String phoneNumber = (String) value;
        Matcher matcher = mask.matcher(phoneNumber);

        if (!matcher.matches()) {
            Locale locale = context.getViewRoot().getLocale();
            ResourceBundle resBundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), locale);
            String errorMsg = resBundle.getString(MessageKeys.ERROR_PHONENUMBER);

            FacesMessage message = new FacesMessage();
            message.setDetail(errorMsg);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(message);
        }
    }

}
