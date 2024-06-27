//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import com.ctl.it.qa.Test_Four.tools.asripages.AsriPage;
//
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class AsriUni2DevicePortPage extends AsriPage {
//	@FindBy(xpath = "//div[@class='assignToMeButton']")
//	public WebElementFacade btn_assign;
//	@FindBy(xpath = "//select[@id='selectedDevice']")
//	public WebElementFacade ddl_selectDevice;
//	@FindBy(xpath = "//label[contains(text(),' Building Location')]/following::input[1]")
//	public WebElementFacade lbl_location;
//	@FindBy(xpath = "//div[@class='mat-select-value']")
//	public WebElementFacade ddl_selectPort;
//	@FindBy(xpath = "//span[@class='mat-option-text' and contains(text(),'GigabitEthernet')]")
//	public WebElementFacade ddl_selectPortOption;
//	@FindBy(xpath = "//select[@id='uniExtension']")
//	public WebElementFacade ddl_selectUniExt;
//	@FindBy(xpath = "//select[@id='uniExtension']/option[contains(text(),'No')]")
//	public WebElementFacade ddl_selectUniExtOption;
//	@FindBy(xpath = "//span[contains(text(),'Topology')]/following::span[1]")
//	public WebElementFacade lbl_topology;
//
//	public WebElementFacade uni2Device(String location) {
//		WebElementFacade ddl_uni2Device = findBy("//option[contains(text(),'" + location + "W2002" + "')]");
//		return ddl_uni2Device;
//	}
//
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return btn_assign;
//	}
//}