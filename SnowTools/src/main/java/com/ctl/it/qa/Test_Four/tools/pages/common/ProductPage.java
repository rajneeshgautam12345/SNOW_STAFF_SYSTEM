package com.ctl.it.qa.Test_Four.tools.pages.common;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends SfaPage {
	@FindBy(xpath = "//a[@title = 'Home Tab - Selected']")
	public WebElementFacade tab_home;
	@FindBy(xpath = ("//html/body/app-root/app-product-summary/div/app-quote-products/div[1]/div[1]/div[2]/button/span[1]")) // new
																																// //
																																// product
																																// //
																																// in
																																// //
																																// new
																																// /																															// gui
	public WebElementFacade btn_createpackage;
	@FindBy(xpath = "(//input[contains(@type,'checkbox')])[2]")
	public WebElementFacade ckb_first_location;
	@FindBy(id = ("countrySelect")) // Save Quote
	public WebElementFacade ddl_countrySelect;
	@FindBy(id = ("searchButton")) // Save Quote
	public WebElementFacade btn_search;
	// for adding a floor on the first floor international
	@FindBy(xpath = "//*[@id=\"specify-service-location\"]/div[2]/div[1]/input") // first floor for international
																					// location
	public WebElementFacade txt_first_location_international;
	// for adding a floor on the room location international
	@FindBy(xpath = "//*[@id=\"specify-service-location\"]/div[2]/div[2]/input") // first room for international
																					// location
	public WebElementFacade txt_room_location_international;
	// for save location international
	@FindBy(xpath = "//*[@id=\"specify-service-location\"]/div[3]/button[1]") // save for international location
	public WebElementFacade btn_save_international;
	// for adding a floor on the first location
	@FindBy(xpath = "//*[@id=\"LocationSearchGrid\"]/div[2]/table/tbody/tr/td[4]/div/img") // first icon for location
	public WebElementFacade img_first_location_icon;
	@FindBy(xpath = "//app-location-record/div/div[2]/div[2]/div[2]/span[1]")
	public WebElementFacade lst_first_location;
	// location
	
	@FindBy(xpath = "//div[@class='content-zone']/div[3]/span")
	public WebElementFacade networkStatus;
	@FindBy(xpath = "(//div[@class='codes']/a)[1]")
	public WebElementFacade floorAndRoomSelection;
	
	@FindBy(xpath = "(//div[@class='codes']/a)[3]")
	public WebElementFacade sceFloorAndRoomSelection;
	
	@FindBy(xpath = "//*[@aria-label='Service Location']")
	public WebElementFacade textServiceLocation;
	@FindBy(xpath = "//button[text()='Select']") // first icon for location
	public WebElementFacade submitFloor;
	@FindBy(xpath = "//*[@id=\"LocationSearchGrid\"]/div[2]/table/tbody/tr[2]/td[4]/div") // picking first location
	public WebElementFacade lst_secondfloor_location;
	@FindBy(id = ("resetButton")) // Reset Button
	public WebElementFacade btn_reset;
	@FindBy(id = ("lm-search-input"))
	public WebElementFacade txt_address;
	@FindBy(xpath = "//div[@id='cdk-overlay-0']")
	public WebElementFacade addressElement;
	
	@FindBy(id = ("cityInput")) // City Text Box
	public WebElementFacade txt_city;
	@FindBy(id = ("stateProvinceSelect")) // City Text Box
	public WebElementFacade lst_state;
	@FindBy(id = ("PL0000005093")) // Address 1 Check Box this are unique to address used
	public WebElementFacade cbox_address1;
	@FindBy(id = ("PL0000000826")) // Address 2 Check Box unique to address used
	public WebElementFacade cbox_address2;
	@FindBy(id = ("selectAllCheckBox")) // Address selectAllCheckBox Check Box
	public WebElementFacade cbox_selectAllCheckBox;
	@FindBy(css = "#ProductPackageWizardView > div:nth-child(1) > div:nth-child(5) > div:nth-child(2) > div:nth-child(3) > button") // Next
																																	// Button
	public WebElementFacade btn_next;
	@FindBy(xpath = "//span[text()='Proceed to Product Selection']")
	public WebElementFacade btn_proceedToProductselection;
	@FindBy(xpath = "//span[text()='Proceed']")
	public WebElementFacade btn_proceedToProductselectionjenkins;
	@FindBy(xpath = "//button[@style='text-align:center;height:24px'][contains(.,'New Product')]") // New Product Button
	public WebElementFacade btn_newproduct;
	@FindBy(xpath = "//*[@id=\"package-configuration\"]/div[2]/div[2]/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/div/span/span/span[1]") // Select
																																				// Product
	public WebElementFacade lst_evcproductdd;
	@FindBy(css = "#package-configuration > div:nth-child(2) > div.box-body > div > table > tbody > tr:nth-child(4) > td:nth-child(2) > table > tbody > tr > td:nth-child(1) > div > span > span > span.k-input") // Select
	public WebElementFacade productGroup;
	@FindBy(xpath = "//*[text()='Product Group:']")
	// itv1
	public WebElementFacade lst_productdd;
	@FindBy(xpath = "//*[@id=\"package-configuration\"]/div[2]/div[2]/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/div/span/span/span[2]/span") // e2e
	public WebElementFacade lst_productdd_e2e;
	@FindBy(xpath = "//*[@id=\"package-configuration\"]/div[2]/div[2]/div/table/tbody/tr[5]/td[2]/div/button")
	public WebElementFacade lst_product_new_product;
	@FindBy(xpath = "//li[(text()='Dedicated Internet Access')]") // Select Product from list //Select Product Dedicated
																	// Internet Access for e2e
	public WebElementFacade lst_productdd_DIA;
	@FindBy(xpath = "//li[(text()='Dedicated Internet Access')]") // Select Product from list //Select Product Dedicated
																	// Internet Access
	public WebElementFacade lst_itv_productdd_DIA;
	@FindBy(xpath = "//li[(text()='Internet')]") // Select Product Internet Access
	public WebElementFacade lst_internet;
	@FindBy(xpath = "//li[(text()='Private Line')]") // Select private line
	public WebElementFacade lst_private_line;
	@FindBy(xpath = "//li[(text()='Ethernet Private Line')]") // Select private line
	public WebElementFacade lst_ethernet_private_line;
	@FindBy(xpath = "//li[(text()='HSIP Ethernet Private Line')]") // Select private line
	public WebElementFacade lst_hsip_ethernet_private_line;
	@FindBy(xpath = "//li[(text()='Wavelength')]") // Select wavelength
	public WebElementFacade lst_wavelength;
	@FindBy(xpath = "//li[(text()='HSIP Wavelength')]") // Select wavelength
	public WebElementFacade lst_hsip_wavelength;
	@FindBy(xpath = "//li[(text()='UNI')]")
	public WebElementFacade lst_productvalue;
	@FindBy(xpath = "//*[@id=\"SelectProduct_listbox\"]/li[contains(., \"E-LAN - EVC Endpoint\")]") // Select Product
																									// from list
	public WebElementFacade lst_elan_evc_endpoint_productvalue;
	@FindBy(xpath = "//*[@id=\"SelectProduct_listbox\"]/li[40]") // Select evc ITV2 and itv1 env is 40 e2e is 41
	public WebElementFacade evc_productvalue;
	@FindBy(xpath = "//li[contains(., 'Transport - Entrance Facility')]") // Select Product from list
	public WebElementFacade lst_tef_productvalue;
	@FindBy(xpath = "//li[contains(., 'eLynk Interface')]") // Select Product from list
	public WebElementFacade lst_elynk_interface;
	@FindBy(xpath = "//*[@id='AttributeForm']/div[3]/div[2]/table/tbody/tr[3]/td[2]/div/span/span/span[1]") // Select
																											// Address
																											// list
	public WebElementFacade lst_classdd;
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-arrow-60-down')])[3]") // address 1
	public WebElementFacade lst_addressdd;
	@FindBy(xpath = "(//select[contains(@id,'ddlAddress')])[1]") // wavelenth_A_address 1
	public WebElementFacade ddl_wavelenth_A_address;
	@FindBy(xpath = "(//select[contains(@id,'ddlAddress')])[2]") // wavelenth_A_address 1
	public WebElementFacade ddl_wavelenth_Z_address;
	@FindBy(xpath = "//*[@id=\"Address1_listbox\"]/li[2]") // Select Address from list
	public WebElementFacade lst_address1value;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[1]/div[2]/table/tbody/tr[4]/td[2]/div/span/span/span[1]") // Select
	// list
	public WebElementFacade sec_addressdd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[23]/td[2]/div/span/span/span[2]") // bulilding
																												// //
																												// ext
	public WebElementFacade sdwan_buildingext;
	@FindBy(xpath = "//*[@id=\"Address2_listbox\"]/li[3]")
	public WebElementFacade sec_address1value;
	@FindBy(xpath = " //*[@id='AttributeForm']/div[3]/div[2]/table/tbody/tr[2]/td[2]/div/span/span/span[1]") // Select
																												// transport
																												// //
																												// list
	public WebElementFacade lst_tranport;
	// //Select UNI bandwidth list
	@FindBy(id = "PortBandwidth")
	public WebElementFacade lst_uniportbandwidth;
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-arrow-60-down')])[6]") // DestTypeASide
	public WebElementFacade DestTypeASide;
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-arrow-60-down')])[7]") // DestTypeASide
	public WebElementFacade A_Side_Data_Center;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[7]/td[2]/div/span/span/span[1]") // Select
																												// //
																												// UNI
																												// //
																												// bandwidth
																												// //
																												// list
	public WebElementFacade lst_router;
	@FindBy(xpath = "//*[@id=\"Port_Bandwidth_listbox\"]/li[contains(., \"100 Mbps\")]") // Select UNI bandwidth from
																							// list
	public WebElementFacade lst_uniportbandwidthvalue;
	// //Select UNI Type
	@FindBy(id = "UNIType") // Select UNI Type
	public WebElementFacade lst_unitypedd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[13]/td[2]/div/span/span/span[1]") // ALoc
	public WebElementFacade lst_aLoc;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[13]/td[2]/div/span/span/span[1]") // ALoc
																												// build
																												// ext
	public WebElementFacade lst_aLoc_build_extend;
	@FindBy(xpath = "//*[@id=\"UNI_Type_listbox\"]") // Select UNI Type from list
	public WebElementFacade lst_unitypevalue;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[7]/td[2]/div/span/span/span[1]") // Select
																												// building
																												// extension
	public WebElementFacade lst_buildingextensiondd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[5]/td[2]/div/span/span") // Select t
																										// building
																										// extension
	public WebElementFacade lst_buildingext_internet_dd;
	@FindBy(xpath = "//*[@id='AttributeForm']/div[3]/div[2]/table/tbody/tr[15]/td[2]/div/span/span/span[1]") // this
																												// itv2
	public WebElementFacade lst_buildingext_dia_dd; // itv2
	// //ITV1
	@FindBy(xpath = "//*[@id=\"Inside_Wiring_listbox\"]/li[2]") // Select building extension
	public WebElementFacade lst_buildingextensionvalue;
	// Configuration Next Button
	@FindBy(xpath = "//*[@id='ProductPackageWizardView']/div[1]/div[4]/div[2]/button")
	public WebElementFacade btn_prodconfignext;
	@FindBy(xpath = "//button[contains(@id,'btnAttribFinish')]") // Product Configuration Next Button
	public WebElementFacade btn_prodconfignext_1;
	@FindBy(xpath = "//*[@id=\"ProductPackageWizardView\"]/div[1]/div[5]/div[2]/div[3]/button") // Child Products Next
																								// Button
	public WebElementFacade btn_prodconfirmnext;
	@FindBy(xpath = "//*[@id=\"ProductPackageWizardView\"]/div[1]/div[5]/div[2]/div[4]/button") // Save Product Button
	public WebElementFacade btn_prodsave;
	// wavelengh deploy menu to get past it
	String srcVal = "assets\\image\\menu-icon.svg";
	@FindBy(xpath = "//div[@class='mat-slide-toggle-thumb']")
	public WebElementFacade btn_predeploy_toggle;
	@FindBy(xpath = "//span[normalize-space()='Add New Product']") // New Product Button
	public WebElementFacade btn_newproduct2;
	@FindBy(xpath = "//*[@id=\"selectAllCheckBox\"]") // Select Address from checkbox
	public WebElementFacade chk_addresses;
	@FindBy(xpath = "//li[contains(., \"E-Line - EVC\")]") // Select Product from list
	public WebElementFacade lst_productvalue2;
	@FindBy(xpath = "//li[contains(., \"eLynk - EVC\")]") // Select Product from list
	public WebElementFacade lst_eLynk;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[6]/td[2]/div/span/span/span[2]") // Select
																												// EVC
																												// Type
	public WebElementFacade lst_evctypedd;
	@FindBy(xpath = "//*[@id=\"EVC_Type_listbox\"]") // Select EVC Type from list
	public WebElementFacade lst_evctypevalue;
	// //Select bandwidth list
	@FindBy(xpath = "(//span[@unselectable='on'][contains(.,'- Select -')])[3]")
	public WebElementFacade lst_evcportbandwidth;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[2]/td[2]/div/span/span/span[1]") // Select
																												// bandwidth
																												// list
	public WebElementFacade lst_dia_bandwidth;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[2]/td[2]/div/span/span/span[2]/span") // Select
																													// bandwidth
																													// list
	public WebElementFacade lst_network_arrow;
	// new interface
	@FindBy(css = "#CircuitType") // Select bandwidth list
	public WebElementFacade lst_circuitType;
	
	@FindBy(id = "WaveBandwidth") // Select bandwidth list
	public WebElementFacade bandwidth;
	
	@FindBy(id = "AccessSubBandwidth") // Select bandwidth list
	public WebElementFacade access_sub_bandwith;
	
	@FindBy(id = "SolutionID") // Select bandwidth list
	public WebElementFacade accessSolution;
	@FindBy(xpath = "//select[@id='InsideWiring']")
	public WebElementFacade lst_insideWiring;
	
	@FindBy(xpath = "//select[@id='ALocInsideWiring']")
	public WebElementFacade lst_alocationInsideWiring;
	
	@FindBy(id = "MultipleLogicals") // Select bandwidth list
	public WebElementFacade multipleLogicals;
	@FindBy(id = "PDR") // Select PDR list
	public WebElementFacade pdr;
	@FindBy(id = "IncludeLumenDefender") // Select PDR list
	public WebElementFacade lumenDefender;
	
	@FindBy(id = "CDR") // Select CDR list
	public WebElementFacade cdr;
	@FindBy(id = "Term") // Select CDR list
	public WebElementFacade term;
	// ManagedService
	@FindBy(id = "nonPrimaryChildProds") // Select CDR list
	public WebElementFacade optionalProd;
	@FindBy(id = "btnGridAddNew") // Select CDR list
	public WebElementFacade addNew;
	@FindBy(id = "KitName") // Select CDR list
	public WebElementFacade kitName;
	@FindBy(id = "CPEProvider") // Select CDR list
	public WebElementFacade cpeProvider;
	@FindBy(id = "btnDialogSave") // Select CDR list
	public WebElementFacade saveButton;
	@FindBy(id = "Transport") // building extension
	public WebElementFacade lst_accesstype;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[7]/td[2]/div/span/span/span[1]") // Select
																												// billing
																												// method
																												// list
	public WebElementFacade lst_dia_billmethod;
	// ITV1
	@FindBy(xpath = "//*[@id='AttributeForm']/div[3]/div[2]/table/tbody/tr[3]/td[2]/div/span/span/span[2]") // Select
																											// bandwidth
																											// list
	public WebElementFacade lst_internetbandwidth;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[5]/td[2]/div/span/span/span[1]") // Select
																												// bandwidth
																												// //
																												// list
	public WebElementFacade lst_elan_bandwidth;
	@FindBy(css = "#PortType") // Select port type
	public WebElementFacade lst_port_type;
	@FindBy(xpath = "//*[@id=\"Bandwidth_listbox\"]/li[8]") // Select bandwidth from list
	public WebElementFacade lst_evcbandwidthvalue;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[6]/td[2]/div/span/span/span[2]/span")
	public WebElementFacade lst_evcclass;
	@FindBy(xpath = "//*[@id='AttributeForm']/div[3]/div[2]/table/tbody/tr[10]/td[2]/div/span/span/span[1]") // Select
																												// Linear
																												// Diverse
																												// from
																												// list
	public WebElementFacade lst_linear_diverse; // Select Linear Diverse from list
	@FindBy(xpath = " //*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[8]/td[2]/div/span/span") // Discounting
																										// Button
	public WebElementFacade ddl_pickclass;
	@FindBy(xpath = "(//*[@aria-posinset='3'])[1]") // Discounting Button
	public WebElementFacade button_discounting;
	@FindBy(xpath = "//*[@id='mat-tab-label-0-2']/div") // Discounting Button
	public WebElementFacade btn_discounting;
	// Save Button
	@FindBy(xpath = "//span[contains(.,'Save & Finish')]") // Discounting Save Button
	public WebElementFacade btn_discountingsave;
	@FindBy(xpath = "//span[contains(.,' Approve Pricing ')]") // approve pricing Button
	public WebElementFacade btn_approve_pricing;
	@FindBy(xpath = "//*[@id='profit-toolbar-right']/button[2]") // populate_pricing
	public WebElementFacade btn_populate_pricing;
	@FindBy(xpath = "//*[@id='ProductPackageWizardView']/div[1]/div[4]/div[3]/button") // quick Save Button
	public WebElementFacade btn_quicksave;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relUNI\"]/span/span/span[1]") // relUNI
	public WebElementFacade lst_elan_uni;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relNetwork\"]/span/span/span[1]") // relNetwork
	public WebElementFacade lst_relNetwork;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relService\"]/span/span/span[2]") // relNetwork
	public WebElementFacade lst_relService;
	@FindBy(name = "relUNI_radio") // relUNI_radio Button
	public WebElementFacade rdo_elan_uni;
	@FindBy(name = "relNetwork_radio") // relNetwork_radio_radio Button
	public WebElementFacade rdo_relNetwork_radio;
	@FindBy(name = "relPort_radio") // rdo_relPort_radioadio Button
	public WebElementFacade rdo_relPort_radio;
	@FindBy(name = "relBilling_Arrangement_radio") // relBilling_Arrangement_radio Button
	public WebElementFacade rdo_relBilling_Arrangement_radio;
	@FindBy(name = "relCloud_Access_Point_radio") // relCloud_Access_Point_radio
	public WebElementFacade rdo_relCloud_Access_Point_radio;
	@FindBy(name = "relCustomer_Access_Point_radio") // relCustomer_Access_Point_radioo
	public WebElementFacade rdo_relCustomer_Access_Point_radio;
	@FindBy(name = "relALoc_UNI_radio") // relALoc_UNI_radio
	public WebElementFacade rdo_relALoc_UNI_radio;
	@FindBy(name = "relZLoc_UNI_radio") // relZLoc_UNI_radio;
	public WebElementFacade relZLoc_UNI_radio;
	@FindBy(name = "relELAN_EVC_radio") // btn_relELAN_EVC_radio;
	public WebElementFacade btn_relELAN_EVC_radio;
	@FindBy(name = "relUNI_radio") // relCustomer_Access_Point_radioo
	public WebElementFacade btn_relUNI_radio;
	@FindBy(name = "relService_radio") // relService_radio
	public WebElementFacade btn_relService_radio;
	// *[@id="AttributeForm"]/div[3]/div[2]/table/tbody/tr[7]/td[2]/div/span/span/span[1]
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[8]/td[2]/div/span") // Select A loc
	public WebElementFacade lst_loc_A_dd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[9]/td[2]/div/span/span/span[1]") // Select
																												// A loc
	public WebElementFacade lst_ethernet_loc_A_dd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[9]/td[2]/div/span/span/span[1]") // Select
																												// A Loc
																												// wavelength
	public WebElementFacade lst_loc_A_waveLength_dd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[16]/td[2]/div/span/span") // Select z loc
	public WebElementFacade lst_loc_Z_dd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[17]/td[2]/div/span/span/span[1]") // Select
																												// ProductA
																												// Loc
																												// wavelength
	public WebElementFacade lst_loc_Z_wavelength_dd;
	@FindBy(xpath = "//select[contains(@id,'ALocInsideWiring')]")
	public WebElementFacade lst_loc_A_wiring;
	@FindBy(id = "WaveBandwidth")
	public WebElementFacade lst_WaveBandwidth;
	@FindBy(id = "ZLocInsideWiring")
	public WebElementFacade lst_ZLocInsideWiring;
	@FindBy(xpath = "//select[contains(@id,'ZLocInsideWiring')]")
	public WebElementFacade lst_loc_Z_wiring;
	@FindBy(id = "CustomRoute")
	public WebElementFacade lst_CustomRoute;
	@FindBy(id = "Term")
	public WebElementFacade lst_Term;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[1]/td[2]/div/span/span/span[1]") // Select
																												// Network
																												// Status
	public WebElementFacade ddl_network_status;
	@FindBy(xpath = "//*[@id=\"Network_Status_listbox\"]/li[2]") // Select Network Status
	public WebElementFacade lst_off_net;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[8]/td[2]/div/span/span") // Select evc list
	public WebElementFacade ddl_evetype;
	@FindBy(xpath = "//*[@id=\"EVC_Class_listbox\"]/li[1]") // Select Network Status
	public WebElementFacade lst_evctype_off_net;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[11]/td[2]/div/span/span/span[1]") // Select
																												// standard
																												// list
	public WebElementFacade ddl_loc_building_ext;
	@FindBy(xpath = "//*[@id=\"CustomRoute\"]") // Select standard list
	public WebElementFacade ddl_custom_loc;
	@FindBy(xpath = "//li[contains(., \"HSIP Service\")]") // Select Product from list
	public WebElementFacade lst_hisp_service;
	@FindBy(xpath = "//*[@id=\"Billing_Arrangement_Name\"]") // Select Product from list
	public WebElementFacade lst_hisp_billing_arrangement_name;
	@FindBy(xpath = "//li[contains(., \"HSIP Billing Arrangement\")]") // Select Product from list
	public WebElementFacade lst_hisp_billing_arrangement;
	// century link engage objects
	@FindBy(xpath = "//li[contains(., 'CenturyLink Engage')]") // Select Product from list
	public WebElementFacade lst_centurylink_engage;
	@FindBy(xpath = "//*[@id='AttributeForm']/div[3]/div[2]/table/tbody/tr[4]/td[2]/div/span/span/span[1]") // Select
																											// building
																											// extension
	public WebElementFacade lst_billing_type_dd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[5]/td[2]/div/span/span/span[1]") // Select
																												// building
																												// extension
	public WebElementFacade lst_billing_type_hsip_EPL_dd;
	@FindBy(xpath = "//li[contains(., 'Flat')]") // Select Product from list
	public WebElementFacade lst_billing_type;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[1]/td[2]/div/span/span/span[1]") // Select
																												// bandwidth
	public WebElementFacade lst_bandwith_hsipEPL_dd;
	@FindBy(xpath = "//li[contains(., 'GIG-E')]") // Select Product from list
	public WebElementFacade lst_bandwith_hsipEPL_value_dd;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[8]/td[2]/div/span/span/span[1]") // Select
																												// Hsip
																												// epl a
																												// loc
	public WebElementFacade lst__hsipEPL_Loc_A_dd;
	@FindBy(id = ("SL0001959005")) // Address 2 Check Box unique to address used
	public WebElementFacade cbox_address_w_floor;
	@FindBy(xpath = "(//input[contains(@type,'checkbox')])[2]") // Address 2 Check Box unique to address used
	public WebElementFacade ckb_first_location_hisp;
	@FindBy(xpath = "(//input[contains(@type,'checkbox')])[3]") // Address 2 Check Box unique to address used
	public WebElementFacade ckb_second_location_hisp;
	@FindBy(xpath = "(//*[@id=\"LocationSearchGrid\"]/div[2]/table/tbody/tr[1]/td[3]") // Address 2 Check Box unique to
																						// address used
	public WebElementFacade txt_first_Location_row;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[3]/td[2]/div/span/span/span[1]") // Select
																												// Hsip
																												// epl a
																												// loc
	public WebElementFacade lst__encryption_wl;
	@FindBy(xpath = "//li[@tabindex='-1'][contains(.,'Data Center')][1]") // Select data center from list
	public WebElementFacade lst_destination_type__dd;
	@FindBy(xpath = "(//span[contains(@class,'k-icon k-i-arrow-60-down')])[18]") // Select data center from list
	// //Select data center from list
	public WebElementFacade lst_elan_building_ext;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[14]/td[2]/div/span/span/span[1]") // Select
																												// data
																												// center
																												// from
																												// list
	public WebElementFacade lst_specific_design_requiremen;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[12]/td[2]/div/span/span/span[1]") // Select
																												// data
																												// center
																												// from
																												// list
	public WebElementFacade lst_a_loc_dd;
	@FindBy(xpath = "//li[contains(.,'IP VPN Port and Access')]")
	public WebElementFacade lst_IP_Van_pick;
	@FindBy(xpath = "//li[(text()='IP VPN Logical Interface')]")
	public WebElementFacade lst_iP_van_logic_interface_pick;
	@FindBy(xpath = "//li[contains(.,'E-NNI')]")
	public WebElementFacade lst_e_nni_pick;
	@FindBy(xpath = "//li[contains(.,'Wholesale UNI')]")
	public WebElementFacade lst_wholesale_uni;
	@FindBy(id = ("FVR_ID")) // Address 2 Check Box unique to address used
	public WebElementFacade txt_fvr_id_listbox;
	@FindBy(xpath = "//*[@id='AttributeForm']/div[3]/div[2]/table/tbody/tr[2]/td[2]/div/span/span/input[1]") // Select
																												// data
																												// center
																												// from
																												// list
	public WebElementFacade txt_total_size;
	@FindBy(xpath = "//*[@id=\"ProductGrid\"]/div[2]/table/tbody/tr[1]/td[2]/div/span[2]/span/span[1]") // Select data
																										// center from
																										// list
	public WebElementFacade lst_select_child;
	@FindBy(xpath = "//*[@id=\"ProductGrid\"]/div[2]/table/tbody/tr[1]/td[2]/div/button[2]") // Select data center from
																								// list
	public WebElementFacade btn_add_child;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[10]/td[2]/div/span/span/span[1]") // Select
																												// A_Loc_Building
	public WebElementFacade lst_A_Loc_Building;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[19]/td[2]/div/span/span") // Select //
																										// custom_route
	public WebElementFacade lst_custom_route;
	@FindBy(xpath = "//*[@id=\"Dedicated_Network_Name\"]") // Select data center from list
	public WebElementFacade txt_ded_network_name;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relPort\"]/span/span/span[1]") // Select data center from list
	public WebElementFacade lst_port;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relBilling_Arrangement\"]/span/span/span[1]") // Select //
																									// lst_bill_arrangement
	public WebElementFacade lst_bill_arrangement;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relCloud_Access_Point\"]/span/span/span[1]") // Select //
																									// lst_bill_arrangement
	public WebElementFacade lst_cloud_access_point;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relCustomer_Access_Point\"]/span/span/span[1]") // Select
																									// lst_bill_arrangement
	public WebElementFacade lst_relCustomer_Access_Point;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relUNI\"]/span/span/span[1]") // Select lst_bill_arrangement
	public WebElementFacade lst_relatedProductSearch_relUNI;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relALoc_UNI\"]/span/span/span[1]") // Select lst_bill_arrangement
	public WebElementFacade lst_relatedProductSearch_relALoc_UNI;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relZLoc_UNI\"]/span/span/span[1]") // Select lst_bill_arrangement
	public WebElementFacade lst_relatedProductSearch_relZLoc_UNI;
	@FindBy(xpath = "//html/body/div[33]/div[1]/div/a") // x button to close uni window
	public WebElementFacade btn_x_close;
	@FindBy(xpath = "//html/body/div[40]/div[1]/div/a") // Select data center from list
	public WebElementFacade btn_close_x;
	@FindBy(xpath = "//html/body/div[40]/div[1]/div/a") // x button to close uni window
	public WebElementFacade btn_x_close_1;
	@FindBy(xpath = "//html/body/div[42]/div[1]/div/a") // x button to close uni window
	public WebElementFacade btn_x_close_2;
	@FindBy(xpath = "//html/body/div[38]/div[1]/div/a") // x button to close uni window
	public WebElementFacade btn_x_close_3;
	@FindBy(xpath = "//html/body/div[32]/div[1]/div/a") // x button to close uni window
	public WebElementFacade btn_x_close_4;
	@FindBy(id = "btnAttribContinue") // continue button
	public WebElementFacade btn_continue;
	@FindBy(css = "#Protection") // Protection
	public WebElementFacade lst_Protection;
	@FindBy(css = "#CircuitDiversityRequired") // CircuitDiversityRequired
	public WebElementFacade lst_CircuitDiversityRequired;
	@FindBy(css = "#LatencyGuaranteeLevel") // LatencyGuaranteeLevel
	public WebElementFacade lst_LatencyGuaranteeLevel;
	@FindBy(css = "#LatencyValue") // LatencyGuaranteeLevel
	public WebElementFacade txt_LatencyValue;
	@FindBy(css = "#Encryption") // Encryption
	public WebElementFacade lst_Encryption;
	@FindBy(xpath = "//button[contains(@id,'btnAttribFinish')]")
	public WebElementFacade btn_finish;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relELAN_EVC\"]/span/span/span[2]/span") // relELAN_EVC
	public WebElementFacade btn_relELAN_EVC;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relUNI\"]/span/span/span[2]/span") // relUNI
	public WebElementFacade btn_relUNI;
	@FindBy(xpath = "//*[@id=\"RelatedProductSearch-relService\"]/span/span/span[2]/span") // relService
	public WebElementFacade btn_relService;
	@FindBy(id = "create-package-button") // new product package button
	public WebElementFacade btn_create_package_button;
	@FindBy(id = ("glmCodeInput_value")) // Address Text Box
	public WebElementFacade txt_GLM;
	@FindBy(xpath = "//*[@id='locationSearchContainer']/form/div[2]/div/div/div[2]") // GLM search button
	public WebElementFacade btn_glm;
	@FindBy(xpath = "//*[@id='locationSearchContainer']/form/div[2]/div/div/div[3]") // GLM search button
	public WebElementFacade btn_glm1;
	@FindBy(xpath = "//*[@id=\"AttributeForm\"]/div[3]/div[2]/table/tbody/tr[16]/td[2]/div/span/span/span[1]") // protector
	public WebElementFacade ddl_procector;
	@FindBy(xpath = "//*[@id='countrySelect']")
	public WebElementFacade ddl_country;
	@FindBy(id = ("selectAllCheckBoxPreDeploy")) // selectAllCheckBoxPreDeploy
	public WebElementFacade cbx_selectAllCheckBoxPreDeploy;
	@FindBy(id = ("preDeployWarningMessageNoButton")) // noCheckBoxPreDeploypopup
	public WebElementFacade cbx_noCheckBoxPreDeploypopup;
	@FindBy(id = ("preDeployWarningMessageYesButton")) // yesCheckBoxPreDeploypopup
	public WebElementFacade cbx_yesCheckBoxPreDeploypopup;
	@FindBy(id = ("scenario-packages-title")) // lbl_productd_pkg
	public WebElementFacade lbl_productd_pkg;
	@FindBy(id = ("selectAllCheckBoxPreDeploy")) // cbx_predeploy
	public WebElementFacade cbx_predeploy;
	@FindBy(xpath = "//span[@aria-owns='Circuit_Type_listbox']") // Select bandwidth list
	public WebElementFacade lst_circuitType1;
	@FindBy(xpath = "//span[@aria-owns='Port_Type_listbox']") // Select port type
	public WebElementFacade lst_port_type1;
	@FindBy(xpath = "//*[@id=\"ProductPackageWizardView\"]/div[3]/div[4]/div[3]/button") // finish button
	public WebElementFacade btn_finish1;
	@FindBy(xpath = "(//*[@id=\"Port_Type_listbox\"]/li[4])[1]") // billingmethod
	public WebElementFacade billing;
	@FindBy(xpath = "//*[@id='status1']/div[2]")
	public WebElementFacade statusOfPSP;
	@FindBy(xpath = "//*[@id='status1']/div")
	public List<WebElement> statusOfBid;
	@FindBy(xpath = "//*[@id='mat-tab-label-0-3']/div")
	public WebElement vendorBidManagement;
	@FindBy(xpath = "(//*[@id='gvrChkSelectVendorBid1']/label/span)[1]")
	public WebElement vendorBidCheckbox;
	@FindBy(xpath = "//button[@id='btnVendorBidSubmit']")
	public WebElement submitBidButton;
	@FindBy(xpath = "//td[@id='gvrRocId1']")
	public WebElement rocId;
	@FindBy(xpath = "//input[@name='username']")
	public WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	@FindBy(xpath = "//button[text( )=' Submit']")
	public WebElement submit;
	@FindBy(xpath = "//input[@id='searchRequests']")
	public WebElement searchROC;
	@FindBy(xpath = "//*[@class='btn btn-primary assignToMe']")
	public WebElement assignToMe;
	@FindBy(xpath = "//*[text()=' Create New Bid ']")
	public WebElement createNewBidButton;
	@FindBy(xpath = "//select[@id='vendorId']") // AT&T ILEC
	public WebElement vendorName;
	@FindBy(xpath = "//input[@id='interconnect']")
	public WebElement accessPop;
	@FindBy(xpath = "(//button[@class='btn btn-success saveBtn' and @type='submit'])[2]")
	public WebElement saveVendorBid;
	@FindBy(xpath = "//ctl-toggle-slider/div[1]/i")
	public WebElement recommended;
	@FindBy(xpath = "//*[@class='btn btn-primary saveReqBtn']")
	public WebElement saveReq;

	@FindBy(xpath = "(//input[@placeholder='Monthly Recurring Charge'])[3]")
	public WebElement mrc;
	@FindBy(xpath = "(//input[@placeholder='Non-Recurring Charge'])[3]")
	public WebElement nrc;
	@FindBy(xpath = "//*[@id='notes-bid-note-0']")
	public WebElement notes;
	@FindBy(xpath = "//*[@id='statusButton1']") /// text=-- Closed
	public WebElement closedBid;
	@FindBy(xpath = "//*[@id='statusBadge']") /// text=-- Closed
	public WebElement checkStatusOfBid;
	@FindBy(xpath = "//button[@id='btnAttribContinue']") // Select CDR list
	public WebElementFacade continueButton;
	@FindBy(xpath = "//span[text()='IP Logical']") // Select CDR list
	public WebElementFacade IPLogicalRow;
	@FindBy(xpath = "//select[@id='IPPortType']") // Select CDR list
	public WebElementFacade ipPortType;
	@FindBy(xpath = "//button[@id='btnGridAddNew']") // Select CDR list
	public WebElementFacade addNewButton;
	@FindBy(xpath = "//*[@aria-owns='Access_One_Type_listbox']") // cbx_predeploy
	public WebElementFacade accessOneType;
	@FindBy(xpath = "//*[@aria-owns='A1Type_listbox']") // cbx_predeploy
	public WebElementFacade accessOneDia;
	@FindBy(xpath = "//*[@aria-owns='Circuit_Type_listbox']") // cbx_predeploy
	public WebElementFacade circuitType;
	@FindBy(xpath = "//*[@aria-owns='Billing_Method_listbox']") // cbx_predeploy
	public WebElementFacade billingMethod;
	@FindBy(xpath = "//*[@aria-owns='PDR_listbox']") // cbx_predeploy
	public WebElementFacade pdrOld;
	@FindBy(xpath = "//*[@aria-owns='Inside_Wiring_listbox']") // cbx_predeploy
	public WebElementFacade buildingExt;
