/**
 * 
 */
package com.appvigil.testing;

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

	public static WebDriver driver;
	
	@BeforeTest
	public void test_LaunchBrowser()
	{
		driver = new FirefoxDriver();
	}
}
