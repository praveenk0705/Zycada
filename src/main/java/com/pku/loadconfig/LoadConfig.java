package com.pku.loadconfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/*
 * Singleton class to load external properties
 */
public class LoadConfig {
	private static LoadConfig _instance = null;
	public static Properties properties = new Properties();

	protected LoadConfig() {
		FileInputStream in = null;
		String fileLocation = new java.io.File("").getAbsolutePath();
		String fileAbsolutePath = fileLocation + "/src/main/resources/application.properties";
		try {
			in = new FileInputStream(fileAbsolutePath);
			properties.load(in);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException ex) {
				}
			}
		}
	}

	public static LoadConfig instance() {
		if (_instance == null) {
			_instance = new LoadConfig();
		}
		return _instance;
	}
}
