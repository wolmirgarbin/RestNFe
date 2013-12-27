package br.com.jtron.restnfe.util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelper {
	
	private static PropertiesHelper propertiesHelper;
	
	public static PropertiesHelper getInstance(){		
		if(propertiesHelper != null){
			return propertiesHelper;
		}else{
			propertiesHelper = new PropertiesHelper();
			return propertiesHelper;
		}		
	}
	
	private PropertiesHelper() {
	     try {
	      properties = new Properties();      
	      properties.load(new FileInputStream("/app/conf/restnfe.properties"));
	     } catch (Exception e) {
	      e.printStackTrace();
	     }	     
	}	
		
	Properties properties;    
	
    public String getKey(String key){
    	return properties.getProperty(key);
    }
	

}