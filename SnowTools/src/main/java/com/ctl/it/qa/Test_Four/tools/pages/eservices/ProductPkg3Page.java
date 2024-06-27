package com.ctl.it.qa.Test_Four.tools.pages.eservices;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPkg3Page extends Page {
	@FindBy(xpath = "//a[contains(@title,'Home Tab')]")
	public WebElementFacade btn_home;
	@FindBy(xpath = "//*[contains(text(),'Product Group')]/following::td[1]//span[@unselectable='on' and @class='k-input']")
	public WebElementFacade lst_select_product_all;
	@FindBy(xpath = "//li[@class='k-item' and contains(text(),'E-Services')]")
	public WebElementFacade lst_select_e_service;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade lst_product;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'IP VPN Port and Access')]")
	public WebElementFacade lst_product_ipvpn;
	@FindBy(xpath = "(//li[@class='k-item' and text()='Dedicated Internet Access'])")
	public WebElementFacade lst_product_DIA;
	@FindBy(xpath = "//select[@id='Transport']")
	public WebElementFacade ddl_ipvpn_access;
	@FindBy(xpath = "//select[contains(@id,'CircuitType')]")
	public WebElementFacade ddl_DIA_bandwidth;
	@FindBy(xpath = "//select[contains(@id,'AccessSubBandwidth')]")
	public WebElementFacade ddl_DIA_sub_bandwidth;
	@FindBy(xpath = "//select[contains(@id,'PortType')]")
	public WebElementFacade ddl_DIA_billing;
	@FindBy(xpath = "//button[@id='btnfinish']")
	public WebElementFacade btn_DIA_finish;
	@FindBy(xpath = "//select[@id='InsideWiring']")
	public WebElementFacade ddl_ipvpn_building;
//	@FindBy(xpath = "//select[contains(@id,'MultiServiceSelection')]")
	@FindBy(xpath = "//*[contains(text(),'Multi Service')]/following-sibling::div/div/select")
	public WebElementFacade ddl_ipvpn_multiservice;
	@FindBy(xpath = "//button[@id='btnAttribContinue']")
	public WebElementFacade btn_ipvpn_continue;
	@FindBy(xpath = "//select[@id='nonPrimaryChildProds']")
	public WebElementFacade ddl_ipvpn_optional_router;
	@FindBy(xpath = "//button[@id='btnGridAddNew']")
	public WebElementFacade btn_ipvpn_router_add;
	@FindBy(xpath = "//select[@id='Manufacturer']")
	public WebElementFacade ddl_ipvpn_router_manufacturer;
	@FindBy(xpath = "//select[@id='Chassis']")
	public WebElementFacade ddl_ipvpn_router_chassis;
	@FindBy(xpath = "//button[@id='btnDialogSave']")
	public WebElementFacade btn_ipvpn_router_add_save;
	@FindBy(xpath = "//button[@id='btnAttribFinish']")
	public WebElementFacade btn_ipvpn_finish;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[2]")
	public WebElementFacade lst_product_re_entry;
