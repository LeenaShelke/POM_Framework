package com.tekarch.pologin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;

public class pologinTekApp extends TestBase{

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public pologinTekApp(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='email_field']")
	WebElement ph_username;
	@FindBy(id="password_field")
	WebElement ph_password;
	@FindBy(xpath="//button[@onclick='login()']")
	WebElement button_loginToAccount;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement button_Home;
	
	public boolean loginToTekApp() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, ph_username, 5);
		oBroUti.ufSendKeys(ph_username, System.getProperty("td_emailId"));
		oBroUti.ufSendKeys(ph_password, System.getProperty("td_password"));
		oBroUti.ufClick(button_loginToAccount);
		oBroUti.waitForElementVisible(driver, button_Home, 5);
		if(oBroUti.isDisplayed(button_Home))
			bRes_Flag=true;
		return bRes_Flag;
	}
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement button_logout;
	
	public boolean logoutOfTekApp() throws Exception {
		boolean bRes_Flag=false;
		if(oBroUti.isDisplayed(button_logout))
			button_logout.click();
		bRes_Flag=true;
		return bRes_Flag;
	}
	public boolean checkLoggedIntoTekAppOrNotElseLogin() throws Exception{
		
		boolean bRes_Flag=false;
		try {
		oBroUti.waitForElementVisible(driver, button_Home, 3);
		}catch(Exception ea) {log.error("By passing error when we run on suite case");}
		if(!oBroUti.isDisplayed(button_Home))
			bRes_Flag=loginToTekApp();
			
		return bRes_Flag;
	}
	public boolean checkLoggedIntoTekAppOrNotElseLogout() throws Exception{
		boolean bRes_Flag=false;
		if(oBroUti.isDisplayed(button_Home))
			bRes_Flag=logoutOfTekApp();
			
		return bRes_Flag;
		
	}

	public boolean invalidloginToTekApp() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, ph_username, 5);
		oBroUti.ufSendKeys(ph_username, System.getProperty("td_invalid_emailId"));
		oBroUti.ufSendKeys(ph_password, System.getProperty("td_invalid_password"));
		oBroUti.ufClick(button_loginToAccount);
		log.info("****************************");
		Thread.sleep(2000);
		log.info(driver.switchTo().alert().getText());
		log.info("****************************");
		assertEquals(driver.switchTo().alert().getText(), "Error : There is no user record corresponding to this identifier. The user may have been deleted.", 
				"Expected: Error : There is no user record corresponding to this identifier. The user may have been deleted. \nActual: "+driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
			bRes_Flag=true;
		return bRes_Flag;
	}

}
