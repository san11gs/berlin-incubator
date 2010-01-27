package incubator.weldJsfJee.util.log;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Wraps Logger-Implementation. Defines InjectionPoint for use with @Inject.
 * 
 * @author schuetz
 * @date 11.01.2010
 */
public class LogFactory {

	@Produces
	Logger createLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass()
				.getName());
	}

}
