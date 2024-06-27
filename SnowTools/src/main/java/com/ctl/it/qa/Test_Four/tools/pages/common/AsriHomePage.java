//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import com.ctl.it.qa.Test_Four.tools.asripages.AsriPage;
//
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class AsriHomePage extends AsriPage {
//	@FindBy(xpath = "//div[@class='name' and contains(text(),'Home')]")
//	public WebElementFacade lbl_home;
//	// @FindBy(xpath = "//div[@id='2'and contains(text(),'Projects')]")
//	@FindBy(xpath = "(//div[contains(.,'Projects')])[3]")
//	public WebElementFacade lnk_project;
//	@FindBy(xpath = "//div[@id='more']")
//	public WebElementFacade lnk_more;
//	@FindBy(xpath = "//li[contains(.,'Circuit Editor')]")
//	public WebElementFacade lnk_CE;
//	@FindBy(xpath = "//input[contains(@placeholder,'Enter Circuit Name')]")
//	public WebElementFacade tbx_circuit_name;
//	@FindBy(xpath = "//a[contains(@id,'idt64')]")
//	public WebElementFacade lst_circuit_name_result;
//	@FindBy(xpath = "//span[@title='ProductsDailyStatistics']")
//	public WebElementFacade lbl_staticstic;
//
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return lbl_staticstic;
//	}
//}
