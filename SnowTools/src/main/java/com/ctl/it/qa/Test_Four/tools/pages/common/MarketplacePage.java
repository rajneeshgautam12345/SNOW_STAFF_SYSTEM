package com.ctl.it.qa.Test_Four.tools.pages.common;

import java.util.List;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MarketplacePage extends SfaPage {
	@FindBy(xpath = "(//*[@id='businessAddressField'])[1]")
	public WebElementFacade locationAddress;
	@FindBy(xpath = "//li[text()='1025 ELDORADO BLVD BROOMFIELD CO 80021 LAB']")
	public WebElementFacade address;
	@FindBy(xpath = "//*[@class='btn btnStyle1 checkAvail']")
	public WebElementFacade checkAvailability;
	@FindBy(xpath = "//*[@class='locationStatusMsg']/div")
	public List<WebElementFacade> locationStatusMsg;
	@FindBy(id = "continue")
	public WebElementFacade addressContinue;
	public String ele1 = "//li/input[@value='";
	public String ele2 = "']";
	// li/input[@value='24']
	// li/input[@value='GIG-E']
	// li/input[@value='Flat Rate']
	// li/input[@value='1000 881.00']
	@FindBy(xpath = "//*[@class='btn btnStyle1 minWidth diaPrdConBtn']")
	public WebElementFacade productDetailsContinue;
	@FindBy(xpath = "//input[@value='Lumen Provided']")
	public WebElementFacade buildingExtensionYes;
	@FindBy(xpath = "//input[@value='Customer Provided']")
	public WebElementFacade buildingExtensionNo;
	@FindBy(xpath = "//*[@class='btn btnStyle1 minWidth diaBuildExtContBtn']")
	public WebElementFacade buildingExtensionContinue;
	@FindBy(xpath = "//input[@name='managed router' and @value='YES']")
	public WebElementFacade managedRouterYes;
	@FindBy(xpath = "//input[@name='managed router' and @value='NO']")
	public WebElementFacade managedRouterNo;
	@FindBy(xpath = "//*[@class='btn btnStyle1 minWidth manageRouterConBtn']")
	public WebElementFacade managedRouterContinue;
	@FindBy(xpath = "//div[@data-ordercontact-type='primary']//input[@id='first-name-control']")
	public WebElementFacade firstName;
	@FindBy(xpath = "//div[@data-ordercontact-type='primary']//input[@id='last-name-control']")
	public WebElementFacade lastName;
	@FindBy(xpath = "//div[@data-ordercontact-type='primary']//input[@id='mobile-number-control']")
	public WebElementFacade mobileNo;
	@FindBy(xpath = "//div[@data-ordercontact-type='primary']//input[@id='phone-number-control']")
	public WebElementFacade phoneNo;
	@FindBy(xpath = "//div[@data-ordercontact-type='primary']//input[@id='email-control']")
	public WebElementFacade email;
	@FindBy(xpath = "//*[@data-ordercontact-type='primary']//*[@for='contact-preference']/..//li/input")
	public List<WebElementFacade> contactPreference;
	@FindBy(xpath = "//div[@data-ordercontact-type='primary']//button[@class='btn btnStyle1 minWidth96 dashButton']")
	public WebElementFacade saveContact;
	@FindBy(xpath = "//button[@class='btn btnStyle1 minWidth nextBtn ordCntContBtn']")
	public WebElementFacade contactContinue;
	@FindBy(xpath = "//select[@name='firstDesignatorType']")
	public WebElementFacade floor;
	@FindBy(xpath = "//*[@name='firstDesignatorValue']/div/input")
	public WebElementFacade floorValue;
	@FindBy(xpath = "//select[@name='secondDesignatorType']")
	public WebElementFacade room;
	@FindBy(xpath = "//input[@name='secondDesignatorValue']")
	public WebElementFacade roomValue;
	@FindBy(xpath = "//button[@class='btn btnStyle1 minWidth nextBtn fiberCnfrmSrvcAddContBtn']")
	public WebElementFacade serviceAddressContinue;
	@FindBy(xpath = "//input[@id='service-sooner']")
	public WebElementFacade accept;
	@FindBy(xpath = "//button[@class='btn btnStyle1 instDateTimeContBtn']")
	public WebElementFacade continueToCheckout;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return continueToCheckout;
	}
}