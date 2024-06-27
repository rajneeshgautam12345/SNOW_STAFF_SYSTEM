package com.ctl.it.qa.Test_Four.tools.steps.snow;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.Snow.OrderLineItemPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class OrderLineSteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(OrderLineSteps.class);
	OrderLineItemPage orderLinePage;
	public static String exeTime;
	public static String omtTaskId;
	public void user_Validates_DIA_Characteristics(String[] expCharacteristicValues, String expAccessType,
			String expCircuitType, String expContractType, String expeRate, String expeoghnEnabled,
			String expInvoiceDesc) {
	}

	public void user_Navigates_To_Product_Order_Section() {
		orderLinePage.productOrdersTab.click();
		logger.info("Successfully clicked on Product Order Tab");
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
	}

	public void user_Validates_Workflow_for_Component(String expectedWorkflow, String component) {
		// expectedWorkflow="LMN-ORCH-DIA-Order Validation";
		String actualWorkflow = orderLinePage.workflowName.getText();
		if (actualWorkflow.equals(expectedWorkflow)) {
			logger.info("Successfully validated the workflow for " + component + " component");
		}
	}

	public void user_Clicks_On_The_Workflow_Link(String workflowName) {
		WebElement workflow = orderLinePage.getDriver()
				.findElement(By.xpath(orderLinePage.workflow1 + workflowName + orderLinePage.workflow2));
		workflow.click();
	}

	public void user_Clicks_On_Order_Task_Tab(String component) {
		
		orderLinePage.orderTasksTab.click();
		logger.info("Successfully clicked on Order Tasks tab");
	}

	public void user_Switch_Back_To_Order_Line_Item(String component) {
		String titleOfPage = getDriver().getTitle();
		System.out.println("Title----" + titleOfPage);
		//getDriver().navigate().refresh();
		waitABit(2000);	
		JavascriptExecutor jsExecutor = (JavascriptExecutor)getDriver();
		String currentFrame = (String) jsExecutor.executeScript("return self.name");	
		System.out.println("Current frame="+currentFrame);
		
		if(!currentFrame.equals("gsft_main"))
		{
		WebElement frame = getDriver().findElement(By.xpath("//iframe[@id='gsft_main']"));
		getDriver().switchTo().frame(frame);
		logger.info("Successfully switched to frame");
		}
		
		if (titleOfPage.contains("| Flow engine context |")) {		
			orderLinePage.backButton.withTimeoutOf(40, TimeUnit.SECONDS).waitUntilClickable().click();
			waitABit(3000);
			orderLinePage.backButton.withTimeoutOf(40, TimeUnit.SECONDS).waitUntilClickable().click();
			waitABit(4000);
			String actualProdSpec = orderLinePage.prodSpecification.getAttribute("value");
			if (actualProdSpec.equals(component)) {
				logger.info("Successfully navigated to " + component + " Order line Item");
			}
		}
		
		
		//getDriver().switchTo().defaultContent();
	}

	public void user_Validates_Task_Open_Status(String expTaskName) {
		List<WebElement> allTasks = orderLinePage.allTasks;
		List<WebElement> allTasksStatus = orderLinePage.allTasksStatus;
		List<WebElement> allTasksCreated= orderLinePage.allTasksCreatedDateAndTime;
		List<WebElement> allOmtTaskId= orderLinePage.allOmtTaskId;
		
		for (int i = 0; i <= allTasks.size() - 1; i++) {
			String actTaskName = allTasks.get(i).getText();
			String actTaskStatus = allTasksStatus.get(i).getText();
			String actTaskCreated = allTasksCreated.get(i).getText();
			String actOmtTaskId = allOmtTaskId.get(i).getText();
			logger.info(actTaskName + "--" + actTaskStatus);
			if (actTaskName.equals(expTaskName) && !actTaskStatus.equals("Open")) {
				logger.info(actTaskName + "--" + actTaskStatus);
				exeTime=actTaskCreated;
				omtTaskId=actOmtTaskId;
			}
		}
	}

	public void user_Validates_Task_Complete_Status(String expTaskName) {
		List<WebElement> allTasks = orderLinePage.allTasks;
		List<WebElement> allTasksStatus = orderLinePage.allTasksStatus;
		for (int i = 0; i <= allTasks.size() - 1; i++) {
			String actTaskName = allTasks.get(i).getText();
			String actTaskStatus = allTasksStatus.get(i).getText();
			if (actTaskName.equals(expTaskName) && !actTaskStatus.equals("Closed complete")) {
				logger.info(actTaskName + "--" + actTaskStatus);
			}
		}
	}

	public void user_Completes_The_Task(String taskName) {
		String taskName1 = "//td[text()='";
		String taskName2 = "']/../td[6]";
		WebElement taskNameElement = orderLinePage.getDriver().findElement(By.xpath(taskName1 + taskName + taskName2));
		String statusOfTask = taskNameElement.getText();
		if (!statusOfTask.equals("Closed complete")) {
			Actions a1 = new Actions(getDriver());
			a1.moveToElement(taskNameElement).doubleClick().perform();
			orderLinePage.stateOfTask.selectByVisibleText("Closed complete");
			a1.moveToElement(orderLinePage.saveState).click().perform();
		}
	}

	public void user_reload_The_Order_Line_Item_Page() {
		waitABit(2000);
		orderLinePage.menuIcon.click();
		waitABit(15000);
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(orderLinePage.reloadForm).click().perform();
		waitABit(5000);
		for (int i=0;i<=13;i++)
		{
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		String value=getDriver().switchTo().activeElement().getText();
		if(value.equals("Reload form"))
		{
			getDriver().switchTo().activeElement().click();
			break;
		}
		}
	}
	
	public void user_entersOrderLineCharacteristicValues(String crd) {
		waitABit(6000);
		orderLinePage.customerOrderCharacteristicTab.click();
		//orderLinePage.searchCharacteristicValue.click();
		orderLinePage.searchCharacteristicValue.sendKeys("Customer Requested Date");
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(4000);
		Actions a1=new Actions(getDriver());
		a1.moveToElement(orderLinePage.crdCharactValueClick).doubleClick().build().perform();
		//orderLinePage.crdCharactValueClick.doubleClick();
		waitABit(2000);
		
		orderLinePage.crdValueEnter.clear();
		orderLinePage.crdValueEnter.sendKeys("2024-2-10");
		//getDriver().switchTo().activeElement().sendKeys("2024-2-10");
		waitABit(1000);
		orderLinePage.saveButton.click();
		waitABit(2000);
		orderLinePage.backButton.click();
		//orderLinePage.saveState.click();
		waitABit(2000);
		
	}
	public void user_entersContactDetails()
	{
		orderLinePage.OrderLineItemContactsTab.click();
		waitABit(2000);
		orderLinePage.contactNewVButton.click();
		waitABit(2000);
		orderLinePage.contactName.sendKeys("Aaron Clark");
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		orderLinePage.contactRole.selectByVisibleText("Local Contact - Primary");
		waitABit(1000);
		orderLinePage.businessPhone.sendKeys("(425) 657-2006");
		waitABit(1000);
		orderLinePage.saveButton.click();
		waitABit(2000);
		orderLinePage.backButton.click();
		waitABit(2000);
		orderLinePage.contactNewVButton.click();
		orderLinePage.contactName.sendKeys("Aaron Clark");
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		orderLinePage.contactRole.selectByVisibleText("Local Contact - Secondary");
		waitABit(1000);
		orderLinePage.businessPhone.sendKeys("(425) 657-2006");
		waitABit(1000);
		orderLinePage.saveButton.click();
		waitABit(2000);
		orderLinePage.backButton.click();
		waitABit(2000);
		waitABit(2000);
	}

	public void user_validatesLayerOMTTask_Kicked_Off(String omtTaskName) {
		//List<WebElement> allOmtTaskId= orderLinePage.allOmtTaskId;
		String expTaskName="";
		List<WebElement> allTasks = orderLinePage.allTasks;
		List<WebElement> allTasksStatus = orderLinePage.allTasksStatus;
		List<WebElement> allTasksCreated= orderLinePage.allTasksCreatedDateAndTime;
		List<WebElement> allOmtTaskId= orderLinePage.allOmtTaskId;
		
		if(omtTaskName.equals("layer 1"))
		{
			
			expTaskName="LMN-LAYER1-ACCESS-MS";
		}
		for (int i = 0; i <= allTasks.size() - 1; i++) {
			String actTaskName = allTasks.get(i).getText();
			String actTaskStatus = allTasksStatus.get(i).getText();
			String actTaskCreated = allTasksCreated.get(i).getText();
			String actOmtTaskId = allOmtTaskId.get(i).getText();
			logger.info(actTaskName + "--" + actTaskStatus);
			
			if (actTaskName.equals(expTaskName) && !actTaskStatus.equals("Open")) {
				logger.info(actTaskName + "--" + actTaskStatus);
				exeTime=actTaskCreated;
				omtTaskId=actOmtTaskId;
			}
		}
	}
	}

