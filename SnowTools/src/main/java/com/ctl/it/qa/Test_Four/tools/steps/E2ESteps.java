package com.ctl.it.qa.Test_Four.tools.steps;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

//import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.IPVPNPortAccess;
import com.ctl.it.qa.Test_Four.tools.pages.common.LATAMPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

@SuppressWarnings("serial")
public abstract class E2ESteps extends Steps {
	private final Logger logger = LoggerFactory.getLogger(E2ESteps.class);
	ProductPage productPage;
	LATAMPage latamPage;
	IPVPNPortAccess ipvnportaccess;
	static String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	static String ANSI_RED_BACKGROUND = "\u001B[41m";
	static final String BLACK_UNDERLINED = "\033[4;30m";
	static String ANSI_RESET = "\u001B[0m";

	public static void printInGreenColor(String statementToBePrinted, String variable) {
		System.out.println(ANSI_GREEN_BACKGROUND + statementToBePrinted + variable + ANSI_RESET);
	}

	public static void softAssertError(String appName, Boolean condition, String expected, String Actual) {
		if (!condition) {
			System.out.println(ANSI_RED_BACKGROUND + "*******************Test Failure in " + appName
					+ "*******************--> Expected was... " + expected + " , But actual is.. " + Actual
					+ ANSI_RESET);
		} else {
			System.out.println(ANSI_GREEN_BACKGROUND + appName + "--> Both Expected & actual are same ..."
					+ "Expected : " + expected + " , Actual : " + Actual + ANSI_RESET);
		}
	}
//	 public static void printInColor(String statementToBePrinted, String variable) {
//		 if (!condition) { 
//			 System.out.println(ANSI_RED_BACKGROUND + "*******************Test Failure in " + variable + "*******************--> "+ ANSI_RESET);
//		 }else {
//			 System.out.println(ANSI_GREEN_BACKGROUND + statementToBePrinted + variable + ANSI_RESET);
//		 }
//	 }

	public Boolean WaitAndSync() {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  WaitAndSync");
			int ncounter;
			ncounter = 0;
			do {
				waitABit(2000);
				if (productPage.isElementVisible(By.xpath("//div[@class='lds-ellipsis']"))) {
					// if
					// (productPage.isElementVisible(By.xpath("//div[@class='k-loading-image']"))) {
					System.out.println("Loading circle is dispayed");
					ncounter = ncounter + 1;
					waitABit(2000);
				} else {
					System.out.println("All good");
					bflag = true;
				}
			} while (bflag != true);
			System.out.println("out of try for  WaitAndSync");
			System.out.println("Loading circle counter is " + ncounter);
			bflag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return bflag;
	}

	public void sendMailReport(String tasknum) throws MessagingException {
		String currentURL = getDriver().getCurrentUrl(); // get the current url of page in now
		String nSwiftID = System.getProperty("Swift.ID"); // get the swift id from memory
		String myEnv = System.getProperty("staf.environment.key");
		String myProductType = System.getProperty("myProduct.ID");
		logger.info("currentURL  is  " + currentURL); // // get the current url
		logger.info("the Env is : " + myEnv);
		waitABit(1000);
//			String to[] = {"Norman.Fulton@CenturyLink.com", "ericw.steele@centurylink.com","richard.allen@centurylink.com","Purnima.Muskula@lumen.com","Sapna.Hallikeri@lumen.com"};
//			SendMail.send("staf.sanity@centurylink.com", to, "Lightening Quote to Order - " + tasknum  + nSwiftID +" - "+ currentURL +" - "+" - "+ myEnv, "");
	}

	public void sendMailReport_beforeSwift(String tasknum) throws MessagingException {
		String currentURL = getDriver().getCurrentUrl(); // get the current url of page in now
		String SIDID = System.getProperty("SID.ID");
		System.out.println("Scenario ID is  " + SIDID); // end of getting order id
		String myEnv = System.getProperty("staf.environment.key");
		String myProductType = System.getProperty("myProduct.ID");
		System.out.println("the Env is : " + myEnv);
		waitABit(1000);
//		String to[] = { "Norman.Fulton@CenturyLink.com", "ericw.steele@centurylink.com",
//				"leslie.tancredo@centurylink.com", "madhumitha.ganesh@centurylink.com" };
//		SendMail.send("staf.sanity@centurylink.com", to, tasknum + "  " + SIDID + " - " + myEnv, "");
	}

