package com.ctl.it.qa.Test_Four.tools.steps.Swift;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
//
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.MetaStormPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;
import com.ctl.it.qa.staf.Page;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

@SuppressWarnings("serial")
public class SwiftSteps extends E2ESteps {
	public static String myOpid = null;
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;
	SwiftPage swiftpage;
	MetaStormPage metastormpage;
	String sess = null;
	String orderpackageid = null;
	private final Logger logger = LoggerFactory.getLogger(SwiftSteps.class);

	public Boolean waitForSwiftProgressBar() {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				waitABit(3000);
				if (productPage.isElementVisible(By.xpath("//*[@id='ajax-spinner']/div/div[1]"))) {
					System.out.println("Loading progress bar is dispayed");
					ncounter = ncounter + 1;
					waitABit(2000);
				} else {
					System.out.println("All good");
					bflag = true;
				}
			} while (bflag != true);
			System.out.println("out of try for  waitForSwiftProgressBar");
			System.out.println("Loading progress bar  counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}

	@SuppressWarnings("deprecation")
	public void Log_in_Swift_get_order(String tasknum) {
		// tasknum is being used to send in name of the product
		int myCounter;
		int pkgCounter;
		Boolean myflag;
		myflag = false;
		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
		String myEnv = System.getProperty("staf.environment.key");
		String myProductType = System.getProperty("myProduct.ID");
		// String myProductType="Dedicated Internet Access";
		swiftPage.openAt(envData.getFieldValue("swifturl")); // the swift url from the e2e.xml
		swiftPage.waitForTextToAppear("SEARCH", 30000);
		E2ESteps.softAssertError("In Swift", true, "the BOID ", String.valueOf(nSwiftID));
		if (nSwiftID.isEmpty()) {
			logger.info("failed BOID is empty ending test ");
			getDriver().close();
			getDriver().quit();
		}
		waitABit(2000);
		swiftPage.lst_business_order_listbox.click(); // list box to pick business owner out of
		waitABit(2000);
		swiftPage.lst_business_order_pick.click(); // click on the "Business Order Id"
		waitABit(2000); // leave this for timing issue returning the impersonate row
		swiftPage.txt_searchId.type(nSwiftID); // enter the swift id
		swiftPage.searchBtn.click(); // click the search button
		waitABit(10000);
		myflag = false;
		myCounter = 0;
		pkgCounter = 0;
		String sholder = "";
		do {
			// try {
			if ((senarioDataPage.find(By.xpath("//*[@id='NoRecordsFoundMessage']")).getAttribute("style")).equals("")) {
				// sholder =
				// senarioDataPage.find(By.xpath("//*[@id='orderPackagesGrid']/div[2]/div[1]/div"))
				// .getTextValue();
				logger.info("waiting 10 sec for first row showed going to check and push search again "); // write the
																											// swift
																											// first row
																											// to show
				// if (sholder.contains("No recods available.")) {
				swiftPage.searchBtn.click(); // click the search button
				logger.info("Swift search button pushed again"); // write the swift search button pushed
				waitABit(10000);
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				myflag = false;
				myCounter = myCounter + 1;
				System.out.println("Record counter is " + myCounter);
				if (myCounter == 40) {
					logger.info("FAILED no record showed up");
					getDriver().close();
					getDriver().quit();
					myflag = true;
				}
			} else {
				logger.info("No records error not found");
				myflag = true;
			}
		} while (myflag != true);
		boolean status = false;
		int counter = 0;
		while (status == false && counter != 10) {
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='taskTab']/div//table/tbody/tr[2]")));
				// WebElement firstEle=getDriver().findElement(By.xpath(""));
				getDriver().findElement(By.xpath("//div[@id='taskTab']/div//table/tbody/tr[2]")).isEnabled();
				status = true;
				logger.info("Status of first gtask kicked off=" + status);
			} catch (TimeoutException e) {
				logger.info("First task is not kicked off");
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				counter++;
			}
		}
		waitABit(1000);
		if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")
				|| (myProductType.contains("IP VPN Port and Access111"))) {
			swiftPage.withTimeoutOf(100, TimeUnit.SECONDS)
					.waitForPresenceOf(By.xpath("//*[@id='orderPackagesGrid']/div[2]/table/tbody/tr[1]/td[1]")); // wait
																													// for
																													// first
																													// row
																													// to
																													// show
		} else {
			swiftPage.withTimeoutOf(600, TimeUnit.SECONDS)
					.waitForPresenceOf(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[2]")); // wait for first row
																									// // to show
		}
		System.out.println(" first row showed "); // write the swift first row to show
		System.out.println("records returned");
		System.out.println("out of senerio manager and all the timing");
		String url1 = getDriver().getCurrentUrl();
		System.out.println("Current URL : " + url1);
		String sOpid = url1.toString();
		myOpid = url1.substring(30, 39);
		System.out.println("the Order package id is " + myOpid);
		if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")
				|| (myProductType.equals("IP VPN Port and Access111"))) {
			swiftPage.lnk_first_order.click(); // click on the first task
			swiftPage.waitForTextToAppear("Tasks", 30000);
			getDriver().navigate().refresh();
			swiftPage.withTimeoutOf(100, TimeUnit.SECONDS)
					.waitForPresenceOf(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[2]")); // wait for first row
																									// to show
			for (int i = 0; i < 2; i++) {
				if (i == 1) {
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
				swiftPage.waitForTextToAppear("Ready", 20000); // Wait for Upload;
				String myName = swiftPage.txt_assignee_name.getText(); // get the name to impersonate
				System.out.println("myName is " + myName);
				swiftPage.lbl_user_info.click(); // open impersonate box
				waitABit(3000);
				swiftPage.txt_user_info.type("");
				getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
				getDriver().switchTo().activeElement().sendKeys(myName);
				waitABit(2000);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
				waitABit(2000);
				swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				waitABit(2000);
			}
			try {
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				swiftPage.btn_oes_order_pick.click(); // cause oes list to open
				waitABit(2000);
				swiftPage.lst_oes_order_pick.click(); // using click because object is described in page as list box
														// pick
				waitABit(2000);
				swiftPage.btn_completeTask.click(); // press the complete button.
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
				swiftPage.searchBtn.click(); // click the search button
			} catch (Exception e) {
				System.out.println(e);
			}
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
		} else {
			String myName = swiftPage.txt_assignee_name.getText(); // get the name to impersonate
			logger.info("myName is " + myName);
			swiftPage.lbl_user_info.click(); // open impersonate box
			waitABit(2000);
			for (int r = 0; r <= 30; r++) {
				WebElement imersonationBox = getDriver()
						.findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"));
				String value = imersonationBox.getAttribute("aria-activedescendant");
				logger.info("Selected Option--" + value);
				waitABit(1000);
				value = value + "Yes";
				System.out.println(value.length());
				if (value.length() != 7) {
					logger.info("Impersoante Text box value present");
					break;
				}
			}
			swiftPage.txt_user_info.type("");
			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
			getDriver().switchTo().activeElement().sendKeys(myName);
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);// ded network type
			waitABit(2000);
			swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				logger.info("error in waitForSwiftProgressBar");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			waitABit(2000);
			try {
				swiftPage.btn_oes_order_pick.click(); // cause oes list to open
				waitABit(2000);
				swiftPage.lst_oes_order_pick.click(); // using click because object is described in page as list box
														// pick 2
			} catch (Exception e) {
				System.out.println(e);
			}
			waitABit(2000);
			swiftPage.btn_completeTask.click(); // press the complete button.
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				logger.info("error in waitForSwiftProgressBar");
			}
			logger.info("Swift Impersonate row is set"); // write the Swift Impersonate row is set
			logger.info("out of swift and all the timing");
		}
	}

	public void Re_Log_into_Swift() {
		// tasknum is being used to send in name of the product
		int myCounter;
		Boolean myflag;
		myflag = false;
		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
		String myEnv = System.getProperty("staf.environment.key");
		swiftPage.openAt(envData.getFieldValue("swifturl")); // the swift url from the e2e.xml
		swiftPage.waitForTextToAppear("SEARCH", 30000);
		waitABit(5000);
		swiftPage.lst_business_order_listbox.click(); // list box to pick business owner out of
		waitABit(4000);
		swiftPage.lst_business_order_pick.click(); // click on the "Business Order Id"
		waitABit(2000); // leave this for timing issue returning the impersonate row
		swiftPage.txt_searchId.type(nSwiftID); // enter the swift id
		swiftPage.searchBtn.click(); // click the search button
		waitABit(10000);
		myflag = false;
		myCounter = 0;
		String sholder = "";
		do {
			try {
//				sholder = senarioDataPage.find(By.xpath("//*[@id='orderPackagesGrid']/div[2]/div[1]/div"))
//						.getTextValue();
				sholder = senarioDataPage.find(By.xpath("//div[@id='taskTab']/div//table/tbody/tr[2]/td[7]/span"))
						.getTextValue();
				logger.info("waiting 10 sec for first row showed going to check and push search again "); // write
																											// the
																											// swift
																											// first
																											// row
																											// to
																											// show
				if (sholder.contains("No records available.")) {
					swiftPage.searchBtn.click(); // click the search button
					logger.info("Swift search button pushed again"); // write the swift search button pushed
					waitABit(10000);
					getDriver().navigate().refresh(); // refresh the page
					waitABit(5000);
					myflag = false;
					myCounter = myCounter + 1;
					System.out.println("Record counter is " + myCounter);
					if (myCounter == 300) {
						logger.info("FAILED no record showed up");
						getDriver().close();
						getDriver().quit();
						myflag = true;
					}
				} else {
					logger.info("Order records showed up");
					myflag = true;
				}
			} catch (Exception e) {
				System.out.println(e);
				myflag = true;
			}
		} while (myflag != true);
		waitABit(100);
	}

	@Step
	public void Verify_Swift_order_success() {
		int myCounter;
		Boolean myflag;
		myflag = false;
		// look for the order to be completed.
		try {
			swiftPage.tab_orderDetailsTab.waitUntilEnabled();// click on ordering tab
			swiftPage.tab_orderDetailsTab.click();// click on ordering tab
			System.out.println("had to press order Details tab to open"); // end of row 3
		} catch (Exception e) {
			System.out.println(e);
		} // end of catch
		myflag = false;
		myCounter = 0;
		do {
			String checkOrder = swiftPage.lbl_OrderPackageStatusLbl.getTextValue();
			if (checkOrder.equals("InProgress")) {
				getDriver().navigate().refresh();
				myflag = false;
				myCounter = myCounter + 1;
				if (myCounter == 50) {
					System.out.println("FAILED Order ready did NOT show up");
					myflag = true;
				}
			} else {
				if (checkOrder.equals("Ordered") || checkOrder.equals("Approved")) {
					System.out.println("Order is ready");
					myflag = true;
				}
			}
		} while (myflag != true);
	}

	@Step
	public void user_adds_PSP_order() {
		Boolean myflag;
		String SIDID = System.getProperty("SID.ID");
		String endUserClli = null;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				swiftPage.lnk_first_order.waitUntilEnabled();
				swiftPage.lnk_first_order.click();
				swiftPage.waitForTextToAppear("Tasks", 30000);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);// move down
				swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
				swiftPage.btn_productPackagesTab.click(); // click on the product package tab
				swiftPage.lnk_service_address.waitUntilEnabled(); // click on service addres
				swiftPage.lnk_service_address.click(); // click on service address
				endUserClli = swiftPage.txt_enduserclli.getText(); // get end user clli
				System.out.println("End user Clli is:  " + endUserClli);
				waitABit(2000);
				swiftPage.btn_serviceaddressClose.waitUntilEnabled(); // close service location window
				swiftPage.btn_serviceaddressClose.click(); // close service location window
				swiftPage.btn_addPspBtn.click(); // click on the PSP Button
				swiftPage.txt_searchClliCriteriaTextBox.type(endUserClli); // add the clli to text box
				getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
				swiftPage.btn_location_search_button.waitUntilEnabled(); // click on search button
				swiftPage.btn_location_search_button.click(); // click on search button
				waitABit(5000);
				swiftPage.img_filtercheckbox.click();// check the filter drop down image
				swiftPage.img_filter.click();// check the filter drop down image
				swiftPage.txt_filterinput.type(endUserClli); // search for the cilli
				swiftPage.btn_filtersearch.click(); // press the search button
				waitABit(5000);
				WebElement loc_element = getDriver()
						.findElement(By.xpath("//*[@id=\"locationSearchGrid\"]/div[2]/table/tbody/tr/td[2]/span"));
				String myLocation = loc_element.getText();
				System.out.println("Location is : " + myLocation);
				WebElement cbxClli_element = getDriver().findElement(By.name(myLocation));
				// waitABit(3000);
				executor.executeScript("arguments[0].click();", cbxClli_element); // check the clli check box
				waitABit(2000);
				swiftPage.btn_pspNext.waitUntilEnabled();// click the next button
				swiftPage.btn_pspNext.click();// click the next button
				swiftPage.waitForTextToAppear("Products", 30000);
				swiftPage.btn_addnewpsp.waitUntilEnabled(); // click on new product package button
				swiftPage.btn_addnewpsp.click(); // click on new product package button
				swiftPage.ddl_pspproduct.waitUntilEnabled(); // the product drop down
				swiftPage.ddl_pspproduct.click(); // the product drop down
				getDriver().switchTo().activeElement().sendKeys("VRF ID");// pick product
				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
				waitABit(2000);
				swiftPage.ddl_pspaddress.waitUntilEnabled();// get the address loaded
				swiftPage.ddl_pspaddress.click();// get the address loaded
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				waitABit(2000);
				swiftPage.btn_pspprproductNext.waitUntilEnabled();// click the next button
				swiftPage.btn_pspprproductNext.click();// click the next button
				JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
				jse1.executeScript("arguments[0].click()", swiftPage.btn_productPackagesTab);
				// swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product
				// package tab
				// swiftPage.btn_productPackagesTab.click(); // click on the product package tab
				waitABit(2000);
				swiftPage.btn_pspNext.waitUntilEnabled();// click the next button
				swiftPage.btn_pspNext.click();// click the next button
				swiftPage.btn_pspprproducSave.waitUntilEnabled();// click the save button
				swiftPage.btn_pspprproducSave.click();// click the save button
				waitABit(2000);
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
				swiftPage.btn_productPackagesTab.click(); // click on the product package tab
				getDriver().switchTo().activeElement().sendKeys(Keys.DOWN);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
				System.out.println("above the vfr task: ");
				swiftPage.arr_vrfid.waitUntilEnabled(); // open the vrf id task
				swiftPage.arr_vrfid.click(); // open the vrf id task
				System.out.println("below the vfr task: ");
				String prodPkgID = swiftPage.lbl_productpkgID.getText(); // get the product package id
				System.out.println("product package id is: " + prodPkgID);
				System.setProperty("PkgId.ID", prodPkgID); // set the swift id in memory
				String myPkgID = System.getProperty("PkgId.ID"); // get the swift id out of memory
				System.out.println(" My product package id is: " + myPkgID);
				swiftPage.arr_vrfid_arrow.waitUntilEnabled(); // open up the vrf id dropdown
				swiftPage.arr_vrfid_arrow.click(); // open up the vrf id dropdown
				swiftPage.lbl_vrfid_secondLabel.waitUntilEnabled(); // click on vrfid label
				swiftPage.lbl_vrfid_secondLabel.click(); // click on vrfid label
				waitABit(2000);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
				swiftPage.lnk_details.waitUntilEnabled(); // click on the details link
				swiftPage.lnk_details.click(); // click on the details link
				waitABit(2000);
				swiftPage.btn_cbpban.waitUntilEnabled(); // CPB ban edit icon
				swiftPage.btn_cbpban.click(); // CPB ban edit icon
				waitABit(2000);
				swiftPage.btn_new_ban.waitUntilEnabled(); // add the scenario id
				swiftPage.btn_new_ban.click(); // add the scenario id
				waitABit(2000);
				swiftPage.btn_cbpban_search.waitUntilEnabled(); // click on the cbp ban sear
				swiftPage.btn_cbpban_search.click(); // click on the cbp ban search
				waitABit(5000);
				swiftPage.txt_accountname.waitUntilEnabled();
				swiftPage.txt_accountname.click(); // click on account name to pick one
				swiftPage.btn_accountsearch.waitUntilEnabled(); // click on search button
				swiftPage.btn_accountsearch.click(); // click on search button
				waitABit(2000);
				WebElement element = getDriver()
						.findElement(By.xpath("(//span[contains(@class,'glyphicon glyphicon-ok')])[21]"));
				waitABit(2000);
				element.click();
				waitABit(2000);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				WebElement elementsave = getDriver().findElement(By.xpath("//*[@id='saveChanges']")); // have to go to
																										// top of page
																										// and hit save
																										// changes for
																										// this app to
																										// save any
																										// edits
				waitABit(2000);
				elementsave.click();
				waitABit(2000);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//		   	 swiftPage.arr_vrfid.waitUntilEnabled(); // open first logical interface
