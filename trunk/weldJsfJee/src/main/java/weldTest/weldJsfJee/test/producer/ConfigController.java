package weldTest.weldJsfJee.test.producer;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * JSF-Config-Controller.
 * 
 * @author schuetz
 * @date 13.01.2010
 */
@SessionScoped
@Named
public class ConfigController implements Serializable {

	@Inject
	private Logger log;

	/** Die aktuell gewaehlte Art der Config. */
	private Config currentConfig;

	/** Verwendet den dev-Config wegen @Dev_Configured-Qualifier. */
	@Inject
	@Dev_Configured
	private Config devConfig;

	/** Verwendet den prod-Config wegen @Prod_Configured-Qualifier. */
	@Inject
	@Prod_Configured
	private Config prodConfig;

	/**
	 * Schaltet die Dev-Config an.
	 */
	public void enableDevConfig() {
		currentConfig = devConfig;
		logConfigChanged();
	}

	/**
	 * Schaltet die Prod-Config an.
	 */
	public void enableProdConfig() {
		currentConfig = prodConfig;
		logConfigChanged();
	}

	public Config getCurrentConfig() {
		return currentConfig;
	}

	/**
	 * Loggt die aktuelle config.
	 */
	private void logConfigChanged() {
		log.info("configuration changed: " + currentConfig);
	}

}
