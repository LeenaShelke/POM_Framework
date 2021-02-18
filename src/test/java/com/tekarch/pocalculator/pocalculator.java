package com.tekarch.pocalculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tekarch.utilities.TestBase;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class pocalculator extends TestBase{

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public pocalculator(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//form[@name='calculator']//input[@value=',,']")
	WebElement num_1;
	@FindBy(xpath = "//input[@value='2']")
	WebElement num_2;
	@FindBy(xpath = "//input[@value='3']")
	WebElement num_3;
	@FindBy(xpath = "//input[@value='4']")
	WebElement num_4;
	@FindBy(xpath = "//input[@value='5']")
	WebElement num_5;
	@FindBy(xpath = "//input[@value='6']")
	WebElement num_6;
	@FindBy(xpath = "//input[@value='7']")
	WebElement num_7;
	@FindBy(xpath = "//input[@value='8']")
	WebElement num_8;
	@FindBy(xpath = "//input[@value='9']")
	WebElement num_9;
	@FindBy(xpath = "//input[@value='0']")
	WebElement num_0;
	@FindBy(xpath = "//input[@value='+']")
	WebElement plus;
	@FindBy(xpath = "//input[@value='-']")
	WebElement minus;
	@FindBy(xpath = "//input[@value='x']")
	WebElement multiply;
	@FindBy(xpath = "//input[@value='/']")
	WebElement divide;
	@FindBy(xpath = "//input[@value='=']")
	WebElement equals;

	public boolean calculateIt(int value1, int value2, String sCalculationType) throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, divide, 5);
		
		char[] cArrValue1=  String.valueOf(value1).toCharArray();
		char[] cArrValue2=  String.valueOf(value2).toCharArray();
		switch (sCalculationType.toLowerCase()) {
		case "add":
			for(char in:cArrValue1)
				oBroUti.ufClick(getCalWebElement(in));
			oBroUti.ufClick(plus);
			for(char in:cArrValue2)
				oBroUti.ufClick(getCalWebElement(in));
			oBroUti.ufClick(equals);
			break;
		case "sub":
			for(char in:cArrValue1)
				oBroUti.ufClick(getCalWebElement(in));
			oBroUti.ufClick(minus);
			for(char in:cArrValue2)
				oBroUti.ufClick(getCalWebElement(in));
			oBroUti.ufClick(equals);
			break;
		case "mul":
			for(char in:cArrValue1)
				oBroUti.ufClick(getCalWebElement(in));
			oBroUti.ufClick(multiply);
			for(char in:cArrValue2)
				oBroUti.ufClick(getCalWebElement(in));
			oBroUti.ufClick(equals);
			break;
		case "div":
			for(char in:cArrValue1)
				oBroUti.ufClick(getCalWebElement(in));
			oBroUti.ufClick(divide);
			for(char in:cArrValue2)
				oBroUti.ufClick(getCalWebElement(in));
			oBroUti.ufClick(equals);
			break;
		
		default:
			log.error("Valid calculator type should be passed");
			break;
		}
		return bRes_Flag;
	}

	private WebElement getCalWebElement(char in) {
		HashMap<String,WebElement > map = new HashMap<String, WebElement>();
		map.put("1", num_1);map.put("2", num_2);map.put("3", num_3);map.put("4", num_4);
		map.put("5", num_5);map.put("6", num_6);map.put("7", num_7);map.put("8", num_8);
		map.put("9", num_9);map.put("0", num_0);
		log.info(map.get(Character.toString(in)));
		return map.get(Character.toString(in));
	}

}
