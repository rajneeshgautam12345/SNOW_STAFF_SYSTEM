//package com.ctl.it.qa.Test_Four.tools.steps.ASRI;
//
//import org.junit.Assert;
//import org.openqa.selenium.JavascriptExecutor;
//
//import com.ctl.it.qa.Test_Four.tools.asristeps.AsriStep;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHierarchyPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHistoryActivityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriTDGPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriUni1DevicePortPage;
//
//import net.serenitybdd.annotations.Step;
//
//@SuppressWarnings("serial")
//public class AsriUni1FlowStep extends AsriStep {
//	AsriTDGPage asriTDGPage;
//	AsriHistoryActivityPage asriHistoryActivityPage;
//	AsriHierarchyPage asriHierarchyPage;
//	AsriUni1DevicePortPage asriUni1DevicePortPage;
//
//	@Step
//	public void uni1Flow() {
//		System.out.println("************** Uni 1 function is started ************");
//		System.out.println("switched to parent frame");
//		asriHistoryActivityPage.lnk_hierarchy.click();
//		System.out.println("clicked on hierachy");
//		getserviceIconEnable(!asriHierarchyPage.ddl_iconUni1.isPresent(), asriHistoryActivityPage.lnk_hierarchy);
//		asriHierarchyPage.ddl_iconUni1.click();
//		waitABit(5000);
//		asriHierarchyPage.lnk_uniservicedesign.click();
//		customClickableWait(asriHistoryActivityPage.lnk_designAndPortLink);
//		asriHistoryActivityPage.lnk_designAndPortLink.click();
//		customClickableWait(asriTDGPage.btn_assign);
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", asriTDGPage.btn_assign);
//		asriTDGPage.btn_assign.click();
//		waitABit(20000);
//		getDriver().switchTo().frame(asriUni1DevicePortPage.frame_gtframe);
//		System.out.println("in the outer frame");
//		getDriver().switchTo().frame(asriUni1DevicePortPage.frame_customIframe);
//		System.out.println("swicted to inner frame ");
//		String location1 = asriUni1DevicePortPage.lbl_location.getText();
//		System.out.println("location is : " + location1);
//		customClickableWait(asriUni1DevicePortPage.ddl_selectDevice);
//		asriUni1DevicePortPage.ddl_selectDevice.click();
//		asriUni1DevicePortPage.uni1Device(location1).click();
//		System.out.println("uni1 device is selected");
//		customwaitforpageloading();
//		asriUni1DevicePortPage.ddl_selectPort.click();
//		asriUni1DevicePortPage.ddl_selectPortOption.click();
//		customwaitforpageloading();
//		String topo = asriUni1DevicePortPage.lbl_topology.getText();
//		System.out.println("topolog is :  " + topo);
//		Assert.assertEquals(true, topo.startsWith("N"));
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_save.click();
//		customwaitforpageloading();
//		getDriver().switchTo().frame(asriUni1DevicePortPage.frame_customIframe);
//		asriUni1DevicePortPage.ddl_selectUniExt.click();
//		asriUni1DevicePortPage.ddl_selectUniExtOption.click();
//		customwaitforpageloading();
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_save.click();
//		customwaitforpageloading();
//		asriTDGPage.btn_complete.click();
//		waitABit(120000);
//		System.out.println("UNI 1 is complted");
//		getDriver().switchTo().parentFrame();
//		System.out.println("After Uni 1 completion inside the 2frame");
//		System.out.println("********** Uni 1 function is completed *************");
//	}
//
//	@Step
//	public void validateUni1Status() {
//		Assert.assertEquals("Uni1 status validation", true,
//				asriHistoryActivityPage.lbl_devicePortComplete.containsText("Complete"));
//	}
//}