package com.tekarch.login;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tekarch.pologin.pologinTekApp;
import com.tekarch.utilities.TestBase;

public class loginTekApp extends TestBase{

	pologinTekApp login;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeTest
	public void settingUpEnvironment() throws Exception {
		sErrorMessage = "";
		sClassNameForScreenShot = getClass().getSimpleName();
		driver.get(oCons.getTekAppURL());
		login = new pologinTekApp(driver);
		login.checkLoggedIntoTekAppOrNotElseLogout();
		
	}
	/*
	 
	 */
	@AfterMethod
	public void settingReqURL() throws Exception {
		driver.get(oCons.getTekAppURL());
	}

	/*
	Precondetion - Test Steps : Expected condetion 
	 
	 */
	
	@Test(priority = 2)
	public void to_Check_Whether_Login_Happening_Or_Not() throws Exception {
		
		 login.loginToTekApp();
	}

	@Test(priority = 1)
	public void To_check_Error_For_Invalid_Login() throws Exception {
		login.invalidloginToTekApp();
		SoftAssert sa = new SoftAssert();
		
		sa.assertAll();
		}
	 	
}
