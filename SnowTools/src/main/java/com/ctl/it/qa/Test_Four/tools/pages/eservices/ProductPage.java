package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends Page {
//	@FindBy(xpath = "//span[contains(.,'Add New Product')]")
	@FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Add New Product')]")
	public WebElementFacade btn_new_product_pkg;
//	@FindBy(xpath = "//button[@class='discounting-button']")
//	public WebElementFacade btn_discount_profitability; 
//	@FindBy(xpath = "//span[contains(.,'Discount & Profit')]")
//	public WebElementFacade btn_discount_profitability;
	@FindBy(xpath = "//div[@class='mat-tab-label-content'][contains(.,'Discounting & Profitability')]")
	public WebElementFacade btn_discount_profitability;
	@FindBy(xpath = "//button[contains(.,'Save Changes')]")
	public WebElementFacade btn_save;
	@FindBy(xpath = "//a[contains(@id,'scenarioDetailHomeLink')]")
	public WebElementFacade lnk_return;
	@FindBy(xpath = "//td[contains(.,'Opportunity ID')]")
	public WebElementFacade btn_opportunity_number;
	@FindBy(xpath = "//a[contains(.,'<< Back')]")
	public WebElementFacade lnk_back;
	@FindBy(xpath = "//a[@title='Opportunities Tab - Selected']")
	public WebElementFacade btn_return_to_opportunity;
	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	public WebElementFacade cbx_box_3;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_new_product_pkg;
	}
}
