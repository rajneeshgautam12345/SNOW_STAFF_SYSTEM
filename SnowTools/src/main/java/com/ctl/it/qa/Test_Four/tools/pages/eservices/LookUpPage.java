package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LookUpPage extends Page {
	// @FindBy(name="go")
	@FindBy(xpath = "//input[@name='go']")
	public WebElementFacade btn_go;
	@FindBy(xpath = "//input[@id='lksrch']")
	public WebElementFacade tbx_search;
	@FindBy(xpath = "//input[contains(@id,'ALL')][@name='lkenhmd']")
	public WebElementFacade rbn_all_fields;
	@FindBy(xpath = "(//a[@href='#'][contains(.,'Qwest Communications')])[1]")
	public WebElementFacade lnk_qwest;
	@FindBy(xpath = "//div[@class='pbBody']/table/tbody/tr[2]/th/a")
	public WebElementFacade lnk_first_result;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_go;
	}
}
