package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class EasePage extends SfaPage {
	
	@FindBy(xpath = "//*[text()='Go to Login Page']")
	public WebElementFacade goToLoginPage;
	@FindBy(xpath = "//input[@id='loginName']")
	public WebElementFacade username;
	
	@FindBy(xpath = "//select[@name='serviceRequestType']")
	public WebElementFacade module;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElementFacade password;
	@FindBy(xpath = "//a/img[@src='images/login.gif']")
	public WebElementFacade loginButton;
	
	@FindBy(xpath = "//div[@id='orderlistmenu']//th[@id='orderTab']")
	public WebElementFacade orderTab;
	
	@FindBy(xpath = "(//div[@id='menuItem49']/div[contains(text(),'Search')])[1]")
	public WebElementFacade search;
	
	@FindBy(xpath = "//input[@name='searchFor']")
	public WebElementFacade searchText;
	
	
	@FindBy(xpath = "//a/img[@src='images/search.gif']")
	public WebElementFacade searchButton;
	
	
	
	


	public WebElementFacade getUniqueElementInPage() {
		return loginButton;
	}
}
