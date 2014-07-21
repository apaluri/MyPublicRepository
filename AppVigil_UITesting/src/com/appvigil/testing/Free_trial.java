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
	public void test_InvalidNameField() throws InterruptedException
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
		name.clear();
		Thread.sleep(1000);

		// Input phone number into the form
		WebElement phonenumber = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[5]/div/input"));
		phonenumber.clear();
		phonenumber.sendKeys("1234567890");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[6]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submitbtn = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[8]/div/input"));
		action.moveToElement(submitbtn).click().build().perform();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[2]/a/ul/li"));
		String errormsg = "Please enter name";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	@Test(dependsOnMethods = {"test_InvalidNameField"})
	public void test_InvalidContactField() throws InterruptedException
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
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[6]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submitbtn = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[8]/div/input"));
		action.moveToElement(submitbtn).click().build().perform();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[2]/a/ul/li"));
		String errormsg = "Please enter contact number";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	@Test(dependsOnMethods = {"test_InvalidNameField","test_InvalidContactField"})
	public void test_InvalidEmailidField() throws InterruptedException
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
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[7]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submitbtn = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[8]/div/input"));
		action.moveToElement(submitbtn).click().build().perform();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[2]/a/ul/li"));
		String errormsg = "Please enter an email address";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	@Test(dependsOnMethods = {"test_InvalidNameField","test_InvalidContactField","test_InvalidEmailidField"})
	public void test_InvalidCaptchaField() throws InterruptedException
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
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[7]/div[1]/input"));
		captcha.clear();
		Thread.sleep(1000);

		// Submit the form
		WebElement submitbtn = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[8]/div/input"));
		action.moveToElement(submitbtn).click().build().perform();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[2]/a/ul/li"));
		String errormsg = "Please enter CAPTCHA";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	@Test(dependsOnMethods = {"test_InvalidNameField","test_InvalidContactField","test_InvalidEmailidField","test_InvalidCaptchaField"})
	public void test_InvalidCredentials() throws InterruptedException
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
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div[7]/div[1]/input"));
		captcha.clear();
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

	@Test(dependsOnMethods = {"test_InvalidCredentials","test_InvalidNameField","test_InvalidContactField","test_InvalidEmailidField","test_InvalidCaptchaField"})
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
