package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By loginButton=By.className("_1_3w1N");
	By email=By.cssSelector("._2IX_2-.VJZDxU");
	By password = By.xpath("//input[@type='password']");
	By submit = By.xpath("//div[@class='_1D1L_j'] //button[@type='submit'] ");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement loginButton()
	{
		return driver.findElement(loginButton);
	}

	public WebElement email()
	{
		return driver.findElement(email);
	}

	
	public WebElement password()
	{
		return driver.findElement(password);
	}

	public WebElement submit()
	{
		return driver.findElement(submit);
	}


}
