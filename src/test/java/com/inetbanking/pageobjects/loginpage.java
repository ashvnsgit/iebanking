package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	
	WebDriver ldriver;
	
	public loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this );
		
	}
	
	@FindBy(xpath="//*[@name='uid']")
	@CacheLookup
	WebElement username;
	@FindBy(xpath="//*[@type='password']")
	@CacheLookup
	WebElement password;
	@FindBy(xpath="//*[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}
	public void setpassword(String pword)
	{
		password.sendKeys(pword);
	}
	 public void login()
	 {
		 btnLogin.click();
	 }
	
	
	
	
	
}
