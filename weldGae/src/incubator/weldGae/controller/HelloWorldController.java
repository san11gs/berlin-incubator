package incubator.weldGae.controller;

import javax.inject.Named;

/**
 * Simple dummy CDI-Bean.
 * 
 * @author m.schuetz
 * @date 04.02.2010
 */
@Named
public class HelloWorldController {
	public String getMessage() {
		return "Hello Weld World";
	}
}