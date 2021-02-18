package com.tekarch.pohome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

import org.apache.log4j.Logger;

public class pohome extends TestBase{

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public pohome(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement button_Home;
	@FindBy(xpath="//a[contains(text(),'Calculator')]")
	WebElement tab_calculator;
	
	public boolean navigateToCalculator() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, button_Home, 5);
		oBroUti.ufClick(tab_calculator);
		bRes_Flag=true;
		return bRes_Flag;
	}

	
}
