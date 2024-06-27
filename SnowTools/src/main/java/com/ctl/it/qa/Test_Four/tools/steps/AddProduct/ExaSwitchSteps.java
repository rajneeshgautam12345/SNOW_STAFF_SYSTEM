package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
public class ExaSwitchSteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(ExaSwitchSteps.class);
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;
	
	@Step
	public void user_adds_managed_services(String managedService, String managedServiceType, String kitName,
			String cpeProvider) {
		if (managedService.equals("Yes")) {
			String[] managedServiceTypes = managedServiceType.split(" and ");
			String[] kitNames = kitName.split(" and ");
			for (int i = 0; i <= managedServiceTypes.length - 1; i++) {
				System.out.println("Managed service to add- " + managedServiceTypes[i]);
				JavascriptExecutor executor = (JavascriptExecutor) getDriver();
				Boolean myflag;
				executor.executeScript("arguments[0].click();", productPage.btn_continue);
				waitABit(1000);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for continue button");
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				// waitABit(2000);
				executor.executeScript("arguments[0].scrollIntoView(true);", productPage.optionalProd);
				waitABit(2000);
				executor.executeScript("arguments[0].click();", productPage.optionalProd);
				// productPage.optionalProd.click(); // Open billing method drop down
				productPage.waitForTextToAppear("Managed Router"); // Wait for Upload;
				waitABit(2000);
				productPage.optionalProd.selectByVisibleText(managedServiceTypes[i]);
				logger.info("Successfully selected the " + managedServiceTypes[i]);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for managedServiceType");
				}
				// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				waitABit(2000);
				productPage.addNew.click(); // Open billing method drop down
				waitABit(5000);
				// getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				productPage.kitName.click(); // Open billing method drop down
				waitABit(2000);
				logger.info("Kit Name to add-" + kitNames[i]);
				productPage.kitName.selectByVisibleText(kitNames[i]);
				logger.info("Successfully selected the KitName-" + kitNames[i]);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for kitName");
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				waitABit(2000);
				if (!cpeProvider.equals("Level 3 Provided")) {
					productPage.cpeProvider.click(); // Open billing method drop down
					waitABit(2000);
					productPage.cpeProvider.selectByVisibleText(cpeProvider);
					logger.info("Successfully selected the CPE Provider as-" + cpeProvider);
					myflag = WaitAndSync();
					if (myflag) {
						System.out.println("error in WaitAndSync for cpeProvider");
					}
				}
				productPage.saveButton.click();
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for cpeProvider");
				}
			}
		}
	}

	@Step
	public void productConfigurationFinishButtonAndDiscountingApproval() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		Boolean myflag;
		executor.executeScript("arguments[0].scrollIntoView(true);", productPage.btn_finish);
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(productPage.btn_finish));
		executor.executeScript("arguments[0].click();", productPage.btn_finish);
		logger.info("Finish button clicked");
		// System.out.println("finish button clicked");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for billingMethod");
		}
		singleLocationNextandDiscount();  // this function does all the next and discount buttons
	}

	@Step
	public void user_adds_exaSwitch_products(String smyproduct, String bandwidth, String alocationBuilExtension,
			String cloudServiceProvider, String cspLocationName, String customRoute, String term) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		logger.info("the Env is : " + myEnv);
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		logger.info("The product is  " + sProductType); // print out product type
		
		productPage.waitForTextToAppear("Select a product", 40000);
			for (int i = 0; i <= 10; i++) {
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
			getDriver().findElement(By.xpath("//input[@aria-label='search input']")).sendKeys("ExaSwitch");
			waitABit(1000);
			getDriver().findElement(By.xpath("(//span[text()='ExaSwitch']/..)[1]")).click();
			logger.info("ExaSwitch Products added");
			if (myEnv.equals("TEST3")) {
				WebElement proceedToConfigure = getDriver()
						.findElement(By.xpath("//span[text()='Proceed to Configure']/.."));
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
				wait.until(ExpectedConditions.elementToBeClickable(proceedToConfigure));
				waitABit(3000);
				proceedToConfigure.click();
				logger.info("Successfully clicked on configure");
			} else {
				WebElement proceedToConfigure = getDriver()
						.findElement(By.xpath("//span[text()='Custom Configure']/.."));
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
				wait.until(ExpectedConditions.elementToBeClickable(proceedToConfigure));
				waitABit(8000);
				executor.executeScript("arguments[0].click();", proceedToConfigure);
				//proceedToConfigure.click();
				logger.info("Successfully clicked on configure");
			}
		
		
		waitABit(10000);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
		
		// this for new ui
		productPage.waitForTextToAppear("ExaSwitch - Basic Config",90000); // Wait for Upload
			
//		if (myEnv.equals("TEST3")) {
//			oldUIconfiguration();
//		} else if (myEnv.equals("TEST2") || myEnv.equals("TEST4") || myEnv.equals("TEST1")) {
			
		    waitABit(5000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(2000);
			
			executor.executeScript("arguments[0].click();", productPage.bandwidth);
			productPage.waitForTextToAppear("100GIG-E");
			waitABit(1000);
			productPage.bandwidth.selectByVisibleText(bandwidth);
			logger.info("Successfully selected the bandwidth");
			myflag = WaitAndSync1();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}

			executor.executeScript("arguments[0].click();", productPage.lst_alocationInsideWiring);
			waitABit(1500);
			productPage.waitForTextToAppear("Extended"); // Wait for Upload;
			waitABit(2000);
			productPage.lst_alocationInsideWiring.selectByVisibleText(alocationBuilExtension);
			logger.info("Successfully selected the alocationInsideWiring Value");
			myflag = WaitAndSync();
			if (myflag) {
					System.out.println("error in WaitAndSync for extended deliver");
			}
			
			executor.executeScript("arguments[0].click();", productPage.cloudProvider);
			waitABit(1500);
			productPage.waitForTextToAppear("AWS");
			waitABit(1000);
			productPage.cloudProvider.selectByVisibleText(cloudServiceProvider);
			logger.info("Successfully selected the Clould ServiceProvider Value");
			myflag = WaitAndSync();
			if (myflag) {
			System.out.println("error in WaitAndSync for Multiple Logicals");
			}
			
			executor.executeScript("arguments[0].click();", productPage.cspLocationName);
			waitABit(1500);
			productPage.waitForTextToAppear("Harlan Test 12345");
			waitABit(1000);
			productPage.cspLocationName.selectByValue(cspLocationName);
			myflag = WaitAndSync();
			if (myflag) {
			System.out.println("error in WaitAndSync for Multiple Logicals");
			}
			
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);	
			waitABit(1000);
			
			if (customRoute.equals("No")) {	
				executor.executeScript("arguments[0].click();", productPage.customRoute);
				productPage.customRoute.selectByValue("No");
				waitABit(2000);			
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Custom Route");
				}
			}
			
			if (!term.equals("12")) {
				executor.executeScript("arguments[0].click();", productPage.term);
				productPage.term.clear();
				productPage.term.sendKeys(term);
				logger.info("Term value is selected--" + term);
				waitABit(2000);
				if (myflag) {
					System.out.println("error in WaitAndSync for Custom Route");
				}
			}
			
			executor.executeScript("arguments[0].click();", productPage.continueButton);
			waitABit(5000);
			
		//	productPage.saveButton.click();
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for Continue");
			}
		}		
	}

	
