//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import com.ctl.it.qa.Test_Four.tools.asripages.AsriPage;
//
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class AsriProjectListPage extends AsriPage {
//	@FindBy(xpath = "//div[contains(text(),'External Order ID')]/following::div[@class='direction'][1]")
//	public WebElementFacade ddl_ExtOrderID;
//	@FindBy(xpath = "//div[@class='text-filter-control externalIdControl']/input")
//	public WebElementFacade tbx_ExtorderID;
//	// @FindBy(xpath = "//div[@class='project-name' and contains(@title,'Service
//	// Group')]")
//	@FindBy(xpath = "(//div[contains(@class,'project-name')])[3]")
//	public WebElementFacade lnk_serviceGp;
//	@FindBy(xpath = "//div[@class='project-name' and contains(@title,'Business Order')]")
//	public WebElementFacade lnk_business_order;
//	@FindBy(xpath = "//div[@class='refreshProjectList']")
//	public WebElementFacade lnk_refresh;
//	@FindBy(xpath = "//span[contains(@class,'displayed-projects')]")
//	public WebElementFacade lbl_project_number;
//
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return ddl_ExtOrderID;
//	}
//}
