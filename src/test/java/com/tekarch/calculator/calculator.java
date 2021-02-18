package com.tekarch.calculator;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tekarch.pocalculator.pocalculator;
import com.tekarch.pohome.pohome;
import com.tekarch.pologin.pologinTekApp;
import com.tekarch.utilities.TestBase;

public class calculator extends TestBase{

	

	pologinTekApp login;
	pohome home;
	pocalculator cal;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeTest
	public void settingUpEnvironment() throws Exception {
		sErrorMessage = "";
		sClassNameForScreenShot = getClass().getSimpleName();
		driver.get(oCons.getTekAppURL());
		login = new pologinTekApp(driver);
		home = new pohome(driver);
		cal = new pocalculator(driver);
		login.checkLoggedIntoTekAppOrNotElseLogin();
		home.navigateToCalculator();
	}

	@AfterMethod
	public void settingReqURL() throws Exception {
		driver.get(oCons.getTekAppURL());
		home.navigateToCalculator();
	}

	@Test(priority = 1)
	public void To_check_whether_ADDITION_is_Working_Fine_Or_Not() throws Exception {
		cal.calculateIt(12, 34, "add");
		}
	@Test(priority = 2)
	public void To_check_whether_SUBTRACTION_is_Working_Fine_Or_Not() throws Exception {
		
		cal.calculateIt(34, 12, "sub");
	}
	 	
	@Test(priority = 3)
	public void To_check_whether_MULTIPLICATION_is_Working_Fine_Or_Not() throws Exception {
		cal.calculateIt(12, 34, "mul");
		}
	@Test(priority = 4)
	public void To_check_whether_DIVISION_is_Working_Fine_Or_Not() throws Exception {
		cal.calculateIt(34, 12, "div");
		}
	@Test(priority = 5)
	public void To_check_whether_LOGOUT_is_Working_Fine_Or_Not() throws Exception {
		login.logoutOfTekApp();
		}
}
