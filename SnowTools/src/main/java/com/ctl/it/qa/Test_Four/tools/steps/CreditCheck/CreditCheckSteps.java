package com.ctl.it.qa.Test_Four.tools.steps.CreditCheck;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//

import com.ctl.it.qa.Test_Four.tools.pages.common.CreditCheckPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.Test_Four.tools.steps.Swift.SwiftSteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

public class CreditCheckSteps extends E2ESteps {
	CreditCheckPage creditcheckpage;
	SwiftPage swiftPage;
	SwiftSteps swiftsteps;

	///////////////////////// Credit check STARTS HERE
	///////////////////////// /////////////////////////////////
	@Step
	public void user_completes_Credit_Check() {
		Boolean myflag = false;
		String myName;
		int myCounter = 0;
		int myTaskCounter = -1;
		String myProductType = System.getProperty("myProduct.ID");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")
				|| (myProductType.contains("IP VPN Port and Access"))) {
			myTaskCounter = 2;
		} else {
			myTaskCounter = 1;
		}
		swiftPage.lnk_first_order.waitUntilEnabled().waitUntilClickable();
		swiftPage.lnk_first_order.click();
		String currentURL = getDriver().getCurrentUrl(); // get the current url of page in now
		String[] myTemp = currentURL.split("/"); // split the url on the "/" delimiter note- user can use split on any
													// char/number etc String [array] is used to put data in from split
		System.out.println("currentURL  is myTemp[4] " + myTemp[4]); // end of getting currentURL which has the return
																		// code number in array[5]
		System.setProperty("OrderPKG.ID", myTemp[4]); // set the pkg id name into memory
		String myOrderPkgID = System.getProperty("OrderPKG.ID"); // get the pkg id name from memory
		System.out.println("myOrderPkgID  is  " + myOrderPkgID);
		swiftPage.searchBtn.click(); // click the search button
		swiftPage.lnk_second_order.waitUntilEnabled().waitUntilClickable();
		swiftPage.lnk_second_order.click();
		swiftPage.waitForTextToAppear("Tasks", 30000);
		currentURL = getDriver().getCurrentUrl(); // get the current url of page in now
		String[] myTemp1 = currentURL.split("/"); // split the url on the "/" delimiter note- user can use split on any
													// char/number etc String [array] is used to put data in from split
		System.out.println("currentURL  is myTemp1[4] " + myTemp1[4]); // end of getting currentURL which has the return
																		// code number in array[5]
		System.setProperty("OrderPKG1.ID", myTemp1[4]); // set the pkg id name into memory
		String myOrderPkgID1 = System.getProperty("OrderPKG1.ID"); // get the pkg id name from memory
		swiftPage.openAt(envData.getFieldValue("creditcheckurl")); // the swift url from
		waitABit(2000);
		System.out.println("myOrderPkgID1  is  " + myOrderPkgID1);
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				creditcheckpage.txt_requestid.type(myOrderPkgID);
			}
			if (i == 1) {
				creditcheckpage.txt_requestid.type(myOrderPkgID1);
			}
			creditcheckpage.btn_search.waitUntilEnabled(); // search button
			creditcheckpage.btn_search.click(); // click on the search button
			creditcheckpage.btn_details.waitUntilEnabled(); // details button
			creditcheckpage.btn_details.click(); // click on the details button
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			creditcheckpage.txt_comments.type("Automation Testing");
			creditcheckpage.ddl_order_results.waitUntilEnabled(); // drop down for order details
			creditcheckpage.ddl_order_results.click(); // click on the order details
			getDriver().switchTo().activeElement().sendKeys("Appoved");
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
			creditcheckpage.btn_savechanges.waitUntilEnabled(); // save changes
			creditcheckpage.btn_savechanges.click(); // click on the changes
		}
		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
		swiftPage.openAt(envData.getFieldValue("swifturl")); // the swift url from the e2e.xml
		swiftPage.waitForTextToAppear("SEARCH", 30000);
		swiftPage.lst_business_order_listbox.click(); // list box to pick business owner out of
		waitABit(2000);
		swiftPage.lst_business_order_pick.click(); // click on the "Business Order Id"
		waitABit(2000); // leave this for timing issue returning the impersonate row
		swiftPage.txt_searchId.type(nSwiftID); // enter the swift id
		swiftPage.searchBtn.click(); // click the search button
		waitABit(10000);
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				swiftPage.lnk_first_order.waitUntilEnabled();
				swiftPage.lnk_first_order.click(); // click on the first task
				swiftPage.waitForTextToAppear("Tasks", 30000);
			}
			if (i == 1) {
				myflag = false;
				swiftPage.lnk_second_order.waitUntilEnabled();
				swiftPage.lnk_second_order.click();
				swiftPage.waitForTextToAppear("Tasks", 30000);
			}
			if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")) {
				if (i == 2) {
					swiftPage.lnk_third_order.click();
					swiftPage.waitForTextToAppear("Tasks", 30000);
				} else {
					break;
				}
			}
			do {
				getDriver().navigate().refresh();
				String mytask = swiftPage.findBy("//*[@id='taskGrid']/div[3]/table/tbody/tr[7]/td[4]/span").getText();
				System.out.println("the task status is  " + mytask);
				if (mytask.equals("In Progress") || mytask.equals("Ready")) {
					getDriver().navigate().refresh();
					waitABit(5000);
					myflag = false;
					myCounter = myCounter + 1;
					if (myCounter == 50) {
						System.out.println("FAILED task never completed");
						myflag = true;
					}
				} else {
					if (mytask.equals("Completed")) {
						System.out.println("Task is complete");
						myflag = true;
						swiftPage.searchBtn.waitUntilEnabled(); // wait for the search button
						swiftPage.searchBtn.click(); // click the search button
						waitABit(5000);
					}
				}
			} while (myflag != true);
		}
		System.out.println("out of credit check");
	}

	@Step
	public void single_location_Credit_Check(String sExpStatus, String sExpTask) {
		Boolean myflag = false;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		waitABit(1);
		WebElement taskRow;
		String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
		if (UpdatedTask.contains("1 - 5 of 5 items")) {
			waitABit(2000);
		} else {
			waitABit(30000);
			getDriver().navigate().refresh();
		}
		System.out.println("5th Task Generated");
		// waitForSwiftProgressBar();
		System.out.println("Update Task Status : " + UpdatedTask);
		String numofTask = UpdatedTask.substring(4, 5);
		System.out.println("number of Tasks are: " + numofTask);
		int myTask = Integer.parseInt(numofTask);
		System.out.println("number of Tasks are: " + myTask);
		for (int i = 3; i <= (myTask + 1);) {
			System.out.println("the number i is: " + i);
			String myStatus = getDriver()
					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[4]/span"))
					.getText();
			String myTaskName = getDriver()
					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[7]/span"))
					.getText();
			System.out.println("the status is : " + myStatus);
			System.out.println("the task is : " + myTaskName);
			if (sExpStatus.equalsIgnoreCase(myStatus) && sExpTask.equalsIgnoreCase(myTaskName)) {
				taskRow = getDriver()
						.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[7]/span"));
				taskRow.click();
				if (sExpTask.equals("Welcome Customer")) {
					// switch (sExpTask) {
					// case "Welcome Customer":
					JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].scrollIntoView(true);", taskRow);
					Actions act = new Actions(getDriver());
					act.contextClick(taskRow).perform();
					waitABit(1000);
					WebElement override;
					override = getDriver()
							.findElement(By.xpath("//*[starts-with(@ng-show,'TaskIRRules.CanOverridePending')]"));
					override.click();
					break;
				} else {
					System.out.println("this task does not require over ride " + sExpTask);
				}
			}
			WebElement taskRow1 = getDriver()
					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[5]/span"));
			String myName = taskRow1.getText(); // get the name to impersonate
			System.out.println("myName is " + myName);
			swiftPage.lbl_user_info.click(); // open impersonate box
			waitABit(5000);
			swiftPage.txt_user_info.type("");
			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
			getDriver().switchTo().activeElement().sendKeys(myName);
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
			waitABit(2000);
			swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
			myflag = swiftsteps.waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
		}
		// i = i + 1;
		waitABit(1);
	}
}
