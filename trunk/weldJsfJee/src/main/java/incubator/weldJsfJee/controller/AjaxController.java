package incubator.weldJsfJee.controller;

import java.io.Serializable;

/**
 * Ajax-Controller. Ajax stuff is triggered directly from the JSF GUI.
 * 
 * @author schuetz
 * @date 10.01.2010
 */
@GuiController
public class AjaxController implements Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
