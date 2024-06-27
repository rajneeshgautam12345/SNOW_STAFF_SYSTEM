package com.ctl.it.qa.Test_Four.tools.steps.Locations;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class CreateLocationSteps extends E2ESteps {
//	private static final String Boolen = null;
	private final Logger logger = LoggerFactory.getLogger(CreateLocationSteps.class);
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;
	public static String network_Status;

	public void create_first_location(String faddress, String fcity, String fstate) {
		// Boolean myflag;
		logger.info("Successfully navigated to location page");
		productPage.waitForTextToAppear("Select one or more sites from the left", 60000);
		getDriver().switchTo().defaultContent();
		logger.info("Successfully switched to parent window");
		getDriver().switchTo().frame(0);
		logger.info("Successfully switched to first frame");
		getDriver().switchTo().frame("quote-iframe");
		logger.info("Successfully switched to quote- iframe");
		// waitABit(1000);
		// productPage.moveTo("#create-package-button");
		// getDriver().findElement(By.cssSelector("#create-package-button")).sendKeys(Keys.ENTER);
//		productPage.waitForTextToAppear("Location Management");
		productPage.waitForTextToAppear("Select one or more sites from the left", 60000);
		productPage.txt_address.type(faddress); // Wait for Address box and type
		waitABit(4000);
		//productPage.addressElement.waitUntilClickable().withTimeoutOf(Duration.ofSeconds(8));
		//productPage.addressElement.withTimeoutOf(Duration.ofSeconds(10)).click();
		//waitABit(1000);
		// productPage.waitForTextToAppear("1025 ELDORADO BLVD", 10000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN); // pick the first address
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // pick the first address
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // pick the first address
		waitABit(2000);
		logger.info("Successfully added the Address");
		E2ESteps.printInGreenColor("Out of Location 1 ", "Locations   is  " + faddress);
	}

//	public void create_third_location(String trdaddress, String trdcity, String trdstate) {
//		Boolean myflag;
//		waitABit(3000);
//		productPage.txt_address.type(trdaddress); // Wait for Address box and type
//		productPage.txt_city.type(trdcity); // Wait for city box and type
//		productPage.lst_state.selectByVisibleText(trdstate); // Wait for state box and type
//		E2ESteps.printInGreenColor("Out of Location 3 ", "Locations   is  " + trdaddress);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//	}
//
//	@Step
//	public void user_adds_three_elan_valid_locations(String faddress, String fcity, String fstate, String fplcode,
//			String secaddress, String seccity, String secstate, String secplcode, String trdaddress, String trdcity,
//			String trdstate, String trdplcode) {
//		Boolean myflag;
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		String myEnv = System.getProperty("staf.environment.key");
//		create_first_location(faddress, fcity, fstate); // create the first location
//		getDriver().findElement(By.id(fplcode)).click(); // find the check box
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.btn_next); // Next Button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//		System.setProperty("myProduct.ID", "E-LAN - EVC"); // set the product into memory
//		String sProductType = System.getProperty("myProduct.ID");// get the product from memory
//		System.out.println("the product  is  " + sProductType); // print out product type
//		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
//			executor.executeScript("arguments[0].click();", productPage.lst_evcproductdd); // Select Product Dropdownn
//			// productPage.lst_evcproductdd.click();// Select Product Dropdown
//		} else {
//			executor.executeScript("arguments[0].click();", productPage.lst_productdd_e2e); // Select Product Dropdownn
//			// productPage.lst_productdd_e2e.click();// Select Product Dropdown
//		}
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys("E-LAN - EVC", Keys.ARROW_DOWN, Keys.ENTER);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for  select Select E-LAN - EVC");
//		}
//		executor.executeScript("arguments[0].click();", productPage.btn_newproduct);// New Product
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for new product 2");
//		}
//		executor.executeScript("arguments[0].click();", productPage.lst_uniportbandwidth);// Select EVP-LAN
//		// productPage.lst_uniportbandwidth.click(); // Select EVP-LAN
//		getDriver().switchTo().activeElement().sendKeys("EVP-LAN", Keys.ENTER);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for EVP_Lan");
//		}
//		executor.executeScript("arguments[0].click();", productPage.lst_classdd); // Select Basic
//		// productPage.lst_classdd.click(); // Select Basic
//		getDriver().switchTo().activeElement().sendKeys("Basic", Keys.ENTER);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for Basic");
//		}
//		executor.executeScript("arguments[0].click();", productPage.lst_unitypedd); // Select UNI Btype
//		// productPage.lst_unitypedd.click(); // Select UNI Btype
//		getDriver().switchTo().activeElement().sendKeys("Transparent", Keys.ENTER);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for Transparent");
//		}
//		executor.executeScript("arguments[0].click();", productPage.btn_quicksave); // quick save button
//		// productPage.btn_quicksave.click(); //quick save button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for quick save");
//		}
//		executor.executeScript("arguments[0].click();", productPage.btn_createpackage); // new button
//		// productPage.btn_createpackage.click(); // new button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//		create_second_location(secaddress, seccity, secstate); // fill out second location
//		getDriver().findElement(By.id(secplcode)).click();
//		waitABit(1000); // check the first elan address
//		executor.executeScript("arguments[0].click();", productPage.btn_reset); // Reset Address form
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in myflag = WaitAndSync() for next button");
//		}
//		create_third_location(trdaddress, trdcity, trdstate); // create the third location
//		executor.executeScript("arguments[0].click();", productPage.btn_search); // Wait for Search Button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//		getDriver().findElement(By.id(trdplcode)).click();
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.btn_next); // Next Button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//	}
//
//	@Step
//	public void user_adds_two_valid_locations(String faddress, String fcity, String fstate, String fplcode,
//			String secaddress, String seccity, String secstate, String secplcode) {
//		Boolean myflag;
//		// JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		System.setProperty("Loc.ID", faddress);
//		String LocID = System.getProperty("Loc.ID");
//		System.out.println("Location  is  " + LocID); // end of getting order id
//		System.setProperty("Loc_2.ID", secaddress);
//		String LocID_2 = System.getProperty("Loc_2.ID");
//		System.out.println("Location  is  " + LocID_2); // end of getting order id
//		create_first_location(faddress, fcity, fstate);// create the first location
//		waitABit(3000);
////		executor.executeScript("arguments[0].click();", productPage.lst_first_location); // Bring up the location pop up
////		productPage.waitForTextToAppear("Floor", 20000);
////		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
////		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
////		waitABit(1000);
////		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
////		// productPage.lst_first_location.withTimeoutOf(60,
////		// TimeUnit.SECONDS).waitUntilPresent().click();
////		waitABit(3000);
////		executor.executeScript("arguments[0].click();", productPage.btn_reset); // press the reset button
////		// productPage.btn_reset.click(); // Reset Address form
////		waitABit(1000);
////		create_second_location(secaddress, seccity, secstate); // add the second location
////		waitABit(1000);
////		// productPage.img_first_location_icon.click(); // click on the location first
////		// icon to add location
////		// waitABit(10000);
////		executor.executeScript("arguments[0].click();", productPage.lst_first_location); // Bring up the location pop up
////		productPage.waitForTextToAppear("Floor", 20000);
////		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
////		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
////		waitABit(1000);
////		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
////		// productPage.lst_secondfloor_location.withTimeoutOf(60,
////		// TimeUnit.SECONDS).waitUntilPresent().click();
////		waitABit(1000);
////		// productPage.btn_next.click();
////		executor.executeScript("arguments[0].click();", productPage.btn_next);// Next Button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//		E2ESteps.printInGreenColor("Out of Location ", "Locations   is  " + faddress + " and " + secaddress);
//	}
//
//	@Step
//	public void user_adds_two_valid_locations_using_Cilli(String fcilli, String fplcode, String seccilli,
//			String secplcode) {
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		Boolean myflag;
//		WebElement element = null;
//		System.setProperty("Loc.ID", fcilli);
//		String LocID = System.getProperty("Loc.ID");
//		System.out.println("Location  is  " + LocID); // end of getting order id
//		System.setProperty("Loc_2.ID", seccilli);
//		String LocID_2 = System.getProperty("Loc_2.ID");
//		System.out.println("Location  is  " + LocID_2); // end of getting order id
//		productPage.WaitForPageToLoad(30);
//		// WebDriverWait wait = new WebDriverWait(getDriver(), 3000); // New Product
//		// Button
//		// wait.until(ExpectedConditions.elementToBeClickable(By.id("create-package-button")));
//		// executor.executeScript("arguments[0].click();",
//		// productPage.btn_createpackage); // create package
//		// productPage.btn_createpackage.withTimeoutOf(60,
//		// TimeUnit.SECONDS).waitUntilPresent().click();
//		waitABit(3000);
//		productPage.txt_address.click();
//		productPage.txt_address.type(fcilli); // Wait for Address box and type
//		productPage.waitForTextToAppear(fcilli, 30000); // Wait for Upload;
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in myflag = WaitAndSync() for next button");
//		}
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.img_first_location_icon); // click on the location
//																								// first icon to add
//																								// location
//		waitABit(3000);
//		// productPage.img_first_location_icon.click(); // click on the location first
//		// icon to add location
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(100);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		// productPage.lst_first_location.withTimeoutOf(60,
//		// TimeUnit.SECONDS).waitUntilPresent().click();
//		waitABit(3000);
//		// executor.executeScript("arguments[0].click();", productPage.btn_reset);//
//		// Reset Address form
//		// productPage.btn_reset.click(); // Reset Address form
//		waitABit(1000);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in myflag = WaitAndSync() for next button");
//		}
//		productPage.btn_glm.waitUntilClickable().click();
//		element = getDriver().findElement(By.id("glmCodeInput_value"));
//		element.click();
//		productPage.txt_GLM.type(seccilli); // Wait for Address box and type
//		// productPage.txt_address.type(seccilli); // Wait for Address box and type
//		productPage.waitForTextToAppear(seccilli, 20000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in myflag = WaitAndSync() for next button");
//		}
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.img_first_location_icon); // Bring up the location
//																								// pop up
//		productPage.waitForTextToAppear("Floor", 20000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(100);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		executor.executeScript("arguments[0].click();", productPage.btn_next); // Next Button
//		// productPage.btn_next.click(); // Next Button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//		E2ESteps.printInGreenColor("Out of Location with Cilli", "Locations cilli are  " + fcilli + " and " + seccilli);
//	}
//
//	@Step
//	public void user_adds_two_locations_using_Cilli_with_Country(String fcilli, String fcountry, String seccilli,
//			String seccountry) {
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		Boolean myflag;
//		System.setProperty("Loc.ID", fcilli);
//		String LocID = System.getProperty("Loc.ID");
//		System.out.println("Location  is  " + LocID); // end of getting order id
//		System.setProperty("Loc_2.ID", seccilli);
//		String LocID_2 = System.getProperty("Loc_2.ID");
//		System.out.println("Location  is  " + LocID_2); // end of getting order id
//		productPage.WaitForPageToLoad(30);
//		// WebDriverWait wait = new WebDriverWait(getDriver(), 3000); // New Product
//		// Button
//		// wait.until(ExpectedConditions.elementToBeClickable(By.id("create-package-button")));
//		// executor.executeScript("arguments[0].click();",
//		// productPage.btn_createpackage); // create package
//		waitABit(3000);
//		WebElement element = null;
//		element = getDriver().findElement(By.id("countrySelect"));
//		element.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(fcountry);
//		waitABit(100);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
//		// switch (fcountry) {
//		if (fcountry.equals("United States")) {
//			// case "United States":
//			productPage.btn_glm.waitUntilClickable().click();
//			// break;
//		} else if (fcountry.equals("United Kingdom")) {
//			// case "United Kingdom":
//			productPage.btn_glm1.waitUntilClickable().click();
//			// break;
//		} else {
//			// default:
//			productPage.btn_glm.waitUntilClickable().click();
//			// break;
//		}
//		waitABit(2000);
//		element = getDriver().findElement(By.id("glmCodeInput_value"));
//		element.click();
//		productPage.txt_GLM.type(fcilli); // Wait for Address box and type
//		productPage.waitForTextToAppear(fcilli, 30000); // Wait for Upload;
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in myflag = WaitAndSync() for next button");
//		}
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.img_first_location_icon); // click on the location
//																								// first icon to add
//																								// location
//		waitABit(3000);
//		// productPage.img_first_location_icon.click(); // click on the location first
//		// icon to add location
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(100);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		// productPage.lst_first_location.withTimeoutOf(60,
//		// TimeUnit.SECONDS).waitUntilPresent().click();
//		waitABit(3000);
//		executor.executeScript("arguments[0].click();", productPage.btn_reset);// Reset Address form
//		element = getDriver().findElement(By.id("countrySelect"));
//		element.click();
//		waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(seccountry);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(3000);
//		// switch (seccountry) {
//		if (seccountry.equals("United States")) {
//			// case "United States":
//			productPage.btn_glm.waitUntilClickable().click();
//			// break;
//		} else if (seccountry.equals("United Kingdom")) {
//			// case "United Kingdom":
//			productPage.btn_glm1.waitUntilClickable().click();
//			// break;
//		}
//		// default:
//		else {
//			productPage.btn_glm.waitUntilClickable().click();
//			// break;
//		}
//		waitABit(3000);
//		element = getDriver().findElement(By.id("glmCodeInput_value"));
//		element.click();
//		productPage.txt_GLM.type(seccilli); // Wait for Address box and type
//		productPage.waitForTextToAppear(seccilli, 30000); // Wait for Upload;
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in myflag = WaitAndSync() for next button");
//		}
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.img_first_location_icon); // click on the location
//																								// first icon to add
//																								// location
//		waitABit(3000);
//		// getDriver().findElement(By.id(secplcode)).click();
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.img_first_location_icon); // click on the location
//																								// first icon to add
//																								// location
//		// productPage.img_first_location_icon.click(); // click on the location first
//		// icon to add location
//		// waitABit(10000);
//		executor.executeScript("arguments[0].click();", productPage.lst_secondfloor_location);
//		waitABit(3000);
//		// productPage.img_first_location_icon.click(); // click on the location first
//		// icon to add location
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(100);
//		// productPage.lst_secondfloor_location.withTimeoutOf(60,
//		// TimeUnit.SECONDS).waitUntilPresent().click();
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.btn_next); // Next Button
//		// productPage.btn_next.click(); // Next Button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//		E2ESteps.printInGreenColor("Out of Locations with country with Cilli",
//				"Locations cilli are  " + fcountry + " and " + seccountry);
//	}
//
//	@Step
//	public void user_adds_one_valid_locations_using_Cilli(String fcountry, String fcilli, String floor, String room) {
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		System.setProperty("Loc.ID", fcilli);
//		String LocID = System.getProperty("Loc.ID");
//		System.out.println("Location is " + LocID);
//		Boolean myflag;
//		// WebDriverWait wait = new WebDriverWait(getDriver(), 3000); // New Product
//		// Button
//		// wait.until(ExpectedConditions.elementToBeClickable(By.id("create-package-button")));
//		// executor.executeScript("arguments[0].click();",
//		// productPage.btn_createpackage);
//		waitABit(3000);
//		getDriver().switchTo().parentFrame();
//		productPage.moveTo("//html/body/a[2]");
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB); //
//		waitABit(1000);
//		getDriver().switchTo().frame(0); // Change to the 0 Frame
//		// executor.executeScript("arguments[0].click();", productPage.ddl_country);
//		// productPage.ddl_country.click();
//		// waitABit(3000);
//		// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP,Keys.ENTER);
//		// waitABit(3000);
//		getDriver().switchTo().activeElement().sendKeys(fcountry);
//		waitABit(2000);
//		// executor.executeScript("arguments[0].click();", productPage.btn_glm);
//		// productPage.btn_glm.waitUntilClickable().click();
//		productPage.txt_address.type(fcilli); // Wait for Address box and type
//		productPage.waitForAbsenceOf("Searching");
//		waitABit(2000);
//		// productPage.waitForTextToAppear(fcilli,20000); // Wait for Upload;
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		// productPage.txt_GLM.type(fcilli); // Wait for Address box and type
////		waitABit(4000);
////		//getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER); 
////		myflag = WaitAndSync();
////		if (myflag) {
////			 System.out.println("error in myflag = WaitAndSync() for picking country address location");
////		}
//		waitABit(1000);
//		executor.executeScript("arguments[0].click();", productPage.img_first_location_icon); // click on the location
//																								// first icon to add
//																								// location
//		// productPage.img_first_location_icon.click(); // click on the location first
//		// icon to add location
//		executor.executeScript("arguments[0].click();", productPage.lst_first_location);
//		// productPage.lst_first_location.withTimeoutOf(60,
//		// TimeUnit.SECONDS).waitUntilPresent().click();
//		waitABit(3000);
//		try {
//			productPage.txt_first_location_international.type(floor);
//			productPage.txt_room_location_international.type(room);
//			executor.executeScript("arguments[0].click();", productPage.btn_save_international); // save button
//			// productPage.btn_save_international.click();
//			myflag = WaitAndSync();
//			if (myflag) {
//				System.out.println("error in WaitAndSync for next button");
//			}
//		} catch (Exception e) {
//			System.out.println("room and floor already set in international");
//		}
//		executor.executeScript("arguments[0].click();", productPage.lst_secondfloor_location);
//		executor.executeScript("arguments[0].click();", productPage.btn_next); // next button
//	}

	@Step
	public void user_adds_one_valid_locations(String faddress, String fcity, String fstate, String fplcode) {
		System.setProperty("Loc.ID", faddress);
		String LocID = System.getProperty("Loc.ID");
		System.out.println("Location  is  " + LocID); // end of getting order id
		Boolean myflag;
		productPage.WaitForPageToLoad(30);
		create_first_location(faddress, fcity, fstate);// create the first location
		getDriver().findElement(By.id(fplcode)).click();
		waitABit(1000);
		productPage.btn_next.click(); // Next Button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for next button");
		}
		E2ESteps.printInGreenColor("Out of Location ", "Location   is  " + faddress);
	}

	@Step
	public void user_adds_one_valid_locations_with_floor(String faddress, String floorAndRoom, String fstate,
			String fplcode) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		Boolean myflag;
		System.setProperty("Loc.ID", faddress);
		String LocID = System.getProperty("Loc.ID");
		logger.info("Location  is  " + LocID); // end of getting order id
		String myuserID = System.getProperty("Type.ID");
		logger.info("my User is " + myuserID);
		if (myuserID.equals("EMEA")) {
			executor.executeScript("arguments[0].click();", productPage.btn_createpackage);
			waitABit(3000);
			productPage.txt_address.type(faddress); // Wait for Address box and type
			waitABit(4000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for next button");
			}
		} else {
			create_first_location(faddress, floorAndRoom, fstate);// create the first location
		}
		waitABit(1000);
		//network_Status=productPage.networkStatus.getText();
		//logger.info("Network Status="+network_Status);
		productPage.floorAndRoomSelection.withTimeoutOf(Duration.ofSeconds(90)).waitUntilClickable().click();
		waitABit(2000);
		productPage.textServiceLocation.withTimeoutOf(Duration.ofSeconds(120)).waitUntilClickable().click();
		productPage.textServiceLocation.sendKeys(floorAndRoom);
		waitABit(600);
		String floorAndRoomEle1 = "//span[contains(text(),'";
		String floorAndRoomEle2 = " ')]/..";
		getDriver().findElement(By.xpath(floorAndRoomEle1 + floorAndRoom + floorAndRoomEle2)).click();		
		waitABit(1000);
		for (int i = 1; i <= 10; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
			waitABit(700);
			String classValue = getDriver().switchTo().activeElement().getAttribute("class");
			if (classValue.equals("chi-button -primary")) {
				// String selectValue=getDriver().switchTo().activeElement().getText();
				break;
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		logger.info("Successfully added the Floor and Room");
	}

//	@Step
//	public void user_adds_one_valid_international_locations_with_floor(String faddress, String fcity, String fstate,
//			String fplcode) {
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		Boolean myflag;
//		System.setProperty("Loc.ID", faddress);
//		String LocID = System.getProperty("Loc.ID");
//		System.out.println("Location  is  " + LocID); // end of getting order id
//		String myuserID = System.getProperty("Type.ID");
//		System.out.println("my User is " + myuserID);
//		productPage.btn_createpackage.waitUntilClickable().click();
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//		if (myuserID.equals("EMEA")) {
//			waitABit(3000);
//			productPage.txt_address.type(faddress); // Wait for Address box and type
//			waitABit(4000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			myflag = WaitAndSync();
//			if (myflag) {
//				System.out.println("error in WaitAndSync for next button");
//			}
//		} else {
//			waitABit(3000);
//			productPage.btn_glm.waitUntilClickable().click();
//			waitABit(2000);
//			productPage.txt_GLM.type(faddress); // Wait for Address box and type
//			waitABit(4000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//			myflag = WaitAndSync();
//			if (myflag) {
//				System.out.println("error in WaitAndSync for next button");
//			}
//		}
//		executor.executeScript("arguments[0].click();", productPage.lst_first_location); // Bring up the location pop up
//		productPage.waitForTextToAppear("Floor", 20000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
//		waitABit(100);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(3000);
//		executor.executeScript("arguments[0].click();", productPage.btn_next); // next button
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for next button");
//		}
//	}
	
	

	public void create_second_location(String secaddress, String floorAndRoom2, String fstate) {
		Boolean myflag;
		waitABit(3000);
		productPage.txt_address.type(secaddress); // Wait for Address box and type
		waitABit(4000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN); // pick the first address
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // pick the first address
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER); // pick the first address
		waitABit(2000);
		logger.info("Successfully added the Address");
		E2ESteps.printInGreenColor("Out of Location 2 ", "Locations   is  " + secaddress);
		
		waitABit(2000);
		//network_Status=productPage.networkStatus.getText();
		//logger.info("Network Status="+network_Status);
		productPage.sceFloorAndRoomSelection.withTimeoutOf(Duration.ofSeconds(90)).waitUntilClickable().click();
		waitABit(3000);
		productPage.textServiceLocation.withTimeoutOf(Duration.ofSeconds(120)).waitUntilClickable().click();
		productPage.textServiceLocation.sendKeys(floorAndRoom2);
		waitABit(600);
		String floorAndRoomEle1 = "//span[contains(text(),'";
		String floorAndRoomEle2 = " ')]/..";
		getDriver().findElement(By.xpath(floorAndRoomEle1 + floorAndRoom2 + floorAndRoomEle2)).click();		
		waitABit(1500);
		for (int i = 1; i <= 10; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
			waitABit(700);
			String classValue = getDriver().switchTo().activeElement().getAttribute("class");
			if (classValue.equals("chi-button -primary")) {
				// String selectValue=getDriver().switchTo().activeElement().getText();
				break;
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		logger.info("Successfully added the Floor and Room for secondary location");

		
	}
	
	public void navigate_to_proceed_to_product_selection() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		try {
			productPage.waitForTextToAppear("Proceed to Product Selection", 60);
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(productPage.btn_proceedToProductselection));
			productPage.btn_proceedToProductselection.waitUntilClickable();
			executor.executeScript("arguments[0].click();", productPage.btn_proceedToProductselection);
			logger.info("Successfully clicked on the Proceed To Product Selection");
		} catch (TimeoutException e) {
			productPage.btn_proceedToProductselectionjenkins.waitUntilClickable();
			executor.executeScript("arguments[0].click();", productPage.btn_proceedToProductselectionjenkins); // next
			logger.info("Successfully clicked on the Proceed To Product Selection"); // button
		}	

	}

}
