package incubator.weldJsfJee.config;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 * Factory-Bean which provides @Produces methods for the different qualifiers.
 * 
 * @author schuetz
 * @date 13.01.2010
 */
@SessionScoped
public class ConfigFactory implements Serializable {

	/**
	 * Producer method for DEVELOPMENT config.
	 */
	@Produces
	@Dev_Configured
	public Config getDevConfigs() {
		return new Config("dev-specific configs", ConfigType.DEVELOPMENT);
	}

	/**
	 * Producer method  for PRODUCTION config.
	 */
	@Produces
	@Prod_Configured
	public Config getProdConfigs() {
		return new Config("prod-specific configs", ConfigType.PRODUCTION);
	}

}
