package com.bit.test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest 
{
	FirefoxDriver dr;
	
	Logger log= Logger.getLogger(BaseTest.class);
	
	@BeforeMethod
	public void start() throws IOException 
	{
	
	DOMConfigurator.configure("log4j.xml");	
	FileInputStream fis=new FileInputStream("config.properties");
	Properties p=new Properties();
	log.info("File Loading");
	p.load(fis);
	dr=new FirefoxDriver();
	log.info("url opening");
	dr.get(p.getProperty("url"));
	
	
		
	}
	
	@AfterMethod
	public void finish()
	{
		log.info("Browser Quiting");
		dr.quit();
	}
	
	
	
}
