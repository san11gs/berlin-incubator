package incubator.weldJsfJee.util.log;

import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

/**
 * Alternative-MyLogger Implementation. After defining this archetype in
 * beans.xml, this MyLogger implementation will be used (for example for testing
 * purposes). @Specializes guarantees that without respecting Qualifier and
 * PRoducers methods.
 * 
 * @see beans.xml
 * 
 * @author schuetz
 * @date 21.01.2010
 */
@Alternative
@Specializes
public class AlternativeLoggerImpl extends MyLoggerImpl {
	// OR: public class AlternativeLoggerImpl implements MyLogger {

	/** Injects default logger. */
	@Inject
	private Logger log;

	/**
	 * Logs message on info level.
	 */
	@Override
	public void info(String msg) {
		log.info("--- alternativeLogger called, msg: " + msg);
	}

}
