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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Aditya
 *
 */
public class Paid_childuser 
{

	/*	
	 * 	@brief
	 *  Test case checking logging in with child user
	 */
	@Test
	public void test_childuserlogin() throws InterruptedException
	{
		LaunchBrowserTest.driver.get("http://appvigil.co/my-account/login/");

		// Set Actions to do mouse hover equivalent mouse actions
		Actions action = new Actions(LaunchBrowserTest.driver);

		// Enter username i.e., email id into the form
		WebElement enterusername = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/form/div[1]/div/input"));
		enterusername.sendKeys("testuser.child@wegilant.com");
		Thread.sleep(1000);

		// Enter password into the form
		WebElement password = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/form/div[2]/div/input"));
		password.sendKeys("12345678");
		Thread.sleep(1000);

		// Click on sign in to signin to the web page
		WebElement signin = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/form/div[4]/div/input"));
		action.moveToElement(signin).click().build().perform();
		Thread.sleep(1000);

	}

	/*
	 * @brief
	 * Test case to check loading of clean app after loggin into the page
	 * 
	 */
	@Test(dependsOnMethods = {"test_childuserlogin"})
	public void test_ChildscanCleanapk() throws InterruptedException, AWTException
	{
		Actions action = new Actions(LaunchBrowserTest.driver);

		//Click on New Audit
		WebElement newaudit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[15]/div[2]/div/div[4]/div/div/a[2]"));
		action.moveToElement(newaudit).click().build().perform();
		Thread.sleep(1000);

		// Get the element to be clicked to load the apk file
		WebElement loadapk = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/div/form/div[1]/label"));
		loadapk.click();
		Thread.sleep(1000);

		// Upload the file adding the required path in StringSelection arguements
		StringSelection str = new StringSelection(LaunchBrowserTest.cleanapkpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		Robot robot = new Robot();
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);

		WebElement submitform = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/div/form"));
		submitform.submit();
		Thread.sleep(1000);


		// Message to check if the apk is loaded successfulyy and ready to be scanned by assertion
		WebElement checkmsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/form/div"));
		System.out.println(checkmsg.getText());
		String actualstring = "Your App has been uploaded successfully. You can start scanning now!";
		Assert.assertEquals(checkmsg.getText(), actualstring );

		// Click on Scan element to start scanning the apk file
		WebElement scanapk = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/form/input"));
		action.moveToElement(scanapk).click().build().perform();
		Thread.sleep(1000);

		// Assert for message available while detecting security threats 
		WebElement getscanmsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[1]/div/h5"));
		System.out.println(getscanmsg.getText());
		String actstring = "Please wait...we are using our magic wand on your android application. It might take few minutes. Please be patient.";
		Assert.assertEquals(getscanmsg.getText(), actstring );

		// Implicit Wait for loading of apk 
		Thread.sleep(LaunchBrowserTest.timeout);
		LaunchBrowserTest.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Assert for successful testing of clean app for being bug-free
		WebElement finalmsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[1]/div/div"));
		System.out.println(finalmsg.getText());
		String finalactstring = ":) Wonderful!!!" + '\n' + '\n' + "No security bug has been found by Appvigil."  + '\n' + '\n' + "Please run the audit again after few days as we are adding vulnerabilities on daily basis.";
		Assert.assertEquals(finalmsg.getText(), finalactstring );
		Thread.sleep(1000);

	}

	/*
	 * @brief
	 * This test case loads buggy apk file to be scanned
	 */
	@Test(dependsOnMethods = {"test_childuserlogin","test_ChildscanCleanapk"})
	public void test_childmultiplescans() throws InterruptedException, AWTException
	{

		Actions action = new Actions(LaunchBrowserTest.driver);

		//Click on New Audit
		WebElement newaudit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[5]/a/span"));
		action.moveToElement(newaudit).click().build().perform();
		Thread.sleep(1000);

		// Get the element to be clicked to load the apk file
		WebElement loadapk = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/div/form/div[1]/label"));
		loadapk.click();
		Thread.sleep(1000);

		// Upload the buggy file adding the required path in StringSelection arguements
		StringSelection str = new StringSelection(LaunchBrowserTest.buggyapkpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		Robot robot = new Robot();
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);

		// Submit the pop up form
		WebElement submitform = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/div/form"));
		submitform.submit();
		Thread.sleep(1000);

		// Check for the message that the apk loading was successfully done
		WebElement checkmsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/form/div"));
		System.out.println(checkmsg.getText());
		String actualstring = "Your App has been uploaded successfully. You can start scanning now!";
		Assert.assertEquals(checkmsg.getText(), actualstring );

		// Scan for the apk file loaded
		WebElement scanapk = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/form/input"));
		action.moveToElement(scanapk).click().build().perform();
		Thread.sleep(1000);

		// Assert for message available while scanning the apk
		WebElement getscanmsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[1]/div/h5"));
		System.out.println(getscanmsg.getText());
		String actstring = "Please wait...we are using our magic wand on your android application. It might take few minutes. Please be patient.";
		Assert.assertEquals(getscanmsg.getText(), actstring );

		// Wait for 180 secs duration for the application to be loaded
		Thread.sleep(LaunchBrowserTest.timeout);
		LaunchBrowserTest.driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);


		// Click to start auditing the report
		WebElement auditrep = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[1]/div/p/a"));
		action.moveToElement(auditrep).click().build().perform();
		Thread.sleep(1000);

		/*// Download the required report
		WebElement downloadreport = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[1]/div[1]/a[2]"));
		action.moveToElement(downloadreport).click().build().perform();
		Thread.sleep(1000);*/

	}

	@Test(dependsOnMethods = {"test_childuserlogin","test_ChildscanCleanapk","test_childmultiplescans"})
	public void test_Elements() throws InterruptedException
	{

		// Check for 'Manage Users' Tab availablity in the home page
		String s = LaunchBrowserTest.driver.getPageSource();

		if( s.contains("Manage Users"))
		{
			System.out.println("Manage Users Tab is available for the child user");
		}
		else
		{
			System.out.println("Manage users Tab is not available for the child user");
		}

		Thread.sleep(1000);
	}

	// Logout child user 
	@Test(dependsOnMethods = {"test_childuserlogin","test_ChildscanCleanapk","test_childmultiplescans","test_Elements"})
	public void test_childlogout() throws InterruptedException
	{
		// Click on right hand corner to open a drop down menu 
		WebElement dropdown = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li/a/i"));
		dropdown.click();
		Thread.sleep(1000);

		// Click on right hand corner to open a drop down menu 
		WebElement logout = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li/ul/li[5]/a"));
		logout.click();
		Thread.sleep(1000);
	}


}