//	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'UNI')])[1]")
//	public WebElementFacade lst_product_uni;
	@FindBy(xpath = "(//li[@class='k-item' and text()='UNI'])")
	public WebElementFacade lst_product_uni;
	// @FindBy(xpath = "//li[@data-offset-index='88']")
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Wholesale UNI')]")
	public WebElementFacade lst_product_wholesaleuni;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'E-LAN - EVC')])[2]")
	public WebElementFacade lst_product_ElanEvc;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'E-Line - EVC')]")
	public WebElementFacade lst_product_evc;
	@FindBy(xpath = "//li[@class='k-item k-state-selected k-state-focused' and contains(text(),'UNI')]")
	public WebElementFacade lst_select_product;
	@FindBy(xpath = "//button[contains(.,'New Product')]")
	public WebElementFacade btn_new_product;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade lst_bandwidth;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'1 Gbps')]")
	public WebElementFacade lst_bandwidth_1gbps;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_uni_type;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[6]")
	public WebElementFacade ddl_elan_uni_type;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_EVC_Class;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[6]")
	public WebElementFacade ddl_elan_EVC_Class;
	// @FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Transparent')]")
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Transparent')])[2]")
	public WebElementFacade ddl_uni_type_transparent;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_uni_class;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Multiplexed')])[2]")
	public WebElementFacade ddl_uni_type_multiplexed;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_evc_type;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[6]")
	public WebElementFacade ddl_elan_evc_type;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Basic')])[2]")
	public WebElementFacade ddl_evc_type_basic;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'EVP-LAN')])[3]")
	public WebElementFacade ddl_evc_type_EVP_LAN;
	// @FindBy(xpath = "//li[contains(@data-offset-index,'33')]")
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'E-Access - OVC')]")
	public WebElementFacade lst_product_eaccessovc;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'E-LAN - EVC Endpoint')]")
	public WebElementFacade lst_product_Elan_Evc_Endpoint;
	@FindBy(xpath = "(//li[contains(@data-offset-index,'32')])[9]")
	public WebElementFacade lst_product_eaccessovc_again;
	@FindBy(xpath = "(//li[contains(@data-offset-index,'30')])[6]")
	public WebElementFacade lst_product_any_other;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	// @FindBy(xpath = "(//span[@unselectable='on'][contains(.,'<Default> Extended
	// Delivery - To the Customer Suite (Level 3 Provided)')])[3]")
	public WebElementFacade lst_building;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Standard Delivery - To the MPoE (Customer Provided)')])[6]")
	public WebElementFacade lst_building_standard;
	@FindBy(xpath = "(//button[@class='sprite wiz-quick-save product-ok-button wiz-butt-margin wiz_quick_save_active'])[3]")
	public WebElementFacade btn_quick_save;
	@FindBy(xpath = "(//li[contains(.,'1 Gbps')])[9]")
	public WebElementFacade btn_bandwidth_1gbps;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_add_1;
	@FindBy(xpath = "(//li[contains(text(),'1525') and @class='k-item k-state-hover']")
	public WebElementFacade ddl_select_add_1;
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-arrow-60-down')])[6]")
	public WebElementFacade ddl_a_loc;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[5]")
	public WebElementFacade ddl_a_loc_ELAN;
	@FindBy(xpath = "(//span[contains(.,'Inventory')])[1]")
	public WebElementFacade btn_a_loc_inventory;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'Scenario')])[5]")
	public WebElementFacade btn_z_loc_scenario;
	@FindBy(xpath = "(//span[@class='k-icon k-i-close'])[1]")
	public WebElementFacade btn_a_loc_inventory_close;
	@FindBy(xpath = "(//button[@data-bind='click: CancelProduct'])[1]")
	public WebElementFacade btn_cancel_package;
	@FindBy(xpath = "(//input[contains(@name,'relALoc_UNI_radio')])[1]")
	public WebElementFacade rbn_add_1;

	// @FindBy(xpath = "//input[@name='relCloud_Access_Point_radio' and
	// @value='442229660']") //for ENNI Building CLLI:LTTNCOML
	// @FindBy(xpath = "//input[@name='relCloud_Access_Point_radio' and
	// @value='442224465']") // for closed ENNI for Network Billing env4
	// @FindBy(xpath = "//input[@name='relCloud_Access_Point_radio' and
	// @value='442302036']")
	// @FindBy(xpath = "//input[@name='relCloud_Access_Point_radio' and
	// @value='442305977']")
	// @FindBy(xpath = "//input[@name='relCloud_Access_Point_radio' and
	// @value='442305980']")
	// @FindBy(xpath = "//input[@name='relCloud_Access_Point_radio' and
	// @value='440349409']")
	public WebElementFacade ENNI(String ENNI) {
		WebElementFacade ENNI1 = findBy("//input[@name='relCloud_Access_Point_radio' and @value='" + ENNI + "']");
		return ENNI1;
	}

	@FindBy(xpath = "(//input[contains(@name,'relELAN_EVC_radio')])[1]")
	public WebElementFacade rbn_elan;
	@FindBy(xpath = "//input[contains(@data-gpid,'1835519')]")
	public WebElementFacade rbn_add_1_qwest; // for closed ENNI for Qwest account
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-arrow-60-down')])[7]")
	// @FindBy(xpath = "(//span[contains(@class,'k-input')])[7]") //for env 2
	public WebElementFacade ddl_z_loc;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[6]")
	public WebElementFacade ddl_z_loc_elan;
	@FindBy(xpath = "//input[@value='CNP_ZLocUNI']")
	// @FindBy(xpath = "(//input[contains(@name,'radio')])[13]")
	public WebElementFacade rbn_add_2;
	@FindBy(xpath = "(//input[@name='relZLoc_UNI_radio'])[1]")
	public WebElementFacade rbn_add_z;

	public WebElementFacade UNI(String existing_uni) {
		WebElementFacade UNI = findBy("//input[@name='relZLoc_UNI_radio' and @value ='" + existing_uni + "']");
		return UNI;
	}

	public WebElementFacade UNI1(String existing_uni1) {
		WebElementFacade UNI1 = findBy("//input[@name='relZLoc_UNI_radio' and @value ='" + existing_uni1 + "']");
		return UNI1;
	}

	public WebElementFacade UNI2(String existing_uni2) {
		WebElementFacade UNI2 = findBy("//input[@name='relZLoc_UNI_radio' and @value ='" + existing_uni2 + "']");
		return UNI2;
	}

	@FindBy(xpath = "(//input[@name='relCustomer_Access_Point_radio'])[1]")
	public WebElementFacade rbn_add_2_2; // for wholesale UNI
	@FindBy(xpath = "//input[@value='CNP_UNI']")
	public WebElementFacade rbn_elan_uni;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade lst_evc;
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[8]")
	public WebElementFacade ddl_span_type;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_ovc;
	// @FindBy(xpath = "(//li[@tabindex='-1'])[813]")
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'EPL')])[3]")
	public WebElementFacade lst_evc_epl;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Access-EVPL')])[3]")
	public WebElementFacade ddl_ovc_evpl;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_bandwidth_10;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_class_evc;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'10 Mbps')])[2]")
	public WebElementFacade ddl_bandwidth_10_mbps;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'10 Mbps')])[4]")
	public WebElementFacade ddl_ovc_bandwidth_10_mbps;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'Dedicated')])[3]")
	public WebElementFacade ddl_ovc_class;
	// @FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	@FindBy(xpath = "(//span[@class='k-icon k-i-arrow-60-down'])[10]")
	public WebElementFacade ddl_ovc_class_2;
	@FindBy(xpath = "(//li[@tabindex='-1'][contains(.,'Basic')])[6]")
	public WebElementFacade ddl_ovc_class_basic;
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_building_z_evc;
	@FindBy(xpath = "(//span[contains(.,'Inventory')])[2]")
	public WebElementFacade btn_existing_uni_inventory;
	// @FindBy(xpath = "(//span[contains(@class,'k-icon k-i-arrow-60-down')])[27]")
	// // for env 1
	@FindBy(xpath = "(//span[contains(.,'- Select -')])[3]")
	public WebElementFacade ddl_building_z;
	@FindBy(xpath = "(//li[@tabindex='-1'])[1723]")
	public WebElementFacade ddl_building_z_standard;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_home;
	}
}
