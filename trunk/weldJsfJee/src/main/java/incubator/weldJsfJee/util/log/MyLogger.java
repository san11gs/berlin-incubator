package incubator.weldJsfJee.util.log;

import java.io.Serializable;

/**
 * MyLogger Interface. Wrapps default Logger-access for testing extended
 * CDI-capabilities.
 * 
 * @author schuetz
 * @date 20.01.20010
 */
public interface MyLogger extends Serializable {

	public void info(String msg);

}