//		   	 swiftPage.arr_vrfid.click(); // open first logical interface
//		   	 waitABit(1000);
//		   	 swiftPage.lbl_ipvpnlogicalinterface_1.waitUntilEnabled(); // click on logical interface label to open it up
//		   	 swiftPage.lbl_ipvpnlogicalinterface_1.click(); // click on logical interface label to open it up
				List<WebElement> parentProducts = getDriver().findElements(By.cssSelector(
						".row.small-gutter#orderdetailssection .k-master-row.ng-scope [role=\"gridcell\"] .ng-binding[ ng-bind=\"dataItem.ProductName\"]")); // return
																																								// task
																																								// names
				for (WebElement ele : parentProducts) {
					if (ele.getText().contains("IP VPN Logical Interface")) {
						ele.click(); // opens first one
						getDriver().findElement(By.cssSelector(
								".container-fluid .col-md-12  table[role='treegrid'] .k-selectable .k-master-row"))
								.click(); // click on child
						break;
					}
				}
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
				// swiftPage.lnk_details.waitUntilClickable().click(); // click on the details
				// link
				swiftPage.lnk_detailedit.waitUntilEnabled(); // click on the edit pencil for VRF ID
				swiftPage.lnk_detailedit.click(); // click on the edit pencil for VRF ID
				swiftPage.btn_autofill.waitUntilEnabled(); // click on auto fill
				swiftPage.btn_autofill.click(); // click on auto fill
				waitABit(8000);
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
				waitABit(3000);
				swiftPage.btn_searchvrf.waitUntilEnabled(); // click on search
				swiftPage.btn_searchvrf.click(); // click on search
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
				swiftPage.img_vfrfiltercheckbox.waitUntilEnabled();// check the filter drop down image for vfr
				swiftPage.img_vfrfiltercheckbox.click();// check the filter drop down image for vfr
				swiftPage.img_vrffilter.waitUntilEnabled();// check the filter drop down image
				swiftPage.img_vrffilter.click();// check the filter drop down imag
				// myPkgID=System.getProperty("PkgId.ID"); // get the swift id out of memory
				swiftPage.txt_filterinput.type(myPkgID); // search for the cilli
				swiftPage.btn_filter.waitUntilEnabled(); // click on filter
				swiftPage.btn_filter.click(); // click on filter
				swiftPage.lbl_vrfid.waitUntilEnabled(); // click on the link
				swiftPage.lbl_vrfid.click(); // click on the link
				swiftPage.btn_savevrf.waitUntilEnabled(); // click on save
				swiftPage.btn_savevrf.click(); // click on save
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				// getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				WebElement elementsave2 = getDriver().findElement(By.xpath("//*[@id='saveChanges']")); // have to go to
																										// top of page
																										// and hit save
																										// changes for
																										// this app to
																										// save any
																										// edits
				waitABit(2000);
				elementsave2.click();
				waitABit(2000);
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			}
			if (i == 1) {
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				swiftPage.searchBtn.waitUntilEnabled(); // click the search button
				swiftPage.searchBtn.click(); // click the search button
				swiftPage.lnk_second_order.waitUntilEnabled();
				swiftPage.lnk_second_order.click();
				swiftPage.waitForTextToAppear("Tasks", 30000);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
				// getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
				swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
				swiftPage.btn_productPackagesTab.click(); // click on the product package tab
//		   	 swiftPage.arr_secondLogInterface.waitUntilEnabled(); // second chevron for logical interface
//		   	 swiftPage.arr_secondLogInterface.click(); // second chevron for logical interface
//		     swiftPage.lbl_ipvpnlogicalinterface_2.waitUntilEnabled(); // click on logical interface label to open it
//		     swiftPage.lbl_ipvpnlogicalinterface_2.click(); // click on logical interface label to open itup
//		   	 WaitAndSync();
				List<WebElement> parentProducts = getDriver().findElements(By.cssSelector(
						".row.small-gutter#orderdetailssection .k-master-row.ng-scope [role=\"gridcell\"] .ng-binding[ ng-bind=\"dataItem.ProductName\"]")); // return
																																								// to
																																								// quote
																																								// button
				for (WebElement ele : parentProducts) {
					if (ele.getText().contains("IP VPN Logical Interface")) {
						ele.click(); // opens first one
						getDriver().findElement(By.cssSelector(
								".container-fluid .col-md-12  table[role='treegrid'] .k-selectable .k-master-row"))
								.click(); // click on child
						break;
					}
				}
				swiftPage.lnk_details.waitUntilEnabled(); // click on the details link
				swiftPage.lnk_details.click(); // click on the details link
				swiftPage.lnk_detailedit.waitUntilEnabled(); // click on the edit pencil for VRF ID
				swiftPage.lnk_detailedit.click(); // click on the edit pencil for VRF ID
				swiftPage.btn_autofill.waitUntilEnabled(); // click on auto fill
				swiftPage.btn_autofill.click(); // click on auto fill
				WaitAndSync();
				waitABit(2000);
				swiftPage.btn_searchvrf.waitUntilEnabled(); // click on search
				swiftPage.btn_searchvrf.click(); // click on search
				WaitAndSync();
				swiftPage.txt_accountname1.waitUntilEnabled(); // click on account name to pick one
				swiftPage.txt_accountname1.click(); // click on account name to pick one
				swiftPage.btn_savevrf.waitUntilEnabled(); // click on save
				swiftPage.btn_savevrf.click(); // click on save
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				WebElement elementsave3 = getDriver().findElement(By.xpath("//*[@id='saveChanges']")); // have to go to
																										// top of page
																										// and hit save
																										// changes for
																										// this app to
																										// save any
																										// edits
				waitABit(2000);
				elementsave3.click();
				waitABit(2000);
				System.out.println("out of PSP");
			}
		}
	}

	@Step
	public void user_completes_WelcomeCustomer() {
		Boolean myflag;
		String myName;
		String myProductType = System.getProperty("myProduct.ID");
		String SIDID = System.getProperty("SID.ID");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")
				|| (myProductType.contains("IP VPN Port and Access"))) {
			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					getDriver().navigate().refresh(); // refresh the page
					waitABit(5000);
					swiftPage.searchBtn.click(); // click the search button
					swiftPage.lnk_first_order.waitUntilEnabled().waitUntilClickable();
					swiftPage.lnk_first_order.click();
					swiftPage.waitForTextToAppear("Tasks", 30000);
					myName = swiftPage.txt_welcomeCustomer_assignee_name.getText();
					swiftPage.lbl_user_info.click(); // open impersonate box
					waitABit(5000);
					swiftPage.txt_user_info.type("");
					getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
					getDriver().switchTo().activeElement().sendKeys(myName);
					waitABit(2000);
					getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
					waitABit(2000);
					swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
					myflag = waitForSwiftProgressBar();
					if (myflag) {
						System.out.println("error in waitForSwiftProgressBar");
					}
					WebElement elementWelcomeCust = getDriver()
							.findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[5]")); // click on welcome
																									// task
					waitABit(2000);
					elementWelcomeCust.click();
					waitABit(2000);
					swiftPage.btn_completeTask.click(); // press the complete button.
					myflag = waitForSwiftProgressBar();
					if (myflag) {
						System.out.println("error in waitForSwiftProgressBar");
					}
					getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				}
				if (i == 1) {
					getDriver().navigate().refresh(); // refresh the page
					waitABit(5000);
					swiftPage.searchBtn.click(); // click the search button
					swiftPage.lnk_second_order.waitUntilEnabled().waitUntilClickable();
					swiftPage.lnk_second_order.click();
					swiftPage.waitForTextToAppear("Tasks", 30000);
					myName = swiftPage.txt_welcomeCustomer_assignee_name.getText();
					swiftPage.lbl_user_info.click(); // open impersonate box
					waitABit(5000);
					swiftPage.txt_user_info.type("");
					getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
					getDriver().switchTo().activeElement().sendKeys(myName);
					waitABit(2000);
					getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
					waitABit(2000);
					swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
					myflag = waitForSwiftProgressBar();
					if (myflag) {
						System.out.println("error in waitForSwiftProgressBar");
					}
					WebElement elementWelcomeCust = getDriver()
							.findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[5]")); // click on welcome
																									// task
					waitABit(2000);
					elementWelcomeCust.click();
					waitABit(2000);
					swiftPage.btn_completeTask.click(); // press the complete button.
					myflag = waitForSwiftProgressBar();
					if (myflag) {
						System.out.println("error in waitForSwiftProgressBar");
					}
					getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
					System.out.println("out of user_completes_WelcomeCustomer");
				}
			}
		} else {
			myName = swiftPage.txt_welcomeCustomer_assignee_name.getText(); // get the name to impersonate
			System.out.println("myName is " + myName);
			swiftPage.lbl_user_info.click(); // open impersonate box
			waitABit(5000);
			swiftPage.txt_user_info.type("");
			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
			getDriver().switchTo().activeElement().sendKeys(myName);
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);// ded network type
			waitABit(2000);
			swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			waitABit(2000);
			try {
				swiftPage.btn_oes_order_pick.click(); // cause oes list to open
				waitABit(2000);
				swiftPage.lst_oes_order_pick.click(); // using click because object is described in page as list box
														// pick 2
			} catch (Exception e) {
				System.out.println(e);
			}
			swiftPage.btn_completeTask.click(); // press the complete button.
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
		}
	}

	@Step
	public void user_completes_Customer_Coordination() {
		Boolean myflag;
		String myName;
		int myTaskCounter = -1;
		String myProductType = System.getProperty("myProduct.ID");
		String SIDID = System.getProperty("SID.ID");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 3);
		String newDate = dateFormat.format(cal.getTime());
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")
				|| (myProductType.contains("IP VPN Port and Access"))) {
			myTaskCounter = 2;
		} else {
			myTaskCounter = 1;
		}
		for (int i = 0; i < myTaskCounter; i++) {
			if (i == 0) {
				swiftPage.lnk_first_order.waitUntilEnabled().waitUntilClickable();
				swiftPage.lnk_first_order.click();
				swiftPage.waitForTextToAppear("Tasks", 30000);
			}
			if (i == 1) {
				swiftPage.lnk_second_order.waitUntilEnabled().waitUntilClickable();
				swiftPage.lnk_second_order.click();
				swiftPage.waitForTextToAppear("Tasks", 30000);
			}
			myName = swiftPage.txt_cust_coordiation_assignee_name.getText();
			swiftPage.lbl_user_info.click(); // open impersonate box
			waitABit(5000);
			swiftPage.txt_user_info.type("");
			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
			getDriver().switchTo().activeElement().sendKeys(myName);
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);//
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);//
			waitABit(2000);
			swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
			WebElement elementCustCoord = getDriver()
					.findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[4]")); // click on welcome task
			waitABit(2000);
			elementCustCoord.click();
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
			swiftPage.btn_productPackagesTab.click(); // click on the product package tab
			WebElement element1 = getDriver().findElement(By.id("cbHeader")); // update
			JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
			jse1.executeScript("arguments[0].click()", element1); // check the select all check box
			swiftPage.btn_editDatesBtn.waitUntilEnabled();// edit date
			swiftPage.btn_editDatesBtn.click(); // edit dates
			swiftPage.txt_NewNddDatePicker.waitUntilEnabled();// set date NDD
			swiftPage.txt_NewNddDatePicker.type(newDate); // set dates NDD
			swiftPage.txt_CurrentCrdDatePicker.waitUntilEnabled();// set date txt_Current Date
			swiftPage.txt_CurrentCrdDatePicker.type(newDate); // set dates txt_Current Date
			swiftPage.btn_EditDateDialogOkBtn.waitUntilEnabled();// save dates
			swiftPage.btn_EditDateDialogOkBtn.click(); // save dates
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			waitABit(2000);
			swiftPage.btn_completeTask.waitUntilEnabled();
			swiftPage.btn_completeTask.click(); // press the complete button.
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			getDriver().navigate().refresh(); // refresh the page
			waitABit(5000);
			swiftPage.searchBtn.click(); // click the search button
			waitABit(2000);
			System.out.println("out of user_completes_Customer_Coordination");
		}
	}

	@Step
	public void user_completes_Order_Details() {
		Boolean myflag;
		String myName;
		int myTaskCounter = -1;
		String myProductType = System.getProperty("myProduct.ID");
		String SIDID = System.getProperty("SID.ID");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		if (myProductType.equalsIgnoreCase("E-LAN - EVC Endpoint")
				|| (myProductType.contains("IP VPN Port and Access"))) {
			myTaskCounter = 2;
		} else {
			myTaskCounter = 1;
		}
		for (int i = 0; i < myTaskCounter; i++) {
			if (i == 0) {
				swiftPage.lnk_first_order.waitUntilEnabled().waitUntilClickable();
				swiftPage.lnk_first_order.click();
				swiftPage.waitForTextToAppear("Tasks", 30000);
			}
			if (i == 1) {
				swiftPage.lnk_second_order.waitUntilEnabled().waitUntilClickable();
				swiftPage.lnk_second_order.click();
				swiftPage.waitForTextToAppear("Tasks", 30000);
			}
			try {
				myName = swiftPage.txt_api_swift_assignee_name.getText();
				swiftPage.lbl_user_info.click(); // open impersonate box
				waitABit(5000);
				swiftPage.txt_user_info.type("");
				getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
				getDriver().switchTo().activeElement().sendKeys(myName);
				waitABit(2000);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
				waitABit(2000);
				swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
				WebElement elementCustCoord = getDriver()
						.findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[6]")); // click on complete
																								// order details task
				JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
				jse1.executeScript("arguments[0].click()", elementCustCoord);
				waitABit(4000);
				// WebElement elementCustCoord =
				// getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[6]"));
				// // click on complete order details task
				// waitABit(2000);
				// elementCustCoord.click();
				// waitABit(2000);
				swiftPage.btn_completeTask.click(); // press the complete button.
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				swiftPage.searchBtn.click(); // click the search button
				waitABit(2000);
				System.out.println("out of user_completes_Order_Detail");
			} catch (Exception e) {
				System.out.println("Last task did not show up");
			}
		}
	}

	@Step
	public void impersonate_second_task() {
		try {
			Boolean myflag;
			String myName = "";
			swiftPage.waitForTextToAppear("Tasks", 3000);
			myName = swiftPage.txt_second_assignee_name.getText(); // get the name to impersonate using welcome
																	// custommer as it is second task on screen.
			System.out.println("myName is " + myName);
			swiftPage.lbl_user_info.click(); // open impersonate box
			waitABit(5000);
			swiftPage.txt_user_info.type("");
			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
			getDriver().switchTo().activeElement().sendKeys(myName);
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);// ded network type
			waitABit(2000);
			swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
		} catch (Exception e) {
			System.out.println("Second task did not show up in swift ");
		}
	}

	@Step
	public void add_swift_doc() {
		Boolean myflag;
		String myName = "";
		myName = swiftPage.txt_second_assignee_name.getText(); // get the name to impersonate using welcome custommer as
																// it is second task on screen.
		System.out.println("myName is " + myName);
		swiftPage.lbl_user_info.click(); // open impersonate box
		waitABit(5000);
		swiftPage.txt_user_info.type("");
		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
		getDriver().switchTo().activeElement().sendKeys(myName);
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);// ded network type
		waitABit(2000);
		swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
	}

	@Step
	public void user_Gathers_Order_Details() {
		String myName;
		for (int i = 0; i < 100; i++) {
			waitABit(3000);
			String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
					.getText();
			logger.info("Update Task Status : " + UpdatedTask);
			if (UpdatedTask.contains("1 - 2 of 2 items") || UpdatedTask.contains("1 - 4 of 4 items")) {
				logger.info("2nd Task Generated");
				waitABit(2000);
				break;
			} else {
				waitABit(8000);
				getDriver().navigate().refresh();
				WaitForPageToLoad(60);
				logger.info("2nd Task Not Generated, Retrying");
			}
		} // ends for
		String SecondTask = getDriver()
				.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[4]/span")).getText();
		logger.info("Second Task Status : " + SecondTask);
		if (SecondTask.contains("Ready")) {
			logger.info("Second Task is Ready to be Validated");
		}
		myName = getDriver().findElement(By.xpath("//*[@id=\"taskGrid\"]/div[3]/table/tbody/tr[3]/td[5]/span"))
				.getText();
		swiftPage.lbl_user_info.click(); // open impersonate box
		waitABit(3000);
		for (int r = 0; r <= 30; r++) {
			WebElement imersonationBox = getDriver()
					.findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"));
			String value = imersonationBox.getAttribute("aria-activedescendant");
			logger.info("Selected Option--" + value);
			waitABit(1000);
			value = value + "Yes";
			System.out.println(value.length());
			if (value.length() != 7) {
				logger.info("Impersoante Text box value present");
				break;
			}
		}
		swiftPage.txt_user_info.type("");
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
		getDriver().switchTo().activeElement().sendKeys(myName);
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
		waitABit(2000);
		swiftPage.btn_impersonateUserBtn.waitUntilClickable().click(); // press impersonate button
		E2ESteps.printInGreenColor("completed user_Gathers_Order_Details",
				"out of function user_Gathers_Order_Details");
	}

	@Step
	public void add_iSE_Document() {
		Boolean myflag;
		try {
			for (int i = 0; i < 3; i++) {
				getDriver().switchTo().parentFrame(); // Change to the Parent Frame
			}
		} catch (Exception e) {
			logger.info("failed to switch to parent frame ");
		}
		try {
			waitABit(5000);
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				logger.info("error in waitForSwiftProgressBar");
			}
			customClickableWait(swiftPage.lnk_doc);
			swiftPage.lnk_doc.click();
			waitABit(3000);
			logger.info(" launch the doc window ");
		} catch (Exception e) {
			try {
				getDriver().navigate().refresh(); // refresh the page
				waitABit(8000);
				swiftPage.lnk_doc_tryagain.click();
			} catch (Exception p) {
				logger.info("unable to launch the doc window ");
			}
		}
		try {
			String stempNOText = swiftPage.txt_NO_doc_text.getText();
			if (stempNOText.contains("No records available")) {
				logger.info("found No records available ");
				getDriver().navigate().refresh(); // refresh the page
				waitABit(8000);
				swiftPage.lnk_doc_tryagain.click();
			}
		} catch (Exception d) {
			logger.info("************ records available ");
		}
		try {
			String stempText = swiftPage.txt_doc_text.getText();
			if (stempText.contains("iSE Design")) {
				logger.info("found IDS document ");
			} else {
				getDriver().navigate().refresh(); // refresh the page
				waitABit(8000);
				swiftPage.lnk_doc_tryagain.click();
			}
		} catch (Exception p) {
			logger.info("unable to ]launch the doc window ");
		}
		waitABit(2000);
		swiftPage.lbl_ise_design.isPresent();
		swiftPage.lbl_ise_design.isCurrentlyEnabled(); // click on the ise design link
		swiftPage.lbl_ise_design.click(); // click on the ise design link
		waitABit(2000);
		swiftPage.btn_design_edit.isCurrentlyEnabled();
		swiftPage.btn_design_edit.click();
		waitABit(2000);
		swiftPage.lst_doc_type.isCurrentlyEnabled();
		swiftPage.lst_doc_type.click();
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys("iSE");
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);//
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);//
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
		getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys("Workbook");
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);//
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);//
		waitABit(2000);
		getDriver().findElement(By.xpath("//*[@data-field='DocumentName']")).click();
		waitABit(1000);
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(swiftPage.btn_save_doctype).click().build().perform();
		swiftPage.btn_save_doctype.waitUntilEnabled();
		swiftPage.btn_save_doctype.click();
		waitABit(4000);
