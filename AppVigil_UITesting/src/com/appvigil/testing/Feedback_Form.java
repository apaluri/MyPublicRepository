/**
 * 
 */
package com.appvigil.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Aditya
 *
 */
public class Feedback_Form 
{

	@Test
	public void test_InvalidNameField() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		LaunchBrowserTest.driver.get("http://appvigil.co/");

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[3]/div/input"));
		name.clear();
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[4]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		WebElement textarea = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[5]/div/textarea"));
		textarea.sendKeys("I love Appvigil.");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[6]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[7]/div/input"));
		submit.click();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[1]/a/ul/li"));
		String errormsg = "Please enter name";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	@Test(dependsOnMethods = {"test_InvalidNameField"})
	public void test_InvalidEmailidField() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[3]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[4]/div/input"));
		emailid.clear();
		Thread.sleep(1000);

		WebElement textarea = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[5]/div/textarea"));
		textarea.clear();
		textarea.sendKeys("I love Appvigil.");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[6]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[7]/div/input"));
		submit.click();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[1]/a/ul/li"));
		String errormsg = "Please enter an email address";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	@Test(dependsOnMethods = {"test_InvalidNameField","test_InvalidEmailidField"})
	public void test_InvalidMessageField() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[3]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[4]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		WebElement textarea = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[5]/div/textarea"));
		textarea.clear();
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[6]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[7]/div/input"));
		submit.click();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[1]/a/ul/li"));
		String errormsg = "Please enter a message";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	@Test(dependsOnMethods = {"test_InvalidNameField","test_InvalidEmailidField","test_InvalidMessageField"})
	public void test_InvalidCaptchaField() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[3]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[4]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		WebElement textarea = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[5]/div/textarea"));
		textarea.clear();
		textarea.sendKeys("I love Appvigil.");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[6]/div[1]/input"));
		captcha.clear();
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[7]/div/input"));
		submit.click();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[1]/a/ul/li"));
		String errormsg = "Please enter CAPTCHA";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}
	
	@Test(dependsOnMethods = {"test_InvalidNameField","test_InvalidEmailidField","test_InvalidMessageField","test_InvalidCaptchaField"})
	public void test_ValidCredentials() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );
		
		LaunchBrowserTest.driver.get("http://appvigil.co/");

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[3]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[4]/div/input"));
		emailid.clear();
		emailid.sendKeys("testuser@wegilant.com");
		Thread.sleep(1000);

		WebElement textarea = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[5]/div/textarea"));
		textarea.clear();
		textarea.sendKeys("I love Appvigil.");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[6]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[7]/div/input"));
		submit.click();
		Thread.sleep(1000);

		// Assert for Debug message caught
		WebElement debugmsg = (new WebDriverWait(LaunchBrowserTest.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[11]/form/div[2]/div[2]")));
		//	String rightmsg = "Link of your detailed audit report has been sent to your inbox";
		System.out.println(debugmsg.getText());
		String rightmsg = "Message has been sent successfully.";
		Assert.assertEquals(debugmsg.getText(), rightmsg);

		Thread.sleep(1000);

	}
	@Test(dependsOnMethods = {"test_InvalidNameField","test_InvalidEmailidField","test_InvalidMessageField","test_InvalidCaptchaField","test_ValidCredentials"})
	public void test_InvalidCredentials() throws InterruptedException
	{
		Actions action = new Actions( LaunchBrowserTest.driver );

		// Input Name of the user into the form
		WebElement name = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[3]/div/input"));
		name.clear();
		name.sendKeys("SeleniumTester");
		Thread.sleep(1000);

		// Enter email id into the form
		WebElement emailid = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[4]/div/input"));
		emailid.clear();
		emailid.sendKeys("testvigilapp@wegilant.com");
		Thread.sleep(1000);

		WebElement textarea = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[5]/div/textarea"));
		textarea.sendKeys("I love Appvigil.");
		Thread.sleep(1000);

		// Enter invalid captcha into the form
		WebElement captcha = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[6]/div[1]/input"));
		captcha.clear();
		captcha.sendKeys("1234");
		Thread.sleep(1000);

		// Submit the form
		WebElement submit = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[7]/div/input"));
		submit.click();
		Thread.sleep(1000);

		// Assert for the Invalid Captcha Error message caught
		WebElement errorcaptchamsg = LaunchBrowserTest.driver.findElement(By.xpath("html/body/div[11]/form/div[2]/div[2]"));
		String errormsg = "Error!!!" + '\n' + "Incorrect Captcha. Seems you are a Hacker!!!";
		System.out.println(errorcaptchamsg.getText());
		Assert.assertEquals(errorcaptchamsg.getText(), errormsg);
	}

	
}
