package incubator.weldJsfJee.util.log;

import java.util.logging.Logger;

import javax.inject.Inject;

/**
 * Default-MyLogger Implementation. As there is only one Implementation, no @Default
 * is required.
 * 
 * @author schuetz
 * @date 20.01.2010
 */
public class MyLoggerImpl implements MyLogger {

	/** Injects default logger. */
	@Inject
	private Logger log;

	/**
	 * Logs message on info level.
	 */
	@Override
	public void info(String msg) {
		log.info("--- myLogger called, msg: " + msg);
	}

}