//	Actions a1=new Actions(getDriver());
//	a1.moveToElement(swiftPage.btn_save_doctype).click().build().perform();
//	swiftPage.btn_save_doctype.click();
		logger.info("added iSE document ");
		getDriver().navigate().refresh(); // refresh the page
		waitABit(10000);
		E2ESteps.printInGreenColor("completed add_iSE_Document", "out of function add_iSE_Document");
	}

	@Step
	public void press_complete_Swift_Task() {
		Boolean myflag;
		swiftPage.btn_completeTask.isCurrentlyEnabled(); // press the complete button.
		swiftPage.btn_completeTask.click(); // press the complete button.
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			logger.info("error in waitForSwiftProgressBar");
		}
		logger.info("This is done press_complete_Swift_Task"); // write the Swift Impersonate row is set
		logger.info("out of swift and all the timing");
		E2ESteps.printInGreenColor("pressed the completed  button for the task",
				"out of function press_complete_Swift_Task");
	}

	// written by eric steele
	@Step
	public void Launch_SEO() {
		String myEnv = System.getProperty("staf.environment.key");
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		String order = "";
		swiftPage.openAt(envData.getFieldValue("SEOurl"));
		waitABit(8000);
		swiftPage.btn_watch_list.click(); // click on log in button
		waitABit(2000);
		String win1 = getDriver().getWindowHandle();
		System.out.println(win1);
		waitABit(2000);
		swiftPage.lst_sort.click();
		waitABit(2000);
		swiftPage.lst_sort.click();
		waitABit(2000);
		swiftPage.lst_process_pick.click();
		// switch (myEnv.toUpperCase()) {
		if (myEnv.toUpperCase().equals("TEST1")) {
			// case "TEST1":
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // pick credit check
			waitABit(3000);
			// break;
		} else if (myEnv.toUpperCase().equals("TEST2")) {
			// case "TEST2":
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // pick credit check
			waitABit(3000);
			// break;
		}
		// case "TEST3":
		else if (myEnv.toUpperCase().equals("TEST3")) {
			// break;
		} else if (myEnv.toUpperCase().equals("TEST4")) {
			// case "TEST4":
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // pick credit check
			waitABit(3000);
		} else {
			// default:
			System.out.println("no Environment found");
			// break;
		}
		waitABit(2000);
		for (int i = 0; i <= 100; i++) {
			WebElement my_order = (WebElement) jse.executeScript(
					"return document.querySelector(\'#ctl00_phMainContent_WatchListPart_AlertListPart_ctl00__" + i
							+ " > td:nth-child(2)\')");
			order = my_order.getText();
			System.out.println(order);
			if (order.contains("SwIFT-" + myOpid + "-OP_Credit_Check")) {
				System.out.println("Found it!");
				my_order.click();
				break;
			}
		}
		E2ESteps.softAssertError("In SOE", true, "the SOE id is ", String.valueOf(myOpid));
		waitABit(4000);
		Set<String> win2 = getDriver().getWindowHandles();
		System.out.println(win2);
		Iterator<String> i1 = win2.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!win1.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child windows
				getDriver().switchTo().window(ChildWindow);
				swiftPage.maximize();
				waitABit(5000);
				swiftPage.complete_creditCheckDone.click();
				Set<String> win3 = getDriver().getWindowHandles();
				win3.remove(win1);
				// win3.remove(ChildWindow);
				System.out.println(win3);
				String rc = win3.toString();
				WebElement continue_element = getDriver()
						.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ConfirmActionWindow\"] "));
				waitABit(1000);
				continue_element.click();
				getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
				getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
				getDriver().switchTo().window(win1);
			}
		}
		E2ESteps.printInGreenColor("In SEO function", "out of function SEO -SwIFT-" + myOpid + "-OP_Credit_Check");
	}

	WebDriver driver;

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				element);
		return ele;
	}

	@Step
	public void overide_completes_WelcomeCustomer(String sExpStatus, String sExpTask) {
		Boolean myflag;
		getDriver().navigate().refresh();
		waitABit(10000);
		swiftPage.lbl_user_info.click(); // open impersonate box
		waitABit(5000);
		swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		this.find_status_taskNamen(sExpStatus, sExpTask); // go to function to find the welcome task
		swiftPage.btn_completeTask.click(); // press the complete button.
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		E2ESteps.printInGreenColor("In SEO overide_completes_WelcomeCustomer",
				"out of function overide_completes_WelcomeCustomer");
	}

	public void find_status_taskNamen(String sExpStatus, String sExpTask) {
		WebElement taskRow;
		Boolean myflag;
		Boolean bflag = false;
		String sholder;
		int ncounter;
		ncounter = 0;
		String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
		if (UpdatedTask.contains("1 - 4 of 4 items")) {
			waitABit(2000);
		} else {
			waitABit(30000);
			getDriver().navigate().refresh();
		}
		System.out.println("3rd & 4th Task Generated");
		// waitForSwiftProgressBar();
		System.out.println("Update Task Status : " + UpdatedTask);
		String numofTask = UpdatedTask.substring(4, 5);
		System.out.println("number of Tasks are: " + numofTask);
		int myTask = Integer.parseInt(numofTask);
		System.out.println("number of Tasks are: " + myTask);
		for (int i = 2; i <= (myTask + 1);) {
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
				waitABit(5000);
				// switch (sExpTask) {
				if (sExpTask.equals("Welcome Customer")) {
					// case "Welcome Customer":
					System.out.println("in the Welcome Customer for over ride");
					Actions act = new Actions(getDriver());
					do {
						act.contextClick(taskRow).perform();
						waitABit(6000);
						try {
							sholder = swiftPage.find(By.xpath("//*[@id='taskGridContextMenu']/li[8]")).getTextValue();
							if (sholder.contains("Override")) {
								bflag = true;
							}
						} catch (Exception e) {
							taskRow.click();
							waitABit(3000);
							ncounter = ncounter + 1;
							if (ncounter > 10) {
								System.out.println("Failed in the Welcome Customer for over ride");
								bflag = false;
							}
						}
					} while (bflag != true);
					WebElement override;
					override = getDriver()
							.findElement(By.xpath("//*[starts-with(@ng-show,'TaskIRRules.CanOverridePending')]"));
					override.click();
					myflag = waitForSwiftProgressBar();
					if (myflag) {
						System.out.println("error in waitForSwiftProgressBar");
					}
					// break;
					else {
						// default:
						System.out.println("this task does not require over ride " + sExpTask);
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
					myflag = waitForSwiftProgressBar();
					if (myflag) {
						System.out.println("error in waitForSwiftProgressBar");
					}
				}
				i = i + 1;
				waitABit(1);
				E2ESteps.softAssertError("In function find_status_taskNamen", true, "The status is ",
						String.valueOf(sExpStatus));
				E2ESteps.softAssertError("In function find_status_taskNamen", true, "The task value is ",
						String.valueOf(sExpTask));
			}
		}
	}

	@Step
	public void completes_Order_Validation(String sExpStatus, String sExpTask) {
		Boolean myflag;
		find_the_status_taskName(sExpStatus, sExpTask); // go to function to find the task
		if (sExpTask.equals("Order Validation")) {
			swiftPage.btn_TDG_form.waitUntilEnabled();
			swiftPage.btn_TDG_form.click();
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
			waitABit(15000);
			// It will return the parent window name as a String
			String parent = getDriver().getWindowHandle();
			// This will return the number of windows opened by Webdriver and will return
			// Set of St//rings
			Set<String> s1 = getDriver().getWindowHandles();
			// Now we will iterate using Iterator
			Iterator<String> I1 = s1.iterator();
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!parent.equals(child_window)) {
					getDriver().switchTo().window(child_window);
					System.out.println(getDriver().switchTo().window(child_window).getTitle());
					swiftPage.btn_TDG_form_edit.waitUntilClickable();
					swiftPage.btn_TDG_form_edit.click(); // click on edit button for TDG form
					myflag = waitForTDGSwiftProgressBar();
					if (myflag) {
						System.out.println("error in waitForTDGSwiftProgressBar");
					}
					waitABit(2000);
					swiftPage.ipLogicalServiceRow.click();
					waitABit(2000);
					swiftPage.lumenToAssignWanIP.selectByValue("Yes");
					waitABit(2000);
					swiftPage.waniPv4BlockSize.selectByValue("/29");
					waitABit(2000);
					swiftPage.btn_TDG_form_save.click(); // click on edit button for TDG form
					myflag = waitForTDGSwiftProgressBar();
					if (myflag) {
						System.out.println("error in waitForTDGSwiftProgressBar");
					}
					getDriver().switchTo().window(child_window).close();
				}
			}
			// once all pop up closed now switch to parent window
			getDriver().switchTo().window(parent);
		}
		waitABit(3000);
		swiftPage.btn_completeTask.click(); // press the complete button.
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		E2ESteps.printInGreenColor("In completes_Order_Validationr", "out of function completes_Order_Validation");
	}

	public void find_the_status_taskName(String sExpStatus, String sExpTask) {
		WebElement taskRow;
		Boolean myflag;
		// String UpdatedTask =
		// getDriver().findElement(By.xpath("//div[@id='taskTab']/div/div/span[2]")).getText();
		String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]")).getText();
		if (UpdatedTask.contains("1 - 8 of 8 items")) {
			waitABit(2000);
		} else {
			waitABit(30000);
			getDriver().navigate().refresh();
		}
		logger.info("3rd & 4th Task Generated");
		// waitForSwiftProgressBar();
		logger.info("Update Task Status : " + UpdatedTask);
		String numofTask = UpdatedTask.substring(4, 5);
		logger.info("number of Tasks are: " + numofTask);
		int myTask = getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size();
		// int myTask = Integer.parseInt(numofTask);
		logger.info("number of Tasks are: " + myTask);
		for (int i = 2; i <= (myTask + 1);) {
			logger.info("the number i is: " + i);
			String myStatus = getDriver()
					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[4]/span"))
					.getText();
			String myTaskName = getDriver()
					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[7]/span"))
					.getText();
			logger.info("the status is : " + myStatus);
			logger.info("the task is : " + myTaskName);
			if (sExpStatus.equalsIgnoreCase(myStatus) && sExpTask.equalsIgnoreCase(myTaskName)) {
				taskRow = getDriver()
						.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[7]/span"));
				taskRow.click();
				// switch (sExpTask) {
				if (sExpTask.equals("Welcome Customer")) {
					// case "Welcome Customer":
					Actions act = new Actions(getDriver());
					act.contextClick(taskRow).perform();
					waitABit(1000);
					WebElement override;
					override = getDriver()
							.findElement(By.xpath("//*[starts-with(@ng-show,'TaskIRRules.CanOverridePending')]"));
					override.click();
					// break;
				} else {
					// default:
					logger.info("this task does not require over ride " + sExpTask);
				}
				WebElement taskRow1 = getDriver()
						.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[5]/span"));
				String myName = taskRow1.getText(); // get the name to impersonate
				logger.info("myName is " + myName);
				swiftPage.lbl_user_info.click(); // open impersonate box
				waitABit(2000);
				for (int r = 0; r <= 30; r++) {
					WebElement imersonationBox = getDriver()
							.findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"));
					String value = imersonationBox.getAttribute("aria-activedescendant");
					System.out.println("Selected Option--" + value);
					waitABit(2000);
					value = value + "Yes";
					System.out.println(value.length());
					waitABit(2000);
					if (value.length() != 7) {
						logger.info("Impersoante Text box value present");
						break;
					}
				}
				swiftPage.txt_user_info.type("");
				getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
				// waitABit(2000);
				getDriver().switchTo().activeElement().sendKeys(myName);
				waitABit(2000);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
				waitABit(2000);
				swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
			}
			i = i + 1;
			waitABit(1);
		}
		E2ESteps.softAssertError("In function find_the_status_taskName", true, "The status is ",
				String.valueOf(sExpStatus));
		E2ESteps.softAssertError("In function find_the_status_taskName", true, "The task value is ",
				String.valueOf(sExpTask));
	}

	@Step
	public void Completes_Customer_Coordination_single_Task(String sExpStatus, String sExpTask) {
		Boolean myflag;
		String SIDID = System.getProperty("SID.ID");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 3);
		String newDate = dateFormat.format(cal.getTime());
		// JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		find_status_taskNamen(sExpStatus, sExpTask);
