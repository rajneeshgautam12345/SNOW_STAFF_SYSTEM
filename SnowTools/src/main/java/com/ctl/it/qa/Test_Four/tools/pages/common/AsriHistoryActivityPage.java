//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import com.ctl.it.qa.Test_Four.tools.asripages.AsriPage;
//
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class AsriHistoryActivityPage extends AsriPage {
//	@FindBy(xpath = "//div[contains(text(),'Hierarchy')]")
//	public WebElementFacade lnk_hierarchy;
//	@FindBy(xpath = "//a[contains(@title,'MP EVC Service Order-ELAN')]")
//	public WebElementFacade lnk_MP_EVC_Service_Order;
//	@FindBy(xpath = "//a[@class='activityName' and contains(@title,'Technical Data Gathering')]")
//	public WebElementFacade lnk_TDG;
//	@FindBy(xpath = "//div[@class='refreshButtonIcon']")
//	public WebElementFacade lnk_TDG_refresh;
//	@FindBy(xpath = "//a[contains(@title,'Device and Port Selection')]")
//	public WebElementFacade lnk_designAndPortLink;
//	@FindBy(xpath = "//a[contains(@title,'Verify Design')]")
//	public WebElementFacade lnk_VerifyDesignlink;
//	@FindBy(xpath = "//button[contains(@id,'gtWizardSaveButton')]")
//	public WebElementFacade lnk_update_service_information;
//	@FindBy(xpath = "//button[@id='gtWizardCompleteButton']")
//	public WebElementFacade lnk_complete_verify_design;
//	@FindBy(xpath = "//a[@class='activityName' and contains(@title,'TDG Complete')]")
//	public WebElementFacade lbl_TDGComplete;
//	@FindBy(xpath = "//a[@class='activityName' and @title='Service Design Completed']")
//	public WebElementFacade lbl_devicePortComplete;
//	@FindBy(xpath = "//div[contains(text(),'Activity Name')]/following::a[contains(text(),'Activate')]")
//	public WebElementFacade lbl_statusactive;
//
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return lnk_hierarchy;
//	}
//}
