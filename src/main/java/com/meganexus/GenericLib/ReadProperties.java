package com.meganexus.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;




public class ReadProperties {
    private static ReadProperties _instance = null;

    private Properties props = null;

    private ReadProperties() {
        props = new Properties();
    	try {
	    FileInputStream fis = new FileInputStream(new File("config//config.properties"));
	    props.load(fis);
    	}
    	
    	catch (Exception e) {
    	    
    	}
    	//String propValue = ReadProperties.getInstance().getProperty(propKey)
    	//System.out.println(props);
    }

    public synchronized static ReadProperties getInstance() {
        if (_instance == null)
            _instance = new ReadProperties();
        return _instance;
    }

  
    public String getProperty(String key) {
        String value = null;
        if (props.containsKey(key))
            value = (String) props.get(key);
         
        else {
        // System.out.println("Value not found in property file");
        }
        return value;
    }
  
}