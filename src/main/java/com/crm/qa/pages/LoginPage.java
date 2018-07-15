package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Crating Page Factory or Object Repository
	@FindBy(name="username11")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing page objects or elements of this Login page
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions Methods
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pass){
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage();
	}
	
	

}