//	@FindBy(xpath = "//button[@id='btnDialogSave']") // Select CDR list
//	public WebElementFacade saveButton;
	// *[contains(@class,'input-padding input-box modal-input ctl-bold')]

	// *[@id='status1']/div
	
	
	//ExaSwitch
	@FindBy(id = "CloudProvider") // 
	public WebElementFacade cloudProvider;
	
	@FindBy(id = "CSPLocationName") // 
	public WebElementFacade cspLocationName;
	
	@FindBy(id = "CustomRoute") // 
	public WebElementFacade customRoute;

	@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-status mat-column-status ng-star-inserted']/div") // 
	public List<WebElement> vendorBidChech;	
	
	@FindBy(xpath = "(//td[@class='mat-cell cdk-cell cdk-column-status mat-column-status ng-star-inserted']/div)[4]/div") // 
	public WebElementFacade vendorBidText;
	
	@FindBy(xpath = "//button[@id='btnMenu']") // 
	public WebElementFacade productConfigMenu;
	@FindBy(xpath = "//span[@class='mat-slide-toggle-thumb']") // 
	public WebElementFacade preDeployToggle;
	
	@FindBy(xpath = "//*[text()=' Pre-deploy ']/strong") // 
	public WebElementFacade preDeployCurrent;
	
	@FindBy(xpath = "//button[text()='CLOSE']") // 
	public WebElementFacade closeBuildCosePopup;
	
	//AsideAccess
	@FindBy(id = "Promotion") // 
	public WebElementFacade promotion;
	
	@FindBy(id = "AAccessService") // 
	public WebElementFacade aAccessService;
	
	@FindBy(id = "ALoc3rdPartyX-Connect") // 
	public WebElementFacade aLoc3rdPartyXConnect;
	
	@FindBy(id = "ZAccessService") // 
	public WebElementFacade zAccessService;
	
	@FindBy(id = "ZLoc3rdPartyX-Connect") // 
	public WebElementFacade zLoc3rdPartyXConnect;
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return tab_home;
	}
}