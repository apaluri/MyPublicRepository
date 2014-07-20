/**
 * 
 */
package com.appvigil.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Aditya
 *
 */
public class Free_trial 
{

	@Test
	public void test_InvalidCredentials() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );
		
		LaunchBrowserTest.driver.get("http://appvigil.co/");
		
		Thread.sleep(1000);
		
		// Click on free trial link 
		WebElement clickfreetrial = LaunchBrowserTest.driver.findElement(By.xpath("html/body/nav/div/div[2]/ul/li[4]/a"));
		action.moveToElement(clickfreetrial).click().build().perform();
		Thread.sleep(1000);
		
		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[4]/div/input"));
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);
		
		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[5]/div/input"));
		phonenumber.sendKeys("1234567890");
		Thread.sleep(1000);
		
		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[6]/div/input"));
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);
		
		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[7]/div[1]/input"));
		captcha.sendKeys("1234");
		Thread.sleep(1000);
		
		// Submit the form
		WebElement submitbtn = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[8]/div/input"));
		action.moveToElement(submitbtn).click().build().perform();
		Thread.sleep(1000);
	
		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[3]"));
		String errormsg = "Error!!!" + '\n' + "Incorrect Captcha. Seems you are a Hacker!!!";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}
	
	@Test(dependsOnMethods = {"test_InvalidCredentials"})
	public void test_ValidCredentials() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );
				
		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[4]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);
		
		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[5]/div/input"));
		phonenumber.clear();
		phonenumber.sendKeys("1234567890");
		Thread.sleep(1000);
		
		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[6]/div/input"));
		emailid.clear();
		emailid.sendKeys("testuser@wegilant.com");
		Thread.sleep(1000);
		
		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);
		
		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[8]/div/input"));
		submit.click();
		Thread.sleep(1000);
	
		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[3]"));
	//	String rightmsg = "Link of your detailed audit report has been sent to your inbox";
		String rightmsg = "Oppss!" + '\n' +"Your email id has already been registered with us.";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), rightmsg);
	}

}
