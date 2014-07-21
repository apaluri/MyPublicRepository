/**
 * 
 */
package com.appvigil.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author Aditya
 *
 */
public class Cleanapkload 
{

	@Test
	public void test_cleanapk() throws InterruptedException, AWTException
	{
		// Launch appvigil.co webpage
		LaunchBrowserTest.driver.get("http://www.appvigil.co/");

		/*System.setProperty("jacob.dll.path", "D:\\DANGER\\Installations\\MyPackages\\jacob-1.18-M2\\jacob-1.18-M2\\jacob-1.18-M2-x64.dll");
		LibraryLoader.loadJacobLibrary(); 
		 */
		// Set Actions to do mouse hover equivalent mouse actions
		Actions action = new Actions(LaunchBrowserTest.driver);

		// Get the current page's window handle
		String parenthandle = LaunchBrowserTest.driver.getWindowHandle();

		// Get the element to be clicked to load the apk file
		WebElement loadapk = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[1]/form"));
		loadapk.click();

		// Upload the file adding the required path in StringSelection arguements
		StringSelection str = new StringSelection(LaunchBrowserTest.cleanapkpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		Robot robot = new Robot();
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);

		Thread.sleep(120000);

		WebElement checkmsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[1]/div"));
		System.out.println(checkmsg.getText());
		String actualstring = "Wonderfull!!" + '\n' + "No security bugs have been found in your Android App." + '\n' + "Cheers!!! :)";
		Assert.assertEquals(checkmsg.getText(), actualstring );
	}

	@Test(dependsOnMethods = {"test_cleanapk"})
	public void test_InvalidNameField() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[4]/div/input"));
		name.clear();
		Thread.sleep(1000);

		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[5]/div/input"));
		phonenumber.clear();
		phonenumber.sendKeys("1234567890");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[6]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.id("dropzone_submit"));
		submit.click();
		Thread.sleep(1000);


		// Check for error message for entering the name
		WebElement errorchkname = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[3]/a/ul/li"));
		Assert.assertEquals(errorchkname.getText(), "Please enter name");
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = {"test_cleanapk","test_InvalidNameField"})
	public void test_InvalidContactField() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[4]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[5]/div/input"));
		phonenumber.clear();
		Thread.sleep(1000);


		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[6]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.id("dropzone_submit"));
		submit.click();
		Thread.sleep(1000);


		// Check for error message for entering the name
		WebElement errorchkname = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[3]/a/ul/li"));
		Assert.assertEquals(errorchkname.getText(), "Please enter contact number");
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = {"test_cleanapk","test_InvalidNameField","test_InvalidContactField"})
	public void test_InvalidEmailidField() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[4]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[5]/div/input"));
		phonenumber.clear();
		phonenumber.sendKeys("1234567890");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[6]/div/input"));
		emailid.clear();
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.id("dropzone_submit"));
		submit.click();
		Thread.sleep(1000);


		// Check for error message for entering the name
		WebElement errorchkname = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[3]/a/ul/li"));
		Assert.assertEquals(errorchkname.getText(), "Please enter an email address");
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = {"test_cleanapk","test_InvalidNameField","test_InvalidContactField","test_InvalidEmailidField"})
	public void test_InvalidCaptchaField() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[4]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[5]/div/input"));
		phonenumber.clear();
		phonenumber.sendKeys("1234567890");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[6]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[7]/div[1]/input"));
		captcha.clear();
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.id("dropzone_submit"));
		submit.click();
		Thread.sleep(1000);


		// Check for error message for entering the name
		WebElement errorchkname = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[3]/a/ul/li"));
		Assert.assertEquals(errorchkname.getText(), "Please enter CAPTCHA");
		Thread.sleep(1000);
	}


	@Test(dependsOnMethods = {"test_cleanapk","test_InvalidNameField","test_InvalidContactField","test_InvalidEmailidField","test_InvalidCaptchaField"})
	public void test_InvalidCredentials() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[4]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[5]/div/input"));
		phonenumber.clear();
		phonenumber.sendKeys("1234567890");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[6]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.id("dropzone_submit"));
		submit.click();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[2]/p"));
		String errormsg = "Incorrect Captcha. Seems you are a Hacker!!!";
		//	System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	@Test(dependsOnMethods = {"test_cleanapk","test_InvalidNameField","test_InvalidContactField","test_InvalidEmailidField","test_InvalidCaptchaField","test_InvalidCredentials"})
	public void test_ValidCredentials() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[4]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[5]/div/input"));
		phonenumber.clear();
		phonenumber.sendKeys("1234567890");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[6]/div/input"));
		emailid.clear();
		emailid.sendKeys("testuser@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.id("dropzone_submit"));
		submit.click();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/form/div[2]/p"));
		//	String rightmsg = "Link of your detailed audit report has been sent to your inbox";
		String rightmsg = "Your email-id has already been registered with us. Please login to your account to scan more apps.";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), rightmsg);
	}

}
