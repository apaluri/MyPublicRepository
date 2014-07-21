/**
 * 
 */
package com.appvigil.testing;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

/**
 * @brief
 * This test case launches the firefox browser using @BeforeTest Annotation
 * 
 * @author Aditya
 *
 */
public class LaunchBrowserTest {

	public static String cleanapkpath = "", buggyapkpath = "";
	public static int timeout;
	
	static 
	{
		// Let the paths to the clean and the buggy apk be available here
		cleanapkpath = "D:\\Developer\\MyEclipseWorkspace\\AppVigil\\aaaaaHelloWorld.apk";
		buggyapkpath = "D:\\Developer\\MyEclipseWorkspace\\AppVigil\\com.fss.obc.apk";
		timeout = 180000;
	}
	
	public static WebDriver driver;
	
	@BeforeTest
	public void test_LaunchBrowser()
	{
		driver = new FirefoxDriver();
	}
}
