package incubator.weldGae.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Wraps access to JSF facesMessages. Does NOT need @Named to be able to be
 * injected.
 * 
 * TODO allow to specialize severity
 * 
 * @author schuetz
 * @date 12.01.2010
 */
public class FacesMessageHandler implements Serializable {

	/**
	 * Adds a FacesMessage.
	 */
	public void add(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(msg));
	}
}
