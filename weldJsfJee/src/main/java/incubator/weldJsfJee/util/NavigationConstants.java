package incubator.weldJsfJee.util;

import java.io.Serializable;

/**
 * JSF-Navigation-Constants. As long as the Strings find an appropriate named
 * jsf-page, there is no need for configuration in faces-config.xml. <br>
 * Example: "customers" refer to "/customers.xhtml"
 * 
 * @author schuetz
 * @date 25.01.2010
 */
public class NavigationConstants implements Serializable {

	public static final String CUSTOMERS = "customers";
	public static final String CUSTOMER_DETAIL = "customerDetail";
}
