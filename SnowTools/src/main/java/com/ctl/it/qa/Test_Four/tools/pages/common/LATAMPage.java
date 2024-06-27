package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LATAMPage extends SfaPage {
	@FindBy(xpath = "//a[@title = 'Home Tab - Selected']")
	public WebElementFacade tab_home;
	@FindBy(id = ("SL0002745723")) // Address 2 Check Box unique to address used
	public WebElementFacade cbox_mexico_location;
	@FindBy(id = ("SL0000416553")) // Address 2 Check Box unique to address used
	public WebElementFacade cbox_argentina_location;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tab_home;
	}
}