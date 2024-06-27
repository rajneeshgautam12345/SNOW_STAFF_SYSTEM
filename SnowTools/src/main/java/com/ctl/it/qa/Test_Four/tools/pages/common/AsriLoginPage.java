//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import com.ctl.it.qa.Test_Four.tools.asripages.AsriPage;
//
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class AsriLoginPage extends AsriPage {
//	@FindBy(xpath = "(//input[@type='text' and contains(@id,'view')])")
//	public WebElementFacade tbx_username;
//	@FindBy(xpath = "//input[@type='password' and contains(@id,'view')]")
//	public WebElementFacade tbx_password;
//	@FindBy(xpath = "//span[@class='ui-button-text' and contains(text(),'Login')]")
//	public WebElementFacade btn_login;
//
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return btn_login;
//	}
//}
