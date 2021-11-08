package com.inetbanking.testcases;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.loginpage;


public class TC_01_LoginTest  extends BaseClass{
	public static Logger log=LogManager.getLogger(TC_01_LoginTest.class.getName());
	@Test
	public void LoginTest() {
		driver.get(baseurl);
		log.debug("Ebank Url getting loaded");
		
		loginpage lp=new loginpage(driver);
		lp.setusername(uname);
		log.info("user giving username");
		lp.setpassword(pword);
		log.info("user giving password");
		lp.login();
		if(driver.getTitle().equals("Guru99 Bank Mnager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("title page validated");
		}
		else
			Assert.assertTrue(false);
		//log.error("expected title page not equal to given");
		
		
		
	}

}
