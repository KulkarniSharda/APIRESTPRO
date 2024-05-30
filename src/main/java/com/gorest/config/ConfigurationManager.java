package com.gorest.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {

	Properties prop;
	FileInputStream fis;
	
	public Properties init() {
		 prop=new Properties();
		 try {
			fis=new FileInputStream("./src/test/resources/properties/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
}}
