package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;
	
	public ConfigReader() throws IOException
	{
		prop=new Properties();
		try {
			InputStream input = getClass()
			        .getClassLoader()
			        .getResourceAsStream("config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getProperty(String key)
	{
		return prop.getProperty(key);
	}	
	public int getTimeout()
	{
		return Integer.parseInt(prop.getProperty("timeouts"));
	}
	public String getBrowser()
	{
		return prop.getProperty("browser");
	}
	public String getUsername()
	{
		return prop.getProperty("username");
	}
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	public String getURL()
	{
		return prop.getProperty("url");
	}
}
