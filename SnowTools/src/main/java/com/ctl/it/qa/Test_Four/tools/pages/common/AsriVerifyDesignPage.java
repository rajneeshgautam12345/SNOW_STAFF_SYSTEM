//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import java.util.List;
//
//import com.ctl.it.qa.Test_Four.tools.asripages.AsriPage;
//
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class AsriVerifyDesignPage extends AsriPage {
//	@FindBy(xpath = "//button[@id='gtWizardCompleteButton']")
//	public WebElementFacade btn_EvcComplete;
//
//	public String getEVCStatus(int i) {
//		List<WebElementFacade> statuslist = findAll(
//				"//tr[contains(@class,'rowLevel4')]/td[@data-column-id='statusColumn']");
//		String EVCstatus = statuslist.get(i).getText();
//		System.out.println("EvcStatus " + i + " : " + EVCstatus);
//		return EVCstatus;
//	}
//
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return btn_EvcComplete;
//	}
//}
