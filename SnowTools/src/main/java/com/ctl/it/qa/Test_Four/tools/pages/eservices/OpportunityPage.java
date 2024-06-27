package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class OpportunityPage extends Page {
	@FindBy(xpath = "(//input[contains(@value,'Add Global Attachment')])[1]")
	public WebElementFacade btn_global_attachment;
	@FindBy(xpath = "//input[contains(@value,' New ')]")
	public WebElementFacade btn_new;
	@FindBy(xpath = "//input[@id='phSearchInput']")
	public WebElementFacade tbx_global_search;
	@FindBy(xpath = "(//a[@data-seclke='Opportunity'])[2]")
	public WebElementFacade lnk_first_result;
	@FindBy(xpath = "(//a[@href='/0060U00000HtIjO'])[2]")
	public WebElementFacade lnk_recent_opportunity;
	@FindBy(xpath = "//input[@id='secondSearchButton']")
	public WebElementFacade btn_search;
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElementFacade btn_continue;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_new;
	}
}
