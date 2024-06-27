//package com.ctl.it.qa.Test_Four.tools.pages.common;
//
//import java.util.List;
//
//import org.openqa.selenium.WebElement;
//
//import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;
//
//import net.serenitybdd.core.annotations.findby.By;
//import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
//
//public class SnowPage extends SfaPage {
//
//    @FindBy(id = "quoteNumber") // quoteNumber
//	public WebElementFacade quoteSearchBox;
//    
//    @FindBy(id = "submitbutton") // submitButton
//   	public WebElementFacade submitButton;
//    
//    @FindBy(xpath = "//tr[@class='odd']") // orderRecordRow
//   	public WebElementFacade orderRecordRow;
//   
//    @FindBy(xpath = "(//tr[@class='odd'])/td[1]") // boid
//   	public WebElementFacade boid;
//    
//    @FindBy(xpath = "(//tr[@class='odd'])/td[5]") // processStatus
//   	public WebElementFacade processStatus;
//    
//    @FindBy(xpath = "(//tr[@class='odd'])/td[6]") // processStatus
//   	public WebElementFacade orderSystem;
//    
//    @FindBy(xpath = "(//tr[@class='odd'])/td[7]") // errorMsgDetails
//   	public WebElementFacade errorMsgDetails;
//      
//    @FindBy(xpath = "//tr[@class='odd']/td[4]") // orderId
//   	public WebElementFacade orderId;
//  
//  
//	@FindBy(id = "username") // _username
//	public WebElementFacade username;
//	
//	@FindBy(name = "login") // submit
//	public WebElementFacade submit;
//	
//	@FindBy(name = "loginfmt")
//	public WebElementFacade tbx_username;
//	@FindBy(id = "idSIButton9")
//	public WebElementFacade btn_next_submit;
//
//	@FindBy(name = "passwd")
//	public WebElementFacade tbx_password;
//	@FindBy(id = "idBtn_Back")
//	public WebElementFacade btn_NO;
//	
//	@FindBy(xpath = "//*[@placeholder='Filter navigator']") // navigatorSearchBox
//	public WebElementFacade navigatorSearchBox;
//	
//	@FindBy(xpath = "//div[text()='Customer Orders']") // navigatorSearchBox
//	public WebElementFacade customerOrders;
//	
//	@FindBy(xpath = "//select[@aria-label='Search a specific field of the Customer Orders list']") // select order search Filter
//	public WebElementFacade searchFilterName;
//	
//	
//	@FindBy(xpath = "//div[@aria-label='Customer Orders, filtering toolbar']//input[@placeholder='Search']") // navigatorSearchBox
//	public WebElementFacade customerOrderSearch;
//	
//	@FindBy(xpath = "//select[@aria-label='Search a specific field of the Customer Orders list']") // orderRecords
//	public WebElementFacade orderSearchFilter;
//	
//	@FindBy(xpath = "//tbody[@class='list2_body']/tr[1]") // orderRecords
//	public WebElementFacade orderRecords;
//	
//	public String validateSearchedOrder1="//tr[@record_class='sn_ind_tmt_orm_order']/td/a[@aria-label='Open record: ";
//	public String validateSearchedOrder2="']";
//
//	
//	@FindBy(xpath = "//*[text()='Number']") // numbers
//	public WebElementFacade numbersText;
//	
//	@FindBy(xpath = "//*[@id='approve']") // aprroveOrder
//	public WebElementFacade aprroveOrder;
//	
//	@FindBy(xpath = "//select[@id='sn_ind_tmt_orm_order.state']") // state
//	public WebElementFacade state;
//		
//	@FindBy(xpath = "//button[text()='Load Related Lists']") // loadRelatedList
//	public WebElementFacade loadRelatedList;
//	
//	//Customer Order Tabs
//	@FindBy(xpath = "//span[contains(text(),'Customer') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade customerOrderLineItemsTab;
//	
//	@FindBy(xpath = "//span[contains(text(),'TDG') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade tdgDataTab;
//
//	@FindBy(xpath = "//span[contains(text(),'Enrichments') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade serviceOrderEnrichmentsTab;
//	
//	@FindBy(xpath = "//span[contains(text(),'Related') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade relatedOrderEntitiesTab;
//	
//	@FindBy(xpath = "//span[contains(text(),'Fallouts') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade falloutTab;
//	
//	//OrderLineItemTabs
//	@FindBy(xpath = "//span[contains(text(),'Characteristic') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade customerOrderCharacteristicTab;
//	
//	@FindBy(xpath = "//span[contains(text(),'Contacts') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade OrderLineItemContactsTab;
//	
//	@FindBy(xpath = "//span[contains(text(),'Product') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade productOrdersTab;
//		
//	@FindBy(xpath = "//span[contains(text(),'Tasks') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade orderTasksTab;
//	
//	@FindBy(xpath = "//span[contains(text(),'Service') and @class='tab_caption_text']") // aprroveOrder
//	public WebElementFacade serviceOrderTab;
//	
//	
//	@FindBy(xpath = "//tr[@record_class='u_related_order_numbers']/td[3]/a") // aprroveOrder
//	public List<WebElement> relatedOrderEntitiesName;
//	
//	@FindBy(xpath = "//tr[@record_class='u_related_order_numbers']/td[4]/a") // aprroveOrder
//	public List<WebElement> relatedOrderEntitiesValue;
//	
//	
//	
//	String productSpecification1="//td[@class='vt']/a[text()='";
//	String productSpecification2="']";
//
//	@FindBy(xpath = "//tr/td[4][@class='vt']/a[text()='") // aprroveOrder
//	public WebElementFacade diaOrderLineItem;
//	
//	
//	public String orderLineItem1="//td[4][@class='vt']/a[text()='";
//	public String orderLineItem2="']/../../td/a[@class='linked formlink']";
//	
//	public String customerOrderCharacteristicsValue1="//td/a[@aria-label='Open record: ";
//	public String customerOrderCharacteristicsValue2="']/../../td[7]";
//
//	@FindBy(xpath = "//*[@id='user_info_dropdown']/div/span[1]") // user
//	public WebElementFacade userName;
//	
//	@FindBy(xpath = "//*[@role='menu']/li[2]") // user
//	public WebElementFacade impersonate;
//	
//	@FindBy(xpath = "//div[@id='s2id_autogen1']") // user
//	public WebElementFacade searchUser;
//	
//	
//	@FindBy(xpath = "//tr[@record_class='sn_ind_tmt_orm_product_order']/td/a[contains(@href, 'sys_flow_context.do')]") // user
//	public WebElementFacade workflowName;
//	
//	
//	public String workflow1="//td/a[text()='";
//	public String workflow2="']";
//	
//	@FindBy(xpath = "//a[@data-now-ux-metrics-link-name='Open in Operations View']") // user
//	public WebElementFacade operationView;
//	
////	@FindBy(xpath = "//div[@class='metainfo']/span[1]") // aprroveOrder
////	public List<WebElement> workflowStatus;
//	
//	@FindBy(xpath = "//div[contains(@aria-label, 'Step number')]/div[@class='metainfo']/span[1]") // aprroveOrder
//	public List<WebElement> workflowStatus;
//	
//	@FindBy(xpath = "//div[contains(@aria-label, 'Step number')]//div[@class='title']/span[1]") // aprroveOrder
//	public List<WebElement> workflow_Name;
//	
//	
//	@FindBy(xpath = "//div[contains(@aria-label, 'Step number')]//div[@class='comments annotation-added']/p") // aprroveOrder
//	public List<WebElement> workflowCommentName;
//	
//	@FindBy(xpath = "//span[@id='flowExecutionStateText']") // user
//	public WebElementFacade workflowExecutionStatus;
//
//	@FindBy(xpath = "//button[@data-original-title='Back']") // user
//	public WebElementFacade backButton;
//	
//	@FindBy(xpath = "//div[@id='element.sn_ind_tmt_orm_order_line_item.product_specification']/div[2]/div[2]/input") // prod Specificn
//	public WebElementFacade prodSpecification;
//	
//	@FindBy(xpath = "//tr[@record_class='sn_ind_tmt_orm_order_task']/td[4]") // aprroveOrder
//	public List<WebElement> allTasks;
//	
//	@FindBy(xpath = "//tr[@record_class='sn_ind_tmt_orm_order_task']/td[5]") // aprroveOrder
//	public List<WebElement> allTasksStatus;
//	//List<WebElement> allTasks=getDriver().findElements(By.xpath("//tr[@record_class='sn_ind_tmt_orm_order_task']/td[4]"));
//	//List<WebElement> allTasksStatus=getDriver().findElements(By.xpath("//tr[@record_class='sn_ind_tmt_orm_order_task']/td[6]"));
//		
//	@FindBy(xpath = "//select[@name='sn_ind_tmt_orm_order_task.state']") // prod Specificn
//	public WebElementFacade stateOfTask;
//	
//	@FindBy(xpath = "//td/a[@id='cell_edit_ok']") // prod Specificn
//	public WebElementFacade saveState;
//	
//	@FindBy(xpath = "//button[@aria-label='Refresh Flow Data']") // prod Specificn
//	public WebElementFacade workflowRefresh;
//	
//	
////	@FindBy(xpath = "//*[@class='select2-search']/input") // user
////	public WebElementFacade searchUser;
//	
//	@FindBy(xpath = "//button[@aria-label='Refresh Flow Data']") // prod Specificn
//	public List<WebElement> serviceOrderRecords;
//	//*[@record_class='sn_ind_tmt_orm_service_order']
//	@FindBy(xpath = "//*[@record_class='sn_ind_tmt_orm_service_order']//a[contains(@aria-label,'Open record: LMN')]") // prod Specificn
//	public List<WebElement> serviceOrderWorkflows;
//	
//	
//	@Override
//	public WebElementFacade getUniqueElementInPage() {
//		return username;
//		// return txt_searchId;
//	}
//}
