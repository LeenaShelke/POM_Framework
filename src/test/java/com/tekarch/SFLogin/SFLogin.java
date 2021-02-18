package com.tekarch.SFLogin;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tekarch.poSFLogin.poSFLogin;
import com.tekarch.pologin.pologinTekApp;
import com.tekarch.utilities.TestBase;

public class SFLogin extends TestBase{
poSFLogin login;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeTest
	public void settingUpEnvironment() throws Exception {
		sErrorMessage = "";
		sClassNameForScreenShot = getClass().getSimpleName();
		driver.get(oCons.getSFAppURL());
		login = new poSFLogin(driver);
		login.checkLoggedIntoSFAppOrNotElseLogout();
		
	}
	/*
	 
	 */
	@AfterMethod
	public void settingReqURL() throws Exception {
		driver.get(oCons.getSFAppURL());
	}

	/*
	Precondetion - Test Steps : Expected condetion 
	 
	 */
	
	@Test(priority = 1)
	public void to_Check_Whether_Login_Happening_Or_Not() throws Exception {
		
		 login.loginToSFApp();
	}

	@Test(priority = 2)
	public void To_check_Error_For_Invalid_Login() throws Exception {
		login.invalidloginToSFApp();
		SoftAssert sa = new SoftAssert();
		
		sa.assertAll();
		}

}
