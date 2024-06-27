package com.ctl.it.qa.Test_Four.tools.pages.common;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class NetworkDesignerPage extends SfaPage {
	@FindBy(id = "loginNameTextField-inputEl") // user name
	public WebElementFacade ise_loginname;
	@FindBy(name = "password") // psw field
	public WebElementFacade ise_password;
	@FindBy(name = "quoteCustomerSearchField") // log on button
	public WebElementFacade txt_createquote;
	// @FindBy(id = "setclosebutton-1117-btnEl") // pop up x button to close it
	@FindBy(id = "setclosebutton-1118-btnInnerEl")
	public WebElementFacade btn_closex;
	@FindBy(id = "quoteSearchForCustomerButton-btnEl") // create quote button
	public WebElementFacade btn_createdquote;
	@FindBy(name = "quoteCustomerSearchField") // Quote Desc
	public WebElementFacade txt_quotedesc;
	@FindBy(xpath = ("(//span[contains(@role,'img')])[28]")) // Save Quote1
	public WebElementFacade btn_createquote;
	@FindBy(id = ("saveButton-btnEl")) // Save
	public WebElementFacade btn_save;
	@FindBy(id = ("designsave-btnIconEl")) // Save design
	public WebElementFacade btn_savedesign;
	@FindBy(xpath = "//span[@class='x-tab-inner x-tab-inner-center'][contains(.,'Details')]") // scenario currency drop
																								// down
	public WebElementFacade img_Details;
	@FindBy(xpath = "//li[@class='ci-msg event-with-key'][contains(.,'Single VRF: VRF ID must be changed from defaulted value.SE')]")
	public WebElementFacade img_firstvpn;
	@FindBy(xpath = "//img[contains(@class,'x-tool-img x-tool-close')]")
	public WebElementFacade img_proceedsave;
	@FindBy(xpath = "(//i[contains(@class,'fa fa-arrow-right color-data icon-fixed-width')])[1]") // description text
																									// box
	public WebElementFacade lnk_globalvpn1;
	@FindBy(xpath = "(//i[contains(@class,'fa fa-arrow-right color-data icon-fixed-width')])[2]")
	public WebElementFacade lnk_globalvpn2;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return img_Details;
	}
}