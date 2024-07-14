package com.ctl.it.qa.Test_Four.tools.pages.common;

import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ScenarioDataPage extends SfaPage {
	@FindBy(xpath = "(//input[@value=' Edit '])[1]")
	public WebElementFacade btn2_edit;
	@FindBy(xpath = "//div[@title='Edit'][contains(.,'Edit')]")
	public WebElementFacade btn_edit;
	@FindBy(xpath = "//span[@class='title slds-path__title'][contains(.,'Agreement')]")
	public WebElementFacade lnk_agreement;
	@FindBy(xpath = "//span[@class='title slds-path__title'][contains(.,'Proposed')]")
	public WebElementFacade lnk_proposed;
	
	@FindBy(xpath = "//span[contains(.,'Mark as Current Stage')]")
	public WebElementFacade btn_mark_asCurrentStage;
	@FindBy(xpath = "//button[contains(@name,'Primary_Loss_Reason__c')]")
	public WebElementFacade ddl_primaryReason;
	@FindBy(xpath = "//button[@class='slds-button slds-button_brand'][contains(.,'Done')]")
	public WebElementFacade btn_done;
	@FindBy(css = "#opp11") // stage selection list box
	public WebElementFacade lst_stage;
	@FindBy(id = "00NA0000005BwOk") // stage selection list box
	public WebElementFacade lst_won_lost;
	@FindBy(xpath = "//*[@id='quoteGrid']/div[4]/div[3]/div/div/div[4]/a") // quote_preparation button
	public WebElementFacade lnk_quote_name;
	@FindBy(xpath = "(//a[@target='_top'])[1]")
	public WebElementFacade lnk_sm_detail;
	@FindBy(name = "edit")
	public WebElementFacade btn_sm_edit;
	@FindBy(id = "00N2A00000DoTFC")
	public WebElementFacade lst_long_haul; // Is there long haul?
	@FindBy(id = "j_id0:myForm:contactRoles:pgBlockTable:0:contact")
	public WebElementFacade txt_order_contact; // billing contact
	@FindBy(id = "j_id0:myForm:contactRoles:pgBlockTable:1:contact")
	public WebElementFacade txt_billing_contact; // order contact
	@FindBy(id = "j_id0:myForm:contactRoles:pgBlockTable:2:contact")
	public WebElementFacade txt_tec_contact; // tec contact
	@FindBy(name = "j_id0:myForm:contactRoles:j_id46:j_id48") // save_contacts
	public WebElementFacade btn_contact_save;
	@FindBy(id = "j_id0:gaForm:Information:documentInformation:docName")
	public WebElementFacade txt_sm_attachmentname;
	@FindBy(xpath = "//th[contains(.,'*Document Name')]//th[contains(.,'*Document Name')]")
	public WebElementFacade lbl_doc_name;
	@FindBy(xpath = "//select[@name='j_id0:gaForm:Information:documentContent:documentType']")
	public WebElementFacade lst_sm_attachmenttype;
	@FindBy(xpath = "(//input[contains(@value,'Add Attachment')])[1]")
	public WebElementFacade btn_sm_addattachment2;
	@FindBy(css = "#ucAttachment_fileAttach")
	public WebElementFacade btn_sm_choosefile;
	@FindBy(xpath = "(//input[contains(@type,'text')])[1]")
	public WebElementFacade txt_attachment_name;
	@FindBy(xpath = "//select[@onchange='documentType(this.value);']")
	public WebElementFacade lst_doc_type;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	public WebElementFacade txt_sm_attachmentdate;
	@FindBy(xpath = "//input[@name='ucAttachment$btnAdd']")
	public WebElementFacade btn_sm_addfile;
	@FindBy(xpath = "//a[contains(.,'Back to Record')]")
	public WebElementFacade btn_sm_backtorecord;
	
	@FindBy(xpath = "//a[text()='Attach A New Global Attachment']")
	public WebElementFacade btn_attachNewGlobalAttachment;
	
	@FindBy(xpath = "//div[@class='entityNameTitle slds-line-height--reset'][contains(.,'Opportunity Quote')]")
	public WebElementFacade lbl_oppty_quote;
	@FindBy(name = "add_global_attachment") // add_add_global_attachment
	public WebElementFacade btn_add_global_attachment;
	@FindBy(id = "j_id0:gaForm:Information:documentInformation:docName")
	public WebElementFacade txt_docName; // doc name
	@FindBy(id = "j_id0:gaForm:Information:documentContent:documentType")
	public WebElementFacade lst_docType; // doc type
	@FindBy(xpath = "//*[@id='j_id0:gaForm:Information:j_id61:description']")
	public WebElementFacade txt_docDec; // doc dec
	@FindBy(id = "j_id0:gaForm:Information:documentContent:j_id36:signedDate")
	public WebElementFacade txt_signedDate;
	@FindBy(name = "j_id0:gaForm:Information:pageBlock:bottom:j_id28") // add_add_global_attachment
	public WebElementFacade btn_save_attach;
	@FindBy(name = "j_id0:gaForm:Information:pageBlock:j_id30")
	public WebElementFacade btn_addattachment;
	@FindBy(css = "input[type='file']") // the file upload
	public WebElementFacade txt_fileFile;
	@FindBy(xpath = "(//input[contains(@value,'Select Billing Account')])[1]") // select_billing_account itv1
	public WebElementFacade btn_select_billing_account;
	@FindBy(xpath = "//*[@id=\"aSG0U00000098j6_00N2A00000DoT73_link\"]") // select_billing_account itv1
	public WebElementFacade lnk_doc;
	@FindBy(id = "ucAttachment_btnAdd")
	public WebElementFacade btn_attachment_add;
	@FindBy(id = "j_id0:accountSearchFields:j_id67:j_id68:j_id69") // update all button e2e
	public WebElementFacade btn_upDate_All;
	@FindBy(css = ".pbHeader table  tbody tr  .pbButton input.btn[value=\\\"Return to Quote\\\"]")
	public WebElementFacade btn_returntoQuote;
	@FindBy(xpath = "//*[@id='lookup006c000000Iy0p300N2A00000DoT72']")
	public WebElementFacade lnk_oppty_name; // Optty link name to click on
	@FindBy(xpath = "//input[contains(@value,'Update All')]")
	public WebElementFacade btn_sm_acctupdateall;
	@FindBy(xpath = "//*[@id=\"j_id0:accountSearchFields:j_id69:qliPgBlock:tb\"]//td[13]") // test
	public WebElementFacade ban_Id;
	@FindBy(xpath = "//*[@id=\"j_id0:accountSearchFields:j_id69:qliPgBlock:0:j_id110\"]") // test 4
	public WebElementFacade acct_null;
	@FindBy(xpath = "//*[@id=\"j_id0:accountSearchFields:j_id69:qliPgBlock:0:j_id110\"]") // test 1
	public WebElementFacade acct_null_test_1;
	@FindBy(xpath = "//*[@id=\"j_id0:accountSearchFields:j_id67:qliPgBlock:0:j_id108\"]") // test 3
	public WebElementFacade acct_null_test_3;
	@FindBy(name = "j_id0:accountSearchFields:j_id125:j_id126:j_id129")
	public WebElementFacade chb_sm_acct;
	@FindBy(xpath = "//a[contains(.,'<< Back')]")
	public WebElementFacade lnk_back;
	@FindBy(xpath = "(//input[contains(@type,'text')])[2]")
	public WebElementFacade txt_cust_signdate;
	@FindBy(xpath = "//button[@title='Edit Customer Signature Date']/lightning-primitive-icon/*[local-name()='svg']")
	public WebElementFacade btn_icon_for_Cust;
	@FindBy(xpath = "//a[contains(@class,'switch-to-lightning')]")
	public WebElementFacade lnk_switch_to_lightening;
	@FindBy(xpath = "//*[@title='Edit Hot Cut/Replacement?']")
	public WebElementFacade icon_hotcut;
//	@FindBy(xpath = "//a[contains(@data-interactive-lib-uid,'7')]")
//	public WebElementFacade ddl_hotcut;
	
	
	//@FindBy(xpath = "//button[@aria-label='Hot Cut/Replacement? - Current Selection: --None--']/span")
	@FindBy(xpath = "//button[@aria-label='Hot Cut/Replacement?']/span")
	public WebElementFacade ddl_hotcut;
	
	
	//input[@placeholder='Search People...']
	
	@FindBy(xpath = "	//a[contains(@data-interactive-lib-uid,'13')]")
	public WebElementFacade ddl_CCM;
	@FindBy(xpath = "//input[contains(@placeholder,'Search People...')]")
	public WebElementFacade ddl_sale_engineer;
//	@FindBy(xpath = "//button[@title='Save']")
//	public WebElementFacade btn_hotcut_save;
	@FindBy(xpath = "//button[@name='SaveEdit']")
	public WebElementFacade btn_hotcut_save;
	
	@FindBy(xpath = "//button[@aria-label='Quote associated to an OTT service?']")
	public WebElementFacade ottService;
	
	@FindBy(xpath = "//a[contains(@title,'Go to Order Contacts Roles')]")
	public WebElementFacade lnk_go_to_Contacts;
	@FindBy(xpath = "//*[@title='Add Existing Contacts']")
	public WebElementFacade btn_add_existing_Contacts;
	@FindBy(xpath = "//button[text() = 'Add Existing Contacts']")
	public WebElementFacade btn_add_existing_Contactsnew;
	@FindBy(xpath = "//div[@class='primaryLabel slds-truncate slds-lookup__result-text'][contains(.,'qoe2e test qtest1')]")
	public WebElementFacade lst_saleRepContact;
	@FindBy(xpath = "//html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[2]/span")
	public WebElementFacade btn_leave_page;
	@FindBy(xpath = "//button[@aria-expanded='false'][contains(.,'Show more actions')]")
	public WebElementFacade btn_open_to_submit;
	@FindBy(xpath = "//span[@class='slds-truncate'][contains(.,'Submit to Order')]")
	public WebElementFacade btn_submit_to_swift;
	@FindBy(xpath = "//*[@id=\"customTab12__item\"]")
	public WebElementFacade lnk_detail_tab;
	@FindBy(xpath = "//input[contains(@data-interactive-lib-uid,'7')]")
	public WebElementFacade txt_for_cust_sign;
	@FindBy(xpath = "//input[contains(@data-interactive-lib-uid,'6')]") // check box for sign date
	public WebElementFacade cbx_for_cust_sign;
	@FindBy(css = "[title='Edit I am Committing to Current Mo Results']")
	public WebElementFacade cbx_for_commit_mo;
	@FindBy(xpath = "//span[@class=' label bBody'][contains(.,'Save')]")
	public WebElementFacade btn_for_cust_sign_save;
	@FindBy(xpath = "(//*[@class='dataCol  first  last ']/input)[1]")
	public WebElementFacade billingAccountNoSearchText;
	@FindBy(xpath = "//input[@value='Search']")
	public WebElementFacade billingAccountSearchButton;
	@FindBy(xpath = "//tr[4]/td[2]/div/select")
	public WebElementFacade contactRoleSelection;
	@FindBy(xpath = "//tr[5]/td[2]/div/select")
	public WebElementFacade contactRoleSelection5;
	@FindBy(xpath = "//tr[6]/td[2]/div/select")
	public WebElementFacade contactRoleSelection6;
	
	//TDF elements
	@FindBy(xpath = "//span[text()='Show more actions']/..")
	public WebElementFacade moreElement;
	@FindBy(xpath = "//iframe[@title='accessibility title']")
	public WebElementFacade iframe_quote;
	@FindBy(xpath = "//iframe[@id='quote-iframe'][@name='theIframe']")
	public WebElementFacade iframe_manage_scenario;
	
	@FindBy(xpath = "//td[@data-col-key-value='9-action-9']//span//button")
	public WebElementFacade tdf_OptionIcon;
	@FindBy(xpath = "//div[@role='menu']//a/span[text()='Edit']")
	public WebElementFacade editMenu;
	@FindBy(xpath = "//label[@for='pmoNo-1']")
	public WebElementFacade pmoNo;
	@FindBy(xpath = "//label[text()='Network Status']/..//span")
	public WebElementFacade networkStatus;
	
	@FindBy(xpath = "//a[@data-label='IP Technical Details']")
	public WebElementFacade ipTechDetails;
	@FindBy(xpath = "//label[@for='ipModeBridged-1']")
	public WebElementFacade ipModeBridged;
	
	@FindBy(xpath = "//label[@for='ipModeRouted-1']")
	public WebElementFacade ipModeRouted;
	
	@FindBy(xpath = "//label[@for='LANIPsYes-1']")
	public WebElementFacade LANIPYes;
	
	
	@FindBy(xpath = "//button[@name='Routing_Protocol__c']")
	public WebElementFacade routingProtocol;
	
	@FindBy(xpath = "//a[@data-label='BGP Details']")
	public WebElementFacade bgpDetailsTab;
	
	@FindBy(xpath = "//input[@name='Customer_BGP_Peer_ASN__c']")
	public WebElementFacade customer_bgp_asn;	
	
	@FindBy(xpath = "//input[@name='Maintainer__c']")
	public WebElementFacade maintener;	
	
	@FindBy(xpath = "//button[@name='Route_Registry__c']")
	public WebElementFacade route_Registry;	
	
	@FindBy(xpath = "//label[@for='registryYes-1']")
	public WebElementFacade route_Registry_Yes;	
	
	@FindBy(xpath = "//input[@name='Route_Registry_Object__c']")
	public WebElementFacade routeRegistryObect;	
	
	@FindBy(xpath = "//button[@name='BGP_Ads_to_Customer__c']")
	public WebElementFacade lmnAdvertisementToCust;	
	@FindBy(xpath = "//input[@name='IPv4_Advertised_Routes__c']")
	public WebElementFacade ipv4AdvertisedRoutes;	
	@FindBy(xpath = "//button[@name='BGP_As_Source__c']")
	public WebElementFacade bgpAsSource;	
	@FindBy(xpath = "//label[@for='bgpAdvancedYes-1']")
	public WebElementFacade bgpAdvanced;
	
	@FindBy(xpath = "//div[@data-value='Blackhole']")
	public WebElementFacade blackhole;
	@FindBy(xpath = "//div[@data-value='MEDS']")
	public WebElementFacade meds;
	@FindBy(xpath = "(//lightning-button-icon[@variant='container']/button)[1]")
	public WebElementFacade moveSelectionArrow;
	
	@FindBy(xpath = "//label[@for='bfdYes-1']")
	public WebElementFacade bfd;
	@FindBy(xpath = "//button[@name='BFD__c']")
	public WebElementFacade bfdTimer;
	
	
	@FindBy(xpath = "//a[@data-label='Access Details']")
	public WebElementFacade accessDetails;
	@FindBy(xpath = "//label[@for='cablingFiber-1']")
	public WebElementFacade cablingType;
	
	@FindBy(xpath = "//label[@for='redundantPowerNo-1']")
	public WebElementFacade redundantPowerSupply;
	@FindBy(xpath = "//label[@for='powerTypeAC-1']")
	public WebElementFacade powerType;
	@FindBy(xpath = "//label[@for='cpeDuplexHardcoded-1']")
	public WebElementFacade custCPEDuplex;
	@FindBy(xpath = "//button[@title='Save Version']")
	public WebElementFacade saveTDFButton;
	@FindBy(xpath = "//button[@title='Publish']")
	public WebElementFacade publishButton;
	@FindBy(xpath = "//button[@name='Customer_Fiber_Mode__c']")
	public WebElementFacade fiberMode;
	@FindBy(xpath = "//label[@for='connectorLC-1']")
	public WebElementFacade connectorType;
	@FindBy(xpath = "//label[@for='beCablingFiber-1']")
	public WebElementFacade existingBuildExtCablingType;
	@FindBy(xpath = "//button[@name='BE_Fiber_Mode__c']")
	public WebElementFacade buildExtFiberMode;
	@FindBy(xpath = "//label[@for='beConnectorLC-1']")
	public WebElementFacade buildExtConnectorType;
	
	@FindBy(xpath = "//a[@id='Access Offnet__item']")
	public WebElementFacade accessOffnetTab;
	@FindBy(xpath = "//input[@name='Offnet_UNI_MTU__c']")
	public WebElementFacade offnetMTU;
	
	@FindBy(xpath = "//label[@for='coloSpaceNo-1']")
	public WebElementFacade colocationSpace;
	
	//SDF element
	@FindBy(xpath = "//th[@data-label='Package ID']//a")
	public WebElementFacade packageId;
	
	@FindBy(xpath = "(//input[@name='Early_Acceptance__c']/..//label)[1]")
	public WebElementFacade earlyAcceptance;
	@FindBy(xpath = "//button[@name='ExpediteType__c']")
	public WebElementFacade expedite;
	@FindBy(xpath = "(//button[@title='Click to select Floor Room Suite'])[1]")
	public WebElementFacade floorAndRoom;
	@FindBy(xpath = "(//button[@name='LOA_CFA__c'])[1]")
	public WebElementFacade loa_cfa;
	@FindBy(xpath = "(//span[text()='Add /Edit Location Contact'])[1]")
	public WebElementFacade add_edit_LocalContact;
	@FindBy(xpath = "//button[@title='Add Contact']")
	public WebElementFacade addLocalContactButton;
	
	@FindBy(xpath = "//input[@name='First_Name__c']")
	public WebElementFacade fistName;
	@FindBy(xpath = "//input[@name='Last_Name__c']")
	public WebElementFacade lastName;
	@FindBy(xpath = "//input[@name='Email__c']")
	public WebElementFacade email;
	@FindBy(xpath = "//input[@name='PhoneNumber__c']")
	public WebElementFacade phoneNo;
	@FindBy(xpath = "//input[@name='MobilePhoneNumber__c']")
	public WebElementFacade mobNO;
	@FindBy(xpath = "//button[@name='Role__c']")
	public WebElementFacade role;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade saveContactSDF;
	
	@FindBy(xpath = "//*[contains(@id,'networkStatus')]/span[1]")
	public WebElementFacade sdfNetworkStatus;
	@FindBy(xpath = "//button[@title='Close']")
	public WebElementFacade closeLocalContactWindow;
	
	@FindBy(xpath = "//button[@title='Save Validate']")
	public WebElementFacade save_ValidateButton;
	@FindBy(xpath = "//a[text()='<< Back']")
	public WebElementFacade backButton;
	
	@FindBy(xpath = "(//button[@title='Click to select Floor Room Suite'])[2]")
	public WebElementFacade floorAndRoom2;
	
	@FindBy(xpath = "//label[@for='opticTypeLR4-1']")
	public WebElementFacade opticType;
	
	@FindBy(xpath = "//input[@name='First_Name__c']")
	public WebElementFacade fistName_z;
	
	@FindBy(xpath = "//input[@name='Last_Name__c']")
	public WebElementFacade lastName_z;
	
	@FindBy(xpath = "//input[@name='Email__c']")
	public WebElementFacade email_z;
	
	@FindBy(xpath = "//input[@name='PhoneNumber__c']")
	public WebElementFacade phoneNo_z;
	
	@FindBy(xpath = "//input[@name='MobilePhoneNumber__c']")
	public WebElementFacade mobNO_z;
	@FindBy(xpath = "//button[@name='Role__c']")
	public WebElementFacade role_z;
	
	@FindBy(xpath = "//button[@name='LOA_CFA_Z__c']")
	public WebElementFacade loa_cfa_z;
	
	@FindBy(xpath = "//input[@name='Vendor_Name_Z__c']")
	public WebElementFacade vendorName;
	
	@FindBy(xpath = "//*[text()='Billing Account']/../../following-sibling::lightning-icon[1]")
	public WebElementFacade ban_check;
	
	//Managed Route page
	@FindBy(xpath = "//a[@id='Managed Router Details__item']")
	public WebElementFacade managedRouterDetails;
	
	@FindBy(xpath = "//button[@name='Edit']")
	public WebElementFacade managedRouterDetailsEdit;
		
	@FindBy(xpath = "//button[@name='LAN_Routing_Protocol__c']")  //Static
	public WebElementFacade lanRoutingProtocol;
	
	@FindBy(xpath = "//label[contains(@for,'multipleWANNo')]")
	public WebElementFacade multipleWANSeries_No;
	
	@FindBy(xpath = "//button[@name='Multi_Router_Role__c']")
	public WebElementFacade multiRouterRole;
		
	@FindBy(xpath = "//label[contains(@for,'multipleLANNo')]")
	public WebElementFacade multipleLANConnection_No;
	
	@FindBy(xpath = "//button[@title='OK']")
	public WebElementFacade saveButton;
	
	//RelatedNumber
	@FindBy(xpath = "//a[@title='The following Related Numbers are required in order to submit your order:  CAT Approval']")
	public WebElementFacade relatedNumberLink;
	@FindBy(xpath = "//button[text()='New' and @name='New']")
	public WebElementFacade newButton;
	@FindBy(xpath = "//textarea[@part='textarea']")
	public WebElementFacade comments;
	@FindBy(xpath = "//input[@name='Detail__c']")
	public WebElementFacade relatedNumber;
	
	@FindBy(xpath = "//button[@aria-label='Type']")
	public WebElementFacade type;
	@FindBy(xpath = "//input[@name='CAR_Approval_Status__c']")
	public WebElementFacade carApprovalStatus;
	@FindBy(xpath = "//*[@name='SaveEdit']")
	public WebElementFacade save;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lst_stage;
	}
}
