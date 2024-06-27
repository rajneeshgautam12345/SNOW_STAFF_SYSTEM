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

import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class DIASteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(DIASteps.class);
	private static final String Boolen = null;
	//LoginPage loginPage;
	//HomePage homePage;
	//ScenarioPage scenarioPage;
	ProductPage productPage;
	//ScenarioDataPage senarioDataPage;
	//SwiftPage swiftPage;
	E2ESteps e2e;
	WaveLengthSteps wavelengthSteps;

	@Step
	public void user_adds_dia_product(String smyproduct, String bandwidth, String accessSubbandwidth,
			String billingMethod, String buildingExt) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String myEnv = System.getProperty("staf.environment.key");
		logger.info("the Env is : " + myEnv);
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		logger.info("The product is  " + sProductType); // print out product type
		if (myEnv.equals("TEST2")) {
			waitABit(5000);
			this.addNewProduct(); // add the product here
		} else if (myEnv.equals("TEST1") || myEnv.equals("TEST4")) {
			productPage.waitForTextToAppear("Select a product", 40000);
			for (int i = 0; i <= 5; i++) {
				int sizeOfproducts = getDriver().findElements(By.xpath("//label[text()='Top 10']/../..//button"))
						.size();
				System.out.println("Size of Products--" + sizeOfproducts);
				if (sizeOfproducts == 10) {
					break;
				} else {
					System.out.println("Waiting to show the products");
					waitABit(2000);
				}
			}
			getDriver().findElement(By.xpath("(//span[text()='Dedicated Internet Access']/..)[1]")).click();
			logger.info("DIA Products added");
			// WebElement
			// proceedToConfigure=getDriver().findElement(By.xpath("//span[text()='Proceed
			// to Configure']/.."));
			WebElement proceedToConfigure = getDriver().findElement(By.xpath("//span[text()='Custom Configure']/.."));
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
			wait.until(ExpectedConditions.elementToBeClickable(proceedToConfigure));
			proceedToConfigure.click();
			logger.info("Successfully clicked on configure");
		}
		// this for new ui
		waitABit(5000);
		myflag = WaitAndSync1();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
		productPage.waitForTextToAppear("Dedicated Internet Access"); // Wait for Upload
