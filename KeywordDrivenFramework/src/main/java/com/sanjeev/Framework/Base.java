package com.sanjeev.Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	public static WebDriver driver;
	
	public Properties prop;
	
	public static WebDriver init_Driver(String device) throws MalformedURLException {
		
		if(device.equals("Android")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			
			cap.setCapability(MobileCapabilityType.NO_RESET, false);
			
			cap.setCapability(MobileCapabilityType.APP, "/Users/sanjeevakumargeejula/Downloads/AppiumJarSeleniumJarchromedriver/ApiDemos-debug.apk");
			
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			
			//return driver;
			
		}
		
		else if(device.equals("iOS")) {
			//driver = new IOSDriver();
		}
		
		else if(device.equals("Web")) {
			System.setProperty("webdriver.chrome.driver", "/Users/sanjeevakumargeejula/Downloads/AppiumJarSeleniumJarchromedriver/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
	public Properties init_Properties() {
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("/Users/sanjeevakumargeejula/eclipse-workspace/PageFactoryFramework/properties/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	

}
