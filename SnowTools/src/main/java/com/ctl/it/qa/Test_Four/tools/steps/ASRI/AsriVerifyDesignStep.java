//package com.ctl.it.qa.Test_Four.tools.steps.ASRI;
//
//import org.junit.Assert;
//
//import com.ctl.it.qa.Test_Four.tools.asristeps.AsriStep;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHierarchyPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHistoryActivityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriTDGPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriVerifyDesignPage;
//
//import net.serenitybdd.annotations.Step;
//
//@SuppressWarnings("serial")
//public class AsriVerifyDesignStep extends AsriStep {
//	AsriTDGPage asriTDGPage;
//	AsriHistoryActivityPage asriHistoryActivityPage;
//	AsriHierarchyPage asriHierarchyPage;
//	AsriVerifyDesignPage asriVerifyDesignPage;
//
//	@Step
//	public void evcFlow() {
//		System.out.println("***************** evc function is started **********");
//		asriHistoryActivityPage.lnk_hierarchy.click();
//		getserviceIconEnable(!asriHierarchyPage.ddl_iconEVC.isPresent(), asriHistoryActivityPage.lnk_hierarchy);
//		asriHierarchyPage.ddl_iconEVC.click();
//		waitABit(20000);
//		String EVC1Status = asriVerifyDesignPage.getEVCStatus(0);
//		String EVC2Status = asriVerifyDesignPage.getEVCStatus(1);
//		String EVC3Status = asriVerifyDesignPage.getEVCStatus(2);
//		System.out.println("all starus validation starts");
//		Assert.assertEquals("EVC status validation : ", true, EVC1Status.contains("Completed")
//				&& EVC2Status.contains("Completed") && EVC3Status.contains("Completed"));
//		System.out.println("all starus validation completed");
//		System.out.println("before click on EVC task Link");
//		asriHierarchyPage.lnke_EVCtask.click();
//		customClickableWait(asriHistoryActivityPage.lnk_VerifyDesignlink);
//		asriHistoryActivityPage.lnk_VerifyDesignlink.click();
//		waitABit(20000);
//		getDriver().switchTo().frame(asriVerifyDesignPage.frame_gtframe);
//		System.out.println("in the frame");
//		asriTDGPage.btn_complete.click();
//		waitABit(120000);
//		System.out.println("EVC is complted");
//		getDriver().switchTo().parentFrame();
//		System.out.println("After EVC completion inside the 2frame");
//		System.out.println("********* evc function is completed *************");
//	}
//
//	@Step
//	public void validateVerifyDesignStatus() {
//		asriHistoryActivityPage.lnk_hierarchy.click();
//		asriHierarchyPage.lnke_EVCtask.click();
//		customClickableWait(asriHistoryActivityPage.lbl_devicePortComplete);
//		Assert.assertEquals("verify design status validation", true,
//				asriHistoryActivityPage.lbl_devicePortComplete.containsText("Activate"));
//		System.out.println("*****validation of final status done & test flow is successfully completed*****");
//	}
//}
