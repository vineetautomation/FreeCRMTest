package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtill;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtill testUtill;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		testUtill = new TestUtill();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,
				"Free CRM software in the cloud powers sales and customer service111");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		testUtill.switchToFrame("mainpanel");
		String username = homePage.validateUserName();
		Assert.assertEquals(username, "User: Vineet srivastavas");

	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException{
		if ( testResult.getStatus()== ITestResult.FAILURE) {
			System.out.println("A failure occured on this page, screenshot taken");
			TestUtill.takeScreenshotAtEndOfTest();	
		}
		driver.quit();
	}
}
