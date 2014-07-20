/**
 * 
 */
package com.appvigil.testing;

import org.testng.annotations.AfterTest;

/**
 * 
 * @brief
 * This will close the instance of firefox browser launched
 * 
 * @author Aditya
 *
 */
public class CloseBrowserTest {

	@AfterTest
	public void test_CloseBrowser()
	{
		LaunchBrowserTest.driver.close();
	}
	
}
