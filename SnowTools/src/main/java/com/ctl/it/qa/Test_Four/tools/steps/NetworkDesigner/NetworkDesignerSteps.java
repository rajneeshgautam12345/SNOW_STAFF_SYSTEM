//package com.ctl.it.qa.Test_Four.tools.steps.NetworkDesigner;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//
//import com.ctl.it.qa.Test_Four.tools.pages.common.NetworkDesignerPage;
//import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
//import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
//
//import net.serenitybdd.annotations.Step;
//import net.serenitybdd.core.annotations.findby.By;
//
//public class NetworkDesignerSteps extends E2ESteps {
//	NetworkDesignerPage networkdesignerpage;
//	SwiftPage swiftPage;
//
//	///////////////////////// ISE STARTS HERE /////////////////////////////////
//	@Step
//	public void user_can_work_order_in_ISE() {
//		String SIDID = System.getProperty("SID.ID");
//		System.out.println("Scenario ID is  " + SIDID); // end of getting order id
//		String USERID = System.getProperty("USER.ID");
//		System.out.println("User ID is  " + USERID); // user id to log in
//		String PSWID = System.getProperty("PSW.ID");
//		// System.out.println("User psw is " +PSWID); // passwork
//		String mpPkgID = System.getProperty("PkgId.ID");
//		System.out.println("the pkg id is  " + mpPkgID); // package id
//		networkdesignerpage.openAt(envData.getFieldValue("ISEurl")); // the swift url from the e2e.xml
//		networkdesignerpage.ise_loginname.waitUntilEnabled();
//		networkdesignerpage.ise_loginname.type(USERID); // user name
//		networkdesignerpage.ise_password.type(PSWID); // user password
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB); // Tab to log in button
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // click on the log in button
//		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//		jse.executeScript("arguments[0].click()", networkdesignerpage.btn_closex);
//		// networkdesignerpage.btn_closex.click(); // close the popup
//		waitABit(1000);
//		networkdesignerpage.btn_createdquote.waitUntilEnabled(); // click on create quote button
//		networkdesignerpage.btn_createdquote.click(); // click on create quote button
//		waitABit(2000);
//		networkdesignerpage.txt_quotedesc.type(SIDID); // enter the sm id
//		waitABit(2000);
//		networkdesignerpage.btn_createquote.waitUntilEnabled();
//		jse.executeScript("arguments[0].click()", networkdesignerpage.btn_createquote);
//		// networkdesignerpage.btn_createquote.click(); /// click on the create quote
//		// button
//		waitABit(7000);
//		try {
//			networkdesignerpage
//					.waitForAbsenceOf("//p[contains(.,'Getting productsLarger number of quotes may take some time.')]");
//		} catch (Exception e) {
//			System.out.println("in catch for number of quotes"); // end of getting order id
//		}
//		waitABit(4000);
//		networkdesignerpage.img_Details.waitUntilEnabled();
//		networkdesignerpage.img_Details.click(); // click on the details link
//		networkdesignerpage.lnk_globalvpn1.waitUntilEnabled();
//		networkdesignerpage.lnk_globalvpn1.click(); // click on the first global vpn link
//		networkdesignerpage.img_firstvpn.waitUntilEnabled();
//		networkdesignerpage.img_firstvpn.click(); // click on the first global vpn edit link
//		waitABit(4000);
//		for (int i = 0; i < 2; i++) {
//			// networkdesignerpage.txt_vrfname.click();
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//			getDriver().switchTo().activeElement().sendKeys(mpPkgID);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//			waitABit(2000);
//			WebElement element = getDriver().findElement(By.xpath("(//span[contains(@role,'img')])[202]")); // update
//			JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
//			jse1.executeScript("arguments[0].click()", element);
//			waitABit(4000);
//			WebElement element1 = getDriver().findElement(By.xpath("(//span[contains(@role,'img')])[72]")); // update
//			JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
//			jse2.executeScript("arguments[0].click()", element1);
//			waitABit(4000);
//			if (i == 0) {
//				networkdesignerpage.lnk_globalvpn2.waitUntilEnabled();
//				networkdesignerpage.lnk_globalvpn2.click(); // click on the second global vpn link
//				networkdesignerpage.img_firstvpn.waitUntilEnabled();
//				networkdesignerpage.img_firstvpn.click(); // click on the second global vpn edit link
//				waitABit(4000);
//			}
//		}
//		networkdesignerpage.btn_save.waitUntilEnabled(); // click the save button
//		networkdesignerpage.btn_save.click();
//		networkdesignerpage.btn_savedesign.waitUntilEnabled(); // click the save design
//		networkdesignerpage.btn_savedesign.click();
//		networkdesignerpage.img_proceedsave.waitUntilEnabled(); // proceed with save
//		networkdesignerpage.img_proceedsave.click(); // proceed with save
//		networkdesignerpage.waitForTextToAppear("Design Saved", 30000);
//		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
//		String myEnv = System.getProperty("staf.environment.key");
//		String myProductType = System.getProperty("myProduct.ID");
//		String mytask = "";
//		int myCounter = 0;
//		Boolean myflag;
//		myflag = false;
//		swiftPage.openAt(envData.getFieldValue("swifturl")); // the swift url from the e2e.xml
//		swiftPage.waitForTextToAppear("SEARCH", 60000);
//		swiftPage.lst_business_order_listbox.click(); // list box to pick business owner out of
//		waitABit(2000);
//		swiftPage.lst_business_order_pick.click(); // click on the "Business Order Id"
//		waitABit(2000); // leave this for timing issue returning the impersonate row
//		swiftPage.txt_searchId.type(nSwiftID); // enter the swift id
//		swiftPage.searchBtn.waitUntilEnabled(); // wait for the search button
//		swiftPage.searchBtn.click(); // click the search button
//		if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")
//				|| (myProductType.contains("IP VPN Port and Access"))) {
//			for (int i = 0; i < 2; i++) {
//				if (i == 0) {
//					swiftPage.lnk_first_order.waitUntilEnabled();
//					swiftPage.lnk_first_order.click(); // click on the first task
//					swiftPage.withTimeoutOf(10, TimeUnit.SECONDS)
//							.waitForPresenceOf(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[2]")); // wait for
//																											// first row
//																											// to show
//				}
//				if (i == 1) {
//					myflag = false;
//					swiftPage.lnk_second_order.waitUntilEnabled();
//					swiftPage.lnk_second_order.click();
//					swiftPage.withTimeoutOf(10, TimeUnit.SECONDS)
//							.waitForPresenceOf(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[2]")); // wait for
//																											// first row
//																											// to show
//				}
//				if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")) {
//					if (i == 2) {
//						swiftPage.lnk_third_order.click();
//						waitABit(5000);
//					} else {
//						break;
//					}
//				}
//				do {
//					getDriver().navigate().refresh();
//					mytask = swiftPage.findBy("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[3]/td[4]/span").getText();
//					System.out.println("the task status is  " + mytask);
//					if (mytask.equals("In Progress") || mytask.equals("Ready")) {
//						getDriver().navigate().refresh();
//						waitABit(5000);
//						myflag = false;
//						myCounter = myCounter + 1;
//						if (myCounter == 50) {
//							System.out.println("FAILED task never completed");
//							myflag = true;
//						}
//					} else {
//						if (mytask.equals("Completed")) {
//							System.out.println("Task is complete");
//							myflag = true;
//							swiftPage.searchBtn.waitUntilEnabled(); // wait for the search button
//							swiftPage.searchBtn.click(); // click the search button
//							waitABit(5000);
//						}
//					}
//				} while (myflag != true);
//			}
//		}
//		waitABit(1000);
//		System.out.println("out of network designer");
//	}
//
//	@Step
//	public void get_url_for_attachment_in_ISE() {
//		String SIDID = System.getProperty("SID.ID");
//		System.out.println("Scenario ID is  " + SIDID); // end of getting order id
//		String USERID = System.getProperty("USER.ID");
//		System.out.println("User ID is  " + USERID); // user id to log in
//		String PSWID = System.getProperty("PSW.ID");
//		System.out.println("User psw is  " + PSWID); // passwork
//		String mpPkgID = System.getProperty("PkgId.ID");
//		System.out.println("the pkg id is  " + mpPkgID); // package id
//		networkdesignerpage.openAt(envData.getFieldValue("ISEurl")); // the swift url from the e2e.xml
//		networkdesignerpage.ise_loginname.waitUntilEnabled();
//		networkdesignerpage.ise_loginname.type(USERID); // user name
//		networkdesignerpage.ise_password.type(PSWID); // user password
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB); // Tab to log in button
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // click on the log in button
//		networkdesignerpage.btn_closex.click(); // close the popup
//		waitABit(1000);
//		networkdesignerpage.btn_createdquote.waitUntilEnabled(); // click on create quote button
//		networkdesignerpage.btn_createdquote.click(); // click on create quote button
//		waitABit(1000);
//		networkdesignerpage.txt_quotedesc.type(SIDID); // enter the sm id
//		networkdesignerpage.btn_createquote.waitUntilEnabled();
//		networkdesignerpage.btn_createquote.click(); /// click on the create quote button
//		waitABit(7000);
//		networkdesignerpage
//				.waitForAbsenceOf("//p[contains(.,'Getting productsLarger number of quotes may take some time.')]");
//		waitABit(4000);
//		networkdesignerpage.img_Details.waitUntilEnabled();
//		networkdesignerpage.img_Details.click(); // click on the details link
//		networkdesignerpage.lnk_globalvpn1.waitUntilEnabled();
//		networkdesignerpage.lnk_globalvpn1.click(); // click on the first global vpn link
//		networkdesignerpage.img_firstvpn.waitUntilEnabled();
//		networkdesignerpage.img_firstvpn.click(); // click on the first global vpn edit link
//		waitABit(4000);
//		// networkdesignerpage.txt_vrfname.click();
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//		getDriver().switchTo().activeElement().sendKeys(mpPkgID);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		WebElement element = getDriver().findElement(By.xpath("(//span[contains(@role,'img')])[202]")); // update
//		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//		jse.executeScript("arguments[0].click()", element);
//		waitABit(4000);
//		WebElement element1 = getDriver().findElement(By.xpath("(//span[contains(@role,'img')])[72]")); // update
//		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
//		jse1.executeScript("arguments[0].click()", element1);
//		waitABit(4000);
//		networkdesignerpage.btn_save.waitUntilEnabled(); // click the save button
//		networkdesignerpage.btn_save.click();
//		networkdesignerpage.btn_savedesign.waitUntilEnabled(); // click the save design
//		networkdesignerpage.btn_savedesign.click();
//		networkdesignerpage.img_proceedsave.waitUntilEnabled(); // proceed with save
//		networkdesignerpage.img_proceedsave.click(); // proceed with save
//		networkdesignerpage.waitForTextToAppear("Design Saved", 30000);
//		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
//		String myEnv = System.getProperty("staf.environment.key");
//		String myProductType = System.getProperty("myProduct.ID");
//		String mytask = "";
//		int myCounter = 0;
//		Boolean myflag;
//		myflag = false;
//		swiftPage.openAt(envData.getFieldValue("swifturl")); // the swift url from the e2e.xml
//		swiftPage.waitForTextToAppear("SEARCH", 60000);
//		swiftPage.lst_business_order_listbox.click(); // list box to pick business owner out of
//		waitABit(2000);
//		swiftPage.lst_business_order_pick.click(); // click on the "Business Order Id"
//		waitABit(2000); // leave this for timing issue returning the impersonate row
//		swiftPage.txt_searchId.type(nSwiftID); // enter the swift id
//		swiftPage.searchBtn.waitUntilEnabled(); // wait for the search button
//		swiftPage.searchBtn.click(); // click the search button
//		waitABit(1000);
//		System.out.println("out of network designer");
//	}
//}
