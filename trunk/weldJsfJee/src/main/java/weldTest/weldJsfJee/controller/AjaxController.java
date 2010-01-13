package weldTest.weldJsfJee.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Ajax-Test-Controller
 * 
 * @author schuetz
 * @date 10.01.2010
 */
@Named
@SessionScoped
public class AjaxController implements Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
