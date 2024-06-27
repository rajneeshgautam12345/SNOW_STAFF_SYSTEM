package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ISMPage extends Page {
	@FindBy(xpath = "//textarea[@id='textareafieldtooltip-1028-inputEl']")
	public WebElementFacade tbx_transaction_id;
	@FindBy(xpath = "//input[@id='combobox-1034-inputEl']")
	public WebElementFacade tbx_return_code;
	@FindBy(xpath = "(//li[@role='option'][contains(.,'All')])[2]")
	public WebElementFacade tbx_return_code_all;
	@FindBy(xpath = "//span[@id='btnSearch-btnInnerEl']")
	public WebElementFacade btn_search;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tbx_transaction_id;
	}
}
