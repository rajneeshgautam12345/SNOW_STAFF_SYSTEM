//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import java.util.List;
//
//import com.ctl.it.qa.Test_Four.tools.asripages.AsriPage;
//
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class AsriTDGPage extends AsriPage {
//	@FindBy(xpath = "//div[@class='assignToMeButton']")
//	public WebElementFacade btn_assign;
//	// @FindBy(xpath = "//span[@style='float:left;']")
//	@FindBy(xpath = "//span[contains(@data-toggle,'collapse')]")
//	public WebElementFacade ddl_Eline;
//	// @FindBy(xpath = "//span[@style='float:left;']")
//	@FindBy(xpath = "//span[contains(@data-toggle,'collapse')]")
//	public WebElementFacade ddl_EAccess;
//	@FindBy(xpath = "//button[@routerlinkactive='active']//span[contains(text(),'EVC')]")
//	public WebElementFacade lnk_ECV;
//	@FindBy(xpath = "//button[@routerlinkactive='active']//span[contains(text(),'UNI')]")
//	public WebElementFacade lnk_UNI;
//	@FindBy(xpath = "//button[@routerlinkactive='active']//span[contains(text(),'OVC')]")
//	public WebElementFacade lnk_OVC;
//	// @FindBy(xpath = "//select[@class='custom-select attributeSelectFont
//	// ng-untouched ng-pristine ng-invalid']")
//	@FindBy(xpath = "//select[contains(@id,'Protection_Type')]")
//	public WebElementFacade ddl_Protection_Type;
//	@FindBy(xpath = "//div[@id=\"row8c_MP_EVC_Service_1_Select_Tablejqxgrid\"]/div[2]/div")
//	public WebElementFacade ddl_Protection_Type_ELAN;
//	@FindBy(xpath = "//select[contains(@id,'Protection_Type')]")
//	public WebElementFacade ddl_Protection_Type_OVC;
//	@FindBy(xpath = "//select[@id='Protection_Type']/option[contains(.,'Network Protected')]")
//	public WebElementFacade ddl_selectNetwork;
//	@FindBy(xpath = "(//select[contains(@id,'Preservation')])[1]")
//	public WebElementFacade ddl_CVLAN_ID;
//	@FindBy(xpath = "(//input[@id='CE_VLAN'])[1]")
//	public WebElementFacade tbx_CVLAN_1;
//	@FindBy(xpath = "(//input[@id='CE_VLAN'])[2]")
//	public WebElementFacade tbx_CVLAN_2;
//	@FindBy(xpath = "//input[@id='ENNI_S_VLAN_ID']")
//	public WebElementFacade tbx_EVLAN_ID;
//	@FindBy(xpath = "//select[contains(@id,'CE_VLAN_CoS_Preservation')]")
//	public WebElementFacade ddl_VLAN_COS;
//	@FindBy(xpath = "//select[contains(@id,'CE_VLAN_CoS_Preservation')]/option[2]")
//	public WebElementFacade ddl_VLAN_COS_yes;
//	@FindBy(xpath = "//select[contains(@id,'S_VLAN_ID_Preservation')]")
//	public WebElementFacade ddl_VLAN_ID;
//	@FindBy(xpath = "//select[contains(@id,'S_VLAN_ID_Preservation')]/option[2]")
//	public WebElementFacade ddl_VLAN_ID_yes;
//	@FindBy(xpath = "//select[contains(@id,'S_VLAN_CoS_Preservation')]")
//	public WebElementFacade ddl_S_VLAN;
//	@FindBy(xpath = "//select[contains(@id,'S_VLAN_CoS_Preservation')]/option[2]")
//	public WebElementFacade ddl_S_VLAN_yes;
//	// TDG's UNI 1 & 2 elements
//	@FindBy(id = "LOA_Required")
//	public WebElementFacade ddl_loaRequire;
//	@FindBy(xpath = "//select[contains(@id,'Interface')]")
//	public WebElementFacade ddl_cat_interface;
//	@FindBy(xpath = "//select[@id='Cross_Connect_Interface']/option[contains(text(),'Fiber (Optical)')]")
//	public WebElementFacade ddl_cat_interface_select;
//	// @FindBy(xpath = "//select[@id='LOA_Required']/option[contains(text(),'Yes -
//	// Level 3 Provided')]")
//	@FindBy(xpath = "//select[@id='LOA_Required']/option[contains(text(),'No')]")
//	public WebElementFacade ddl_selectloaRequire;
//	@FindBy(id = "UNI_Interface_Type")
//	public WebElementFacade ddl_interface;
//	@FindBy(xpath = "//select[@id='UNI_Interface_Type']/option[contains(text(),'Fiber')]")
//	public WebElementFacade ddl_Selectinterface;
//	@FindBy(id = "UNI_Mode")
//	public WebElementFacade ddl_UNI_Mode;
//	@FindBy(xpath = "//select[@id='UNI_Mode']/option[contains(text(),'SM')]")
//	public WebElementFacade ddl_selectUNI_Mode;
//	@FindBy(id = "UNI_Connector_Type")
//	public WebElementFacade ddl_UNI_Connector_Type;
//	@FindBy(xpath = "//select[@id='UNI_Connector_Type']/option[contains(text(),'SC')]")
//	public WebElementFacade ddl_selectUNI_Connector_Type;
//	@FindBy(id = "Redundant_Power_Supply")
//	public WebElementFacade ddl_Redundant_Power_Supply;
//	@FindBy(xpath = "//select[@id='Redundant_Power_Supply']/option[contains(text(),'Yes')]")
//	public WebElementFacade ddl_selectRedundant_Power_Supply;
//	@FindBy(id = "Power_Type")
//	public WebElementFacade ddl_Power_Type;
//	@FindBy(xpath = "//select[@id='Power_Type']/option[contains(text(),'AC')]")
//	public WebElementFacade ddl_selectPower_Type;
//	@FindBy(id = "Customer_CPE_Duplex")
//	public WebElementFacade ddl_Customer_CPE_Duplex;
//	@FindBy(xpath = "//select[@id='Customer_CPE_Duplex']/option[contains(text(),'Hard-coded Full')]")
//	public WebElementFacade ddl_selectCustomer_CPE_Duplex;
//	@FindBy(xpath = "//input[@id='Colocation_CLLI']")
//	public WebElementFacade ddl_Colocation_CLLI;
//	@FindBy(xpath = "//select[@id='Interface_Type']")
//	public WebElementFacade ddl_Interface_Type;
//	@FindBy(xpath = "//select[@id='Off_net_Service_Interface_Rate']")
//	public WebElementFacade ddl_Interface_Rate;
//	@FindBy(xpath = "//select[@id='Off_net_Service_Interface_Rate']/option[contains(text(),'Ethernet 1000M')]")
//	public WebElementFacade ddl_select_Interface_Rate;
//	@FindBy(xpath = "//button[@class='btn btn-outline-primary' and text()='Save']")
//	public WebElementFacade btn_save;
//	@FindBy(xpath = "//button[@routerlinkactive='active']//span[contains(text(),'DNV')]")
//	public WebElementFacade lnk_TDGuni1;
//	@FindBy(xpath = "//button[@routerlinkactive='active']//span[contains(text(),'CLE')]")
//	public WebElementFacade lnk_TDGuni2;
//	@FindBy(xpath = "//button[contains(.,'Validate All')]")
//	public WebElementFacade btn_validate;
//	@FindBy(xpath = "//button[@id='gtWizardSaveButton']")
//	public WebElementFacade btn_save_elan;
//	@FindBy(xpath = "//button[@id='gtWizardCompleteButton']")
//	public WebElementFacade btn_complete;
//	@FindBy(xpath = "(//button[@routerlinkactive='active']//span[contains(text(),'Cat')])[1]")
//	public WebElementFacade lnk_Cat1;
//	@FindBy(xpath = "(//button[@routerlinkactive='active']//span[contains(text(),'Cat')])[2]")
//	public WebElementFacade lnk_Cat2;
//	// IPVPN TDG
//	@FindBy(xpath = "(//button[@routerlinkactive='active']//span[contains(text(),'IPVPN')])[2]")
//	public WebElementFacade ipvpn;
//	@FindBy(xpath = "//button[@routerlinkactive='active']//span[contains(text(),'Port')]")
//	public WebElementFacade port;
//	@FindBy(xpath = "//button[@routerlinkactive='active']//span[contains(text(),'Internet_Access')]")
//	public WebElementFacade internetAccess;
//	@FindBy(xpath = "//select[@id='Tagging_Type']")
//	public WebElementFacade taggingType;
//	// Internet
//	@FindBy(xpath = "//select[@id='WAN_IP_Version']")
//	public WebElementFacade wanIPVersion;
//	@FindBy(xpath = "//select[@id='WAN_IP_Block_to_Assign']")
//	public WebElementFacade wanIPBlockToAssign;
//	@FindBy(xpath = "//select[@id='WAN_Routing_Protocol']")
//	public WebElementFacade wanRoutingProtocol;
//	@FindBy(xpath = "//input[@id='Diverse_From']")
//	public WebElementFacade diverseForm;
//	/// ipvpn
//	@FindBy(xpath = "//select[@id='Customer_Assigned_WAN_IPs_Option']")
//	public WebElementFacade custAssignWANIPs;
//	@FindBy(xpath = "//input[@id='Customer_Assigned_CTL_IPs']")
//	public WebElementFacade custAssignCTLIPs;
//	@FindBy(xpath = "//input[@id='Customer_Assigned_IPs']")
//	public WebElementFacade custAssignIPs;
//	@FindBy(xpath = "//select[@id='SubnetLengthAndSubnetMask']")
//	public WebElementFacade SubnetLengthAndSubnetMask;
//	@FindBy(xpath = "//input[@id='Unique_Customer_ASN']")
//	public WebElementFacade uniqueCustASN;
//	@FindBy(xpath = "//select[@id='Configure_For']")
//	public WebElementFacade ipv4ConfigureFor;
//	@FindBy(xpath = "//select[@id='Authentication_Required']")
//	public WebElementFacade authenticationReq;
//	@FindBy(xpath = "//select[@id='Assign_By']")
//	public WebElementFacade ipv4AssignBy;
//	@FindBy(xpath = "//select[@id='IPv4_BFD_Timer_On']")
//	public WebElementFacade ipv4BFDTimerOn;
//	@FindBy(xpath = "//select[@id='MultiCast']")
//	public WebElementFacade multicast;
//	@FindBy(xpath = "//select[@id='Number_Of_LL_Queues']")
//	public WebElementFacade noOfLLQueues;
//	@FindBy(xpath = "//select[@id='MCOS_Scheduler_Policy_Template_1']")
//	public WebElementFacade mcosSchedulerPolicyTemplate;
//	@FindBy(xpath = "//select[@id='Premium_Plus_Premium_PIR']")
//	public WebElementFacade premiumPlusPremiumPIR;
//	@FindBy(xpath = "//select[@id='Premium_Plus_Premium_CIR']")
//	public WebElementFacade premiumPlusPremiumCIR;
//	@FindBy(xpath = "//select[@id='Custom_Policing']")
//	public WebElementFacade customPolicing;
//	@FindBy(xpath = "//select[@id='Premium_Plus_Premium_Policer']")
//	public WebElementFacade premiumPlusPremiumPolicer;
//	@FindBy(xpath = "//select[@id='Class_of_Service_Trust_Mark']")
//	public WebElementFacade classOfServiceTrustMark;
//	@FindBy(xpath = "//select[@id='COS_Allocation']")
//	public WebElementFacade cosAllocation;
//	@FindBy(xpath = "//select[@id='OTT_Voice_Complete_Required']")
//	public WebElementFacade ottVoiceCompleteReq;
//	@FindBy(xpath = "//select[@id='OTT_ANS_Required']")
//	public WebElementFacade ottANSReq;
//	@FindBy(xpath = "//select[@id='OTT_SD_WAN_Required']")
//	public WebElementFacade ottSDWANReq;
//	@FindBy(xpath = "//select[@id='OTT_Dynamic_Connections_Required']")
//	public WebElementFacade ottDynamicConnReq;
//
//	public WebElementFacade selectUni(int i) {
//		List<WebElementFacade> list = findAll("//button[@routerlinkactive='active']//span[contains(text(),'UNI')]");
//		WebElementFacade uni1Ele = list.get(i);
//		return uni1Ele;
//	}
//
//	public WebElementFacade selectCat(int i) {
//		List<WebElementFacade> list = findAll("//button[@routerlinkactive='active']//span[contains(text(),'Cat')]");
//		WebElementFacade cat = list.get(i);
//		return cat;
//	}
//
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return btn_assign;
//	}
//}
