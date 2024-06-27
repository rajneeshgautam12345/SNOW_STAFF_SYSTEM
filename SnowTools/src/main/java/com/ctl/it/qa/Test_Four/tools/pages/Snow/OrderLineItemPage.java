package com.ctl.it.qa.Test_Four.tools.pages.Snow;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class OrderLineItemPage extends SfaPage {
	// OrderLineItemTabs
	@FindBy(xpath = "//span[contains(text(),'Characteristic') and @class='tab_caption_text']")
	public WebElementFacade customerOrderCharacteristicTab;
	@FindBy(xpath = "//span[contains(text(),'Contacts') and @class='tab_caption_text']")
	public WebElementFacade OrderLineItemContactsTab;
	@FindBy(xpath = "//span[contains(text(),'Product') and @class='tab_caption_text']")
	public WebElementFacade productOrdersTab;
	@FindBy(xpath = "//span[contains(text(),'Tasks') and @class='tab_caption_text']")
	public WebElementFacade orderTasksTab;
	@FindBy(xpath = "//button[@aria-label='additional actions menu']")
	public WebElementFacade menuIcon;
	@FindBy(xpath = "//div[text()='Reload form']")
	public WebElementFacade reloadForm;
	@FindBy(xpath = "//span[contains(text(),'Service') and @class='tab_caption_text']")
	public WebElementFacade serviceOrderTab;
	String productSpecification1 = "//td[@class='vt']/a[text()='";
	String productSpecification2 = "']";
	public String customerOrderCharacteristicsValue1 = "//td/a[@aria-label='Open record: ";
	public String customerOrderCharacteristicsValue2 = "']/../../td[7]";
	@FindBy(xpath = "//tr[@record_class='sn_ind_tmt_orm_product_order']/td/a[contains(@href, 'sys_flow_context.do')]") // user
	public WebElementFacade workflowName;
	public String workflow1 = "//td/a[text()='";
	public String workflow2 = "']";
	
	@FindBy(xpath = "//div[@id='element.sn_ind_tmt_orm_order_line_item.product_specification']/div[2]/div[2]/input") // prod																													// Specificn
	public WebElementFacade prodSpecification;
	@FindBy(xpath = "//tr[@record_class='sn_ind_tmt_orm_order_task']/td[4]") // aprroveOrder
	public List<WebElement> allTasks;
	@FindBy(xpath = "//tr[@record_class='sn_ind_tmt_orm_order_task']/td[6]") // aprroveOrder
	public List<WebElement> allTasksStatus;
	@FindBy(xpath = "//tr[@record_class='sn_ind_tmt_orm_order_task']/td/div[1]") // aprroveOrder
	public List<WebElement> allTasksCreatedDateAndTime;
	
	@FindBy(xpath = "//tr[@record_class='sn_ind_tmt_orm_order_task']/td/a[@class='linked formlink']") // 
	public List<WebElement> allOmtTaskId;
	
	@FindBy(xpath = "//select[@name='sn_ind_tmt_orm_order_task.state']") // prod Specificn
	public WebElementFacade stateOfTask;
	@FindBy(xpath = "//td/a[@id='cell_edit_ok']") // prod Specificn
	public WebElementFacade saveState;
	@FindBy(xpath = "//button[@data-original-title='Back']") // user
	public WebElementFacade backButton;
	
	@FindBy(xpath = "//span[@id='sn_ind_tmt_orm_order_line_item.sn_ind_tmt_orm_order_characteristic_value.order_line_item_hide_search']//input[@aria-label='Search']")
	public WebElementFacade searchCharacteristicValue;
	
	@FindBy(xpath = "//a[text()='Customer Requested Date']/../..//td//a[contains(@href, 'sn_ind_tmt_orm_order_characteristic_value') and @class='linked formlink']")
	public WebElementFacade crdCharactValueClick;
	
	@FindBy(xpath = "//textarea[@id='sn_ind_tmt_orm_order_characteristic_value.characteristic_option_value']")
	public WebElementFacade crdValueEnter;
	
	@FindBy(xpath = "(//button[text()='Save'])[1]")
	public WebElementFacade saveButton;
	
	@FindBy(xpath = "//button[contains(@onclick,'order_line_item_contact') and text()='New']")
	public WebElementFacade contactNewVButton;
	
	@FindBy(xpath = "//input[@data-name='u_contact_name']")
	public WebElementFacade contactName;
	
	@FindBy(xpath = "//select[@id='sn_ind_tmt_orm_order_line_item_contact.u_role']")
	public WebElementFacade contactRole;
		
	@FindBy(xpath = "//input[@aria-label='Business Phone']")
	public WebElementFacade businessPhone;
	
	
	
	
	

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return serviceOrderTab;
	}
}
