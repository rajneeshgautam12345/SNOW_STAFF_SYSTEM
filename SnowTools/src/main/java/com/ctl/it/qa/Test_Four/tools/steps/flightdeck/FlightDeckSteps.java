package com.ctl.it.qa.Test_Four.tools.steps.flightdeck;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.Test_Four.tools.pages.common.FlightDeckPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.Swift.SwiftSteps;
import com.ctl.it.qa.Test_Four.tools.steps.snow.ServiceNowSteps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class FlightDeckSteps extends E2ESteps {
	
	FlightDeckPage flightDeck;

	@Step
	public void logs_in_flightDeck() {
		
		String userType="Valid";
		String FDUrl = envData.getFieldValue("FlightDeck");
		String myUser =envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_uname");
		String myUserPassword = envData.getContainer("LoginPage").getContainer(userType).getFieldValue("tbx_password");
		getDriver().switchTo().newWindow(WindowType.WINDOW);
		// Opens FD homepage in the newly opened window
		getDriver().navigate().to(FDUrl);		
		//getDriver().get(FDUrl);
		System.out.println("Url is entered");
//		getDriver().manage().window().maximize();
//		System.out.println("window is maximized");
		System.out.println("FlightDeck Page is exists");
		flightDeck.username.waitUntilClickable().withTimeoutOf(90, TimeUnit.SECONDS);
		flightDeck.username.sendKeys(myUser);
		waitABit(1000);
		flightDeck.password.sendKeys(myUserPassword);
		waitABit(1000);
		flightDeck.loginButton.click();
	}

	@Step
	public void navigate_To_AdvanceSearch() {
		flightDeck.waitForTextToAppear("Basic Menu", 60000);
		flightDeck.basicMenuButton.waitUntilClickable().withTimeoutOf(60, TimeUnit.SECONDS);
		flightDeck.basicMenuButton.click();
		flightDeck.advanceSearch.waitUntilClickable().withTimeoutOf(60, TimeUnit.SECONDS);
		flightDeck.advanceSearch.click();
		flightDeck.waitForTextToAppear("Order ID", 60000);
	}

	@Step
	public void validateAdvanceSearchPage() {
		flightDeck.advanceSearchHeader.waitUntilEnabled().withTimeoutOf(60, TimeUnit.SECONDS);
	}

	@Step
	public void searchOrderId() {
		// String orderId = SwiftSteps.myOpid;
		String orderId = "553314604";
		SwiftSteps.myOpid = "553314604";
		String sourceTaskIdSearch = "AP-";
		flightDeck.orderIDSearch.waitUntilClickable().withTimeoutOf(60, TimeUnit.SECONDS);
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(flightDeck.excludeSysTaskCheckbox).click().build().perform();
		// flightDeck.excludeSysTaskCheckbox.click();
		waitABit(1000);
		Select s1 = new Select(flightDeck.sourceTaskIdDropdown);
		s1.selectByVisibleText("contains");
		// flightDeck.orderIDSearch.click();
		waitABit(1000);
		flightDeck.sourceTaskISearchTextBox.sendKeys(sourceTaskIdSearch + orderId);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		getDriver().switchTo().activeElement().sendKeys(sourceTaskIdSearch+orderId);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(5000);
		// flightDeck.searchButton.click();
	}

	@Step
	public void selectPerPageTaskSize(String size) {
		WebElement sizeWebelement = getDriver().findElement(By.xpath("//span[text()='Per Page: ']/..//select"));
		Select s1 = new Select(sizeWebelement);
		s1.selectByVisibleText(size);
	}

	
	@Step
	public void User_Search_Task(String targetTaskName) {
		waitABit(5000);
		int totalPages = getPageCount();
		boolean status = false;
		for (int i = 1; i <= totalPages - 1; i++) {
			List<WebElement> allTasks = getDriver()
					.findElements(By.xpath("//div[@col-id='TASK_NAME' and @role='gridcell']/div/span"));
			List<WebElement> allTaskStatus = getDriver().findElements(
					By.xpath("//div[@col-id='TASK_STATUS' and @role='gridcell']/div/span"));
			System.out.println("Size of task Row--" + allTasks.size());
			for (int j = 0; j <= allTasks.size() - 1; j++) {
				String taskName = allTasks.get(j).getText();
				String taskStatus = allTaskStatus.get(j).getText();
				System.out.println("Task Name--" + taskName+ "-"+taskStatus);
				if (taskName.equals(targetTaskName)) {
					System.out.println("Found the target task");
					status = true;
					//allSourceTaskId.get(j).click();
					break;
				}
			}
			if (status == true) {
				break;
			} else {
				WebElement nextPageIcon = getDriver().findElement(By.xpath("//div[@aria-label='Next Page']"));
				Actions a1 = new Actions(getDriver());
				a1.moveToElement(nextPageIcon).click().build().perform();
				waitABit(3000);
			}
		}
		waitABit(4000);
	}
	
	
	public void User_Validate_Task_completed(String targetTaskName) {
		//Offnet Manual Design Template
		
		String taskStatus1="//div[@col-id='TASK_NAME']/div/span[text()='";
		String taskStatus2="']/../../../div[@col-id='TASK_STATUS']/div/span";
		
		String actTaskStatus=getDriver().findElement(By.xpath(taskStatus1+targetTaskName+taskStatus2)).getText();
		
		if(actTaskStatus.equals("Completed"))
		{
			System.out.println(targetTaskName+ "-successfully completed");
		}
	}
	@Step
	public void User_Search_And_Open_Task(String targetTaskName) {
		waitABit(5000);
		int totalPages = getPageCount();
		boolean status = false;
		for (int i = 1; i <= totalPages - 1; i++) {
			List<WebElement> allTasks = getDriver()
					.findElements(By.xpath("//div[@col-id='TASK_NAME' and @role='gridcell']/div/span"));
			List<WebElement> allSourceTaskId = getDriver().findElements(
					By.xpath("//div[@col-id='TASK_NAME' and @role='gridcell']/div/span/../../../div[3]/div"));
			System.out.println("Size of task Row--" + allTasks.size());
			for (int j = 0; j <= allTasks.size() - 1; j++) {
				String taskName = allTasks.get(j).getText();
				System.out.println("Task Name--" + taskName);
				if (taskName.equals(targetTaskName)) {
					System.out.println("Found the target task");
					status = true;
					allSourceTaskId.get(j).click();
					break;
				}
			}
			if (status == true) {
				break;
			} else {
				WebElement nextPageIcon = getDriver().findElement(By.xpath("//div[@aria-label='Next Page']"));
				Actions a1 = new Actions(getDriver());
				a1.moveToElement(nextPageIcon).click().build().perform();
				waitABit(3000);
			}
		}
		waitABit(4000);
	}

	@Step
	public void UserSuccessfullyCompleted_ConfirmSchedule_Activation_Task(String taskName) {
		String taskName1 = "//*[text()='";
		String taskName2 = "']/../../../div[@col-id='TASK_INSTANCE_ID']";
		getDriver().findElement(By.xpath(taskName1 + taskName + taskName2)).click();
	}

	@Step
	public void UserComplete_Service_Validate_Field_Task(String taskName) {
		String taskName1 = "//*[text()='";
		String taskName2 = "']/../../../div[@col-id='TASK_INSTANCE_ID']";
		getDriver().findElement(By.xpath(taskName1 + taskName + taskName2)).click();
	}

	@Step
	public void UserComplete_Service_Validate_UNI_Task(String taskName) {
		String taskName1 = "//*[text()='";
		String taskName2 = "']/../../../div[@col-id='TASK_INSTANCE_ID']";
		getDriver().findElement(By.xpath(taskName1 + taskName + taskName2)).click();
		// *[text()='Confirm/Schedule
		// Activation']/../../../div[@col-id='TASK_INSTANCE_ID']
	}

	@Step
	public void UserComplete_Send_Completion_Details_Task(String taskName) {
		String taskName1 = "//*[text()='";
		String taskName2 = "']/../../../div[@col-id='TASK_INSTANCE_ID']";
		getDriver().findElement(By.xpath(taskName1 + taskName + taskName2)).click();
	}

	@Step
	public int getPageCount() {
		// waitABit(5000);
		String totalRecords = getDriver().findElement(By.xpath("//span[@ref='lbRecordCount']")).getText();
		System.out.println("Total Records--" + totalRecords);
		int total_Records = Integer.parseInt(totalRecords);
		System.out.println("Coverted into int--" + total_Records);
		// double totalPageSize=total_Records/10;
		int total_PageSize = total_Records / 10;
		System.out.println("Page1--" + total_PageSize);
		int rem = total_Records % 10;
		System.out.println("Remainder Value--" + rem);
		if (rem != 0) {
			total_PageSize = total_PageSize + 1;
			System.out.println("Final Total Page size" + total_PageSize);
		}
		return total_PageSize;
	}

	@Step
	public SearchContext expandRootElement(WebElement element) {
		SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) getDriver())
				.executeScript("return arguments[0].shadowRoot", element);
		return shadowRoot;
	}

	@Step
	public void AssignWorkbookAndUserToTask(String locatorValue) {
		waitABit(5000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		// Assign click operation
		WebElement ele = (WebElement) executor.executeScript(
				"return document.querySelector(\"#print-section1>fdc-page-2\").shadowRoot.querySelector(\"#dom-id-page-vertical-1\").shadowRoot.querySelector(\"div.page-div>fdc-tab >fdc-actions-widget\").shadowRoot.querySelector(\"#Assign\")");
		ele.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(500);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(500);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(500);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1000);
		getDriver().switchTo().activeElement().click();
		waitABit(2000);
		for (int i = 0; i <= 200; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			String workbook = getDriver().switchTo().activeElement().getText();
			System.out.println("Workbook--" + workbook);
			if (workbook.equals("ASRI Support")) {
				getDriver().switchTo().activeElement().click();
				System.out.println("Selected the ASRI Support Workbook");
				break;
			}
		}
		waitABit(5000);
		WebElement UserDropdown = (WebElement) executor.executeScript(
				"return document.querySelector(\"#Select\\\\ User\").shadowRoot.querySelector(\"div.dropdown > div.dropdown-field\")");
		UserDropdown.click();
		waitABit(1000);
		for (int i = 0; i <= 50; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			String userName = getDriver().switchTo().activeElement().getText();
			// waitABit(100);
			System.out.println("Username--" + userName);
			if (userName.equals("Mohapatra, Biswabhusan - AD01991")) {
				getDriver().switchTo().activeElement().click();
				System.out.println("Selected the current user");
				break;
			}
		}
		waitABit(5000);
		WebElement save = (WebElement) executor
				.executeScript("return document.querySelector(\"#Save\").shadowRoot.querySelector(\"button\")");
		executor.executeScript("arguments[0].click()", save);
		waitABit(6000);
		WebElement alretClose = (WebElement) executor.executeScript(
				"return document.querySelector(\"#mat-tab-content-0-2 > div > div > app-page-content > sa-task-details-framework > fd-task-detail-micro > div:nth-child(1) > fdc-alert\").shadowRoot.querySelector(\"#btn-alert-close\")");
		executor.executeScript("arguments[0].click()", alretClose);
		waitABit(2000);
	}

	@Step
	public void completeTask() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement completeButton = (WebElement) executor.executeScript(
				"return document.querySelector(\"#print-section1 > fdc-page-2\").shadowRoot.querySelector(\"#dom-id-page-vertical-1\").shadowRoot.querySelector(\"div.page-div > fdc-tab > fdc-actions-widget\").shadowRoot.querySelector(\"#Complete\")");
		executor.executeScript("arguments[0].click()", completeButton);
		waitABit(8000);
	}

	@Step
	public void validateTaskCompletedStatus() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement taskStatus = (WebElement) executor.executeScript(
				"return document.querySelector(\"#print-section1 > fdc-page-2\").shadowRoot.querySelector(\"#dom-id-page-vertical-1\").shadowRoot.querySelector(\"#dom-id-page-section-1\").shadowRoot.querySelector(\"#dom-id-page-section-1-col-1\").shadowRoot.querySelector(\"#dom-id-widget-statusInfoWidget\").shadowRoot.querySelector(\"#card_title > span:nth-child(2)\")");
		String StatusValue = taskStatus.getAttribute("class");
		if (taskStatus.equals("Completed")) {
			System.out.println("Successfully validated the status of the task" + StatusValue);
		}
	}

	@Step
	public void closeAllTab() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement closeTab = (WebElement) executor.executeScript(
				"return document.querySelector(\"#header > fdc-closable-chip\").shadowRoot.querySelector(\"div > div.chip-close\")");
		closeTab.click();
		waitABit(2000);
	}
	@Step
	public void User_Search_Order_In_QuickSearch() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement quickSearch = (WebElement) executor.executeScript(
				"return document.querySelector(\"#menuitems > div:nth-child(6) > div > div > div:nth-child(2) > div > div > div:nth-child(1) > div > fdc-input\").shadowRoot.querySelector(\"div > input\")");
		quickSearch.clear();
		quickSearch.sendKeys(ServiceNowSteps.snowOrderId);
		WebElement serchButton = getDriver().findElement(By.xpath("//button[@class='mat-focus-indicator sbmt-btn mat-stroked-button mat-button-base']"));
		serchButton.click();
		waitABit(2000);
	}
	
	public void user_Switch_To_Flight_Deck_Window()
	{
		//getDriver().switchTo().defaultContent();
		Set<String> allWindows = getDriver().getWindowHandles();
		for (String window : allWindows) {
			String title = getDriver().switchTo().window(window).getTitle();
			System.out.println("Window Titles--" + title);
			if (title.equals("Flight Deck")) {
				getDriver().switchTo().window(window);
				waitABit(2000);
				break;
			}
			}
		}
	}
	


