package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FlightDeckPage extends SfaPage {
	
	
	
	@FindBy(xpath = "//input[@name='email']")
	public WebElementFacade username;
	@FindBy(xpath = "//input[@name='password']")
	public WebElementFacade password;
	@FindBy(xpath = "//button[@class='login_btn']")
	public WebElementFacade loginButton;
	@FindBy(xpath = "(//div[@class='panel-title'])[1]") // _searchId
	public WebElementFacade basicMenuButton;
	@FindBy(xpath = "//a[@title='Advanced Search']") // _search button
	public WebElementFacade advanceSearch;
	@FindBy(xpath = "//*[@role='tablist']//div[text()='Advanced Search ']") // _search button
	public WebElementFacade advanceSearchHeader;
	@FindBy(xpath = "(//*[@type='checkbox'])[2]")
	public WebElementFacade excludeSysTaskCheckbox;
	@FindBy(xpath = "//*[@id='General Search Parameters-defaultLayout11']/..") // _search button
	public WebElementFacade orderIDSearch;
	@FindBy(xpath = "//button[@color='primary']/span[text()=' Search ']/..") // _search button
	public WebElementFacade searchButton;
	@FindBy(xpath = "//label[text()='Source Task ID']/../../span[2]/select")
	public WebElementFacade sourceTaskIdDropdown;
	@FindBy(xpath = "//input[@id='General Search Parameters-defaultLayout0']")
	public WebElementFacade sourceTaskISearchTextBox;

	// IntDataContainer dataCon = envData.getContainer("FDLoginPage");
//	CommonObjectsPage commonObjectsPage ;
//	@Step
//	public void logs_in_flightDeck() {
////		System.setProperty("Type.ID", userType);
////		String mytypeID = System.getProperty("Type.ID");
////		System.out.println("userType is  " + mytypeID); // end of getting user type id	
//		//commonObjectsPage.openAt(envData.getFieldValue("SESurl"));
//		//commonObjectsPage.openAt(url);
//		System.out.println(envData.getContainer("FDLoginPage").getFieldValue("FDUrl"));
//		commonObjectsPage.openAt(envData.getContainer("FDLoginPage").getFieldValue("FDUrl"));
//		
//		//flightDeck.openAt(envData.getContainer("FDLoginPage").getFieldValue("FDUrl"));
//		System.out.println("Url is entered");
//		getDriver().manage().window().maximize();
//		System.out.println("window is maximized");
//		//shouldExist(flightDeck, 90);
//		System.out.println("FlightDeck Page is exists");
//		username.waitUntilClickable().withTimeoutOf(90, TimeUnit.SECONDS);
//		username.sendKeys(dataCon.getFieldValue("tbx_username"));
//		waitABit(1000);
//		password.sendKeys(dataCon.getFieldValue("tbx_password"));
//		waitABit(1000);
//		loginButton.click();
//	}
	public WebElementFacade getUniqueElementInPage() {
		return sourceTaskISearchTextBox;
	}
}
