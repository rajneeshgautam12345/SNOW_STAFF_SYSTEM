package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPkgPage extends Page {
	@FindBy(xpath = "//b[contains(.,'Product Wizard')]")
	public WebElementFacade lnk_wizard;
	@FindBy(xpath = "//input[contains(@id,'siteAddressInput_value')]")
	public WebElementFacade tbx_address;
	@FindBy(xpath = "//input[@id='selectAllCheckBox']")
	public WebElementFacade cbx_box;
	@FindBy(xpath = "//img[@src='/Images/addEditServiceLocation.png']")
	public WebElementFacade btn_edit_location;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[4]")
	public WebElementFacade btn_edit_location_arrow;
	@FindBy(xpath = "(//button[@type='button'])[25]")
	public WebElementFacade btn_next;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElementFacade cbx_box_2;
	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	public WebElementFacade cbx_box_3;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lnk_wizard;
	}
}
