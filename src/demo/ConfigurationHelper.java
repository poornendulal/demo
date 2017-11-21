package demo;
import java.io.FileInputStream;
import java.util.*;
public class ConfigurationHelper{
	Properties configFile;
	   public ConfigurationHelper()
	   {
		   configFile = new java.util.Properties();
			try {			
			  configFile.load(new FileInputStream("/automation.settings"));
			  System.out.println("Reading automation.settings File");
			}catch(Exception eta){
			    eta.printStackTrace();
			    System.out.println("Reading Configuration File Failed !");
			}   
		   String cfgfile = configFile.getProperty("projectsettings");
		configFile = new java.util.Properties();
		try {			
		  configFile.load(new FileInputStream(cfgfile));
		  System.out.println("Loading the project.settings File");
		}catch(Exception eta){
		    eta.printStackTrace();
		    System.out.println("Reading Configuration File Test Case Failed !");
		}
	   }
	   public String getProperty(String key)
	   {
		String value = this.configFile.getProperty(key);
		System.out.println("Reading Configuration Item "+value +" from configuration File");
		return value;
	   }
	public static void main(String[] args) {
		ConfigurationHelper cfg = new ConfigurationHelper();
		System.out.println(cfg.getProperty("url") + " Read Configuration item 'URL'");
		System.out.println(cfg.getProperty("sheetName")+ " Read Configuration item 'Excel Data Pool Sheet Name'");
		System.out.println(cfg.getProperty("fileName")+ " Read Configuration item 'Excel Data Pool File Name'");
		System.out.println(cfg.getProperty("implicitwait")+ " Read Configuration item 'Excel Data Pool Sheet Name'");	
	}
	
}