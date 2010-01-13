package weldTest.weldJsfJee.test.producer;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 * Factory-Bean, welches die einzelnen @Produces-Methoden fuer die entsprechenden Qualifier bereitstellt.
 * 
 * @author schuetz
 * @date 13.01.2010
 */
@SessionScoped
public class ConfigFactory implements Serializable {

	/**
	 * Producer-Methode fuer DEVELOPMENT-Config
	 */
	@Produces
	@Dev_Configured
	public Config getDevConfigs() {
		return new Config("dev-specific configs", ConfigType.DEVELOPMENT);
	}

	/**
	 * Producer-Methode fuer PRODUCTION-Config
	 */
	@Produces
	@Prod_Configured
	public Config getProdConfigs() {
		return new Config("prod-specific configs", ConfigType.PRODUCTION);
	}

}
