package com.tekarch.poSFLogin;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

public class poSFLogin extends TestBase {
	Logger log = Logger.getLogger(getClass().getSimpleName());

	public poSFLogin(WebDriver driver) throws InterruptedException {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement ph_username;
	@FindBy(xpath = "//input[@class='input r4 wide mb16 mt8 password']")
	WebElement ph_password;
	@FindBy(xpath="//input[@class='button r4 wide primary']")
	WebElement button_loginToAccount;
	@FindBy(xpath="//a[@title='Home Tab']")
	WebElement button_Home;
	
	public boolean loginToSFApp() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, ph_username, 5);
		oBroUti.ufSendKeys(ph_username, System.getProperty("td_SF_emailId"));
		oBroUti.ufSendKeys(ph_password, System.getProperty("td_SF_password"));
		oBroUti.ufClick(button_loginToAccount);
		oBroUti.waitForElementVisible(driver, button_Home, 5);
		if(oBroUti.isDisplayed(button_Home))
			bRes_Flag=true;
		return bRes_Flag;
	}
	@FindBy(xpath="//a[@title='Logout']")
	WebElement button_logout;
	
	public boolean logoutOfSFApp() throws Exception {
		boolean bRes_Flag=false;
		if(oBroUti.isDisplayed(button_logout))
			button_logout.click();
		bRes_Flag=true;
		return bRes_Flag;
	}
	public boolean checkLoggedIntoSFAppOrNotElseLogin() throws Exception{
		
		boolean bRes_Flag=false;
		try {
		oBroUti.waitForElementVisible(driver, button_Home, 3);
		}catch(Exception ea) {log.error("By passing error when we run on suite case");}
		if(!oBroUti.isDisplayed(button_Home))
			bRes_Flag=loginToSFApp();
			
		return bRes_Flag;
	}
	public boolean checkLoggedIntoSFAppOrNotElseLogout() throws Exception{
		boolean bRes_Flag=false;
		if(oBroUti.isDisplayed(button_Home))
			bRes_Flag=logoutOfSFApp();
			
		return bRes_Flag;
		
	}
	
	public boolean invalidloginToSFApp() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, ph_username, 5);
		oBroUti.ufSendKeys(ph_username, System.getProperty("td_invalid_SF_emailId"));
		oBroUti.ufSendKeys(ph_password, System.getProperty("td_invalid_SF_password"));
		oBroUti.ufClick(button_loginToAccount);
		log.info("****************************");
		Thread.sleep(2000);
		log.info(driver.findElement(By.xpath("//div[@id='error']")).getText());
		
		log.info("****************************");
		assertEquals(driver.findElement(By.xpath("//div[@id='error']")).getText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator."); 
				
		
		driver.findElement(By.xpath("//div[@id='error']")).getText();
			bRes_Flag=true;
		return bRes_Flag;
	}


}
