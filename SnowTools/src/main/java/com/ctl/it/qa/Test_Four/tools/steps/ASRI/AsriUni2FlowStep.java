//package com.ctl.it.qa.Test_Four.tools.steps.ASRI;
//
//import org.junit.Assert;
//import org.openqa.selenium.JavascriptExecutor;
//
//import com.ctl.it.qa.Test_Four.tools.asristeps.AsriStep;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHierarchyPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriHistoryActivityPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriTDGPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.AsriUni2DevicePortPage;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.annotations.findby.By;
//
//@SuppressWarnings("serial")
//public class AsriUni2FlowStep extends AsriStep {
//	AsriTDGPage asriTDGPage;
//	AsriHistoryActivityPage asriHistoryActivityPage;
//	AsriHierarchyPage asriHierarchyPage;
//	AsriUni2DevicePortPage asriUni2DevicePortPage;
//
//	@Step
//	public void uni2Flow() {
//		System.out.println("************* Uni 2 function is started ***********");
//		asriHistoryActivityPage.lnk_hierarchy.click();
//		System.out.println("clicked on hierachy");
//		getserviceIconEnable(!asriHierarchyPage.ddl_iconUni2.isPresent(), asriHistoryActivityPage.lnk_hierarchy);
//		asriHierarchyPage.ddl_iconUni2.click();
//		waitABit(5000);
//		asriHierarchyPage.lnk_uniservicedesign.click();
//		waitABit(10000);
//		asriHistoryActivityPage.lnk_designAndPortLink.click();
//		customClickableWait(asriTDGPage.btn_assign);
//		System.out.println("beforebassign click");
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", asriTDGPage.btn_assign);
//		asriTDGPage.btn_assign.click();
//		System.out.println("assigne button is clicked");
//		waitABit(20000);
//		getDriver().switchTo().frame(asriUni2DevicePortPage.frame_gtframe);
//		System.out.println("in the outer frame");
//		getDriver().switchTo().frame(asriUni2DevicePortPage.frame_customIframe);
//		System.out.println("swicted to inner frame ");
//		String location = asriUni2DevicePortPage.lbl_location.getText();
//		System.out.println("location is : " + location);
//		customClickableWait(asriUni2DevicePortPage.ddl_selectDevice);
//		asriUni2DevicePortPage.ddl_selectDevice.click();
//		asriUni2DevicePortPage.uni2Device(location).click();
//		System.out.println("uni2 device is selected");
//		customwaitforpageloading();
//		asriUni2DevicePortPage.ddl_selectPort.click();
//		asriUni2DevicePortPage.ddl_selectPortOption.click();
//		customwaitforpageloading();
//		String topo = asriUni2DevicePortPage.lbl_topology.getText();
//		System.out.println("topolog is :  " + topo);
//		Assert.assertEquals(true, topo.startsWith("N"));
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_save.click();
//		customwaitforpageloading();
//		getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@id='asri-app-custom-iframe']")));
//		asriUni2DevicePortPage.ddl_selectUniExt.click();
//		asriUni2DevicePortPage.ddl_selectUniExtOption.click();
//		customwaitforpageloading();
//		getDriver().switchTo().parentFrame();
//		asriTDGPage.btn_save.click();
//		customwaitforpageloading();
//		asriTDGPage.btn_complete.click();
//		waitABit(240000);
//		System.out.println("UNI 2 is complted");
//		getDriver().switchTo().parentFrame();
//		System.out.println("After Uni 2 completion inside the 2frame");
//		System.out.println("*********** Uni 2 function is completed ********");
//	}
//
//	@Step
//	public void validateUni2Status() {
//		Assert.assertEquals("Uni2 status validation", true,
//				asriHistoryActivityPage.lbl_devicePortComplete.containsText("Complete"));
//	}
//}