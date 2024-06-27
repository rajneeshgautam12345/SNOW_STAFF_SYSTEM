package com.ctl.it.qa.Test_Four.tools.steps.snow;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.Snow.FlowDesignerPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

@SuppressWarnings("serial")
public class FlowDesignerSteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(FlowDesignerSteps.class);
	FlowDesignerPage flowDesignerPage;

	public void user_switch_To_The_Workflow_Window() {
		//String parentWindow = getDriver().getWindowHandle();
		getDriver().switchTo().defaultContent();
		Set<String> allWindows = getDriver().getWindowHandles();
		for (String window : allWindows) {
			String title = getDriver().switchTo().window(window).getTitle();
			if (title.startsWith("Flow Designer - Operations View :")) {
				getDriver().switchTo().window(window);
				logger.info("Successfully switched to flow designer window");
			}
		}
	}

	public void user_Switch_Back_To_Flow_Engine_Context_Window() {
		getDriver().switchTo().defaultContent();
		Set<String> allWindows = getDriver().getWindowHandles();
		for (String window : allWindows) {
			String title = getDriver().switchTo().window(window).getTitle();
			System.out.println("Window Titles--" + title);
			if (title.contains("LMN-ORCH-DIA-Order Validation | Flow engine context | ServiceNow")) {
				getDriver().switchTo().window(window);
				waitABit(2000);
				break;
			}
		}
	}

	public void user_Switch_Back_To_OrderLineWindow_Tab() {
		Set<String> allWindows = getDriver().getWindowHandles();
		for (String window : allWindows) {
			String title = getDriver().switchTo().window(window).getTitle();
			System.out.println("Window Titles--" + title);
			if (!title.startsWith("Flow Designer")) {
				getDriver().switchTo().window(window);
				logger.info("Switched to order line window");
				waitABit(2000);
				break;
			}
		}
	}

	public void user_Validates_TDG_Task_Wait_Status() {
		waitABit(8000);
		int count = 0;
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		flowDesignerPage.runAsSystem.click();
		waitABit(1000);
		for (int i = 1; i <= 10; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		}
		for (int i = 0; i <= allWorkflowStatus.size() - 1; i++) {
			String workflowCommentsName = "";
			String statusOfWorkflow = allWorkflowStatus.get(i).getText();
			if (i < 15) {
				workflowCommentsName = allWorkflowCommentName.get(i).getText();
				logger.info(i + "-" + workflowCommentsName + " - " + statusOfWorkflow);
			}
			if ((i <= 9) && (statusOfWorkflow.equals("Waiting") && (count <= 3))) {
				refreshWorkflow();
				logger.info("Successfully clicked on refresh workflow");
				i = 0;
				count++;
			} else if ((workflowCommentsName.equals("WAIT FOR TDG TO FINISH"))
					&& (statusOfWorkflow.equals("Waiting"))) {
				logger.info("Waiting for TDG Task to be completed in Snow");
				break;
			}
		}
	}

	public void user_Validates_Order_Validation_Wait_Status() {
		waitABit(8000);
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		// List<WebElement> allWorkflowName = flowDesignerPage.workflow_Name;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		flowDesignerPage.runAsSystem.click();
		waitABit(1000);
		for (int i = 1; i <= 32; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		}
		waitABit(1000);
		for (int i = 0; i <= allWorkflowStatus.size() - 1; i++) {
			String workflowCommentsName;
			String statusOfWorkflow = allWorkflowStatus.get(i).getText();
			// String WorkflowName = allWorkflowName.get(i).getText();
			if (i <= 24) {
				workflowCommentsName = allWorkflowCommentName.get(i).getText();
				logger.info(i + " workflowCommentsName" + "-" + workflowCommentsName + "-" + statusOfWorkflow);
			} else {
				workflowCommentsName = "Not Req";
			}
			// logger.info(WorkflowName + "-" + statusOfWorkflow);
			if ((i <= 21) && (statusOfWorkflow.equals("Waiting"))) {
				refreshWorkflow();
				i = 0;
			} else if ((workflowCommentsName.equals("[SOX COMPLIANCE]: Wait for task closure / resolution."))
					&& (statusOfWorkflow.equals("Waiting"))) {
				logger.info("Waiting for Order validation task to be completed in Snow");
				break;
			}
		}
	}

	public void user_Validates_Credit_Check_Wait_Status() {
		waitABit(8000);
		refreshWorkflow();
		int count = 0;
		flowDesignerPage.runAsSystem.click();
		waitABit(1000);
		for (int i = 1; i <= 35; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		}
	    List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		//List<WebElement> allWorkflowStatus1 = flowDesignerPage.workflowStatus1;
		//List<WebElement> allWorkflowName = flowDesignerPage.workflow_Name;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		for (int i = 0; i <= allWorkflowStatus.size() - 1; i++) {
			String workflowCommentsName = "";
			 String statusOfWorkflow = allWorkflowStatus.get(i).getText();
			//String statusOfWorkflow1 = allWorkflowStatus1.get(i).getText();
			//String workflowName = allWorkflowName.get(i).getText();
			if (i < 35) {
				 workflowCommentsName = allWorkflowCommentName.get(i).getText();
			     logger.info(i + "-" + workflowCommentsName + " - "+statusOfWorkflow);
				//logger.info(i + "-" + workflowName + " - " + statusOfWorkflow1);
			}
			if ((i <= 30) && statusOfWorkflow.equals("Waiting") && (count <= 5)) {
				refreshWorkflow();
				logger.info("Successfully clicked on workflow refresh");
				i = 21;
				count++;
			} else if ((workflowCommentsName.equals("[Credit Check]: Wait for closure"))
					&& statusOfWorkflow.equals("Waiting")) {
				logger.info("Waiting for Credit check to be approved");
				break;
			}
		}
	}

	public void user_Validates_CCM_Task_Wait_Status() {
		waitABit(8000);
		refreshWorkflow();
		int count = 0;
		flowDesignerPage.runAsSystem.click();
		waitABit(1000);
		for (int i = 1; i <= 46; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		}
		waitABit(1000);
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus1;
		// List<WebElement> allWorkflowName = flowDesignerPage.workflow_Name;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		for (int i = 0; i <= allWorkflowStatus.size() - 1; i++) {
			String workflowCommentsName = "";
			String statusOfWorkflow = allWorkflowStatus.get(i).getText();
			if (i <= 20) {
				workflowCommentsName = allWorkflowCommentName.get(i).getText();
				logger.info(i + workflowCommentsName + "-" + statusOfWorkflow);
			}
			if ((i <= 12) && (statusOfWorkflow.equals("Waiting")) && (count <= 5)) {
				refreshWorkflow();
				logger.info("Successfully clicked on Workflow refresh");
				i = 2;
				count++;
			} else if ((workflowCommentsName.equals("DIGITAL DIALOG]: Create CCM Task"))
					&& (statusOfWorkflow.equals("Waiting"))) {
				logger.info("Waiting for CCM Task to be completed in Snow");
				break;
			}
		}
	}

	public void user_Validates_IIQ_Task_Wait_Status() {
		waitABit(8000);
		int count = 0;
		refreshWorkflow();
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		// List<WebElement> allWorkflowName = flowDesignerPage.workflow_Name;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		waitABit(1000);
		for (int i = 1; i <= 62; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		}
		waitABit(1000);
		for (int i = 0; i <= allWorkflowStatus.size() - 1; i++) {
			String workflowCommentsName;
			String statusOfWorkflow = allWorkflowStatus.get(i).getText();
			// String WorkflowName = allWorkflowName.get(i).getText();
			// logger.info(i + "-" + WorkflowName + "-" + statusOfWorkflow);
			workflowCommentsName = allWorkflowCommentName.get(i).getText();
			logger.info(i + workflowCommentsName + "-" + statusOfWorkflow);
			// logger.info(workflowCommentsName + "-" + statusOfWorkflow);
			if ((statusOfWorkflow.equals("Waiting")) && (i <= 44) && (count <= 5)) {
				refreshWorkflow();
				i = 5;
				count++;
			} else if ((workflowCommentsName.equals("[IIQ Anchor Dates]")) && (statusOfWorkflow.equals("Waiting"))) {
				logger.info("Waiting for IIQ Task to be completed in Snow");
				waitABit(20000);
				refreshWorkflow();
			} else if ((workflowCommentsName.equals("[IIQ Anchor Dates]")) && (statusOfWorkflow.equals("Completed"))) {
				logger.info("IIQ flow successfully completed in Snow");
				break;
			}
		}
	}

	public void refreshWorkflow() {
		flowDesignerPage.workflowRefresh.click();
		waitABit(8000);
		logger.info("Successfully clicked on workflow refresh");
	}

	public void validatesWorkflowComleted(String workflowName) {
		for (int i = 1; i <= 5; i++) {
			String workflowExeStatus = flowDesignerPage.workflowExecutionStatus.getText();
			if (workflowExeStatus.equals("Waiting")) {
				refreshWorkflow();
				waitABit(10000);
			}
			if (workflowExeStatus.equals("Completed")) {
				logger.info("Successfully completed Order Validation workflow");
			}
		}
	}

	public void User_Open_The_Workfow(String workflow) {
		flowDesignerPage.workflowHomeIcon.click();
		flowDesignerPage.flowsIcon.click();
		flowDesignerPage.flowsSearchText.sendKeys(workflow);
		flowDesignerPage.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		getDriver()
				.findElement(By.xpath(flowDesignerPage.flowName1 + "LMN WFO MVP OffNet" + flowDesignerPage.flowName2))
				.click();
		flowDesignerPage.flowMoreActionButton.click();
		flowDesignerPage.executionsOption.click();
		// tr/td/a[text()='LMN WFO MVP OffNet']
		
		
		List<WebElement> allExecutionLink= getDriver().findElements(By.xpath("//tr/td/a/div[1]"));
		
		flowDesignerPage.executionSearchDropdown.selectByVisibleText("Created");
		flowDesignerPage.flowsSearchText.sendKeys(OrderLineSteps.exeTime);
		flowDesignerPage.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		
		for(int i=0;i<=flowDesignerPage.omtTaskValidate.size()-1;i++)
		{
			String workflowExecutionLinks=flowDesignerPage.workflowExecutionLinks.get(i).getText();
			String actOmtTaskId=flowDesignerPage.omtTaskValidate.get(i).getText();
			if(OrderLineSteps.omtTaskId.equals(actOmtTaskId))
			{
				flowDesignerPage.workflowExecutionLinks.get(i).click();
				waitABit(2000);
			}
		}
	
	}
	
	public void user_Navigates_To_LMN_WFO_MVP_OffNet_Subflow()
	{
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;

		for(int i=0;i<=allWorkflowStatus.size()-1;i++)
		{
			String statusOfWorkflow = allWorkflowStatus.get(i).getText();
			String workflowCommentName=allWorkflowCommentName.get(i).getText();
			
			if((i==0) && (workflowCommentName.equals("OffNet Flow"))&&(statusOfWorkflow.equals("Waiting")))
			{
				flowDesignerPage.openSubflowOffnet.click();
				waitABit(2000);
			}
		}
	}
	
	public void user_Validates_Offnet_Flow_Waiting_For_Offnet_Manual_Design_Task()
	{
		int count=0;
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		waitABit(1000);
		for (int i = 0; i <= allWorkflowStatus.size() - 1; i++) {
			String workflowCommentsName;
			String statusOfWorkflow = allWorkflowStatus.get(i).getText();
			workflowCommentsName = allWorkflowCommentName.get(i).getText();
			logger.info(i+"-"+workflowCommentsName+" - "+statusOfWorkflow);
			if ((statusOfWorkflow.equals("Waiting")) && (i <= 11) && (count <= 5))
			{
						refreshWorkflow();
						i = 5;
						count++;
			} 
			else if ((workflowCommentsName.equals("[Wait for response]")) && (statusOfWorkflow.equals("Waiting"))) {
						logger.info("Waiting for Offnet Manual Design Task to be completed");
						break;
			}
					
	 }
	}
	
	public void user_Validates_Subflow_Create_Offnet_Port_Completed()
	{
		int count=0;
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		waitABit(1000);
		for (int i = 0; i <= allWorkflowStatus.size() - 1; i++) {
			String workflowCommentsName;
			String statusOfWorkflow = allWorkflowStatus.get(i).getText();
			workflowCommentsName = allWorkflowCommentName.get(i).getText();
			logger.info(i+"-"+workflowCommentsName+" - "+statusOfWorkflow);
			if ((statusOfWorkflow.equals("Waiting")) && (i <= 23) && (count <= 5))
			{
						refreshWorkflow();
						i = 5;
						count++;
			} 
			else if ((workflowCommentsName.equals("This Sub Flow has the logic for both Install and SUPP for 'LMN-Initialize OffNet UNI Itential Flow'")) && (statusOfWorkflow.equals("Completed"))) {
						logger.info("Create Offnet Port workflow kicked off in AP");
						break;
			}
					
	 }
	}
	

	public void user_Validates_Subflow_Completed_Under_Flow(int i,String subflow,String flow)
	{
		int count=0;
		List<WebElement> allWorkflowStatus1 = flowDesignerPage.workflowStatus1;
		List<WebElement> allWorkflowName = flowDesignerPage.workflow_Name;
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		waitABit(1000);
		for (int j = 0; j <= allWorkflowStatus.size() - 1; j++) {
			String workflowCommentsName;
			String statusOfWorkflow = allWorkflowStatus.get(j).getText();
			workflowCommentsName = allWorkflowCommentName.get(j).getText();
			logger.info(j+"-"+workflowCommentsName+" - "+statusOfWorkflow);
			if ((statusOfWorkflow.equals("Waiting")) && (j <= i) && (count <= 5))
			{
						refreshWorkflow();
						j = 1;
						count++;
			} 
			else if ((workflowCommentsName.equals(subflow)) && (statusOfWorkflow.equals("Completed"))) {
						logger.info("");
						break;
			}
					
	 }
	}
	
	
	public void user_Validates_Subflow_Waiting_Under_Flow(int i,String flow,String subflow)
	{
		int count=0;
		List<WebElement> allWorkflowStatus1 = flowDesignerPage.workflowStatus1;
		List<WebElement> allWorkflowName = flowDesignerPage.workflow_Name;
		List<WebElement> allWorkflowStatus = flowDesignerPage.workflowStatus;
		List<WebElement> allWorkflowCommentName = flowDesignerPage.workflowCommentName;
		waitABit(1000);
		for (int j = 0; j <= allWorkflowStatus.size() - 1; j++) {
			String workflowCommentsName;
			String statusOfWorkflow = allWorkflowStatus.get(j).getText();
			workflowCommentsName = allWorkflowCommentName.get(j).getText();
			logger.info(j+"-"+workflowCommentsName+" - "+statusOfWorkflow);
			if ((statusOfWorkflow.equals("Waiting")) && (j <= i) && (count <= 5))
			{
						refreshWorkflow();
						j = 1;
						count++;
			} 
			else if ((workflowCommentsName.equals(subflow)) && (statusOfWorkflow.equals("Waiting"))) {
						logger.info("Successfully validated the "+flow+" is waiting for "+subflow);
						break;
			}
					
	 }
	}
	
}
