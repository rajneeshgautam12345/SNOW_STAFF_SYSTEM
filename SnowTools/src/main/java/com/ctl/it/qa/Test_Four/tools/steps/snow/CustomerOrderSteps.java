package com.ctl.it.qa.Test_Four.tools.steps.snow;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.Snow.CustomerOrderPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class CustomerOrderSteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(CustomerOrderSteps.class);
	CustomerOrderPage customerOrderPage;
	public static String snowOrderId = null;

	public void landed_To_Orders_Details() {
		customerOrderPage.waitForTextToAppear("Number", 90000);
	}

	public void clicks_On_Approve_Order() {
		customerOrderPage.aprroveOrder.click();
		logger.info("Successfully clicked on Approve Order button");
	}

	public void validatesOrderApproved() {
		String stateValue = customerOrderPage.state.getSelectedValue();
		if (stateValue.equals("In progress")) {
			logger.info("Order successfully approved");
		}
	}

	public void clicks_On_Related_Items() {
		// customerOrderPage.loadRelatedList.click();
	}

	public void clicks_On_Related_Order_Entities() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", customerOrderPage.relatedOrderEntitiesTab);
		waitABit(2000);
		executor.executeScript("arguments[0].click()", customerOrderPage.relatedOrderEntitiesTab);
		logger.info("Successfully clicked on Related Order Item tab");
	}

	public void validates_Related_Order_Entities() {
		for (int i = 0; i <= customerOrderPage.relatedOrderEntitiesName.size() - 1; i++) {
			String entityName = customerOrderPage.relatedOrderEntitiesName.get(i).getText();
			String entityValue = customerOrderPage.relatedOrderEntitiesValue.get(i).getText();
			if (entityName.equals("Quote Number")) {
				String expectedQuoteNo = System.getProperty("SID.ID");
				entityValue.equals(expectedQuoteNo);
				System.out.println("Successfully validated Quote ID- " + entityValue);
			} else if (entityName.equals("Salesforce Opportunity ID")) {
				String oppId = System.getProperty("Order.ID");
				entityValue.equals(oppId);
				System.out.println("Successfully validated Opportunity Id- " + entityValue);
			}
		}
	}

	public void user_Navigates_To_Component_Order_Line_Item(String orderLineProdComp) {
		waitABit(10000);
		customerOrderPage.customerOrderLineItemsTab.click();
		customerOrderPage.getDriver().findElement(
				By.xpath(customerOrderPage.orderLineItem1 + orderLineProdComp + customerOrderPage.orderLineItem2));
		customerOrderPage.getDriver()
				.findElement(By
						.xpath(customerOrderPage.orderLineItem1 + orderLineProdComp + customerOrderPage.orderLineItem2))
				.click();
		logger.info("Successfully clicked to " + orderLineProdComp + " order line item");
	}

	public void user_navigates_Back_To_CustomerOrderPage_From_OrderLineItem() {
		waitABit(2000);
		customerOrderPage.backButton.click();
		waitABit(3000);
		logger.info("Successfully navigated to Customer Order Page");
	}

	public void clicks_On_Technical_Data_Gathering_Tab() {
		
		waitABit(2000);
		customerOrderPage.tdgDataTab.click();
		waitABit(3000);
		logger.info("Successfully clicked on Technical data gathering tab");
	
	}

	public void enters_AccessType_and_AccessSubType_details() {		
		customerOrderPage.tdgRecord.click();
		waitABit(1000);
		//customerOrderPage.accessType.sendKeys("Off Net");
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		customerOrderPage.saveButton.click();			
	}

	//public void enters_ip_Subnet_details(String ipMode, String ipVersion,String ip_Wan_Lan,String block_To_Assign,String routing_Protocol,String ip_Scope) {
		public void enters_ip_Subnet_details() {

		customerOrderPage.ipRoutingNewButton.click();
		customerOrderPage.ipMode.sendKeys("Bridged");
		waitABit(500);
		Select s1 = new Select(customerOrderPage.ipVersion);
		s1.selectByVisibleText("IPv4");
		waitABit(500);
		//customerOrderPage.ipVersion.sendKeys("IPv4");
		Select s2 = new Select(customerOrderPage.ip_Wan_Lan);
		s2.selectByVisibleText("WAN");
		waitABit(1000);
		//customerOrderPage.ip_Wan_Lan.sendKeys("WAN");
		customerOrderPage.block_To_Assign.sendKeys("/30");
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(1000);
		customerOrderPage.routing_Protocol.sendKeys("Static");
		waitABit(500);
		customerOrderPage.ip_Scope.sendKeys("Public");
		waitABit(500);
		customerOrderPage.saveButton.click();
		waitABit(2000);
				
	}

	//public void enters_transport_access_details(String ipMode,String ipVersion,String ip_Wan_Lan,String block_To_Assign,String routing_Protocol,String ip_Scope  ) {
		public void enters_transport_access_details( ) {	
			
		String accessType=customerOrderPage.getNetworkStatus.getAttribute("value");
			
		customerOrderPage.transportAccess.click();
		waitABit(1000);
		customerOrderPage.transportAccessNewButton.click();
		waitABit(1000);
		customerOrderPage.uniPortSpeed.sendKeys("1000 Mbps");
		waitABit(200);
		customerOrderPage.loaRequired.sendKeys("No");
		waitABit(200);
		customerOrderPage.uniInterfaceType.sendKeys("Fiber");
		waitABit(200);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(400);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		customerOrderPage.uniMode.sendKeys("MM");
		waitABit(200);
		customerOrderPage.uniConnectorType.sendKeys("LC");
		waitABit(200);
		customerOrderPage.redundantPowerSupply.sendKeys("No");
		waitABit(200);
		customerOrderPage.powerType.sendKeys("AC");
		waitABit(200);
		customerOrderPage.customerCpeDuplex.sendKeys("Hard-coded Full");
		waitABit(200);
		customerOrderPage.taggingType.sendKeys("Untagged");
		waitABit(200);
		customerOrderPage.uniType.sendKeys("Transparent");
		waitABit(200);
		if(accessType.equals("Off Net"))
		{
		customerOrderPage.interfaceRate.sendKeys("Ethernet 1000M");
		waitABit(200);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(200);
		customerOrderPage.offnetQty.sendKeys("1");
		waitABit(200);
		customerOrderPage.colocationClli.sendKeys("BNNTCOAP");
		waitABit(200);
		customerOrderPage.seclocationAccess.sendKeys("BNNTCOAPS01");
		waitABit(200);
		customerOrderPage.interfaceType.sendKeys("OpticalMMF");
		waitABit(200);
		}
		customerOrderPage.classOfService.sendKeys("Basic");
		waitABit(500);
		
		customerOrderPage.saveButton.click();
		waitABit(2000);
		
		
	}
		
		
		public void user_Approve_Credit_Check_Status()
		{
			waitABit(2000);
			customerOrderPage.creditCheckStatus.selectByVisibleText("Approved");
			waitABit(5000);
			customerOrderPage.saveButton.click();
			waitABit(2000);
			
		}

		public void clicks_On_Service_Order_Enrichment_Items() {
			JavascriptExecutor executor = (JavascriptExecutor) getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", customerOrderPage.serviceOrderEnrichmentsTab);
			waitABit(2000);
			executor.executeScript("arguments[0].click()", customerOrderPage.serviceOrderEnrichmentsTab);
			logger.info("Successfully clicked on Service Order Enrichment tab");
			
		}

		public void user_Validates_Port_Service_Alias_Value() {
			
			String portServiceAlias=customerOrderPage.portServiceAliasValue.getText();
			if(!portServiceAlias.equals("(empty)"))
			{
				System.out.println("Port Service Value-"+portServiceAlias+ "successfully validated");
			}
			
		}

		public void user_navigates_to_Mesh_Path_action() {
			
			String subflowStatus=getDriver().findElement(By.xpath("//span[text()='LMN SOMDIA Path Comp - Main-MS subflow']/../../..//div[3]/span")).getText();
			if(subflowStatus.equals("Waiting"))
			{
				getDriver().findElement(By.xpath("//span[text()='LMN SOMDIA Path Comp - Main-MS subflow']/../../..//div[4]/div/a[2]")).click();
				
			}
			
			String subflowStatus2=getDriver().findElement(By.xpath("//span[text()='LMN-SOM-Path Comp MESH']/../../..//div[3]/span")).getText();
			
			if(subflowStatus2.equals("Waiting"))
			{
				getDriver().findElement(By.xpath("//span[text()='LMN-SOM-Path Comp MESH']/../../..//div[4]/div/a[2]")).click();
				
			}
			
			String meshPathActionStatus=getDriver().findElement(By.xpath("//span[text()='MESH Path Comp']/../../../../div[3]/span[1]")).getText();
			
			if(!meshPathActionStatus.equals("Completed"))
			{
			 //refreshworkflow()
			}
				
			
		}

		public void user_validates_device_and_port_details_of_mesh_response() {
			
			getDriver().findElement(By.xpath("//span[text()='MESH Path Comp']")).click();
			
			String deviceName=getDriver().findElement(By.xpath("//span[text()='Device']/../span[2]")).getText();
			String port=getDriver().findElement(By.xpath("//span[text()='Port']/../span[2]")).getText();
			
			
			
			
			
		}

		public void open_Path_Comp_Workflow(String flowName) {
			
			if(flowName.equals("path comp workflow"))
			{
				flowName= "*LMN SOMDIA Path Comp - Main-MS";
				
				getDriver().findElement(By.xpath("//span[@aria-label='Home']")).click();
				getDriver().findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("flowName");
				getDriver().findElement(By.xpath("//a[text()='LMN SOMDIA Path Comp - Main-MS']")).click();
				getDriver().findElement(By.xpath("//button[@id='btn_moreActionsPopoverButton']")).click();
				getDriver().findElement(By.xpath("//button[@aria-label='Open Executions List']")).click();
				
				String omtTaskId="OMTASK000052792";
				String executionLink1="//a[text()='Order Task: ";
				String executionLink2="']/../../td[3]/a";
				
				getDriver().findElement(By.xpath(executionLink1+omtTaskId+executionLink2)).click();

				
			}
			else if(flowName.equals("layer1 workflow"))
			{
				flowName= "LMN-SOM-AP Layer 1 Access";
				
				getDriver().findElement(By.xpath("//span[@aria-label='Home']")).click();
				//getDriver().findElement(By.xpath("//a[text()='Subflows']")).click();
				
				getDriver().findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("flowName");
				getDriver().findElement(By.xpath("//a[text()='LMN Layer 1 Access']")).click();
				getDriver().findElement(By.xpath("//button[@id='btn_moreActionsPopoverButton']")).click();
				getDriver().findElement(By.xpath("//button[@aria-label='Open Executions List']")).click();
				
				String omtTaskId="OMTASK000052792";
				String executionLink1="//a[text()='Order Task: ";
				String executionLink2="']/../../td[3]/a";
				
				getDriver().findElement(By.xpath(executionLink1+omtTaskId+executionLink2)).click();

			}
			
						
			
			}
}