//	 WebElement elementCustCoord = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[4]"));  // click  on welcome task
//	 waitABit(2000);
//	 elementCustCoord.click();
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
		swiftPage.btn_productPackagesTab.click(); // click on the product package tab
		WebElement element1 = getDriver().findElement(By.id("cbHeader")); // update
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click()", element1); // check the select all check box
		swiftPage.btn_editDatesBtn.waitUntilEnabled();// edit date
		swiftPage.btn_editDatesBtn.click(); // edit dates
		// swiftPage.txt_NewNddDatePicker.waitUntilEnabled();// set date NDD
		// swiftPage.txt_NewNddDatePicker.type(newDate); //set dates NDD
		swiftPage.txt_CurrentCrdDatePicker.waitUntilEnabled();// set date txt_Current Date
		swiftPage.txt_CurrentCrdDatePicker.type(""); // set dates txt_Current Date
		swiftPage.txt_CurrentCrdDatePicker.type(newDate); // set dates txt_Current Date
		swiftPage.btn_EditDateDialogOkBtn.waitUntilEnabled();// save dates
		swiftPage.btn_EditDateDialogOkBtn.click(); // save dates
		// getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		swiftPage.btn_completeTask.waitUntilEnabled();
		swiftPage.btn_completeTask.click(); // press the complete button.
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		getDriver().navigate().refresh(); // refresh the page
		waitABit(3000);
		System.out.println("out of user_completes_Customer_Coordination");
		E2ESteps.printInGreenColor("completed  user_completes_Customer_Coordination",
				"out of function out user_completes_Customer_Coordination");
	}

	@Step
	public void Wait_For_BPMS_Acceptance_Task(String sExpStatus, String sExpTask) {
		Boolean bflag = false;
		int ncounter = 0;
		do {
			waitABit(100);
			String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
					.getText();
			if (UpdatedTask.contains("1 - 8 of 8 items")) {
				waitABit(2000);
			} else {
				waitABit(20000);
				getDriver().navigate().refresh();
			}
			logger.info("Update Task Status : " + UpdatedTask);
			String numofTask = UpdatedTask.substring(4, 5);
			logger.info("number of Tasks are: " + numofTask);
			int myTask = Integer.parseInt(numofTask);
			logger.info("number of Tasks are: " + myTask);
			for (int i = 2; i <= (myTask + 1); i++) {
				logger.info("the number i is: " + i);
				String myStatus = getDriver()
						.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[4]/span"))
						.getText();
				String myTaskName = getDriver()
						.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[7]/span"))
						.getText();
				logger.info("the status is : " + myStatus);
				logger.info("the task is : " + myTaskName);
				logger.info("Table status is " + myStatus + "  and my Task is " + myTaskName);
				if (myStatus.equalsIgnoreCase("Completed")
						&& myTaskName.equalsIgnoreCase("Waiting For BPMS Acceptance")) {
					logger.info("Waiting For BPMS Acceptance task is completed");
					bflag = true;
				} else if (!myStatus.equalsIgnoreCase("Completed")) {
					logger.info("waiting on completed");
					ncounter = ncounter + 1;
					getDriver().navigate().refresh();
					waitABit(5000);
					if (ncounter > 100)
						bflag = true;
				}
				String checkTimeout = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
						.getText();
				if (checkTimeout.contains("1 - 9 of 9 items")) {
					String myTimeOutCheck = getDriver()
							.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[" + i + "]/td[7]/span"))
							.getText();
					logger.info("BPMS is timed out ");
					E2ESteps.softAssertError("BPMS is timed out ", bflag, "The task value is ",
							String.valueOf(sExpTask));
					bflag = true;
					waitABit(2000);
				}
			}
		} while (bflag != true);
		E2ESteps.softAssertError("In function Wait_For_BPMS_Acceptance_Task", bflag, "The status is ",
				String.valueOf(sExpStatus));
		E2ESteps.softAssertError("In function Wait_For_BPMS_Acceptance_Task", bflag, "The task value is ",
				String.valueOf(sExpTask));
	}

	///////////////////////// SWIFT STARTS HERE /////////////////////////////////
	// tasknum is being used to send in name of the product
	@Step
	public void user_can_submit_order(int futureday, String tasknum) throws MessagingException {
		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
		// String nSwiftID=System.setProperty("Swift.ID", "2744083");
		String myEnv = System.getProperty("staf.environment.key");
		String myProductType = System.getProperty("myProduct.ID");
		// String myProductType = System.setProperty("myProduct.ID", "Dedicated Internet
		// Access");
		logger.info("the product  is  " + myProductType); // print out product type
		// String sNetType=System.getProperty("myNet.ID"); // get the net status from
		// memory
		// System.out.println("the net status is " +sNetType); // print out net status
		// type
		Log_in_Swift_get_order(tasknum); // log into swift, find the order id
		waitABit(1000);
	}

	@Step
	public void i_reassign_validate_and_complete_the_second_task_in_swift() {
//	int myCounter;
//    int pkgCounter;
//	Boolean myflag;
//	myflag = false;
//	String n1SwiftID="2909571";
//	String n2SwiftID=System.setProperty("Swift.ID","2909571");
////	System.out.println("order id b-"+nSwiftID);
//	//String nSwiftID="2909571";
//	String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
//	String myEnv = System.getProperty("staf.environment.key");
//	String myProductType = System.setProperty("myProduct.ID","Dedicated Internet Access");
//	swiftPage.openAt(envData.getFieldValue("swifturl")); // the swift url from the e2e.xml
//	swiftPage.waitForTextToAppear("SEARCH" , 30000);
//	E2ESteps.softAssertError("In Swift", true, "the BOID ",String.valueOf(nSwiftID));
//	if(nSwiftID.isEmpty()){
//	System.out.println("failed BOID is empty ending test ");
//	getDriver().close();
//	getDriver().quit();
//	}
//	swiftPage.lst_business_order_listbox.click(); // list box to pick business owner out of 
//	 waitABit(2000);
//	swiftPage.lst_business_order_pick.click(); //click on the "Business Order Id"
//	 waitABit(2000); //leave this for timing issue returning the impersonate row
//	swiftPage.txt_searchId.type(nSwiftID); // enter the swift id 
//	 swiftPage.searchBtn.click(); // click the search button 
//	waitABit (10000);
//	String url1 = getDriver().getCurrentUrl();
//	System.out.println("Current URL : "+url1);
//	String sOpid = url1.toString();
//	myOpid= url1.substring(30, 39);
//	boolean status=false;
//	getDriver().navigate().refresh();
//	waitABit(15000);
//	--------------------------------------
		String orderpackageid = getDriver().findElement(By.xpath("//div[@class='k-link']/span[1]")).getText();
		System.out.println("Order Package ID = " + orderpackageid);
		Serenity.setSessionVariable("orderpackageid").to(orderpackageid);
		sess = Serenity.sessionVariableCalled("orderpackageid");
		waitABit(3000);
		System.out.println("Waiting for Next Task to Generate");
		try {
			for (int i = 0; i < 100; i++) {
				waitABit(5000);
				String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
						.getText();
				System.out.println("Update Task Status : " + UpdatedTask);
				if (UpdatedTask.contains("1 - 2 of 2 items")) {
					System.out.println("2nd Task Generated");
					waitABit(2000);
					break;
				} else {
					waitABit(10000);
					getDriver().navigate().refresh();
					WaitForPageToLoad(60);
					System.out.println("2nd Task Not Generated, Retrying");
				}
				customwaitforpageloading(swiftpage);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		customClickableWait(swiftpage.lnk_order_package_ready2);
		String SecondTask = getDriver()
				.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[3]/td[4]/span")).getText();
		System.out.println("Second Task Status : " + SecondTask);
		if (SecondTask.contains("Ready")) {
			System.out.println("Second Task is Ready to be Validated");
		}
		for (int j = 0; j < 2; j++) {
			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
			if (User.contains("Madahalli Chowdegowda, Raju")) {
				System.out.println("2nd Task Already Impersonating to Raju");
				break;
			} else {
				System.out.println("Need to Impersonate 2nd Task");
				customClickableWait(swiftpage.btn_userinfo);
				swiftpage.btn_userinfo.click();
				waitABit(2000);
				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
						.sendKeys("Madahalli Chowdegowda, Raju");
				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
				waitABit(2000);
				swiftpage.btn_impersonate.click();
				customwaitforpageloading(swiftpage);
				waitABit(2000);
			}
		}
		waitABit(2000);
		customClickableWait(swiftpage.lnk_order_package_ready2);
		swiftpage.lnk_order_package_ready2.click();
		waitABit(3000);
		customClickableWait(swiftpage.btn_reassign_me);
		swiftpage.btn_reassign_me.click();
		waitABit(5000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
		customwaitforpageloading(swiftpage);
		System.out.println("2nd Task Reassigned to User");
		waitForSwiftProgressBar(swiftpage);
		swiftpage.lnk_order_package_ready2.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilVisible().waitUntilEnabled();
		swiftpage.lnk_order_package_ready2.click();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
		customClickableWait(swiftpage.btn_complete);
		waitForSwiftProgressBar(swiftpage);
		waitABit(3000);
		swiftpage.btn_complete.click();
		waitABit(5000);
		customwaitforpageloading(swiftpage);
		waitForSwiftProgressBar(swiftpage);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
		waitABit(3000);
		System.out.println("2nd Task Completed");
		String Packg_Status = getDriver().findElement(By.xpath("//span[@id='OrderPackageStatusLbl']")).getText();
		System.out.println("Package Status : " + Packg_Status);
		// --------------- wait for credit Approval step--------------------
		String taskName = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[7]/span"))
				.getText();
		if (taskName.equals("Wait For Credit Approval")) {
			getDriver().close();
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			metastormpage.openAt(envData.getFieldValue("SEOurl"));
			WaitForPageToLoad(100);
			metastormpage.maximize();
			waitABit(5000); // auto login wait
			System.out.println("MetaStorm Page is Loaded");
			System.out.println("Current URL : " + getDriver().getCurrentUrl());
			customClickableWait(metastormpage.btn_watch_list);
			metastormpage.btn_watch_list.click();
			waitABit(3000);
			customClickableWait(metastormpage.ddl_process);
			metastormpage.ddl_process.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_process_OP_Credit_Check);
			metastormpage.ddl_process_OP_Credit_Check.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_stage);
			metastormpage.ddl_stage.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_stage_Credit_Approval);
			metastormpage.ddl_stage_Credit_Approval.click();
			waitABit(5000);
			String parent = getDriver().getWindowHandle();
			System.out.println("Sess Value for Xpath is : " + sess);
			metastormpage.metastorm(sess).click();
			waitABit(10000);
			java.util.Set<String> child = getDriver().getWindowHandles();
			System.out.println("Size of the Window : " + child.size());
			child.remove(parent);
			getDriver().switchTo().window((String) child.toArray()[0]);
			getDriver().getTitle();
			getDriver().manage().window().maximize();
			try {
				List<WebElement> TaskList = getDriver().findElements(By.xpath("//div[@id='ActionListMenu']//ul/li[9]"));
				for (int k = 0; k < TaskList.size(); k++) {
					waitABit(5000);
					if (TaskList.get(k).getText().contains("CreditCheckDone")) {
						waitABit(5000);
						System.out.println("CreditCheckDone Button Found");
						String parent1 = getDriver().getWindowHandle();
						TaskList.get(k).click();
						System.out.println("CreditCheckDone Button Clicked");
						waitABit(10000);
						getDriver().switchTo().frame(0);
						getDriver().switchTo().frame(0);
						waitABit(2000);
						getDriver().findElement(By.xpath("//input[@id ='btnConfirm' and @value ='Yes']")).click();
						System.out.println("CreditApproval Task Done");
						getDriver().switchTo().defaultContent();
						System.out.println("Metastorm Task Performed");
						getDriver().switchTo().window(parent);
					}
				}
			} catch (Exception e) {
				System.out.println("Catched Exception : " + e.getMessage());
			} finally {
				System.out.println("CreditApproval Task Done");
			}
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			String URL = envData.getFieldValue("swifturl");
			swiftpage.openAt(URL);
			WaitForPageToLoad(60);
			System.out.println("Swift Page Launched Again");
			swiftpage.maximize();
			WaitForPageToLoad(5); // wait for auto log in
			swiftpage.tbx_order_id_field.clear();
			swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);
			WaitForPageToLoad(60);
			customClickableWait(swiftpage.lnk_order_package_ready1);
		}
		try {
			for (int i = 0; i < 100; i++) {
				waitABit(2000);
				String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
						.getText();
				System.out.println("Update Task Status : " + UpdatedTask);
				/*
				 * WebDriverWait wait = new WebDriverWait(getDriver(), 100);
				 * wait.until(ExpectedConditions.textToBePresentInElement(UpdatedTask,
				 * "1 - 2 of 2 items"));
				 */
				if (UpdatedTask.contains("1 - 4 of 4 items")) {
					waitABit(2000);
					break;
				} else {
					waitABit(20000);
					getDriver().navigate().refresh();
					WaitForPageToLoad(60);
				}
				System.out.println("3rd & 4th Task Generated");
				waitForSwiftProgressBar(swiftpage);
				customwaitforpageloading(swiftpage);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		customClickableWait(swiftpage.lnk_order_package_ready4);
		for (int i = 0; i < 5; i++) {
			String FourthTask = getDriver()
					.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[4]/span")).getText();
			System.out.println("Fourth Task Status : " + FourthTask);
			if (FourthTask.contains("Ready")) {
				System.out.println("Fourth Task is Ready to be Validated");
				break;
			} else {
				System.out.println("Fourth Task is Not Ready to be Validated, Switching to MetaStorm");
				getDriver().close();
				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				metastormpage.openAt(envData.getFieldValue("SEOurl"));
				WaitForPageToLoad(100);
				metastormpage.maximize();
				waitABit(5000); // auto login wait
				System.out.println("MetaStorm Page is Loaded");
				System.out.println("Current URL : " + getDriver().getCurrentUrl());
				customClickableWait(metastormpage.btn_watch_list);
				metastormpage.btn_watch_list.click();
				waitABit(3000);
				customClickableWait(metastormpage.ddl_process);
				metastormpage.ddl_process.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_process_OP_Welcome);
				metastormpage.ddl_process_OP_Welcome.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_stage);
				metastormpage.ddl_stage.click();
				waitABit(5000);
				customClickableWait(metastormpage.ddl_stage_select);
				metastormpage.ddl_stage_select.click();
				waitABit(5000);
				String parent = getDriver().getWindowHandle();
				System.out.println("Sess Value for Xpath is : " + sess);
				metastormpage.metastorm(sess).click();
				waitABit(10000);
				java.util.Set<String> child = getDriver().getWindowHandles();
				System.out.println("Size of the Window : " + child.size());
				child.remove(parent);
				getDriver().switchTo().window((String) child.toArray()[0]);
				getDriver().getTitle();
				getDriver().manage().window().maximize();
				try {
					List<WebElement> TaskList = getDriver()
							.findElements(By.xpath("//div[@id='ActionListMenu']//ul/li[9]"));
					for (int k = 0; k < TaskList.size(); k++) {
						waitABit(5000);
						if (TaskList.get(k).getText().contains("ManuallyExpireWCTaskWait")) {
							waitABit(5000);
							System.out.println("Manually Expire WC Task Wait Button Found");
							String parent1 = getDriver().getWindowHandle();
							TaskList.get(k).click();
							System.out.println("Manually Expire WC Task Wait Clicked");
							waitABit(10000);
							Set<String> grandchild = getDriver().getWindowHandles();
							System.out.println("Size of the Window : " + grandchild.size());
							Iterator<String> ite = grandchild.iterator();
							while (ite.hasNext()) {
								String popupHandle = ite.next();
								if (!parent1.equals(popupHandle) && !child.equals(popupHandle)
										&& !parent.equals(popupHandle)) {
									getDriver().switchTo().window(popupHandle);
									getDriver().manage().window().maximize();
									System.out.println("Window title is : " + getDriver().getTitle());
									waitABit(2000);
									customClickableWait(metastormpage.btn_manual_expire_ok);
									metastormpage.btn_manual_expire_ok.click();
									waitABit(10000);
								}
							}
							System.out.println("Metastorm Task Performed");
							getDriver().switchTo().window(parent);
							getDriver().close();
						}
					}
				} catch (Exception e) {
					System.out.println("Catched Exception : " + e.getMessage());
				} finally {
					System.out.println("Manually Expire WC Task Done");
				}
				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				String URL = envData.getFieldValue("swifturl");
				swiftpage.openAt(URL);
				WaitForPageToLoad(60);
				System.out.println("Swift Page Launched Again");
				swiftpage.maximize();
				WaitForPageToLoad(5); // wait for auto log in
				swiftpage.tbx_order_id_field.clear();
				swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);
				WaitForPageToLoad(60);
				customClickableWait(swiftpage.lnk_order_package_ready1);
			}
		}
		customClickableWait(swiftpage.lnk_order_package_ready4);
		swiftpage.lnk_order_package_ready4.click();
		waitABit(3000);
		for (int k = 0; k < 2; k++) {
			String User = getDriver().findElement(By.xpath("//span[@id='headerUserInfo']/span[1]")).getText();
			if (User.contains("Madahalli Chowdegowda, Raju")) {
				System.out.println("4th Task Already Impersonating to Raju");
				break;
			} else {
				waitABit(3000);
				customClickableWait(swiftpage.btn_userinfo);
				swiftpage.btn_userinfo.click();
				waitABit(2000);
				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']")).clear();
				getDriver().findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"))
						.sendKeys("Madahalli Chowdegowda, Raju");
				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
				waitABit(2000);
				swiftpage.btn_impersonate.click();
				customwaitforpageloading(swiftpage);
				waitForSwiftProgressBar(swiftpage);
				waitABit(2000);
			}
		}
		customClickableWait(swiftpage.lnk_order_package_ready4);
		swiftpage.lnk_order_package_ready4.click();
		waitABit(3000);
		customClickableWait(swiftpage.btn_reassign_me);
		swiftpage.btn_reassign_me.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
		customwaitforpageloading(swiftpage);
		waitForSwiftProgressBar(swiftpage);
		System.out.println("4th Task Reassigned to User");
		customClickableWait(swiftpage.lnk_order_package_ready4);
		swiftpage.lnk_order_package_ready4.waitUntilPresent();
		swiftpage.lnk_order_package_ready4.click();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
		customClickableWait(swiftpage.btn_complete);
		waitForSwiftProgressBar(swiftpage);
		// waitABit(3000);
		swiftpage.btn_complete.click();
		// waitABit(10000);
		waitForSwiftProgressBar(swiftpage);
		customwaitforpageloading(swiftpage);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
		customClickableWait(swiftpage.lnk_order_package_ready3);
		swiftpage.lnk_order_package_ready3.click();
		waitABit(3000);
		customClickableWait(swiftpage.btn_reassign_me);
		swiftpage.btn_reassign_me.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB, Keys.ENTER);
		customwaitforpageloading(swiftpage);
		waitForSwiftProgressBar(swiftpage);
		System.out.println("3rd Task Reassigned to User");
		customClickableWait(swiftpage.lnk_order_package_ready3);
		swiftpage.lnk_order_package_ready3.waitUntilPresent();
		swiftpage.lnk_order_package_ready3.click();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_complete);
		customClickableWait(swiftpage.btn_complete);
		waitForSwiftProgressBar(swiftpage);
		// waitABit(3000);
		swiftpage.btn_complete.click();
		// waitABit(10000);
		waitForSwiftProgressBar(swiftpage);
		customwaitforpageloading(swiftpage);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", swiftpage.btn_collapse);
		// --------------- wait for credit Approval step--------------------
		// span[contains(text(), 'Wait For Credit Approval')]
		boolean credApprovalStatus = false;
		String taskName2 = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[6]/td[7]/span"))
				.getText();
		if (taskName2.equals("Wait For Credit Approval")) {
			credApprovalStatus = true;
			System.out.println("Credit Approval Status" + credApprovalStatus);
			getDriver().close();
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			metastormpage.openAt(envData.getFieldValue("SEOurl"));
			WaitForPageToLoad(100);
			metastormpage.maximize();
			waitABit(5000); // auto login wait
			System.out.println("MetaStorm Page is Loaded");
			System.out.println("Current URL : " + getDriver().getCurrentUrl());
			customClickableWait(metastormpage.btn_watch_list);
			metastormpage.btn_watch_list.click();
			waitABit(3000);
			customClickableWait(metastormpage.ddl_process);
			metastormpage.ddl_process.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_process_OP_Credit_Check);
			metastormpage.ddl_process_OP_Credit_Check.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_stage);
			metastormpage.ddl_stage.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_stage_Credit_Approval);
			metastormpage.ddl_stage_Credit_Approval.click();
			waitABit(5000);
			String parent = getDriver().getWindowHandle();
			System.out.println("Sess Value for Xpath is : " + sess);
			metastormpage.metastorm(sess).click();
			waitABit(10000);
			java.util.Set<String> child = getDriver().getWindowHandles();
			System.out.println("Size of the Window : " + child.size());
			child.remove(parent);
			getDriver().switchTo().window((String) child.toArray()[0]);
			getDriver().getTitle();
			getDriver().manage().window().maximize();
			try {
				List<WebElement> TaskList = getDriver().findElements(By.xpath("//div[@id='ActionListMenu']//ul/li[9]"));
				for (int k = 0; k < TaskList.size(); k++) {
					waitABit(5000);
					if (TaskList.get(k).getText().contains("CreditCheckDone")) {
						waitABit(5000);
						System.out.println("CreditCheckDone Button Found");
						String parent1 = getDriver().getWindowHandle();
						TaskList.get(k).click();
						System.out.println("CreditCheckDone Button Clicked");
						waitABit(10000);
						getDriver().switchTo().frame(0);
						getDriver().switchTo().frame(0);
						waitABit(2000);
						getDriver().findElement(By.xpath("//input[@id ='btnConfirm' and @value ='Yes']")).click();
						System.out.println("CreditApproval Task Done");
						getDriver().switchTo().defaultContent();
						System.out.println("Metastorm Task Performed");
						getDriver().switchTo().window(parent);
					}
				}
			} catch (Exception e) {
				System.out.println("Catched Exception : " + e.getMessage());
			} finally {
				System.out.println("CreditApproval Task Done");
			}
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			String URL = envData.getFieldValue("swifturl");
			swiftpage.openAt(URL);
			WaitForPageToLoad(60);
			System.out.println("Swift Page Launched Again");
			swiftpage.maximize();
			WaitForPageToLoad(5); // wait for auto log in
			swiftpage.tbx_order_id_field.clear();
			swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);
			WaitForPageToLoad(60);
			customClickableWait(swiftpage.lnk_order_package_ready1);
		}
		// -------- OV Downstream Task -----------
		waitABit(10000);
		String FifthTask;
		if (credApprovalStatus == true) {
			FifthTask = getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[8]/td[4]/span"))
					.getText();
		} else {
			FifthTask = getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[7]/td[4]/span"))
					.getText();
		}
		System.out.println("Fifth Task Status : " + FifthTask);
		if (FifthTask.contains("Cancelled")) {
			System.out.println("Fifth Task is Cancelled");
		} else {
			System.out.println("Fifth Task is Ready to be Validated, Switching to MetaStorm");
			getDriver().close();
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			metastormpage.openAt(envData.getFieldValue("SEOurl"));
			WaitForPageToLoad(100);
			metastormpage.maximize();
			waitABit(5000); // auto login wait
			System.out.println("MetaStorm Page is Loaded");
			System.out.println("Current URL : " + getDriver().getCurrentUrl());
			customClickableWait(metastormpage.btn_watch_list);
			metastormpage.btn_watch_list.click();
			waitABit(3000);
			customClickableWait(metastormpage.ddl_process);
			metastormpage.ddl_process.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_process_OP_Install);
			metastormpage.ddl_process_OP_Install.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_stage);
			metastormpage.ddl_stage.click();
			waitABit(5000);
			customClickableWait(metastormpage.ddl_stage_select_OV);
			metastormpage.ddl_stage_select_OV.click();
			waitABit(5000);
			String parent = getDriver().getWindowHandle();
			System.out.println("Sess Value for Xpath is : " + sess);
			metastormpage.metastorm(sess).click();
			waitABit(10000);
			java.util.Set<String> child = getDriver().getWindowHandles();
			System.out.println("Size of the Window : " + child.size());
			child.remove(parent);
			getDriver().switchTo().window((String) child.toArray()[0]);
			getDriver().getTitle();
			getDriver().manage().window().maximize();
			try {
				List<WebElement> TaskList = getDriver()
						.findElements(By.xpath("//div[@id='ActionListMenu']//ul/li[8]/a"));
				for (int k = 0; k < TaskList.size(); k++) {
					waitABit(5000);
					if (TaskList.get(k).getText().contains("ActivateOVTask")) {
						waitABit(5000);
						System.out.println("ActivateOVTask Button Found");
						String parent1 = getDriver().getWindowHandle();
						TaskList.get(k).click();
						System.out.println("ActivateOVTask Clicked");
						waitABit(10000);
						getDriver().switchTo().frame(0);
						getDriver().switchTo().frame(0);
						waitABit(2000);
						getDriver().findElement(By.xpath("//input[@id ='btnConfirm' and @value ='Yes']")).click();
						System.out.println("ActivateOV Task Done");
						getDriver().switchTo().defaultContent();
						System.out.println("Metastorm Task Performed");
						getDriver().switchTo().window(parent);
					}
				}
			} catch (Exception e) {
				System.out.println("Catched Exception : " + e.getMessage());
			} finally {
				System.out.println("ActivateOV Task Done");
				getDriver().switchTo().window(parent);
				// getDriver().close();
			}
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			String URL = envData.getFieldValue("swifturl");
			swiftpage.openAt(URL);
			WaitForPageToLoad(60);
			System.out.println("Swift Page Launched Again");
			swiftpage.maximize();
			WaitForPageToLoad(5); // wait for auto log in
			swiftpage.tbx_order_id_field.clear();
			swiftpage.tbx_order_id_field.sendKeys(orderpackageid + Keys.ENTER);
			WaitForPageToLoad(60);
			customClickableWait(swiftpage.lnk_OES_ready1);
		}
	}

	public void customwaitforpageloading(Page page) {
		page.withTimeoutOf(Duration.ofSeconds(800))
				.waitForElementsToDisappear(org.openqa.selenium.By.xpath("//div[@class='k-loading-image']"));
		System.out.println("Page Loading Circle is being Displayed");
		// waitABit(5000);
	}

	public Boolean waitForSwiftProgressBar(Page page) {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				waitABit(5000);
				if (page.isElementVisible(By.xpath("//*[@id='ajax-spinner']/div/div[1]"))) {
					System.out.println("Loading progress bar is dispayed");
					ncounter = ncounter + 1;
					waitABit(3000);
				} else {
					System.out.println("All good");
					bflag = true;
				}
			} while (bflag != true);
			System.out.println("out of try for  waitForSwiftProgressBar");
			System.out.println("Loading progress bar  counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}

	@Step
	public void user_enters_CRD() {
		Boolean myflag;
		String myName;
		int myTaskCounter = -1;
		String myProductType = System.getProperty("myProduct.ID");
		String SIDID = System.getProperty("SID.ID");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 3);
		String newDate = dateFormat.format(cal.getTime());
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
		swiftPage.btn_productPackagesTab.click(); // click on the product package tab
		WebElement element1 = getDriver().findElement(By.id("cbHeader")); // update
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click()", element1); // check the select all check box
		swiftPage.btn_editDatesBtn.waitUntilEnabled();// edit date
		swiftPage.btn_editDatesBtn.click(); // edit dates
		swiftPage.txt_CurrentCrdDatePicker.waitUntilEnabled();// set date txt_Current Date
		swiftPage.txt_CurrentCrdDatePicker.type(newDate); // set dates txt_Current Date
		swiftPage.btn_EditDateDialogOkBtn.waitUntilEnabled();// save dates
		swiftPage.btn_EditDateDialogOkBtn.click(); // save dates
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(2000);
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		getDriver().navigate().refresh(); // refresh the page
		waitABit(5000);
//		swiftPage.searchBtn.click(); // click the search button
//		waitABit(2000);
		logger.info("out of user_CRD date");
	}

	public boolean checkWaitForCreditApprovalTaskStatus() {
		boolean status = false;
		int counter = 0;
		waitABit(2000);
		logger.info(
				"Size of task-" + getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size());
		while ((getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size() <= 2)
				&& counter <= 100) {
			logger.info("3rd task not generated, Counter Value-" + counter);
			getDriver().navigate().refresh();
			waitABit(10000);
			counter++;
		}
		getDriver().navigate().refresh();
		waitABit(6000);
		List<WebElement> alltasks = getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]/span"));
		List<WebElement> allTaskStatus = getDriver()
				.findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[4]/span"));
		for (int i = 0; i < alltasks.size(); i++) {
			waitABit(1000);
			String taskName = alltasks.get(i).getText();
			String taskStatus = allTaskStatus.get(i).getText();
			logger.info("Task Name-" + taskName + ", Status of task-" + taskStatus);
			if (taskName.equals("Wait For Credit Approval") && taskStatus.equals("Ready")) {
				logger.info("Clear the Wait For Credit Approval task from SEO");
				status = true;
				break;
			}
		}
		return status;
	}

	@Step
	public void Launch_SEO2(String process, String stage) {
		String myEnv = System.getProperty("staf.environment.key");
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(180));
		String order = "";
		swiftPage.openAt(envData.getFieldValue("SEOurl"));
		waitABit(8000);
		swiftPage.btn_watch_list.click(); // click on log in button
		waitABit(4000);
		String win1 = getDriver().getWindowHandle();
		System.out.println(win1);
		waitABit(5000);
		swiftPage.lst_sort.click();
		waitABit(5000);
		swiftPage.lst_sort.click();
		waitABit(4000);
		swiftPage.lst_process_pick.click();
		waitABit(3000);
		// Process Dropdown
		// List<WebElementFacade> processDropdownOptions =
		// swiftPage.processDropDown_Options;
		List<WebElement> processDropdownOptions = getDriver().findElements(By.xpath("(//ul[@class='rcbList'])[1]/li"));
		for (int i = 0; i <= processDropdownOptions.size() - 1; i++) {
			String option = processDropdownOptions.get(i).getText();
			logger.info("Option1-" + i + option);
			if (option.equals(process)) // option.equals("OP Install") Stage2--OP_Welcome_Customer
			{
				processDropdownOptions.get(i).click();
			}
		}
		waitABit(2000);
		// Stage dropdown
		if (stage.isEmpty() == false) {
			// WebElement stageDropdown =
			// getDriver().findElement(By.xpath("//input[@name='ctl00$phMainContent$WatchListPart$StageList']"));
			WebElementFacade stageDropdown = swiftPage.stageDropdown;
			waitABit(3000);
			List<WebElement> stageDropdownOptions = getDriver()
					.findElements(By.xpath("(//ul[@class='rcbList'])[2]/li"));
			// List<WebElementFacade> stageDropdownOptions=swiftPage.stageDropdownOptions;
			for (int i = 0; i <= stageDropdownOptions.size() - 1; i++) {
				String option2 = stageDropdownOptions.get(i).getText();
				logger.info("Option2-" + i + option2);
				if (option2.equals(stage)) // option2.equals("Waiting For Downstream System Job Completion")
				{
					stageDropdownOptions.get(i).click();
					logger.info("Waiting For Downstream System Job Completion stage clicked");
				}
			}
		}
		waitABit(2000);
