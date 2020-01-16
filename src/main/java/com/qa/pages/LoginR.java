package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginR extends TestBase {

	@FindBy(name="email")
	WebElement newemailid;
	
	@FindBy(name="pass")
	WebElement newpassword;
	
	@FindBy(id="loginbutton")
	WebElement btnlogin;
	
	public LoginR() {
		PageFactory.initElements(driver, this);
	}
	
	public String title_validation() {
		return driver.getTitle();
	}
	
	public void logina(String un,String pas) {
		newemailid.sendKeys(un);
		newpassword.sendKeys(pas);
		btnlogin.click();
	
	}
}
