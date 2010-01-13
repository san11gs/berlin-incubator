package weldTest.weldJsfJee.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Kapselt den Zugriff auf die FacesMessages.
 * Benoetigt KEIN @Named um injected werden zu koennen.
 * 
 * TODO Severity beruecksichtigen
 * 
 * @author schuetz
 * @date 12.01.2010
 */
public class FacesMessageHandler implements Serializable {
	
	/**
	 * Fuegt eine FacesMessage hinzu.
	 */
	public void add(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(msg));
	}
}
