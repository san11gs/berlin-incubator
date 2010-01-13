package weldTest.weldJsfJee.util;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 * --> kapselt die Logger-Implementierung, definiert den setzt InjectionPoint, Verwendung mittels @Inject
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
