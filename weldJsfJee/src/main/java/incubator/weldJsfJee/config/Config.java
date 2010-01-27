package incubator.weldJsfJee.config;

import java.io.Serializable;

/**
 * Represents a configuration.
 * 
 * @author schuetz
 * @date 13.01.2010
 */
public class Config implements Serializable {
	private String configString;
	private ConfigType configType;

	public Config(String configString, ConfigType configType) {
		this.configString = configString;
		this.configType = configType;
	}

	public String getConfigString() {
		return configString;
	}

	public void setConfigString(String configString) {
		this.configString = configString;
	}

	public ConfigType getConfigType() {
		return configType;
	}

	public void setConfigType(ConfigType configType) {
		this.configType = configType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("config: ");
		sb.append(configType);
		sb.append(" | ");
		sb.append(configString);

		return sb.toString();
	}
}
