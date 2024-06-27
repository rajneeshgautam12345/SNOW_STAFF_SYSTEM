//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import com.ctl.it.qa.Test_Four.tools.asripages.AsriPage;
//
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class AsriHierarchyPage extends AsriPage {
//	@FindBy(xpath = "//div[contains(@class,'columnTitle statusColumn status resizingEnabled')]")
//	public WebElementFacade lbl_status;
//	@FindBy(xpath = "//tr[contains(@class,'rowLevel3 uxf-collection-lastItem')]//span[@data-cell='clickable']")
//	public WebElementFacade ddl_iconUni1;
//	@FindBy(xpath = "//tr[contains(@class,'rowLevel3 uxf-collection-lastItem')]/preceding::span[1]")
//	public WebElementFacade ddl_iconUni2;
//	@FindBy(xpath = "//tr[contains(@class,'rowLevel3 uxf-collection-lastItem')]/preceding::span[2]")
//	public WebElementFacade ddl_iconEVC;
//	@FindBy(xpath = "//a[contains(@title,'UNI Service Design')]")
//	public WebElementFacade lnk_uniservicedesign;
//	@FindBy(xpath = "//a[contains(@title,'EVC Service Order')]")
//	public WebElementFacade lnke_EVCtask;
//
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return lbl_status;
//	}
//}
