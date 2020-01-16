package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.LoginR;

public class Logina extends TestBase {
	LoginPage loginpage;
	LoginR loginagain;
	public Logina(){
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		loginagain=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test
	public void validation_title() {
		String title = loginagain.title_validation();
		Assert.assertEquals(title, "Log in to Facebook | Facebook","Page title not matched");
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
