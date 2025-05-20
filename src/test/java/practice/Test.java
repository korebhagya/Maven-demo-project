package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {


		
		public String readDataFromPropertyFile(String key) throws IOException
		{
			FileInputStream fis = new FileInputStream("src\\test\\resources\\commondata.properties");
			Properties p = new Properties();
			p.load(fis);
			String value = p.getProperty(key);
			return value;
		}
	
	}