	public void customClickableWait(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(500));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void customVisibleWaitism(WebElementFacade element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(150));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@Step
	public void singleLocationNextandDiscount() {
	//	JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		Boolean myflag;
	//	String sEVCType;
		String myProductType = System.getProperty("myProduct.ID");
		System.out.println("the product type in single location next and discount is : " + myProductType);
        //Discounting Buttons
		waitABit(2000);
		logger.info("above btn discounting----");
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(3000);
		for (int i = 0; i <= 4; i++) {
			String discountingButtonDisableStatus = productPage.button_discounting.getAttribute("aria-disabled");
			System.out.println("Discounting and Profitability disabled status--" + discountingButtonDisableStatus);
			if (discountingButtonDisableStatus.equals("true")) {
				waitABit(4000);
			} else {
				break;
			}
		}
		waitABit(1000);
		String status = productPage.statusOfPSP.getText();
		System.out.println("Status of PSP-" + status);
		int sizeOfElement = productPage.statusOfBid.size();
		System.out.println("sizeOfElement--" + sizeOfElement);
		if (status.equals("Profit Approval Pending")) {
			logger.info("Inside Profit Approval Pendig");
			if (sizeOfElement == 4) {
				System.out.println("Inside Size of else");
//				submitVendorBid();
//				submitROCfromROCApplication();
				System.out.println("Vendor Bid Required");
			}
		}
		productPage.btn_discounting.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(200)).click();
		try {
			if(status.equals("Auto Estimate Approval Required")) {
			logger.info("Inside of Auto Estimate Approval Required");
			productPage.closeBuildCosePopup.withTimeoutOf(Duration.ofSeconds(8)).click();
			}
			productPage.btn_discounting.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(100)).click();
			logger.info("Clicked on discounting button");
		} catch (Exception p) {
			System.out.println("caught the second attempt to click on discount button");
		}
		logger.info("Inside Discounting approval page");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for  Discounting Button");
			waitABit(2000);
		}
		logger.info("above the btn_discountingsave ");
		waitABit(2000);
		try {	
			productPage.btn_approve_pricing.withTimeoutOf(Duration.ofSeconds(8)).click();
			waitABit(6000);
		} catch (Exception p) {
			logger.info("appove pricing  button");
		}
		try {
			productPage.btn_discountingsave.withTimeoutOf(Duration.ofSeconds(100)).click();
		} catch (Exception p) {
			System.out.println("caught the second attempt to click on save button  button");
		}
		logger.info("discounting save button pressed ");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for  Discounting Save Button");
			waitABit(2000);
		}
	}

	public void set_HSIP_Service_single_location() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		Boolean myflag;
		myflag = false;
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String sBillType = System.getProperty("myBillType.ID");
		String brc = sBillType;
		System.out.println("the billtype  is  " + sBillType); // print out product type
		String LocID = System.getProperty("Loc.ID");
		System.out.println("Location  is  " + LocID); // end of getting order id
		String myEnv = System.getProperty("staf.environment.key");
		try {
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			executor.executeScript("arguments[0].click();", productPage.btn_quicksave); // quick save button
			// productPage.btn_quicksave.waitUntilClickable().click(); //quick save button
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for quick save");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			executor.executeScript("arguments[0].click();", productPage.btn_createpackage); // New Product
			// productPage.btn_createpackage.waitUntilClickable().click(); // New Product
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for new product 2");
			}
			if (LocID.equals("SL0002745723")) {
				// switch (LocID) {
				// case "SL0002745723":
				latamPage.cbox_mexico_location.waitUntilClickable().click(); // mexico checkbox
			} else if (LocID.equals("SL0000585028")) {
				// case "":
				latamPage.cbox_argentina_location.waitUntilClickable().click(); // argentina_location checkbox
			} else {
				// String myLoc=productPage.txt_first_Location_row.getText();
				String myLoc = getDriver()
						.findElement(By.xpath("//*[@id=\"LocationSearchGrid\"]/div[2]/table/tbody/tr[1]/td[3]"))
						.getText();
				if (myLoc.contains(LocID)) {
					productPage.ckb_first_location_hisp.waitUntilClickable().click(); // USA loctions Select Addresses
																						// US
				} else {
					productPage.ckb_second_location_hisp.waitUntilClickable().click();
				}
				// break;
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			executor.executeScript("arguments[0].click();", productPage.btn_next);
			// productPage.btn_next.waitUntilEnabled();
			// productPage.btn_next.waitUntilClickable().click(); // Next Button
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for next button");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd); // Select Product Dropdown
			// productPage.lst_productdd.waitUntilClickable().click();// Select Product
			// Dropdown
		} else {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd_e2e); // Select Product Dropdown
			// productPage.lst_productdd_e2e.waitUntilClickable().click();// Select Product
			// Dropdown
		}
		waitABit(2000);
		executor.executeScript("arguments[0].click();", productPage.lst_hisp_service); // Select HSIP Service
		// productPage.lst_hisp_service.waitUntilClickable().click(); // Select HSIP
		// Service
		waitABit(2000);
		executor.executeScript("arguments[0].click();", productPage.btn_newproduct); // New Product
		// productPage.btn_newproduct.waitUntilClickable().click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product 2");
		}
