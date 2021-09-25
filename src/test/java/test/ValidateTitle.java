package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void open() throws IOException
	{
		driver=init();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validate() throws InterruptedException
	{
		LandingPage lp= new LandingPage(driver);
		//lp.loginButton().click();
		Thread.sleep(2000);
		lp.email().sendKeys("9949615261");;
		Thread.sleep(2000);
		lp.password().sendKeys("9246198354a");;
		Thread.sleep(2000);
		lp.submit().click();
	
		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
