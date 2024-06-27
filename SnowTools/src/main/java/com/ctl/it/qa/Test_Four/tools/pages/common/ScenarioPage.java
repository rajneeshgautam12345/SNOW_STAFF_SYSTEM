package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ScenarioPage extends SfaPage {
	@FindBy(xpath = "//a[@title = 'Home Tab - Selected']")
	public WebElementFacade tab_home;
	@FindBy(name = "opp3") // text oppty name field
	public WebElementFacade txt_accName;
	// @FindBy(id=("j_id0:quoteForm:relatedQuotesId:j_id37:j_id38")) //New Quote
	// starts here itv2
	@FindBy(xpath = "//h2[contains(.,'Opportunity Quotes')]/following::input[1]") // New Quote starts here e2e itv1
	public WebElementFacade btn_newquote;
	@FindBy(xpath = "//a[@data-label='Quotes']")
	public WebElementFacade tab_quote;
	@FindBy(xpath = "//button[@title='Edit Fully Executed Contract Attached']/lightning-primitive-icon/*[local-name()='svg']")
	public WebElementFacade btn_icon_for_Cust;
	// @FindBy(css = "input[name='quoteName']") //scenario list box Name
	// @FindBy(xpath = "//input[contains(@id,'mat-input-0')]")
	@FindBy(css = "input[name='quoteName']")
	// @FindBy(name = "quoteName")
	// scenario list box Name
	public WebElementFacade txt_quotename;
	@FindBy(css = "button:nth-of-type(2) > .mat-button-wrapper") // scenario save button
	public WebElementFacade btn_SM_save;
	@FindBy(xpath = "//*[@id=\"ScenarioDesc\"]") // Quote Desc
	public WebElementFacade txt_quotedesc;
	@FindBy(xpath = ("//*[@id=\"SaveButton\"]")) // Save Quote
	public WebElementFacade btn_savequote;
//	@FindBy(css = "#mat-select-value-1") // scenario currency drop down
//	public WebElementFacade ddl_currencyArrow;
	@FindBy(xpath = "//*[@name='currencyCode']/div/div/span/span") // scenario currency drop down
	public WebElementFacade currencyValue;
	// @FindBy(id=("mat-input-1")) //description text box
	@FindBy(xpath = "//*[@name='quoteDesc']")
	public WebElementFacade txt_description;
	// end of new
	@FindBy(id = ("SaveButton")) // description text box
	public WebElementFacade btn_save;
	@FindBy(css = (".btnEnable.advanceActionIcon.mat-focus-indicator.mat-raised-button.mat-button-base .mat-button-wrapper")) // description
																																// text
																																// box
	public WebElementFacade btn_add_new_product;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tab_home;
	}
}