//	executor.executeScript("arguments[0].click();",productPage.lst_addressdd);   // Select address Dropdown
//	//productPage.lst_addressdd.waitUntilClickable().click();// Select address Dropdown
//	waitABit(1000);
//	getDriver().switchTo().activeElement().sendKeys(LocID, Keys.ENTER); 
//	myflag = WaitAndSync();
//	if (myflag) {
//		 System.out.println("error in WaitAndSync for Select address");
//	}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		if (sProductType.equals("HSIP Wavelength")) {
			String rc = productPage.lst_port.getText();
			if (rc.equalsIgnoreCase("- Select -")) {
				productPage.lst_port.click();
				waitABit(3000);
				productPage.rdo_relPort_radio.click();
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Select address");
				}
			}
			try {
				productPage.lst_tranport.click(); // open up band width
				getDriver().switchTo().activeElement().sendKeys("10", Keys.ENTER);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Select address");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			productPage.lst_billing_type_dd.waitUntilClickable().click(); // open the billing option
			waitABit(1000);
			if (brc.equals(sBillType)) {
				getDriver().switchTo().activeElement().sendKeys(sBillType, Keys.ENTER);
			} else {
				productPage.lst_billing_type.waitUntilPresent().waitUntilEnabled().waitUntilClickable().click(); // pick
																													// flat
																													// out
																													// of
																													// drop
																													// down
			}
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for pick flat out of drop down");
			}
			if (sBillType.equals("Billing Arrangement")) {
				String rc1 = productPage.lst_bill_arrangement.getText();
				if (rc1.equalsIgnoreCase("- Select -")) {
					productPage.lst_bill_arrangement.waitUntilClickable().click();
					waitABit(3000);
					productPage.rdo_relBilling_Arrangement_radio.click();
					myflag = WaitAndSync();
					if (myflag) {
						System.out.println("error in WaitAndSync for Select address");
					}
				}
			}
		}
		if (sProductType.equals("HSIP Ethernet Private Line")) {
			String rc = productPage.lst_port.getText();
			if (rc.equalsIgnoreCase("- Select -")) {
				productPage.lst_port.click();
				waitABit(3000);
				productPage.rdo_relPort_radio.click();
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Select address");
				}
			}