//		myflag = WaitAndSync1();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for bandwidth");
//		}
		if (myEnv.equals("TEST2")) {
			oldUIconfiguration();
		} else {
			waitABit(2000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			// executor.executeScript("arguments[0].scrollIntoView(true);",
			// productPage.lst_circuitType);
			waitABit(2000);
			executor.executeScript("arguments[0].click();", productPage.lst_circuitType);
			productPage.waitForTextToAppear("10 GigE");
			waitABit(1000);
			productPage.lst_circuitType.selectByVisibleText(bandwidth);
			logger.info("Successfully selected the bandwidth");
			// System.out.println("Successfully Bandwidth Selected");
			myflag = WaitAndSync1();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
//			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			if (!accessSubbandwidth.equals("1000 Mbps")) {
				if (bandwidth.contains("GigE")) {
					productPage.access_sub_bandwith.selectByValue(accessSubbandwidth);
				}
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for bandwidth");
				}
			}
			if (!buildingExt.equals("Standard Delivery - To the MPoE (Customer Provided)")) {
				executor.executeScript("arguments[0].click();", productPage.lst_insideWiring);
				waitABit(1500);
				productPage.waitForTextToAppear("Extended"); // Wait for Upload;
				waitABit(2000);
				productPage.lst_insideWiring.selectByVisibleText(buildingExt);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for extended deliver");
				}
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(2000);
			productPage.lst_port_type.click(); // Open billing method drop down
			productPage.waitForTextToAppear("Billing Arrangement"); // Wait for Upload;
			waitABit(1000);
			productPage.lst_port_type.selectByVisibleText(billingMethod);
			logger.info("Successfully selected the Port Type");
			myflag = WaitAndSync1();
			if (myflag) {
				System.out.println("error in WaitAndSync for billingMethod");
			}
			executor.executeScript("arguments[0].scrollIntoView(true);", productPage.btn_finish);
			// System.out.println("page is down");
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(productPage.btn_finish));
			executor.executeScript("arguments[0].click();", productPage.btn_finish);
			logger.info("Finish button clicked");
		}
		singleLocationNextandDiscount(); // this function does all the next and discount buttons
	}

	// oldUIconfiguration
	public void oldUIconfiguration() {
		boolean myflag;
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		productPage.waitForTextToAppear("Dedicated Internet Access"); // Wait for Upload
		js.executeScript("arguments[0].scrollIntoView(true);", productPage.lst_circuitType1);
		productPage.lst_circuitType1.click(); // Select Bandwidth Dropdown
		productPage.waitForTextToAppear("10 GigE");
		waitABit(2000);
		getDriver().findElement(By.xpath("(//li[text()= 'GigE - Ethernet Switched Access (50-1,000)'])[1]")).click();
		System.out.println("Successfully Bandwidth Selected");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//		if (bandwidth.contains("GigE")) {
//			productPage.access_sub_bandwith.selectByValue("100 Mbps");
//		}
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for bandwidth");
//		}
//			productPage.lst_insideWiring.click(); // Select Building Extension Drop down
//			productPage.waitForTextToAppear("Extend"); // Wait for Upload;
//			waitABit(2000);
//			productPage.lst_insideWiring.selectByVisibleText(buildingExt);
//			myflag = WaitAndSync();
//			if (myflag) {
//				System.out.println("error in WaitAndSync for extended deliver");
//			}
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		js.executeScript("arguments[0].scrollIntoView(true);", productPage.lst_port_type1);
		waitABit(2000);
		productPage.lst_port_type1.click(); // Open billing method drop down
		productPage.waitForTextToAppear("Billing Arrangement"); // Wait for Upload;
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(800);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(800);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(800);
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for billingMethod");
		}
		System.out.println("Flat Rate selected");
		waitABit(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", productPage.btn_finish1);
		System.out.println("page is down");
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(productPage.btn_finish1));
		productPage.btn_finish1.click();
		System.out.println("finish button clicked");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for billingMethod");
		}
	}

	@Step
	public void user_adds_dia_products(String smyproduct, String bandwidth, String accessubBandwidth,
			String billingMethod, String buildingExt, String multipleLogicals, String pdr, String cdr, String term) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		logger.info("the Env is : " + myEnv);
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		logger.info("The product is  " + sProductType); // print out product type
		if (myEnv.equals("TEST3")) {
			waitABit(5000);
			this.addNewProduct(); // add the product here
		} else if (myEnv.equals("TEST1") || myEnv.equals("TEST4")|| myEnv.equals("TEST2")) {
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
			getDriver().findElement(By.xpath("(//span[text()='Dedicated Internet Access']/..)[1]")).click();
			logger.info("DIA Products added");
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
				logger.info("Successfully clicked on configure");
			}
		}
		// this for new ui
		waitABit(5000);
		productPage.waitForTextToAppear("Dedicated Internet Access",90000); // Wait for Upload
		waitABit(5000);
		myflag = WaitAndSync1();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
				
		if (myEnv.equals("TEST3")) {
			oldUIconfiguration();
		} else if (myEnv.equals("TEST2") || myEnv.equals("TEST4") || myEnv.equals("TEST1")) {
			waitABit(5000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(2000);
			executor.executeScript("arguments[0].click();", productPage.lst_circuitType);
			productPage.waitForTextToAppear("10 GigE");
			waitABit(1000);
			productPage.lst_circuitType.selectByVisibleText(bandwidth);
			logger.info("Successfully selected the bandwidth");
			myflag = WaitAndSync1();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
			if (!accessubBandwidth.equals("1000 Mbps")) {
				productPage.access_sub_bandwith.selectByValue(accessubBandwidth);
				logger.info("Successfully selected the Acess subbandwidth");
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for access bandwidth");
				}
			}
			       
			Select s1=new Select(productPage.lst_insideWiring);
			String buildExtSelectedValue=s1.getFirstSelectedOption().getText();
			if (!buildingExt.equals("Standard Delivery - To the MPoE (Customer Provided)")||buildExtSelectedValue.contains("Extended Delivery - To the Customer Suite")) {		
				executor.executeScript("arguments[0].click();", productPage.lst_insideWiring);
				waitABit(1500);
				productPage.waitForTextToAppear("Extended"); // Wait for Upload;
				waitABit(2000);
				productPage.lst_insideWiring.selectByVisibleText(buildingExt);
				logger.info("Successfully selected the building extension");
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for extended deliver");
				}
			}
			if (!multipleLogicals.equals("No")) {
				executor.executeScript("arguments[0].click();", productPage.multipleLogicals);
				waitABit(1500);
				productPage.waitForTextToAppear("Yes");
				waitABit(1000);
				productPage.multipleLogicals.selectByVisibleText(multipleLogicals);
				logger.info("Successfully selected the Multiple logicals");
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for Multiple Logicals");
				}
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(2000);
			executor.executeScript("arguments[0].click();", productPage.lst_port_type);
			productPage.waitForTextToAppear("Billing Arrangement"); // Wait for Upload;
			waitABit(1000);
			productPage.lst_port_type.selectByVisibleText(billingMethod);
			logger.info("Successfully selected the Port Type");
			myflag = WaitAndSync1();
			if (myflag) {
				System.out.println("error in WaitAndSync for billingMethod");
			}
			
			if (myEnv.equals("TEST4") && (!bandwidth.equals("10 Gig LanWave - Wave Access (500-10,000)")))
			{
				Select s2=new Select(productPage.lumenDefender);		
				String selectedlumenDefenderValue=s2.getFirstSelectedOption().getText();
				System.out.println("Lumen defender by default S]elected Value-"+selectedlumenDefenderValue);
				if(!selectedlumenDefenderValue.equals("No <Default>"))
				{
				executor.executeScript("arguments[0].scrollIntoView();", productPage.lumenDefender);
				waitABit(2000);
				executor.executeScript("arguments[0].click();", productPage.lumenDefender);
				waitABit(1500);
				productPage.waitForTextToAppear("No"); // Wait for Upload;
				waitABit(2000);
				productPage.lumenDefender.selectByVisibleText("No ");
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for Lumen Defender");
				}
				}
				System.out.println("Lumen defender value by default selected");
			}
			if (!pdr.equals("1000")) {
				executor.executeScript("arguments[0].click();", productPage.pdr);
				waitABit(1500);
				productPage.waitForTextToAppear("10"); // Wait for Upload;
				waitABit(2000);
				productPage.pdr.selectByVisibleText(pdr);
				logger.info("Successfully selected the PDR value");
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for PDR");
				}
			}
			if (!term.equals("36")) {
				executor.executeScript("arguments[0].click();", productPage.term);
				productPage.term.clear();
				productPage.term.sendKeys(term);
				logger.info("Term value is selected--" + term);
				waitABit(2000);
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for PDR");
				}
			}
			
			    executor.executeScript("arguments[0].click();", productPage.btn_continue);
			    logger.info("Successfully clicked on continue button");
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for Continue");
				}
			}
		}
	
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
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for continue button");
				}
				getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				executor.executeScript("arguments[0].scrollIntoView(true);", productPage.optionalProd);
				waitABit(2000);
				executor.executeScript("arguments[0].click();", productPage.optionalProd);
				productPage.waitForTextToAppear("Managed Router"); // Wait for Upload;
				waitABit(2000);
				productPage.optionalProd.selectByVisibleText(managedServiceTypes[i]);
				logger.info("Successfully selected the " + managedServiceTypes[i]);
				myflag = WaitAndSync1();
				if (myflag) {
					System.out.println("error in WaitAndSync for managedServiceType");
				}
				waitABit(2000);
				productPage.addNew.click(); // Open billing method drop down
				waitABit(5000);
				productPage.kitName.click(); // Open billing method drop down
				waitABit(2000);
				logger.info("Kit Name to add-" + kitNames[i]);
				productPage.kitName.selectByVisibleText(kitNames[i]);
				logger.info("Successfully selected the KitName-" + kitNames[i]);
				myflag = WaitAndSync1();
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
					myflag = WaitAndSync1();
					if (myflag) {
						System.out.println("error in WaitAndSync for cpeProvider");
					}
				}
				productPage.saveButton.click();
				logger.info("Successfully saved Managed service details");
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
		logger.info("Successfully clicked on finish button");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for billingMethod");
		}
		
		singleLocationNextandDiscount();  // this function does all the next and discount buttons,
		
		
		
	}

	@Step
	public void user_adds_dia_products2(String smyproduct, String bandwidth, String accessubBandwidth, String accessSolution,
			String billingMethod, String buildingExt, String multipleLogicals, String pdr, String cdr, String term) 
	{
		Boolean myflag;
		
		
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		logger.info("the Env is : " + myEnv);
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		logger.info("The product is  " + sProductType); // print out product type
		if (myEnv.equals("TEST3")) {
			waitABit(5000);
			this.addNewProduct(); // add the product here
		} else if (myEnv.equals("TEST1") || myEnv.equals("TEST4")|| myEnv.equals("TEST2")) {
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
			getDriver().findElement(By.xpath("(//span[text()='Dedicated Internet Access']/..)[1]")).click();
			logger.info("DIA Products added");
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
		}	
				// this for new ui
		productPage.waitForTextToAppear("Dedicated Internet Access"); // Wait for Upload
		waitABit(10000);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
		if (myEnv.equals("TEST3")) {
			oldUIconfiguration();
		} else if (myEnv.equals("TEST2") || myEnv.equals("TEST4") || myEnv.equals("TEST1")) {
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(2000);
			executor.executeScript("arguments[0].click();", productPage.lst_circuitType);
			productPage.waitForTextToAppear("10 GigE");
			waitABit(1000);
			productPage.lst_circuitType.selectByVisibleText(bandwidth);
			logger.info("Successfully selected the bandwidth");
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
			// if (bandwidth.contains("GigE")) {
			if (!accessubBandwidth.equals("1000 Mbps")) {
				productPage.access_sub_bandwith.selectByValue(accessubBandwidth);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for bandwidth");
				}
			}
			
			if (!accessSolution.equals("default")) {
				Select s1=new Select(productPage.accessSolution);
				List<WebElement> allOptions=s1.getOptions();
				for(int i=0;i<=allOptions.size()-1;i++)
				{
				      String option=allOptions.get(i).getText();
				      System.out.println(option+"present");
				      if(option.contains(accessSolution))
				      {
				    	  productPage.accessSolution.selectByVisibleText(option);
				    	  myflag = WaitAndSync();
							if (myflag) {
								System.out.println("error in WaitAndSync for accessSolution");
							}
							logger.info("Successfully selected the access Solution");
							break;
				      }
				}
				
				
			}
			
			if (!buildingExt.equals("Standard Delivery - To the MPoE (Customer Provided)")) {
				executor.executeScript("arguments[0].click();", productPage.lst_insideWiring);
				waitABit(1500);
				productPage.waitForTextToAppear("Extended"); // Wait for Upload;
				waitABit(2000);
				productPage.lst_insideWiring.selectByVisibleText(buildingExt);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for extended deliver");
				}
			}
			if (!multipleLogicals.equals("No")) {
				executor.executeScript("arguments[0].click();", productPage.multipleLogicals);
				waitABit(1500);
				productPage.waitForTextToAppear("Yes");
				waitABit(1000);
				productPage.multipleLogicals.selectByVisibleText(multipleLogicals);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for Multiple Logicals");
				}
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			waitABit(2000);
			executor.executeScript("arguments[0].click();", productPage.lst_port_type);
			// productPage.lst_port_type.click(); // Open billing method drop down
			productPage.waitForTextToAppear("Billing Arrangement"); // Wait for Upload;
			waitABit(1000);
			
			productPage.lst_port_type.selectByVisibleText(billingMethod);
			logger.info("Successfully selected the Port Type");
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for billingMethod");
			}
			if (!pdr.equals("1000")) {
				executor.executeScript("arguments[0].click();", productPage.pdr);
				waitABit(1500);
				productPage.waitForTextToAppear("10"); // Wait for Upload;
				waitABit(2000);
				productPage.pdr.selectByVisibleText(pdr);
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for PDR");
				}
			}
			if (!term.equals("36")) {
				executor.executeScript("arguments[0].click();", productPage.term);
				productPage.term.clear();
				productPage.term.sendKeys(term);
				logger.info("Term value is selected--" + term);
				waitABit(2000);
			}
			if (multipleLogicals.equals("Yes")) {
				executor.executeScript("arguments[0].click();", productPage.continueButton);
				waitABit(2000);
				executor.executeScript("arguments[0].click();", productPage.IPLogicalRow);
				waitABit(2000);
				productPage.addNewButton.click();
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for PDR");
				}
				productPage.ipPortType.selectByValue("Flat Rate");
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for PDR");
				}
				productPage.saveButton.click();
				myflag = WaitAndSync();
				if (myflag) {
					System.out.println("error in WaitAndSync for PDR");
				}
			}
		}

	}


