package incubator.weldGae;

import javax.inject.Named;

/**
 * Simple dummy CDI-Bean.
 * 
 * @author m.schuetz
 * @date 04.02.2010
 */
@Named
public class HelloWorld {
	public String getMessage() {
		return "Hello Weld World";
	}
}