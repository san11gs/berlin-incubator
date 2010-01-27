package incubator.weldJsfJee.controller;

import incubator.weldJsfJee.config.Config;
import incubator.weldJsfJee.config.Dev_Configured;
import incubator.weldJsfJee.config.Prod_Configured;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.inject.Inject;

/**
 * JSF-Config-Controller to show extended Use of qualifiers.
 * 
 * @author schuetz
 * @date 13.01.2010
 */
@GuiController
public class ConfigController implements Serializable {

	@Inject
	private Logger log;

	/** Current type of config. */
	private Config currentConfig;

	/** Use @Dev_Configured Qualifier. */
	@Inject
	@Dev_Configured
	private Config devConfig;

	/** Use @Prod_Configured Qualifier. */
	@Inject
	@Prod_Configured
	private Config prodConfig;

	/**
	 * Switch to devConfig.
	 */
	public void enableDevConfig() {
		currentConfig = devConfig;
		logConfigChanged();
	}

	/**
	 * Switch to prodConfig.
	 */
	public void enableProdConfig() {
		currentConfig = prodConfig;
		logConfigChanged();
	}

	public Config getCurrentConfig() {
		return currentConfig;
	}

	/**
	 * Logs current config.
	 */
	private void logConfigChanged() {
		log.info("configuration changed: " + currentConfig);
	}

}
