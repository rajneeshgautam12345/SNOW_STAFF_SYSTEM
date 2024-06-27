package com.ctl.it.qa.Test_Four.tools.pages.Snow;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CustomerOrderPage extends SfaPage {
	@FindBy(xpath = "//*[text()='Number']") // numbers
	public WebElementFacade numbersText;
	@FindBy(xpath = "//*[@id='approve']") // aprroveOrder
	public WebElementFacade aprroveOrder;
	
	
	
	@FindBy(xpath = "//select[@id='sn_ind_tmt_orm_order.state']") // state
	public WebElementFacade state;
	@FindBy(xpath = "//button[text()='Load Related Lists']") // loadRelatedList
	public WebElementFacade loadRelatedList;
	// Customer Order Tabs
	@FindBy(xpath = "//span[contains(text(),'Customer') and @class='tab_caption_text']")
	public WebElementFacade customerOrderLineItemsTab;
	@FindBy(xpath = "//span[contains(text(),'Gatherings') and @class='tab_caption_text']")
	public WebElementFacade tdgDataTab;
	@FindBy(xpath = "//span[contains(text(),'Enrichments') and @class='tab_caption_text']")
	public WebElementFacade serviceOrderEnrichmentsTab;
	@FindBy(xpath = "//span[contains(text(),'Related') and @class='tab_caption_text']")
	public WebElementFacade relatedOrderEntitiesTab;
	@FindBy(xpath = "//span[contains(text(),'Fallouts') and @class='tab_caption_text']")
	public WebElementFacade falloutTab;
	@FindBy(xpath = "//tr[@record_class='u_related_order_numbers']/td[3]/a")
	public List<WebElement> relatedOrderEntitiesName;
	@FindBy(xpath = "//tr[@record_class='u_related_order_numbers']/td[4]/a")
	public List<WebElement> relatedOrderEntitiesValue;
	
	
	public String orderLineItem1 = "(//*[contains(@href, 'sn_prd_pm_product_specification') and text()='";
	public String orderLineItem2 = "']/../..//a[contains(text(), 'ORDL')])[1]";
	@FindBy(xpath = "//button[@data-original-title='Back']")
	public WebElementFacade backButton;
	
	@FindBy(xpath = "//tr[@record_class='u_lmn_technical_data_gathering']/td/a[@class='linked formlink']")
	public WebElementFacade tdgRecord;
	
	@FindBy(xpath = "//input[@name='sys_display.u_lmn_technical_data_gathering.u_access_type']")
	public WebElementFacade accessType;
	
	@FindBy(xpath = "//input[@name='sys_display.u_lmn_technical_data_gathering.u_access_sub_type']")
	public WebElementFacade accessSubType;
	
	@FindBy(xpath = "(//button[text()='Save'])[1]")
	public WebElementFacade saveButton;
	
	
	
	@FindBy(xpath = "//input[@name='u_lmn_technical_data_gathering.u_access_sub_type_label']")
	public WebElementFacade getNetworkStatus;
	
	@FindBy(xpath = "//span[contains(text(),'Transport') and @class='tab_caption_text']")
	public WebElementFacade transportAccess;
	
	@FindBy(xpath = "//button[contains(@onclick,'u_ip_routing') and text()='New']")
	public WebElementFacade ipRoutingNewButton;
	@FindBy(xpath = "//input[@data-name='u_ip_mode']")
	public WebElementFacade ipMode;
	@FindBy(xpath = "//select[@id='u_ip_routing.u_ip_version']")
	public WebElementFacade ipVersion;
	@FindBy(xpath = "//select[@id='u_ip_routing.u_ip_wan_lan']")
	public WebElementFacade ip_Wan_Lan;
	@FindBy(xpath = "//input[@data-name='u_block_to_assign']")
	public WebElementFacade block_To_Assign;
	@FindBy(xpath = "//input[@data-name='u_routing_protocol']")
	public WebElementFacade routing_Protocol;
	@FindBy(xpath = "//input[@data-name='u_ip_scope']")
	public WebElementFacade ip_Scope;
	
	@FindBy(xpath = "//button[contains(@onclick,'u_transport_access_options') and text()='New']")
	public WebElementFacade transportAccessNewButton;
	@FindBy(xpath = "//input[@data-name='u_uni_port_speed']")
	public WebElementFacade uniPortSpeed;
	
	@FindBy(xpath = "//input[@data-name='u_loa_required']")
	public WebElementFacade loaRequired;
	
	@FindBy(xpath = "//input[@data-name='u_uni_interface_type']")
	public WebElementFacade uniInterfaceType;
	@FindBy(xpath = "//input[@data-name='u_uni_mode']")
	public WebElementFacade uniMode;
	@FindBy(xpath = "//input[@data-name='u_uni_connector_type']")
	public WebElementFacade uniConnectorType;
	@FindBy(xpath = "//input[@data-name='u_redundant_power_supply']")
	public WebElementFacade redundantPowerSupply;
	@FindBy(xpath = "//input[@data-name='u_power_type']")
	public WebElementFacade powerType;
	@FindBy(xpath = "//input[@data-name='u_customer_cpe_duplex']")
	public WebElementFacade customerCpeDuplex;
	@FindBy(xpath = "//input[@data-name='u_tagging_type']")
	public WebElementFacade taggingType;
	@FindBy(xpath = "//input[@data-name='u_uni_type']")
	public WebElementFacade uniType;
	@FindBy(xpath = "//input[@data-name='u_off_net_service_interface_rate']")
	public WebElementFacade interfaceRate;
	@FindBy(xpath = "//input[@name='u_transport_access_options.u_off_net_quantity']")
	public WebElementFacade offnetQty;
	@FindBy(xpath = "//input[@name='u_transport_access_options.u_colocation_clli']")
	public WebElementFacade colocationClli;
	
	@FindBy(xpath = "//input[@name='u_transport_access_options.u_secloc_location']")
	public WebElementFacade seclocationAccess;

	@FindBy(xpath = "//input[@data-name='u_interface_type']")
	public WebElementFacade interfaceType;
	
	@FindBy(xpath = "//span[text()='Advanced Offnet']")
	public WebElementFacade advancedOffnet;
	
	@FindBy(xpath = "//input[@data-name='u_class_of_service']")
	public WebElementFacade classOfService;
	
	@FindBy(xpath = "//select[@name='sn_ind_tmt_orm_order.u_credit_check_status']")
	public WebElementFacade creditCheckStatus;
	@FindBy(xpath = "//tr[@record_class='u_service_order_enrichment']/td[3]/a")
	public WebElementFacade portServiceAliasValue;			
	
	
//	@FindBy(xpath = "//input[@name='sys_display.u_lmn_technical_data_gathering.u_access_sub_type']")
//	public WebElementFacade accessSubType;
	
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return backButton;
	}
}
