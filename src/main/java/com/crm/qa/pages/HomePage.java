package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'User: Vineet srivastavas')]")
	WebElement userNameLabel;
	
	//Initializing Page Object
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateUserName(){
		String uname = userNameLabel.getText().trim();
		return uname;
	}
}