//		try {
//			productPage.lst_tranport.click(); // open up band width
//			getDriver().switchTo().activeElement().sendKeys("10", Keys.ENTER); 
//			myflag = WaitAndSync();
//			if (myflag) {
//				 System.out.println("error in WaitAndSync for Select address");
//			}
//		}catch(Exception e) {
//			  System.out.println(e);
//		 }
			// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			productPage.lst_elan_bandwidth.waitUntilClickable().click(); // open the billing option
			productPage.waitForTextToAppear("Billing Arrangement", 20000); // Wait for Upload;
			getDriver().switchTo().activeElement().sendKeys("Flat", Keys.ENTER);// pick Center for Shared Services -
																				// Ashburn
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for  send key center");
			}
			// getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			productPage.lst_loc_A_waveLength_dd.waitUntilClickable().click();// Select A location Drop down
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
//		 	executor.executeScript("arguments[0].click();",productPage.lst_aLoc);  // Select Building Extension Drop down for A
//		 	waitABit(3000);
//			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
//			myflag = WaitAndSync();
//			if (myflag) {
//				System.out.println("error in WaitAndSync for standard deliver");
//			}
		}
		if (sProductType.equals("HSIP Cross Connect")) {
			String rc = productPage.lst_port.getText();
			if (rc.equalsIgnoreCase("- Select -")) {
				productPage.lst_port.click();
				waitABit(3000);
				productPage.rdo_relPort_radio.click();
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Select address");
				}
				waitABit(2000);
				productPage.lst_billing_type_dd.waitUntilClickable().click(); // open the billing option
				productPage.waitForTextToAppear("Billing Arrangement", 20000); // Wait for Upload;
				getDriver().switchTo().activeElement().sendKeys(sBillType, Keys.ENTER);// pick Center for Shared
																						// Services - Ashburn
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for  send key center");
				}
			}
		}
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		//getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		//getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		//getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		executor.executeScript("arguments[0].scrollIntoView(true);", productPage.lst_billing_type_dd);
//		productPage.lst_billing_type_dd.waitUntilClickable().click(); // open the billing option 
//		productPage.waitForTextToAppear("Billing Arrangement", 20000); // Wait for Upload;
//		getDriver().switchTo().activeElement().sendKeys("Flat", Keys.ENTER);// pick Center for Shared Services - Ashburn
//		myflag = WaitAndSync();
//		if (myflag) {
//			 System.out.println("error in WaitAndSync for  send key center");
		// }
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(1000);
	}

	public void set_HSIP_Billing_single_location() {
		Boolean myflag;
		myflag = false;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String sBillType = System.getProperty("myBillType.ID");
		System.out.println("the billiing type  is  " + sBillType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
		String LocID = System.getProperty("Loc.ID");
		System.out.println("Location  is  " + LocID); // end of getting order id
		try {
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			executor.executeScript("arguments[0].click();", productPage.btn_quicksave); // quick save button
			// productPage.btn_quicksave.waitUntilClickable().click(); //quick save button
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for quick save");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			executor.executeScript("arguments[0].click();", productPage.btn_createpackage); // New Product
			// productPage.btn_createpackage.waitUntilClickable().click(); // New Product
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for new product 2");
			}
			// switch (LocID) {
			if (LocID.equals("SL0002745723")) {
				// case "SL0002745723":
				latamPage.cbox_mexico_location.waitUntilClickable().click(); // mexico checkbox
				// break;
			} else if (LocID.equals("SL0000585028")) {
				// case "SL0000585028":
				latamPage.cbox_argentina_location.waitUntilClickable().click(); // argentina_location checkbox
				// break;
			}
			// default:
			else {
				// String myLoc=productPage.txt_first_Location_row.getText();
				String myLoc = getDriver()
						.findElement(By.xpath("//*[@id=\"LocationSearchGrid\"]/div[2]/table/tbody/tr[1]/td[3]"))
						.getText();
				if (myLoc.contains(LocID)) {
					productPage.ckb_first_location_hisp.waitUntilClickable().click(); // USA loctions Select Addresses
																						// US
				} else {
					productPage.ckb_second_location_hisp.waitUntilClickable().click();
				}
				// break;
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			executor.executeScript("arguments[0].click();", productPage.btn_next);
			// productPage.btn_next.waitUntilEnabled();
			// productPage.btn_next.waitUntilClickable().click(); // Next Button
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for next button");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd); // Select Product Dropdown
			// productPage.lst_productdd.waitUntilClickable().click();// Select Product
			// Dropdown
		} else {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd_e2e); // Select Product Dropdown
			// productPage.lst_productdd_e2e.waitUntilClickable().click();// Select Product
			// Dropdown
		}
		waitABit(2000);
		executor.executeScript("arguments[0].click();", productPage.lst_hisp_service); // Select HSIP Service
		// productPage.lst_hisp_service.waitUntilClickable().click(); // Select HSIP
		// Service
		waitABit(2000);
		executor.executeScript("arguments[0].click();", productPage.btn_newproduct); // New Product
		// productPage.btn_newproduct.waitUntilClickable().click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product 2");
		}
