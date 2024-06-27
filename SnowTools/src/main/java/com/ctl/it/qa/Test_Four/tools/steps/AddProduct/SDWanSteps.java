package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class SDWanSteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(SDWanSteps.class);
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;

	@Step
	public void user_adds_sdwan_product2(String smyproduct, String accesstype, String access1, String bandwidth,
			String bill_method, String buildingExt) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String LocID = System.getProperty("Loc.ID");
		System.out.println("Location  is  " + LocID); // end of getting order id
		String myEnv = System.getProperty("staf.environment.key");
		this.addNewProduct(); // add the product here
		executor.executeScript("arguments[0].click();", productPage.ddl_loc_building_ext);// primary device
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(accesstype, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for primary device");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_a_loc_dd);// access one
		productPage.waitForTextToAppear("Existing", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(access1, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for access one");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_buildingext_dia_dd);// bandwidth
		productPage.waitForTextToAppear("Fast", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(bandwidth, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwith");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_loc_Z_wavelength_dd);// billing method
		productPage.waitForTextToAppear("CDR", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(bill_method, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for ");
		}
		executor.executeScript("arguments[0].click();", productPage.sdwan_buildingext);// building ext
		productPage.waitForTextToAppear("Extended", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(buildingExt, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for building Ext ");
		}
		singleLocationNextandDiscount(); // Next Buttons
	}

	@Step
	public void user_adds_sdwan_product(String smyproduct, String accesstype, String access1, String bandwidth,
			String bill_method, String buildingExt) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String LocID = System.getProperty("Loc.ID");
		System.out.println("Location  is  " + LocID); // end of getting order id
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		// this.addNewProduct(); // add the product here
		if (myEnv.equals("TEST2")) {
			waitABit(5000);
			this.addNewProduct(); // add the product here
		} else if (myEnv.equals("TEST1") || myEnv.equals("TEST4")) {
			productPage.waitForTextToAppear("Select a product", 40000);
			for (int i = 0; i <= 5; i++) {
				int sizeOfproducts = getDriver().findElements(By.xpath("//label[text()='Top 10']/../..//button"))
						.size();
				logger.info("Size of Products--" + sizeOfproducts);
				if (sizeOfproducts == 10) {
					break;
				} else {
					logger.info("Waiting to show the products");
					waitABit(2000);
				}
			}
			waitABit(2000);
			getDriver().findElement(By.xpath("(//span[text()='SD-WAN']/..)[1]")).click();
			logger.info("SDWAN Product added");
			if (myEnv.equals("TEST4")) {
				WebElement proceedToConfigure = getDriver()
						.findElement(By.xpath("//span[text()='Proceed to Configure']/.."));
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
				wait.until(ExpectedConditions.elementToBeClickable(proceedToConfigure));
				proceedToConfigure.click();
				logger.info("Successfully clicked on configure");
			} else {
				WebElement proceedToConfigure = getDriver()
						.findElement(By.xpath("//span[text()='Custom Configure']/.."));
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
				wait.until(ExpectedConditions.elementToBeClickable(proceedToConfigure));
				proceedToConfigure.click();
				logger.info("Successfully clicked on configure");
			}
		}
		waitABit(10000);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for proceed to configure");
		}
		///////////////////////////////////
		executor.executeScript("arguments[0].click();", productPage.accessOneType);// primary device
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(accesstype, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access one type");
		}
		if (accesstype.equals("Dedicated Inernet Access")) {
			executor.executeScript("arguments[0].click();", productPage.accessOneDia);// access one
			productPage.waitForTextToAppear("New or Swift Inventoried", 10000);
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys("New or Swift Inventoried", Keys.ENTER);
			// productPage.lst_chckbox_create_new_package.click();
			waitABit(2000);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync New or Swift Inventoried");
			}
		}
		executor.executeScript("arguments[0].click();", productPage.circuitType);// primary device
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(bandwidth, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Bandwidth");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		executor.executeScript("arguments[0].click();", productPage.billingMethod);// bandwidth
		// productPage.waitForTextToAppear("Flat Rate", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(bill_method, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for billing method");
		}
		executor.executeScript("arguments[0].click();", productPage.pdrOld);// billing method
		productPage.waitForTextToAppear("20", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("1000", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for PDR");
		}
		executor.executeScript("arguments[0].click();", productPage.buildingExt);// building ext
		productPage.waitForTextToAppear("Extended", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(buildingExt, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for building Ext ");
		}
		getDriver().findElement(By.xpath(
				"(//*[@class='sprite wiz-quick-save product-ok-button wiz-butt-margin wiz_quick_save_active'])[1]"))
				.click();
		waitABit(5000);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Save Product ");
		}
		waitABit(25000);
		singleLocationNextandDiscount(); // Next Buttons
	}
}
