package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.utilities.Eventlistener;
import com.qa.utilities.TestUtil;

public class TestBase {
	public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static Eventlistener eventlistener;
	public TestBase(){
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/ronal/selenium/PageObjectModelDemo/src/main/java/com"
				+"/qa/config/config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
	public static void initialization() {
		System.out.println("Inside initialization method");
		String browserName =prop.getProperty("browser");
		System.out.println("browser nameeee"+browserName);
		String url_to_open = prop.getProperty("url");
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe ");
			driver = new ChromeDriver();
			
			
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventlistener = new Eventlistener();
		e_driver.register(eventlistener);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICLIT_WAIT, TimeUnit.SECONDS);
		driver.get(url_to_open);
		
	}

}