//		productPage.lst_hisp_billing_arrangement_name.typeAndEnter("Automation"); // New Product 
//		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
//		waitABit(1000);
		productPage.lst_billing_type_dd.waitUntilClickable().click(); // open the billing option
		productPage.waitForTextToAppear("Billing Arrangement", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("Flat", Keys.ENTER);// pick Center for Shared Services - Ashburn
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for  send key center");
		}
	}

	public void setManageRouter() {
		Boolean myflag;
		myflag = false;
		String myrouter = "Managed Router";
		Long tempNum = Math.round(Math.random() * 100000);
		String mySPCRID = String.valueOf(tempNum);
		waitABit(3000);
		WebElement continue_element = getDriver().findElement(By.id("btnAttribContinue"));
		waitABit(3000);
		// ipvnportaccess.btn_continue.waitUntilEnabled().waitUntilClickable().click();
		continue_element.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		ipvnportaccess.ddl_addotherproducts.waitUntilClickable().click();
		ipvnportaccess.waitForTextToAppear("Managed IAD", 2000); // Wait for Upload
		waitABit(1000);
		ipvnportaccess.ddl_addotherproducts.selectByVisibleText(myrouter);
		ipvnportaccess.btn_add.waitUntilClickable().click(); // click on add new button
		waitABit(1000);
		ipvnportaccess.ddl_manufacturer.selectByVisibleText("Cisco"); // pick a router
		waitABit(1000);
		// ipvnportaccess.ddl_chassis.selectByVisibleText("CASR 920"); // pick chassis
		ipvnportaccess.ddl_chassis.selectByIndex(1);
		waitABit(1000);
		ipvnportaccess.btn_dialogsave.waitUntilClickable().click(); // click the save button
		waitABit(5000);
//	 try {
//		 ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click();  //Specific Design Requirements/Diversity
//	 }catch(Exception e) {
//		 ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click();  //Specific Design Requirements/Diversity
//	 }
//	 
//	 waitABit(1000);
//	 ipvnportaccess.txt_spcrid.type(mySPCRID); // add a number in spcrid field
//	 ipvnportaccess.btn_continue.waitUntilClickable().click(); // click the continue button
//	 
//	waitABit(4000);
		WebElement continue_element1 = getDriver().findElement(By.id("btnAttribContinue"));
		continue_element1.click();
		waitABit(4000);
	}

	public void setIPVPN_Internet() {
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		ipvnportaccess.ddl_multiserviceselection.waitUntilClickable();
		jse.executeScript("arguments[0].click()", ipvnportaccess.ddl_multiserviceselection);
		// ipvnportaccess.ddl_multiserviceselection.click();
		if (sProductType.equals("IP VPN Port and Access_Internet_Agg")) {
			ipvnportaccess.ddl_multiserviceselection.selectByVisibleText("Aggregate");
		}
		waitABit(5000);
		WebElement continue_element = getDriver().findElement(By.id("btnAttribContinue"));
		continue_element.click();
		// executor.executeScript("arguments[0].click();",continue_element);
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		ipvnportaccess.btn_InternetServices.waitUntilClickable(); // click on internet
		jse.executeScript("arguments[0].click()", ipvnportaccess.btn_InternetServices);
		// ipvnportaccess.btn_InternetServices.click(); //click on internet
		ipvnportaccess.btn_btnGridAddNew.waitUntilClickable(); // click on new internet over VPN
		ipvnportaccess.btn_btnGridAddNew.click(); // click on internet over new VPN
		ipvnportaccess.btn_dialogsave.waitUntilClickable(); // click the save button
		ipvnportaccess.btn_dialogsave.click(); // click the save button
		waitABit(5000);
//	 try {
//		 ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click();  //Specific Design Requirements/Diversity
//	 }catch(Exception e) {
//		 ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click();  //Specific Design Requirements/Diversity
//	 }
//	 
//	 waitABit(1000);
//	 ipvnportaccess.txt_spcrid.type(mySPCRID); // add a number in spcrid field
//	 ipvnportaccess.btn_continue.waitUntilClickable().click(); // click the continue button
//	 
//	waitABit(4000);
		WebElement continue_element1 = getDriver().findElement(By.id("btnAttribContinue"));
		continue_element1.click();
		waitABit(4000);
	}

	public void setManaged_IAD() {
		String myrouter = "Managed IAD";
		Long tempNum = Math.round(Math.random() * 100000);
		String mySPCRID = String.valueOf(tempNum);
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		WebElement continue_element = getDriver().findElement(By.id("btnAttribContinue"));
		waitABit(3000);
		// ipvnportaccess.btn_continue.waitUntilEnabled().waitUntilClickable().click();
		continue_element.click();
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		ipvnportaccess.ddl_addotherproducts.waitUntilClickable().click();
		waitABit(1000);
		ipvnportaccess.waitForTextToAppear("Managed IAD", 2000); // Wait for Upload
		waitABit(1000);
		ipvnportaccess.ddl_addotherproducts.selectByVisibleText(myrouter);
		waitABit(1000);
		ipvnportaccess.btn_add.waitUntilClickable().click(); // click on add new button
		waitABit(1000);
		ipvnportaccess.ddl_manufacturer.selectByVisibleText("Custom"); // pick a router
		waitABit(1000);
		ipvnportaccess.txt_customkitname.type("myCustomKit"); // pick chassis
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		ipvnportaccess.btn_dialogsave.waitUntilClickable().click(); // click the save button
		waitABit(5000);
		try {
			ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click(); // Specific Design Requirements/Diversity
		} catch (Exception e) {
			ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click(); // Specific Design Requirements/Diversity
		}
		waitABit(1000);
		ipvnportaccess.txt_spcrid.type(mySPCRID); // add a number in spcrid field
		// ipvnportaccess.btn_continue.waitUntilClickable().click(); // click the
		// continue button
		waitABit(4000);
		WebElement continue_element1 = getDriver().findElement(By.id("btnAttribContinue"));
		continue_element1.click();
		waitABit(4000);
	}

	public void set_Onsite_Support_Services() {
		String myrouter = "Onsite Support Services (OSS)";
		Long tempNum = Math.round(Math.random() * 100000);
		String mySPCRID = String.valueOf(tempNum);
		WebElement continue_element = getDriver().findElement(By.id("btnAttribContinue"));
		waitABit(3000);
		// ipvnportaccess.btn_continue.waitUntilEnabled().waitUntilClickable().click();
		continue_element.click();
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		ipvnportaccess.ddl_addotherproducts.waitUntilClickable().click();
		ipvnportaccess.waitForTextToAppear("Managed IAD", 2000); // Wait for Upload
		waitABit(1000);
		ipvnportaccess.ddl_addotherproducts.selectByVisibleText(myrouter);
		ipvnportaccess.btn_add.waitUntilClickable().click(); // click on add new button
		waitABit(1000);
		ipvnportaccess.ddl_manufacturer.selectByVisibleText("Cisco"); // pick a router
		waitABit(1000);
		// ipvnportaccess.ddl_chassis.selectByVisibleText("CASR 920"); // pick chassis
		ipvnportaccess.ddl_chassis.selectByIndex(1);
		waitABit(1000);
		ipvnportaccess.btn_dialogsave.waitUntilClickable().click(); // click the save button
		waitABit(5000);
		WebElement continue_element1 = getDriver().findElement(By.id("btnAttribContinue"));
		continue_element1.click();
		waitABit(4000);
	}

	public void set_Telecom_Service_Priority() {
		String myrouter = "Telecom Service Priority (TSP)";
//	 Long tempNum=Math.round(Math.random()*100000);
//	 String mySPCRID=String.valueOf(tempNum);
		WebElement continue_element = getDriver().findElement(By.id("btnAttribContinue"));
		waitABit(3000);
		// ipvnportaccess.btn_continue.waitUntilEnabled().waitUntilClickable().click();
		continue_element.click();
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		waitABit(1000);
		ipvnportaccess.ddl_addotherproducts.waitUntilClickable().click();
		waitABit(1000);
		ipvnportaccess.waitForTextToAppear("Managed IAD", 2000); // Wait for Upload
		waitABit(1000);
		ipvnportaccess.ddl_addotherproducts.selectByVisibleText(myrouter);
		waitABit(1000);
		ipvnportaccess.btn_add.waitUntilClickable().click(); // click on add new button
		waitABit(5000);
//	 try {
//		 ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click();  //Specific Design Requirements/Diversity
//	 }catch(Exception e) {
//		 ipvnportaccess.lnk_sdrdiversity.waitUntilClickable().click();  //Specific Design Requirements/Diversity
//	 }
//	 waitABit(1000);
//	 ipvnportaccess.txt_spcrid.type(mySPCRID); // add a number in spcrid field
//	 ipvnportaccess.btn_continue.waitUntilClickable().click(); // click the continue button
		WebElement continue_element1 = getDriver().findElement(By.id("btnAttribContinue"));
		continue_element1.click();
		waitABit(4000);
	}

	public void set_Diversity() {
		waitABit(1000);
		for (int i = 0; i < 3; i++) {
			WebElement continue_element = getDriver().findElement(By.id("btnAttribContinue")); // click on continue
																								// button
			waitABit(3000);
			continue_element.click();
			waitABit(4000);
		}
		WebElement change_element = getDriver().findElement(By.id("changeLabel-SDRDiversity")); // click on the change
																								// link
		waitABit(3000);
		change_element.click();
		waitABit(4000);
		WebElement access_diversity_element1 = getDriver().findElement(By.id("DLR")); // click on the change link
		waitABit(3000);
		access_diversity_element1.click();
		waitABit(4000);
		getDriver().switchTo().activeElement().sendKeys("Yes", Keys.ENTER);
		waitABit(1000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(100);
	}

	public void addNewProduct() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("The product  is  " + sProductType); // print out product type
		String myEnv = (System.getProperty("staf.environment.key")).toUpperCase();
		System.out.println(myEnv + "Environment name");
		boolean myflag;
		myflag = WaitAndSync();
		logger.info("Navigated to Product Selection Page");
		if (myflag) {
			System.out.println("error in WaitAndSync for next button");
		}
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			executor.executeScript("arguments[0].scrollIntoView(true);", productPage.lst_productdd);
			waitABit(1000);
			executor.executeScript("arguments[0].click();", productPage.productGroup); // Select Product Dropdown
			logger.info("Clicked on the Product Selection dropdown");
			// productPage.lst_productdd.click();// Select Product Dropdown
		} else {
			executor.executeScript("arguments[0].scrollIntoView(true);", productPage.lst_productdd);
			waitABit(2000);
			executor.executeScript("arguments[0].click();", productPage.lst_productdd_e2e); // Select Product Dropdown
			logger.info("Clicked on the Product Selection dropdown");
			// productPage.lst_productdd_e2e.click();// Select Product Dropdown
		}
		waitABit(2000);
		productPage.waitForTextToAppear("Adaptive Network Security - Site", 20000); // Wait for Upload;
		// switch (sProductType) {
		if (sProductType.equals("Dedicated Internet Access")) {
			// case "Dedicated Internet Access":
			executor.executeScript("arguments[0].click();", productPage.lst_productdd_DIA);
			// break;
		} else if (sProductType.equals("eLync Interface")) {
			// case "eLync Interface":
			executor.executeScript("arguments[0].click();", productPage.lst_elynk_interface); // Select the product out
																								// of list box using
																								// smyproject
			// break;
		} else if (sProductType.equals("E-NNI")) {
			// case "E-NNI":
			executor.executeScript("arguments[0].click();", productPage.lst_e_nni_pick); // Select the product out of
																							// list box using smyproject
			// break;
		} else if (sProductType.equals("Private Line")) {
			// case "Private Line":
			executor.executeScript("arguments[0].click();", productPage.lst_private_line); // Select the product out of
																							// list box using smyproject
			// break;
		} else if (sProductType.equals("Ethernet Private Line")) {
			// case "Ethernet Private Line":
			executor.executeScript("arguments[0].click();", productPage.lst_ethernet_private_line); // Select the
																									// product out of
																									// list box using
																									// smyproject
			// break;
		} else if (sProductType.equals("HSIP Ethernet Private Line")) {
			// case "HSIP Ethernet Private Line":
			executor.executeScript("arguments[0].click();", productPage.lst_hsip_ethernet_private_line); // Select the
																											// product
																											// out of
																											// list box
																											// using
																											// smyproject
			// break;
		}
		// case "HSIP Cross Connect":
		else if (sProductType.equals("HSIP Cross Connect")) {
			getDriver().switchTo().activeElement().sendKeys("HSIP Cross Connect ", Keys.ENTER);
			// Select the product out of list box using smyproject
			// break;
		} else {
			// default:
			getDriver().switchTo().activeElement().sendKeys(sProductType, Keys.ENTER);
			logger.info("Selected the " + sProductType + " from dropdown");
		}
		// productPage.btn_newproduct.click(); // New Product
		executor.executeScript("arguments[0].click();", productPage.btn_newproduct); // New Product
		logger.info("Clicked on the Add new product button");
		WaitAndSync();
		waitABit(4000);
		E2ESteps.printInGreenColor("Product type picked ", "Product type  is  " + sProductType);
	}

	public void set_CableType(String cable_type) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", productPage.lst__encryption_wl); // open cable type list box
		productPage.waitForTextToAppear("Cat5e", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(cable_type, Keys.ENTER);
	}

	public Boolean WaitAndSync1() {
		Boolean bflag;
		bflag = false;
		try {
			System.out.println("in try for  waitForSwiftProgressBar");
			int ncounter;
			ncounter = 0;
			do {
				// waitABit(1000);
				try {
					WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
					wait.until(
							ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='lds-ellipsis']")));
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

	@Step
	public void submitVendorBid() {
		
		productPage.vendorBidManagement.click();
		waitABit(5000);
		productPage.waitForTextToAppear("ROC ID", 90000);
		waitABit(10000);
		//productPage.waitForTextToAppear("Vendor Bid Required", 90000);
		productPage.getDriver().findElement(By.xpath("//*[@class='mat-table cdk-table']/tbody/tr")).isDisplayed();
		Actions a1 = new Actions(getDriver());
		a1.moveToElement(productPage.vendorBidCheckbox).click().build().perform();
		// productPage.vendorBidCheckbox.click();
		waitABit(2000);
		
		productPage.submitBidButton.click();

		waitABit(20000);
	
		
	}

	@Step
	public void submitROCfromROCApplication() {
		
		String username =envData.getContainer("LoginPage").getContainer("Valid").getFieldValue("tbx_uname");
		String password = envData.getContainer("LoginPage").getContainer("Valid").getFieldValue("tbx_password");	
		
		String rocId = productPage.rocId.getText();
		System.out.println("ROC Id-" + rocId);
		String rocUrl = envData.getFieldValue("rocUrl");
		String productPageUrl = getDriver().getCurrentUrl();
		getDriver().navigate().to(rocUrl);
		logger.info("Successfully open ROC application");
		productPage.username.sendKeys(username);
		productPage.password.sendKeys(password);
		waitABit(1500);
		productPage.submit.click();
		logger.info("Successfully logged into ROC application");
		// getDriver().navigate().to(rocUrl);
		waitABit(2000);
		productPage.waitForTextToAppear("Requests for Off-Net Cost", 90);
		productPage.searchROC.sendKeys(rocId);
		waitABit(1000);
		logger.info("Successfully searched ROC ID");
		productPage.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(10000);
		for (String winHandle : getDriver().getWindowHandles()) {
			String windowTitle = getDriver().switchTo().window(winHandle).getTitle();
			logger.info("Title =" + windowTitle);
			if (windowTitle.contains("Request - ")) {
				getDriver().switchTo().window(winHandle);
				logger.info("Switched to request Window");
				break;
			}
		}
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		waitABit(2000);
		productPage.assignToMe.click();
		waitABit(2000);
		productPage.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1000);
		productPage.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		logger.info("Successfully bid assigned");
		waitABit(4000);
		executor.executeScript("arguments[0].scrollIntoView();", productPage.createNewBidButton);
		waitABit(2000);
		productPage.createNewBidButton.click();
		logger.info("Successfully clicked on Create New Bid");
		waitABit(5000);
		productPage.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		waitABit(1000);
		productPage.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		waitABit(5000);
		Select s1 = new Select(productPage.vendorName);
		s1.selectByVisibleText("COMCAST");
		logger.info("Successfully slected the vendorName");
		waitABit(2000);
		productPage.accessPop.sendKeys("BNNTCOAP");
		logger.info("Successfully slected the Access POP");
		waitABit(2000);
		executor.executeScript("arguments[0].scrollIntoView();", productPage.mrc);
		waitABit(2000);
		List<WebElement> allBidTerm= getDriver().findElements(By.xpath("(//*[@id='newBidTermTable'])[2]/tbody/tr/th/ngcontainer/i"));
		for(int i=0;i<allBidTerm.size()-1;i++)
		{
			String checkEnabled=allBidTerm.get(i).getAttribute("class");
			logger.info("check enabled-"+checkEnabled+"S");
			if(checkEnabled.equals("fa green fa-2x toggle-format fa-toggle-on")&&(i!=2))
			{
				allBidTerm.get(i).click();
				logger.info("Inside If");
			}
			else if(i==2 && !checkEnabled.equals("fa green fa-2x toggle-format fa-toggle-on") )
			{
				allBidTerm.get(i).click();
				logger.info("Inside else If");
			}
			
		}
		
		//productPage.recommended.click();
		waitABit(2000);
		executor.executeScript("arguments[0].scrollIntoView();", productPage.mrc);
		productPage.mrc.clear();		
		productPage.mrc.sendKeys("100");
		logger.info("Successfully entered the MRC Value");
		productPage.nrc.clear();
		productPage.nrc.sendKeys("100");
		logger.info("Successfully entered the NRC Value");
		waitABit(2000);
		executor.executeScript("arguments[0].scrollIntoView();", productPage.saveVendorBid);		
		productPage.saveVendorBid.click();
		waitABit(5000);
        logger.info("Successfully saved the vendor bid");
		executor.executeScript("arguments[0].scrollIntoView();", productPage.recommended);
		executor.executeScript("arguments[0].click();", productPage.recommended);
		 logger.info("Successfully clicked on recommended");
		executor.executeScript("arguments[0].scrollIntoView();", productPage.notes);
		productPage.notes.sendKeys("Test");
		logger.info("Successfully added notes in vendor bid");
		waitABit(5000);		
		executor.executeScript("arguments[0].scrollIntoView();", productPage.closedBid);
		waitABit(1000);
		productPage.closedBid.click();
		logger.info("Successfully closed the vendor bid");
		waitABit(5000);
		productPage.saveReq.click();
		logger.info("Successfully saved the closed bid");
		waitABit(5000);
		productPage.checkStatusOfBid.getText();
		logger.info("Successfully get the status of vendor bid");
		waitABit(5000);
		getDriver().navigate().to(productPageUrl);
	}
}
