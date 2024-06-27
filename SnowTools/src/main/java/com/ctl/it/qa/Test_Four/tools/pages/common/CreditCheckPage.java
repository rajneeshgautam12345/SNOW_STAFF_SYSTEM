package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreditCheckPage extends SfaPage {
	@FindBy(xpath = "//input[contains(@id,'RequestId')]") // request txt box
	public WebElementFacade txt_requestid;
	@FindBy(xpath = "(//input[contains(@type,'submit')])[3]") // search button
	public WebElementFacade btn_search;
	@FindBy(xpath = "//a[@class='btn btn-sm btn-primary'][contains(.,'Details')]") // detail button
	public WebElementFacade btn_details;
	@FindBy(xpath = "//select[contains(@id,'OrderCreditResult')]") // drop down for order results to apporve
	public WebElementFacade ddl_order_results;
	@FindBy(xpath = "//input[contains(@id,'order-save-bttn')]")
	public WebElementFacade btn_savechanges;
	@FindBy(xpath = "//textarea[contains(@id,'Comment')]")
	public WebElementFacade txt_comments;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return txt_requestid;
	}
}