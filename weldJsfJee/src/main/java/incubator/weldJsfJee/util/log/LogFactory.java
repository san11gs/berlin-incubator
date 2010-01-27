package incubator.weldJsfJee.util.log;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.weld.log.LoggerProducer;

/**
 * Wraps Logger-Implementation. Defines InjectionPoint for use with @Inject.
 * 
 * TODO Delete this file after bug is fixed with LoggerProducer.
 * 
 * @see LoggerProducer
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
