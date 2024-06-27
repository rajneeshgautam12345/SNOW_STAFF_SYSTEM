package com.ctl.it.qa.Test_Four.tools.pages.Snow;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ctl.it.qa.Test_Four.tools.pages.SfaPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FlowDesignerPage extends SfaPage {
	@FindBy(xpath = "//div[contains(@aria-label, 'Step number')]//div[@class='comments annotation-added']/p/../../../div[@class='metainfo']/span[1]")
	public List<WebElement> workflowStatus;
	
	
	@FindBy(xpath = "//div[contains(@aria-label, 'Step number')]//div[@class='title']/span[1]/../../../div[@class='metainfo']/span[1]")
	public List<WebElement> workflowStatus1;
	
	
	@FindBy(xpath = "//div[contains(@aria-label, 'Step number')]//div[@class='title']/span[1]")
	public List<WebElement> workflow_Name;
	@FindBy(xpath = "//div[contains(@aria-label, 'Step number')]//div[@class='comments annotation-added']/p")
	public List<WebElement> workflowCommentName;
	@FindBy(xpath = "//span[@id='flowExecutionStateText']")
	public WebElementFacade workflowExecutionStatus;
	@FindBy(xpath = "//button[@aria-label='Refresh Flow Data']")
	public WebElementFacade workflowRefresh;
	
	@FindBy(xpath = "//span[@data-tip='Home']")
	public WebElementFacade workflowHomeIcon;
	
	@FindBy(xpath = "//li/a[text()='Flows']")
	public WebElementFacade flowsIcon;
	
	@FindBy(xpath = "//input[@aria-label='Search']")
	public WebElementFacade flowsSearchText;
	
	public String flowName1="//tr/td/a[text()='";
	public String flowName2="']";
	
	@FindBy(xpath = "//button[@id='btn_moreActionsPopoverButton']")
	public WebElementFacade flowMoreActionButton;
	
	@FindBy(xpath = "//ul//li/button[text()='Executions']")
	public WebElementFacade executionsOption;

	@FindBy(xpath = "//select[@aria-label='Search a specific field of the Flow engine contexts list']")
	public WebElementFacade executionSearchDropdown;
	
	@FindBy(xpath = "//tr/td/a[contains(@href, 'sn_ind_tmt_orm_order_task.do?')]")
	public List<WebElement> omtTaskValidate;
	

	@FindBy(xpath = "//tr/td/a/div[1]")
	public List<WebElement> workflowExecutionLinks;
	
	
	@FindBy(xpath = "(//div[text()='Run as: System'])[1]")
	public WebElementFacade runAsSystem;
	
	@FindBy(xpath = "//div[contains(@aria-label, 'Step number 3 a Subflow LMN-WFO-MVP-OffNet')]/div/div/a[2]")
	public WebElementFacade openSubflowOffnet;
	
	
	//tr/td/a[text()='LMN WFO MVP OffNet']

	

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return workflowExecutionStatus;
	}
}
