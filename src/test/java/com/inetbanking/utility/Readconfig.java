package com.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties prop;
	 public Readconfig() {
		 
		 File src=new File("./configuration/config.properties");
		 try {
			 FileInputStream fis=new FileInputStream(src);
			 prop=new Properties();
			 prop.load(fis);
			 }
		 catch(Exception e)
		 {
			 System.out.println("Exception is "+e.getMessage());
		 }
		  }
	 
	 public String getapplicationurl()
	 {
		 String url=prop.getProperty("baseurl");
		 return url;
		 
	 }
	 
	 public String getusername()
	 {
		 String Username=prop.getProperty("uname");
		 return Username;
	 }
	 public String getpassword()
	  {
		String Password= prop.getProperty("pword");
		return Password;
	 }
	 public String getbrowser()
	  {
		String Chrome= prop.getProperty("chromepath");
		return Chrome;
	 }
	 public String getbrowserIE()
	  {
		String IE= prop.getProperty("IEDriver");
		return IE;
	 }
	 

	
	

}