//	@Step
//	public void user_adds_exaSwitch_products(String smyproduct, String bandwidth, String alocationBuilExtension,
//			String cloudServiceProvider, String cspLocationName, String customRoute, String term) {
//		Boolean myflag;
//		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
//		logger.info("the Env is : " + myEnv);
//		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
//		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
//		logger.info("The product is  " + sProductType); // print out product type
//		
//		productPage.waitForTextToAppear("Select a product", 40000);
//			for (int i = 0; i <= 10; i++) {
//				int sizeOfproducts = getDriver().findElements(By.xpath("//label[text()='Top 10']/../..//button"))
//						.size();
//				logger.info("Size of Products--" + sizeOfproducts);
//				if (sizeOfproducts == 10) {
//					break;
//				} else {
//					logger.info("Waiting to show the products");
//					waitABit(2000);
//				}
//			}
//			getDriver().findElement(By.xpath("//input[@aria-label='search input']")).sendKeys("ExaSwitch");
//			waitABit(1000);
//			getDriver().findElement(By.xpath("(//span[text()='ExaSwitch']/..)[1]")).click();
//			logger.info("ExaSwitch Products added");
//			if (myEnv.equals("TEST3")) {
//				WebElement proceedToConfigure = getDriver()
//						.findElement(By.xpath("//span[text()='Proceed to Configure']/.."));
//				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
//				wait.until(ExpectedConditions.elementToBeClickable(proceedToConfigure));
//				waitABit(3000);
//				proceedToConfigure.click();
//				logger.info("Successfully clicked on configure");
//			} else {
//				WebElement proceedToConfigure = getDriver()
//						.findElement(By.xpath("//span[text()='Custom Configure']/.."));
//				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
//				wait.until(ExpectedConditions.elementToBeClickable(proceedToConfigure));
//				waitABit(8000);
//				executor.executeScript("arguments[0].click();", proceedToConfigure);
//				//proceedToConfigure.click();
//				logger.info("Successfully clicked on configure");
//			}
//		
//		// this for new ui
//		productPage.waitForTextToAppear("ExaSwitch - Basic Config"); // Wait for Upload
//		waitABit(10000);
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for bandwidth");
//		}
//			
//		if (myEnv.equals("TEST3")) {
//			oldUIconfiguration();
//		} else if (myEnv.equals("TEST2") || myEnv.equals("TEST4") || myEnv.equals("TEST1")) {
//			waitABit(5000);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			waitABit(2000);
//			executor.executeScript("arguments[0].click();", productPage.bandwidth);
//			productPage.waitForTextToAppear("10 GigE");
//			waitABit(1000);
//			productPage.bandwidth.selectByVisibleText(bandwidth);
//			logger.info("Successfully selected the bandwidth");
//			myflag = WaitAndSync1();
//			if (myflag) {
//				System.out.println("error in WaitAndSync for bandwidth");
//			}
//
//			executor.executeScript("arguments[0].click();", productPage.lst_alocationInsideWiring);
//			waitABit(1500);
//			productPage.waitForTextToAppear("Extended"); // Wait for Upload;
//			waitABit(2000);
//			productPage.lst_alocationInsideWiring.selectByVisibleText(alocationBuilExtension);
//			myflag = WaitAndSync();
//			if (myflag) {
//					System.out.println("error in WaitAndSync for extended deliver");
//			}
//			
//			executor.executeScript("arguments[0].click();", productPage.cloudProvider);
//			waitABit(1500);
//			productPage.waitForTextToAppear("AWS");
//			waitABit(1000);
//			productPage.cloudProvider.selectByVisibleText(cloudServiceProvider);
//			myflag = WaitAndSync();
//			if (myflag) {
//			System.out.println("error in WaitAndSync for Multiple Logicals");
//			}
//			
//			executor.executeScript("arguments[0].click();", productPage.cspLocationName);
//			waitABit(1500);
//			productPage.waitForTextToAppear("AWS 44858");
//			waitABit(1000);
//			productPage.cloudProvider.selectByVisibleText(cspLocationName);
//			myflag = WaitAndSync();
//			if (myflag) {
//			System.out.println("error in WaitAndSync for Multiple Logicals");
//			}
//			
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
//			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);	
//			
//			if (customRoute.equals("No")) {			
//				productPage.customRoute.selectByValue("No");
//				waitABit(2000);			
//				myflag = WaitAndSync();
//				if (myflag) {
//					System.out.println("error in WaitAndSync for Custom Route");
//				}
//			}
//			
//			if (!term.equals("12")) {
//				executor.executeScript("arguments[0].click();", productPage.term);
//				productPage.term.clear();
//				productPage.term.sendKeys(term);
//				logger.info("Term value is selected--" + term);
//				waitABit(2000);
//				if (myflag) {
//					System.out.println("error in WaitAndSync for Custom Route");
//				}
//			}
//			
//			executor.executeScript("arguments[0].click();", productPage.continueButton);
//			waitABit(5000);
//			
//			productPage.saveButton.click();
//			myflag = WaitAndSync();
//			if (myflag) {
//				System.out.println("error in WaitAndSync for PDR");
//			}
//		}
//		
//	}
}
	
