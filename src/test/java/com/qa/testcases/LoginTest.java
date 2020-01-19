package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.LoginR;

public class LoginTest extends TestBase {
	LoginPage loginpage;
	LoginR loginagain;
	public LoginTest(){
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		
	}
	@Test
	public void Login() {
		try {
			System.out.println("Inside Login Method");
			loginagain=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("Inside tear down method");
		driver.quit();
	}
	

}
