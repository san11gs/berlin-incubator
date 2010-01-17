package weldTest.weldJsfJee.controller;

import java.io.Serializable;

import weldTest.weldJsfJee.stereotype.GuiController;

/**
 * Ajax-Test-Controller
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
