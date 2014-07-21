/**
 * 
 */
package com.appvigil.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.html.SubmittableElement;

/**
 * @author Aditya
 *
 */
public class Paid_Buggyuser 
{
	@Test
	public void test_paiduserlogin() throws InterruptedException
	{
		LaunchBrowserTest.driver.get("http://appvigil.co/my-account/login/");

		// Set Actions to do mouse hover equivalent mouse actions
		Actions action = new Actions(LaunchBrowserTest.driver);

		WebElement enterusername = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/form/div[1]/div/input"));
		enterusername.sendKeys("testuser.parent.with.child@wegilant.com");
		Thread.sleep(1000);

		WebElement password = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/form/div[2]/div/input"));
		password.sendKeys("12345678");
		Thread.sleep(1000);

		WebElement signin = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[2]/div/form/div[4]/div/input"));
		action.moveToElement(signin).click().build().perform();
		Thread.sleep(1000);

	}

	@Test(dependsOnMethods = {"test_paiduserlogin"})
	public void test_NewAuditBuggyapk() throws InterruptedException, AWTException
	{
		Actions action = new Actions(LaunchBrowserTest.driver);

		//Click on New Audit
		WebElement newaudit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[6]/a/span"));
		action.moveToElement(newaudit).click().build().perform();
		Thread.sleep(1000);

		// Get the element to be clicked to load the apk file
		WebElement loadapk = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/div/form/div[1]/label"));
		loadapk.click();

		// Upload the file adding the required path in StringSelection arguements
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

		WebElement submitform = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/div/form"));
		submitform.submit();
		Thread.sleep(1000);

		WebElement checkmsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/form/div"));
		System.out.println(checkmsg.getText());
		String actualstring = "Your App has been uploaded successfully. You can start scanning now!";
		Assert.assertEquals(checkmsg.getText(), actualstring );

		WebElement scanapk = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[2]/form/input"));
		action.moveToElement(scanapk).click().build().perform();
		Thread.sleep(1000);

		// Assert for message available while detecting security threats 
		WebElement getscanmsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[3]/div[1]/div/h5"));
		System.out.println(getscanmsg.getText());
		String actstring = "Please wait...we are using our magic wand on your android application. It might take few minutes. Please be patient.";
		Assert.assertEquals(getscanmsg.getText(), actstring );
		
		Thread.sleep(LaunchBrowserTest.timeout);
		LaunchBrowserTest.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
		// Click on dashboard
		WebElement dashboard = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[2]/a/span"));
		action.moveToElement(dashboard).click().build().perform();
		Thread.sleep(1000);
		
		// Click to get the detailed report
		WebElement getreport = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/div/h3/a"));
		action.moveToElement(getreport).click().build().perform();
		Thread.sleep(1000);

		// Check for Bugs tag
		WebElement bugfield = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/section/section[3]/table[1]/tbody/tr[1]/td[3]"));
		action.moveToElement(bugfield).click().build().perform();
		Thread.sleep(1000);

		// Check for the bug count
		WebElement bugcount = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/section/section[3]/table[1]/tbody/tr[2]/td[3]"));
		action.moveToElement(bugcount).click().build().perform();
		Thread.sleep(1000);

	}

	/*
	 * @brief
	 * This test case adds user through manage users tab available after post login for 
	 * a free user
	 */
	@Test(dependsOnMethods = { "test_paiduserlogin", "test_NewAuditBuggyapk"} )
	public void test_manageusers() throws InterruptedException
	{
		Actions action = new Actions(LaunchBrowserTest.driver);

		// Click on Manage Users
		WebElement clickmanageusers = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[3]/a"));
		action.moveToElement(clickmanageusers).click().build().perform();
		Thread.sleep(1000);

		// Click on Add Users
		WebElement adduser = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[2]/a"));
		action.moveToElement(adduser).click().build().perform();
		Thread.sleep(1000);

		/*		
		// Switch to popup
		String parentWindowHandle = LaunchBrowserTest.driver.getWindowHandle(); // save the current window handle.
		WebDriver popup = null;
		Iterator<String> windowIterator = (Iterator<String>) LaunchBrowserTest.driver.getWindowHandles();
		while(windowIterator.hasNext()) 
		{ 
			String windowHandle = windowIterator.next(); 
			popup = LaunchBrowserTest.driver.switchTo().window(windowHandle);

			if ( popup.getTitle().equals("Add User") )
			{
				break;
			}
		}
		 */

		// Mouse hover to the pop-up form to add user 
		WebElement hovertopopupform = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/form/div[2]"));
		action.moveToElement(hovertopopupform).click().build().perform();
		Thread.sleep(1000);

		// Add testuser.child@wegilant.com sub user
		WebElement subuseremail = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/form/div[2]/div/div[2]/div/input"));
		subuseremail.sendKeys("testuser.child@wegilant.com");
		Thread.sleep(1000);

		// Add name of the sub user
		WebElement subusername = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/form/div[2]/div/div[3]/div/input"));
		subusername.sendKeys("childuser");
		Thread.sleep(1000);

		// Add contact number of the sub user
		WebElement subusercontact = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/form/div[2]/div/div[4]/div/input"));
		subusercontact.sendKeys("1234567890");
		Thread.sleep(1000);

		// Click on submit form
		WebElement submitadduser = LaunchBrowserTest.driver.findElement(By.id("add_user_btn"));
		submitadduser.click();
		Thread.sleep(1000);

		// Assert for the error message as free user cannot add child/sub users
		WebElement geterrormsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/form/div[2]/div/div[1]/div"));
		String expected = "×" + '\n' + "User with email ID testuser.child@wegilant.com is already a registered subuser.";
		System.out.println(geterrormsg.getText());
		Assert.assertEquals(geterrormsg.getText(), expected );

		// Click on close to close the pop up window
		WebElement closepopup = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/form/div[3]/button"));
		closepopup.click();
		Thread.sleep(1000);
	}

	/*
	 * @brief
	 * This test case asserts for all the elements present on the web page
	 */
	@Test(dependsOnMethods = { "test_paiduserlogin", "test_NewAuditBuggyapk","test_manageusers"} )
	public void test_Elements() throws InterruptedException
	{

		WebElement dashboard = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[2]/div[1]/ul/li[2]/a/span"));
		String expected = "Dashboard";
		Assert.assertEquals(dashboard.getText(), expected );

		String s = LaunchBrowserTest.driver.getPageSource();

		if( s.contains("Manage Users"))
		{
			System.out.println("Manage Users Tab is available for the parent user");
		}
		else
		{
			System.out.println("Manage users Tab is not available for the parent user");
		}
	}

	// Logout parent user
	@Test(dependsOnMethods = { "test_paiduserlogin", "test_NewAuditBuggyapk","test_manageusers"} )
	public void test_logout() throws InterruptedException
	{
		// Click on right hand corner to open a drop down menu 
		WebElement dropdown = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li/a/i"));
		dropdown.click();
		Thread.sleep(1000);

		// Click on right hand corner to open a drop down menu 
		WebElement logout = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li/ul/li[4]/a"));
		logout.click();
		Thread.sleep(1000);
	}


}
