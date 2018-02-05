package demo;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationHelper {
	Properties configFile;

	public ConfigurationHelper() {
		configFile = new java.util.Properties();
		try {
			configFile.load(new FileInputStream("/automation.settings"));

		} catch (Exception eta) {
			System.exit(1);
		}
		String cfgfile = configFile.getProperty("projectsettings");
		configFile = new java.util.Properties();
		try {
			configFile.load(new FileInputStream(cfgfile));
		} catch (Exception eta) {
			System.exit(1);
		}
	}

	public String getProperty(String key) {

		return this.configFile.getProperty(key);
	}
}