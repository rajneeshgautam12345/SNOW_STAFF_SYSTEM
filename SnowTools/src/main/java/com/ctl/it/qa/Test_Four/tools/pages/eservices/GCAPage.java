package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class GCAPage extends Page {
	@FindBy(xpath = "//input[@id='RequestId']")
	public WebElementFacade tbx_request_id;
	@FindBy(xpath = "(//input[@type='submit'])[3]")
	public WebElementFacade btn_submit;
	@FindBy(xpath = "//a[@class='btn btn-sm btn-primary'][contains(.,'Details')]")
	public WebElementFacade btn_details;
	@FindBy(xpath = "//select[@id='OrderCreditResult']")
	public WebElementFacade ddl_order_result;
	@FindBy(xpath = "//input[@id='order-save-bttn']")
	public WebElementFacade btn_save;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_submit;
	}
}
