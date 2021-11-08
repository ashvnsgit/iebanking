package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utility.Readconfig;



public class BaseClass {
	
	Readconfig readconfig=new Readconfig();

	public String baseurl=readconfig.getapplicationurl();
	public String uname=readconfig.getusername();
	public String pword=readconfig.getpassword();
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getbrowser());
			driver=new ChromeDriver();
			
		}
		else if(br.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getbrowserIE());
			driver=new InternetExplorerDriver();
		}
		driver.get(baseurl);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		
	}
	public String takescreenshot(String testcasename,WebDriver driver) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String Destinationfile=System.getProperty("user.dir")+"\\screenshot\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(Destinationfile));
		return Destinationfile;
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
}
