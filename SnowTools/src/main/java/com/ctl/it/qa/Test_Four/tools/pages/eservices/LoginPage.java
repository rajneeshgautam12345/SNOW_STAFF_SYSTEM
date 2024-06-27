package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends Page {
//	@FindBy(xpath = "//span[contains(.,'LUMEN OAM SSO')]")
	@FindBy(xpath = "//*[@id=\"idp_section_buttons\"]/button/span")
	public WebElementFacade btn_OAM_SSO;
	@FindBy(xpath = "//*[@type=\"email\"]")
	public WebElementFacade tbx_email;
	@FindBy(xpath = "//input[contains(@name,'username')]")
	public WebElementFacade tbx_username;
	@FindBy(xpath = "//input[contains(@id,'password')]")
	public WebElementFacade tbx_password;
	@FindBy(xpath = "//input[contains(@type,'submit')]")
	public WebElementFacade btn_log_in;
	@FindBy(xpath = "//span[@class='photoContainer forceSocialPhoto']/div/span")
	public WebElementFacade img_profile;
	@FindBy(xpath = "//a[contains(.,'Switch to Salesforce Classic')]")
	public WebElementFacade lnk_back_to_classic;
	@FindBy(xpath = "//a[@href='/006/o'][contains(.,'Opportunities')]")
	public WebElementFacade btn_opportunities;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tbx_username;
	}
}
