package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sound.sampled.TargetDataLine;

import org.apache.logging.log4j.core.util.FileUtils;
import org.checkerframework.checker.formatter.qual.ReturnsFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init() throws IOException
	{
		String propPath= System.getProperty("user.dir")+"//src//main//java//resources//data.properties";
		String chromePath=	System.getProperty("user.dir")+"//src//main//java//resources//chromedriver.exe";
		prop= new Properties();
		FileInputStream fi = new FileInputStream(propPath);
		prop.load(fi);
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",chromePath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			}
		return driver;
		}
	
	public String screenshot(String methodName,WebDriver driver) throws IOException
	{
		String scrnPath = System.getProperty("user.dir")+"//reports//"+methodName+".jpg";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs=ts.getScreenshotAs(OutputType.FILE);			
		org.apache.commons.io.FileUtils.copyFile(fs, new File(scrnPath));
		
		return scrnPath;
	
	
	}
			
}
