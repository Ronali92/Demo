package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	//Page Factory
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement submitbtn;
	
	//forgotten account webelement
	@FindBy(xpath="//a[contains(text(),'Forgotten')]")
	WebElement forgottenlink;
	  
	@FindBy(id="u_0_15")
	WebElement signupbtn;
	
	@FindBy(name="firstname")
	WebElement firstnametxt;
	
	@FindBy(name="lastname")
	WebElement lastnametxt;
	
	@FindBy(name="reg_email__")
	WebElement emailtxt;
	 
	@FindBy(name="reg_passwd__")
	WebElement passwordtxt;
	
	
	@FindBy(id="day")
	WebElement birthday;
	
	@FindBy(id="month")
	WebElement birthmonth;
	
	@FindBy(id="birthday_year")
	WebElement birthyear;
	
	@FindBy(xpath="//*[@id='u_0_11']")
	List<WebElement> radioBtnSelectGender;
	
	//Initialze all the webelement BY Page Factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//define different actions
	public LoginR login(String uname,String pass) {
		try {
			username.sendKeys(uname);
			password.sendKeys(pass);
			Thread.sleep(1000);
			submitbtn.click();
			//return new LoginR();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		return new LoginR();
	}
  
}
