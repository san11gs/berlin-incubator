package incubator.weldJsfJee.util.log;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Decorates all implementations of MyLogger. May not be abstract (although
 * reference says that)!
 * 
 * @see beans.xml
 * 
 * @author schuetz
 * @date 20.01.2010
 */
@Decorator
public class MyLoggerDecorator implements MyLogger {

	/** Delegate for all MyLogger Implementations. */
	@Inject
	@Delegate
	@Any
	private MyLogger myLogger;

	/**
	 * Adds functionality (which in the dummy case is the comment) and delegates
	 * to appropriate implementation (which in this case is the MyLoggerImpl as
	 * there is only one implementation = @Default).
	 */
	public void info(String msg) {
		myLogger.info("--- decorated with message: " + msg);
	}
}