//		List<WebElement> allrecords = getDriver().findElements(By.xpath("//td[@class='gridData']//tbody/tr")); // --Added
//		List<WebElement> allOrders = getDriver().findElements(By.xpath("//td[@class='gridData']//tbody/tr/td[1]")); // --Added
//		List<WebElement> allSubjects = getDriver().findElements(By.xpath("//td[@class='gridData']//tbody/tr/td[2]")); // --Added
		List<WebElementFacade> allrecords = swiftPage.allrecords;
		List<WebElementFacade> allOrders = swiftPage.allOrders;
		List<WebElementFacade> allSubjects = swiftPage.allSubjects;
		logger.info("Size of all Orders-" + allOrders.size());
		for (int i = 0; i <= allrecords.size() - 1; i++) {
			order = allOrders.get(i).getText(); // -- Added Raj
			String subject = allSubjects.get(i).getText();
			logger.info("Order Id----" + order);
			logger.info("My opp Id=" + myOpid);
			logger.info(order);
			// Welcome Customer Records
			if (subject.equals("SwIFT-" + myOpid + "-OP_Welcome_Customer")) {
				logger.info("Welcome Customer row found it!");
				allOrders.get(i).click();
				// my_order.click();
				break;
			}
			// Waiting for Downstrean System Job Completion Records
			else if (subject.equals("SwIFT-" + myOpid + "-OP_Install")) {
				logger.info("Waiting for Downstrean System Job Completion Found it!");
				allOrders.get(i).click();
				// my_order.click();
				break;
			}
			// Credit Check Records
			else if (subject.equals("SwIFT-" + myOpid + "-OP_Credit_Check")) {
				logger.info("Wait for Credit Approval found it!");
				allOrders.get(i).click();
				// my_order.click();
				break;
			}
		}
		E2ESteps.softAssertError("In SOE", true, "the SOE id is ", String.valueOf(myOpid));
		waitABit(4000);
		Set<String> win2 = getDriver().getWindowHandles();
		System.out.println(win2);
		Iterator<String> i1 = win2.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			logger.info("Under While");
			if (!win1.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child windows
				getDriver().switchTo().window(ChildWindow);
				swiftPage.maximize();
				logger.info("Maximize");
				waitABit(5000);
				if (process.equals("OP_Welcome_Customer")) {
					logger.info("Under welcome Customer process");
//					File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//					try {
//						String userDir = System.getProperty("user.dir");
//						FileUtils.copyFile(scrFile, new File(userDir + "\\target\\report\\scen.png"));
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					WebElement manually = getDriver()
//							.findElement(By.xpath("//span[text()='ManuallyExpireWCTaskWait']"));
					WebElementFacade manually = swiftPage.manuallyExpireWCTaskWait;
					wait.until(ExpectedConditions.elementToBeClickable(swiftPage.manuallyExpireWCTaskWait));
					Actions a1 = new Actions(getDriver());
					a1.moveToElement(manually).click().build().perform();
					waitABit(2000);
					logger.info("clicked on Manually ExpireWC Task button");
				} else if (process.equals("OP Install")) {
					System.out.println("under OP Install process");
					// WebElement activateOV =
					// getDriver().findElement(By.xpath("//span[text()='ActivateOVTask']"));
					WebElementFacade activateOV = swiftPage.activateOVTask;
					wait.until(ExpectedConditions.elementToBeClickable(swiftPage.activateOVTask));
					Actions a1 = new Actions(getDriver());
					a1.moveToElement(activateOV).click().build().perform();
					logger.info("under OP Install process");
					waitABit(5000);
				} else if (process.equals("OP Credit Check")) {
					System.out.println("under OP Credit Check");
					// WebElement creditCheckDoneButton =
					// getDriver().findElement(By.xpath("//span[text()='CreditCheckDone']"));
					WebElementFacade creditCheckDoneButton = swiftPage.creditCheckDone;
					wait.until(ExpectedConditions.elementToBeClickable(swiftPage.creditCheckDone));
					Actions a1 = new Actions(getDriver());
					a1.moveToElement(creditCheckDoneButton).click().build().perform();
					logger.info("Credit Check done button clicked");
					waitABit(3000);
				}
				if (process.equals("OP_Welcome_Customer")) {
					for (String winHandle : getDriver().getWindowHandles()) {
						String windowTitle = getDriver().switchTo().window(winHandle).getTitle();
						logger.info("Title =" + windowTitle);
						waitABit(2000);
						if (windowTitle.contains("ManuallyExpireWCTaskWait")) {
							logger.info("inside ManuallyExpireWCTaskWait if condition");
							// WebElement continue_element =
							// getDriver().findElement(By.xpath("//input[@name='btnConfirm']"));
							WebElementFacade continue_element = swiftPage.btnConfirmForManuallyExpiredWCTask;
							wait.until(ExpectedConditions
									.elementToBeClickable(swiftPage.btnConfirmForManuallyExpiredWCTask));
							waitABit(2000);
							Actions a2 = new Actions(getDriver());
							a2.moveToElement(continue_element).click().build().perform();
							System.out.println();
							break;
						}
					}
				}
				if (stage.isEmpty() == false) {
					waitABit(3000);
					List<WebElement> frame1 = getDriver().findElements(By.tagName("iframe"));
					logger.info("Size of frame-" + frame1.size());
					getDriver().switchTo().frame(0);
					String srcValue = getDriver().findElement(By.tagName("iframe")).getAttribute("src");
					logger.info("SrcValue--" + srcValue);
					logger.info("Frame-" + getDriver().getTitle());
					waitABit(2000);
					getDriver().switchTo().frame(0);
					waitABit(2000);
					// WebElement ele = getDriver().findElement(By.xpath("//input[@id='btnConfirm'
					// and @value='Yes']"));
					WebElementFacade ele = swiftPage.btnConfirm;
					wait.until(ExpectedConditions.elementToBeClickable(swiftPage.btnConfirm));
					logger.info("popup--" + ele.getText());
					ele.click();
					waitABit(4000);
					logger.info("Out of frame ");
				}
				waitABit(2000);
				logger.info("Out of for set");
				break;
			}
		}
		getDriver().switchTo().window(win1);
		E2ESteps.printInGreenColor("In SEO function", " out of function SEO -SwIFT-" + myOpid + "-OP_Welcome_Customer");
	}

	public boolean checkWelcomeCustomerAndCoordinateCustomerTaskStatus() {
		int counter = 0;
		boolean status = false;
		logger.info("Size of task--"
				+ getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size());
		while (((getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size()) <= 3)
				&& counter <= 100) {
			logger.info("3rd and 4th task not generated");
			getDriver().navigate().refresh();
			waitABit(3000);
			counter++;
		}
		List<WebElement> alltasks = getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]"));
		List<WebElement> allTaskStatus = getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[4]"));
		for (int i = 0; i < alltasks.size(); i++) {
			String taskName = alltasks.get(i).getText();
			String taskStatus = allTaskStatus.get(i).getText();
			logger.info(taskName + " and Status of task--" + taskStatus);
			// System.out.println(taskStatus);
			if (taskName.endsWith("Welcome Customer") && taskStatus.equals("Pending")) {
				logger.info("Clear the Credit Check from SEO");
				status = true;
				break;
			}
		}
		return status;
	}

	public boolean waitingForDownStreamSystemTaskCheck() {
		boolean status = false;
		List<WebElement> alltasks = getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]"));
		List<WebElement> allTaskStatus = getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[4]"));
		for (int i = 0; i < alltasks.size(); i++) {
			String taskName = alltasks.get(i).getText();
			String taskStatus = allTaskStatus.get(i).getText();
			logger.info(taskName + " and Status of task--" + taskStatus);
			// System.out.println(taskStatus);
			if (taskName.equals("Waiting For Downstream System Job Completion") && taskStatus.equals("Ready")) {
				logger.info("Clear the Waiting For Downstream System Job from SEO");
				status = true;
				break;
			}
		}
		E2ESteps.printInGreenColor("completed waitingForDownStreamSystemTaskCheck",
				"out of function waitingForDownStreamSystemTaskCheck");
		return status;
	}

	@Step
	public void user_CompleteWelcomeCustomerTask() {
		Boolean myflag;
		String myName;
		for (int i = 0; i < 100; i++) {
			waitABit(5000);
			String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
					.getText();
			logger.info("Update Task Status : " + UpdatedTask);
			if (UpdatedTask.contains("1 - 4 of 4 items")) {
				logger.info("3rd and 4th task Generated");
				waitABit(2000);
				break;
			} else {
				waitABit(10000);
				getDriver().navigate().refresh();
				WaitForPageToLoad(60);
				logger.info("3rd and 4th Task Not Generated, Retrying");
			}
		}
		String fourthTaskStatus = getDriver()
				.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[4]/span")).getText();
		String fourthtaskName = getDriver()
				.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[7]/span")).getText();
		logger.info("Fourth Task Status : " + fourthTaskStatus);
		if ((fourthTaskStatus.contains("Ready")) && (fourthtaskName.equals("Welcome Customer"))) {
			logger.info("Fourth Task is Ready to be Validated");
			myName = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[5]/span"))
					.getText();
			logger.info("myName is " + myName);
			String currUser = getDriver().findElement(By.xpath("//*[@id=\"headerUserInfo\"]/span[1]"))
					.getAttribute("innerHTML");
			logger.info("Current User-" + currUser);
			String finalCurrUser = currUser.substring(16, currUser.length() - 1);
			logger.info("Length of final User-" + finalCurrUser.length());
			logger.info("Final Current User-" + finalCurrUser);
			if (!myName.equals(finalCurrUser)) {
				swiftPage.lbl_user_info.click(); // open impersonate box
				waitABit(3000);
				for (int r = 0; r <= 30; r++) {
					WebElement imersonationBox = getDriver()
							.findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"));
					String value = imersonationBox.getAttribute("aria-activedescendant");
					logger.info("Selected Option--" + value);
					waitABit(1000);
					value = value + "Yes";
					System.out.println(value.length());
					if (value.length() != 7) {
						logger.info("Impersoante Text box value present");
						break;
					}
				}
				swiftPage.txt_user_info.type("");
				waitABit(1000);
				getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
				getDriver().switchTo().activeElement().sendKeys(myName);
				waitABit(3000);
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//
				waitABit(2000);
				swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
				// waitABit(2000);
				myflag = waitForSwiftProgressBar();
				if (myflag) {
					System.out.println("error in waitForSwiftProgressBar");
				}
			}
		}
		getDriver().findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[5]/td[4]/span")).click();
		waitABit(2000);
		E2ESteps.printInGreenColor("completed user_CompleteWelcomeCustomerTask",
				"out of function user_CompleteWelcomeCustomerTask");
	}

	@Step
	public void user_CompleteCoordinateCustomerTask() {
		Boolean myflag;
		String myName;
		for (int i = 0; i < 100; i++) {
			waitABit(2000);
			String UpdatedTask = getDriver().findElement(By.xpath("(//span[@class='k-pager-info k-label'])[1]"))
					.getText();
			logger.info("Update Task Status : " + UpdatedTask);
			if (UpdatedTask.contains("1 - 4 of 4 items")) {
				logger.info("3rd and 4th task Generated");
				waitABit(2000);
				break;
			} else {
				waitABit(6000);
				getDriver().navigate().refresh();
				WaitForPageToLoad(60);
				logger.info("3rd and 4th Task Not Generated, Retrying");
				waitABit(3000);
			}
		}
		String thirdTask = getDriver()
				.findElement(By.xpath("//div[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[4]/span")).getText();
		logger.info("Third Task Status : " + thirdTask);
		if (thirdTask.contains("Ready")) {
			logger.info("Third Task is Ready to be Validated");
		}
		myName = getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[5]/span")).getText();
		String currUser = getDriver().findElement(By.xpath("//*[@id=\"headerUserInfo\"]/span[1]"))
				.getAttribute("innerHTML");
		logger.info("Current User-" + currUser);
		String finalCurrUser = currUser.substring(16, currUser.length() - 1);
		logger.info("Length of final User-" + finalCurrUser.length());
		logger.info("Final Current User-" + finalCurrUser);
		if (!myName.equals(finalCurrUser)) {
			swiftPage.lbl_user_info.click(); // open impersonate box
			waitABit(5000);
			for (int r = 0; r <= 30; r++) {
				WebElement imersonationBox = getDriver()
						.findElement(By.xpath("//input[@aria-owns='impersonateUserId_listbox']"));
				String value = imersonationBox.getAttribute("aria-activedescendant");
				logger.info("Selected Option--" + value);
				waitABit(2000);
				value = value + "Yes";
				System.out.println(value.length());
				if (value.length() != 7) {
					logger.info("Impersoante Text box value present");
					break;
				}
			}
			swiftPage.txt_user_info.type("");
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
			getDriver().switchTo().activeElement().sendKeys(myName);
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			waitABit(2000);
			swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
			// waitABit(2000);
			myflag = waitForSwiftProgressBar();
			if (myflag) {
				System.out.println("error in waitForSwiftProgressBar");
			}
			waitABit(2000);
		}
		WebElement CoordinateCustomerRow = getDriver()
				.findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[4]/td[5]/span"));
		CoordinateCustomerRow.click();
		waitABit(2000);
		E2ESteps.printInGreenColor("completed user_CompleteCoordinateCustomerTask",
				"out of function user_CompleteCoordinateCustomerTasks");
	}

	///////////////////////////////////////////////////////////////
	public void loginToSwift() {
		String myEnv = System.getProperty("staf.environment.key");
		swiftPage.openAt(envData.getFieldValue("swiftCusturl")); // the swift url from the e2e.xml
		swiftPage.waitForTextToAppear("SEARCH", 30000);
		swiftPage.maximize();
//		swiftPage.getDriver().navigate().to(envData.getFieldValue("url"));
		waitABit(5000);
//		String tempcurrentURL = getDriver().getCurrentUrl(); // get the current url
//		logger.info("currentURL  is  " + tempcurrentURL); // // get the current url
//		System.setProperty("URL.ID", tempcurrentURL); // set the url into memory
//		String OrginalURL = System.getProperty("URL.ID"); // get the url from memory
//		logger.info("OrginalURL  is  " + OrginalURL); // end of getting original url
//		loginPage.btn_SSO.click(); // click on the single sign in button
//		logger.info("Successfully launched the SFA url" );
	}

	public void ClickOnCreateNewPackage() {
		WebElement createNewPackage = getDriver()
				.findElement(By.xpath("//button[@id='ShowCreateOrderPackageFormBtn']"));
		// createNewPackage.waitUntilEnabled();
		createNewPackage.click();
		System.out.println("Clicked on Create New Package Button");
	}

	public void validateCreateNewPackageSection() {
		WebElement createNewPackageSection = getDriver()
				.findElement(By.xpath("//button[@id='ShowCreateOrderPackageFormBtn']"));
		createNewPackageSection.isEnabled();
		System.out.println("Successfully navigated to Create New Package Section");
	}

	public void entersCreateNewPackageDetails(String accName, String salesOffice, String ProdType,
			String globalRegion) {
		getDriver().findElement(By.xpath("(//button[@id='AccountManagementSearchBtn'])[1]")).click();
		waitABit(800);
		getDriver().findElement(By.xpath("(//button[@ng-click='SearchAccounts()'])[1]")).click();
		waitABit(1000);
		getDriver().findElement(By.xpath("(//div[@id='AccountManagementSearchGrid']//tbody/tr/td)[1]")).click();
		WebElement save = getDriver()
				.findElement(By.xpath("(//button[@ng-click='AccountManagementSearchOkClick()'])[1]"));
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", save);
		System.out.println("Successfully Customer Account is selected");
		// save.click();
		waitABit(1000);
		getDriver().findElement(By.xpath("//dt[text()='Sales Office']/../dd/span")).click();
		waitABit(600);
		getDriver().switchTo().activeElement().sendKeys(salesOffice);
		waitABit(1300);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Successfully Sales Office is selected");
		getDriver().findElement(By.xpath("//span[@aria-owns='ProductsOptionDropDown_listbox']")).click();
		getDriver().switchTo().activeElement().sendKeys(ProdType);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Successfully Product Type is selected");
		waitABit(1000);
		// getDriver().findElement(By.xpath("//span[@class='k-widget k-dropdown k-header
		// required']")).click(); //global reg
	}

	public void clicksOnSaveNewOrderPackage() {
		WebElement saveNewOrderPackage = getDriver().findElement(By.xpath("//button[@id='SaveNewOrderPackageButton']"));
		saveNewOrderPackage.isEnabled();
		saveNewOrderPackage.isDisplayed();
		saveNewOrderPackage.click();
		System.out.println("Successfully Save New Order Package button Clicked");
		waitABit(4000);
	}

	public void userSuccessfullyValidatedNewOrderNumberGenerated(String smyproduct) {
		String actualUrl = getDriver().getCurrentUrl();
		for (int i = 0; i <= 10; i++) {
			waitABit(800);
			actualUrl = getDriver().getCurrentUrl();
			System.out.println("Url of page" + actualUrl);
			String expctedUrl = envData.getFieldValue("swifturl").substring(0, 28);
			System.out.println("Expected url--" + expctedUrl);
			if (actualUrl.contains(expctedUrl)) {
				break;
			}
		}
		System.out.println("Current URL : " + actualUrl);
		String sOpid = actualUrl.toString();
		myOpid = actualUrl.substring(30, 39);
		System.out.println("the Order package id is " + myOpid);
		System.setProperty("myProduct.ID", smyproduct);
		WebElement boid = getDriver().findElement(By.xpath("//*[@id=\"pageMetaData\"]/div[2]/span[2]"));
		String tempSwiftOrderID = boid.getText();
		System.setProperty("Swift.ID", tempSwiftOrderID);
		boolean status = false;
		int counter = 0;
		while (status == false && counter != 10) {
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(8));
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[1]")));
				getDriver().findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[1]")).isEnabled();
				status = true;
				System.out.println("Status of first task kicked off=" + status);
			} catch (TimeoutException e) {
				System.out.println("First task is not kicked off");
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				counter++;
			}
		}
	}

	public void navigateToProductPackageSection() {
		WebElement createNewPackageSection = getDriver().findElement(By.xpath("//a[@id='productPackagesTab']"));
		createNewPackageSection.isEnabled();
		createNewPackageSection.click();
		System.out.println("Product Package button is clicked");
	}

	public void UesrsuccessfullynavigatedToProductPackageSection() {
		WebElement createNewPackageSection = getDriver().findElement(By.xpath("//a[@id='productPackagesTab']"));
		createNewPackageSection.isEnabled();
		System.out.println("Successfully navigated to Product Package Section");
	}

	public void clicksOnAddPSP() {
		waitABit(1000);
		swiftPage.btn_addPspBtn.waitUntilEnabled().waitUntilClickable();
		swiftPage.btn_addPspBtn.click(); // click on the PSP Button
		System.out.println("Clicked on Add PSP");
	}

	public void entersCLLIAndClickOnSeach(String cLLI) {
		waitABit(2000);
		swiftPage.txt_searchClliCriteriaTextBox.type(cLLI); // add the clli to text box
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		swiftPage.btn_location_search_button.waitUntilEnabled(); //
		swiftPage.btn_location_search_button.click(); // click on search button
		System.out.println("Successfully entered CLLI and Clicked on Search");
		waitABit(3000);
	}

	public void selectLocationAndClickOnSave(String eEndCLLI) {
		swiftPage.img_filtercheckbox.click();// check the filter drop down image
		swiftPage.img_filter.click();// check the filter drop down image
		swiftPage.txt_filterinput.type(eEndCLLI); // search for the cilli
		swiftPage.btn_filtersearch.click(); // press the search button
		waitABit(1500);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		WebElement loc_element = getDriver()
				.findElement(By.xpath("//*[@id=\"locationSearchGrid\"]/div[2]/table/tbody/tr/td[2]/span"));
		String myLocation = loc_element.getText();
		System.out.println("Location is : " + myLocation);
		WebElement cbxClli_element = getDriver().findElement(By.name(myLocation));
		// waitABit(3000);
		executor.executeScript("arguments[0].click();", cbxClli_element); // check the clli check box
		System.out.println("Successfully selected the eEndCLLI");
		waitABit(1500);
		swiftPage.btn_pspNext.waitUntilEnabled();// click the next button
		swiftPage.btn_pspNext.click();// click the next button
		System.out.println("Successfully clicked on next button");
		waitABit(2000);
	}

	public void userClicksOnAddNewProduct() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		swiftPage.waitForTextToAppear("Products", 30000);
		swiftPage.btn_addnewpsp.waitUntilEnabled(); // click on new product package button
		swiftPage.btn_addnewpsp.click(); // click on new product package button
		waitABit(2000);
		swiftPage.ddl_pspproduct.waitUntilEnabled(); // the product drop down
		swiftPage.ddl_pspproduct.click(); // the product drop down
		waitABit(3000);
	}

	public void userAddProduct_ProductAddressAndCurrency() {
		getDriver().switchTo().activeElement().sendKeys("D");// pick product
		for (int i = 1; i <= 18; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(2000);
			String prodValue = getDriver().findElement(By
					.xpath("//*[@id=\"productEditor\"]/div[2]/div[2]/table[1]/thead/tr[1]/td[2]/div/span/span/span[1]"))
					.getText();
			System.out.println("Product Value" + prodValue);
			if (prodValue.equals("Dedicated Internet Access")) {
				getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
				break;
			}
		}
		System.out.println("Successfully selected the Product");
		Boolean myflag;
		myflag = waitForSwiftProgressBar1();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		swiftPage.ddl_pspaddress.waitUntilEnabled();// get the address loaded
		swiftPage.ddl_pspaddress.click();// get the address loaded
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		waitABit(3000);
		System.out.println("Successfully selected the Address");
	}

	public void userEntersTheProductConfigurationDetails() {
		swiftPage.circuitType.waitUntilEnabled();
		swiftPage.circuitType.click();
		getDriver().switchTo().activeElement().sendKeys("10 G");// pick product
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Successfully selected the Bandwidth");
		Boolean myflag;
		myflag = waitForSwiftProgressBar1();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		swiftPage.portType.waitUntilEnabled().waitUntilClickable();
		swiftPage.portType.click();
		getDriver().switchTo().activeElement().sendKeys("F");// pick product
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Successfully selected the Billing Method");
		myflag = waitForSwiftProgressBar1();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		swiftPage.accessType.waitUntilEnabled().waitUntilClickable();
		swiftPage.accessType.click();
		getDriver().switchTo().activeElement().sendKeys("<");// pick product
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Successfully selected the Access Type");
		myflag = waitForSwiftProgressBar1();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		swiftPage.accessSubbandwidth.click();
		getDriver().switchTo().activeElement().sendKeys("4");// pick product
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Successfully selected the Access subbandwidth");
		myflag = waitForSwiftProgressBar1();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
	}

	public void userSaveProductDetails() {
		waitABit(1000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", swiftPage.btn_pspprproductNext);
		boolean myflag;
		myflag = waitForSwiftProgressBar1();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		swiftPage.btn_pspNext.waitUntilEnabled();// click the next button
		// waitABit(2000);
		swiftPage.btn_pspNext.click();// click the next button
		waitABit(2000);
		swiftPage.btn_pspprproducSave.waitUntilEnabled();// click the save button
		swiftPage.btn_pspprproducSave.click();// click the save button
		myflag = waitForSwiftProgressBar1();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
	}

	public void userSuccessfullyValidatedTheAddedProductInProductPackageSection() {
		swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
		swiftPage.btn_productPackagesTab.click(); // click on the product package tab
		getDriver().switchTo().activeElement().sendKeys(Keys.DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		WebElement prodPackageRow = getDriver()
				.findElement(By.xpath("//*[@id='productSummaryGrid']/div/table/tbody/tr[1]"));
		prodPackageRow.isDisplayed();
		prodPackageRow.isEnabled();
		System.out.println("Successfully validated the Product is added");
	}

	public void userEntersOrderDeatailsValue() {
		swiftPage.tab_orderDetailsTab.waitUntilEnabled();
		swiftPage.tab_orderDetailsTab.click();
		swiftPage.orderType.waitUntilEnabled();
		swiftPage.orderType.click();
		getDriver().switchTo().activeElement().sendKeys("I");
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Successfully order type is entered");
		waitABit(2000);
		swiftPage.ccm.click();
		swiftPage.ccm.click();// cause oes list to open
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys("Gautam, Rajneesh");
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		System.out.println("Successfully CCM value is entered");
	}

	public void userEntersContactDetails() {
		swiftPage.tab_contactsTab.click();
		getDriver().findElement(By.xpath("//input[@placeholder='Type a contact name...']")).click();
		getDriver().switchTo().activeElement().sendKeys("Janis");
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		getDriver().findElement(By.xpath("//div[text()='Section']")).click();
		waitABit(1500);
		getDriver().findElement(By.xpath("//label[text()='Role']/../div/div")).click();
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(600);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(600);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(600);
		getDriver().findElement(By.xpath("//div[text()='Section']")).click();
		waitABit(1500);
		getDriver().findElement(By.xpath("//label[text()='Section']/../div/div")).click();
		waitABit(600);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(600);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(600);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(600);
		System.out.println("Successfully contacts is addedd");
		getDriver().findElement(By.xpath("//div[text()='Section']")).click();
		waitABit(1500);
	}

	public void userClicksOnSaveChanges() {
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(800);
		WebElement elementsave = getDriver().findElement(By.xpath("//*[@id='saveChanges']")); // have to go to top of
																								// page and hit save //
																								// changes for this app
																								// // to save any edits
		waitABit(2000);
		elementsave.click();
		Boolean myflag;
		myflag = waitForSwiftProgressBar1();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		waitABit(1000);
	}

	public Boolean waitForSwiftProgressBar1() {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				// waitABit(1000);
				try {
					WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@id='ajax-spinner']/div/div[1]")));
					System.out.println("All good");
					bflag = true;
				} catch (TimeoutException e) {
					System.out.println("Loading progress bar is dispayed");
					ncounter = ncounter + 1;
					waitABit(1000);
				}
			} while (bflag != true);
			System.out.println("out of try for  waitForSwiftProgressBar");
			System.out.println("Loading progress bar  counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}

	public void enterCustomerRequestDate() {
		Boolean myflag;
		String SIDID = System.getProperty("SID.ID");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 3);
		String newDate = dateFormat.format(cal.getTime());
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
		swiftPage.btn_productPackagesTab.click(); // click on the product package tab
		WebElement element1 = getDriver().findElement(By.id("cbHeader")); // update
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click()", element1); // check the select all check box
		swiftPage.btn_editDatesBtn.waitUntilEnabled();// edit date
		swiftPage.btn_editDatesBtn.click(); // edit dates
		// swiftPage.txt_NewNddDatePicker.waitUntilEnabled();// set date NDD
		// swiftPage.txt_NewNddDatePicker.type(newDate); //set dates NDD
		swiftPage.txt_CurrentCrdDatePicker.waitUntilEnabled();// set date txt_Current Date
		swiftPage.txt_CurrentCrdDatePicker.type(""); // set dates txt_Current Date
		swiftPage.txt_CurrentCrdDatePicker.type(newDate); // set dates txt_Current Date
		swiftPage.btn_EditDateDialogOkBtn.waitUntilEnabled();// save dates
		swiftPage.btn_EditDateDialogOkBtn.click(); // save dates
		// getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
	}

	public void user_enters_CRD_NDD() {
		Boolean myflag;
		String myName;
		int myTaskCounter = -1;
		String myProductType = System.getProperty("myProduct.ID");
		String SIDID = System.getProperty("SID.ID");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Set Date
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 3);
		String newDate = dateFormat.format(cal.getTime());
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
		swiftPage.btn_productPackagesTab.click(); // click on the product package tab
		waitABit(2000);
		WebElement element1 = getDriver().findElement(By.id("cbHeader")); // update
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click()", element1); // check the select all check box
		swiftPage.btn_editDatesBtn.waitUntilEnabled();// edit date
		swiftPage.btn_editDatesBtn.click(); // edit dates
		swiftPage.txt_CurrentCrdDatePicker.waitUntilEnabled();// set date txt_Current Date
		swiftPage.txt_CurrentCrdDatePicker.type(newDate); // set dates txt_Current Date
		swiftPage.txt_NewNddDatePicker.waitUntilEnabled();// set date txt_Current Date
		swiftPage.txt_NewNddDatePicker.type(newDate); // set dates txt_Current Date
		swiftPage.btn_EditDateDialogOkBtn.waitUntilEnabled();// save dates
		swiftPage.btn_EditDateDialogOkBtn.click(); // save dates
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(2000);
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		getDriver().navigate().refresh(); // refresh the page
		waitABit(5000);
		swiftPage.searchBtn.click(); // click the search button
		waitABit(2000);
		System.out.println("out of user_CRD date");
	}

	public void user_enters_vrf_details() {
		boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		swiftPage.btn_productPackagesTab.waitUntilEnabled(); // click on the product package tab
		swiftPage.btn_productPackagesTab.click(); // click on the product package tab
		waitABit(8000);
		swiftPage.ipvpn_logical_expand.click();
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		swiftPage.ipcpn_logical_clk.click();
		waitABit(5000);
		executor.executeScript("arguments[0].click();", swiftPage.details_clk);
		waitABit(5000);
		executor.executeScript("arguments[0].click();", swiftPage.select_icon);
		waitABit(10000);
		swiftPage.auto_fill_clk.click();
		swiftPage.vrf_searchbutton.click();
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		waitABit(10000);
		swiftPage.vrf_first_row.click();
		waitABit(5000);
		swiftPage.vrf_save.click();
		waitABit(10000);
	}

	public void completes_Complete_Order_Details_Task(String sExpStatus, String sExpTask) {
		boolean status = false;
		boolean myflag;
		int counter = 0;
		waitABit(2000);
		System.out.println(
				"Size of task" + getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size());
		while ((getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size()) <= 3
				&& counter <= 100) {
			System.out.println("5th task not generated, Counter Value-" + counter);
			getDriver().navigate().refresh();
			waitABit(7000);
			counter++;
		}
		waitABit(5000);
		List<WebElement> alltasks = getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]/span"));
		List<WebElement> allTaskStatus = getDriver()
				.findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[4]/span"));
		for (int i = 0; i < alltasks.size(); i++) {
			waitABit(2000);
			String taskName = alltasks.get(i).getText();
			String taskStatus = allTaskStatus.get(i).getText();
			System.out.println("Task Name-" + taskName + ", Status of task" + taskStatus);
			if (taskName.equals("Complete Order Details") && taskStatus.equals("Ready")) {
				System.out.println("Found the Complete Order Details task");
				alltasks.get(i).click();
				status = true;
				break;
			}
		}
		waitABit(3000);
		swiftPage.btn_completeTask.click(); // press the complete button.
		myflag = waitForSwiftProgressBar();
		if (myflag) {
			System.out.println("error in waitForSwiftProgressBar");
		}
		E2ESteps.printInGreenColor("In completes_Order_Details", "out of function completes_Order_Details");
	}

	public boolean search_Target_Task(String sExpStatus, String sExpTask, int sizeOfTask) {
		boolean status = false;
		boolean myflag;
		int counter = 0;
		waitABit(2000);
		System.out.println(
				"Size of task" + getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size());
		while ((getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]")).size()) <= (sizeOfTask
				- 1) && counter <= 100) {
			System.out.println(sizeOfTask + " task not generated, Counter Value-" + counter);
			getDriver().navigate().refresh();
			waitABit(7000);
			counter++;
		}
		waitABit(5000);
		List<WebElement> alltasks = getDriver().findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[7]/span"));
		List<WebElement> allTaskStatus = getDriver()
				.findElements(By.xpath("(//tbody[@role='rowgroup'])[1]/tr/td[4]/span"));
		for (int i = 0; i < alltasks.size(); i++) {
			waitABit(2000);
			String taskName = alltasks.get(i).getText();
			String taskStatus = allTaskStatus.get(i).getText();
			System.out.println("Task Name-" + taskName + ", Status of task" + taskStatus);
			if (taskName.equals(sExpTask) && taskStatus.equals(sExpStatus)) {
				System.out.println("Found the " + sExpTask + " task");
				alltasks.get(i).click();
				status = true;
				if (taskName.equals("Complete Order Details") || taskName.equals("Welcome Customer")
						|| taskName.equals("Coordinate Customer")) {
					String myName = getDriver()
							.findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[6]/td[5]/span")).getText();
					String currUser = getDriver().findElement(By.xpath("//*[@id=\"headerUserInfo\"]/span[1]"))
							.getAttribute("innerHTML");
					System.out.println("Current User-" + currUser);
					String finalCurrUser = currUser.substring(16, currUser.length() - 1);
					System.out.println("Length of final User-" + finalCurrUser.length());
					System.out.println("Final Current User-" + finalCurrUser);
					if (!myName.equals(finalCurrUser)) {
						swiftPage.lbl_user_info.click(); // open impersonate box
						waitABit(5000);
						swiftPage.txt_user_info.type("");
						waitABit(1000);
						getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
						getDriver().switchTo().activeElement().sendKeys(myName);
						waitABit(3000);
						getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
						waitABit(2000);
						swiftPage.btn_impersonateUserBtn.click(); // press impersonate button
						// waitABit(2000);
						myflag = waitForSwiftProgressBar();
						if (myflag) {
							System.out.println("error in waitForSwiftProgressBar");
						}
						waitABit(2000);
					}
					WebElement completeOrderDetailsRow = getDriver()
							.findElement(By.xpath("//*[@id='taskGrid']/div[3]/table/tbody/tr[6]/td[5]/span"));
					completeOrderDetailsRow.click();
					waitABit(2000);
				}
				break;
			}
		}
		E2ESteps.printInGreenColor("In search_Target_Task", "out of function search_Target_Task");
		return status;
	}

	public void impersonateTaskUser() {
	}

	@SuppressWarnings("deprecation")
	public void Log_in_Swift_get_order2(String tasknum) {
		int myCounter;
		int pkgCounter;
		Boolean myflag;
		myflag = false;
		System.setProperty("Swift.ID", "2745300"); // get the swift id from memory
		// String myProductType = System.getProperty("myProduct.ID");
		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
		String myEnv = System.getProperty("staf.environment.key");
		String myProductType = "Dedicated Internet Access";
		swiftPage.openAt(envData.getFieldValue("swifturl")); // the swift url from the e2e.xml
		swiftPage.waitForTextToAppear("SEARCH", 30000);
		E2ESteps.softAssertError("In Swift", true, "the BOID ", String.valueOf(nSwiftID));
		if (nSwiftID.isEmpty()) {
			System.out.println("failed BOID is empty ending test ");
			getDriver().close();
			getDriver().quit();
		}
		waitABit(2000);
		swiftPage.lst_business_order_listbox.click(); // list box to pick business owner out of
		waitABit(2000);
		swiftPage.lst_business_order_pick.click(); // click on the "Business Order Id"
		waitABit(2000); // leave this for timing issue returning the impersonate row
		swiftPage.txt_searchId.type(nSwiftID); // enter the swift id
		swiftPage.searchBtn.click(); // click the search button
		waitABit(10000);
		myflag = false;
		myCounter = 0;
		pkgCounter = 0;
		String sholder = "";
		do {
			// try {
			if ((senarioDataPage.find(By.xpath("//*[@id='NoRecordsFoundMessage']")).getAttribute("style")).equals("")) {
				// sholder =
				// senarioDataPage.find(By.xpath("//*[@id='orderPackagesGrid']/div[2]/div[1]/div"))
				// .getTextValue();
				System.out.println("waiting 10 sec for first row showed going to check and push search again "); // write
																													// the
																													// swift
																													// first
																													// row
																													// to
																													// show
				// if (sholder.contains("No recods available.")) {
				swiftPage.searchBtn.click(); // click the search button
				System.out.println("Swift search button pushed again"); // write the swift search button pushed
				waitABit(10000);
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				myflag = false;
				myCounter = myCounter + 1;
				System.out.println("Record counter is " + myCounter);
				if (myCounter == 40) {
					System.out.println("FAILED no record showed up");
					getDriver().close();
					getDriver().quit();
					myflag = true;
				}
			} else {
				System.out.println("No records error not found");
				myflag = true;
			}
		} while (myflag != true);
		boolean status = false;
		int counter = 0;
		while (status == false && counter != 10) {
			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='taskTab']/div//table/tbody/tr[2]")));
				// WebElement firstEle=getDriver().findElement(By.xpath(""));
				getDriver().findElement(By.xpath("//div[@id='taskTab']/div//table/tbody/tr[2]")).isEnabled();
				status = true;
				System.out.println("Status of first gtask kicked off=" + status);
			} catch (TimeoutException e) {
				System.out.println("First task is not kicked off");
				getDriver().navigate().refresh(); // refresh the page
				waitABit(5000);
				counter++;
			}
		}
		String url1 = getDriver().getCurrentUrl();
		System.out.println("Current URL : " + url1);
		String sOpid = url1.toString();
		myOpid = url1.substring(30, 39);
		System.out.println("the Order package id is " + myOpid);
	}

	public Boolean waitForTDGSwiftProgressBar() {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForTDGSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				// waitABit(1000);
				try {
					WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
					wait.until(ExpectedConditions.invisibilityOfElementLocated(
							By.xpath("//*[@id='progressBarModal' and @class='modal in']")));
					System.out.println("All good");
					bflag = true;
				} catch (TimeoutException e) {
					System.out.println("Loading progress bar is dispayed");
					ncounter = ncounter + 1;
					waitABit(2000);
				}
			} while (bflag != true);
			System.out.println("out of try for  waitForTDGSwiftProgressBar");
			System.out.println("Loading progress bar  counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}
}