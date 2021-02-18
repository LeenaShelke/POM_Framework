package com.xero.pobasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

import org.apache.log4j.Logger;

public class poLogin extends TestBase{

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public poLogin(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "(//main//input[@name='name'])[1]")
	WebElement ph_username;
	

}
