package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class WaveLengthSteps extends E2ESteps {
	private final Logger logger = LoggerFactory.getLogger(DIASteps.class);
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;
    public static String preDeploy_Status="OFF";
	// Wave Length
	// //////////////////////////////////////////////////////////////////////////////////////
	@Step
	public void user_adds_wavelength_product(String smyproduct,String bandwidth,String buildingExt_A,String buildingExt_Z,String custom_Route,String protection,String circuit_Divesity,String latency_guarantee,String encryption,String Contract_Type,String term) {
		
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String myEnv = System.getProperty("staf.environment.key").toUpperCase();
		logger.info("the Env is : " + myEnv);
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		logger.info("The product is  " + sProductType); // print out product type
		
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
		getDriver().findElement(By.xpath("(//span[text()='Wavelength']/..)[1]")).click();
		logger.info("Wavelength Products added");
		waitABit(4000);
		// WebElement
		// proceedToConfigure=getDriver().findElement(By.xpath("//span[text()='Proceed
		// to Configure']/.."));
		WebElement proceedToConfigure = getDriver().findElement(By.xpath("//span[text()='Custom Configure']/.."));
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(proceedToConfigure));
		executor.executeScript("arguments[0].click();", proceedToConfigure);
		//proceedToConfigure.click();
		logger.info("Successfully clicked on configure");
	      waitABit(5000);
		myflag = WaitAndSync1();
		   if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		   }
     	productPage.waitForTextToAppear("A Address",120000); // Wait for Upload
	   
	
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
				
		waitABit(5000);
		productPage.ddl_wavelenth_A_address.waitUntilClickable().click();// Select address Drop down
		waitABit(2000);
		// productPage.ddl_wavelenth_A_address.selectByIndex(0)
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER);
		System.out.println("first address picked");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for address select 1");
			productPage.sec_addressdd.waitUntilClickable().click();// Select second address Dropdown
		}
		waitABit(1000);
		productPage.ddl_wavelenth_Z_address.waitUntilClickable().click();// Select address Drop down
		waitABit(1000);
		// productPage.ddl_wavelenth_A_address.selectByIndex(0);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		System.out.println("second address picked");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for address select 2");
			productPage.sec_addressdd.waitUntilClickable().click();// Select second address Dropdown
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
		waitABit(1000);
		
		
		if(!bandwidth.equals("10GIG-E LAN"))
		{
		executor.executeScript("arguments[0].click();", productPage.lst_WaveBandwidth);
		productPage.waitForTextToAppear("1Gb SAN");
		waitABit(1000);
		productPage.lst_WaveBandwidth.selectByVisibleText(bandwidth);
		logger.info("Successfully selected the bandwidth");
		myflag = WaitAndSync1();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
		}
		//productPage.lst_loc_A_wiring.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilClickable().click(); // Select
		executor.executeScript("arguments[0].click();", productPage.lst_loc_A_wiring);
		waitABit(1000);
		productPage.lst_loc_A_wiring.sendKeys(buildingExt_A);
		System.out.println("set the configuration buildingExt_A");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for A wiring select 1");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
		
		executor.executeScript("arguments[0].click();", productPage.lst_ZLocInsideWiring);
		//productPage.lst_ZLocInsideWiring.waitUntilClickable().click();// Select building ext
		waitABit(4000);
		productPage.lst_ZLocInsideWiring.sendKeys(buildingExt_Z);
		waitABit(2000);
		System.out.println("set the configuration buildingExt_Z ");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for z wiring select 1");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(1000);
		
		if(!custom_Route.equals("Yes"))
		{
	    executor.executeScript("arguments[0].click();", productPage.lst_CustomRoute);
		//productPage.lst_CustomRoute.waitUntilClickable().click();// Select Custom Route
		waitABit(3000);
		productPage.lst_CustomRoute.sendKeys(custom_Route);
		System.out.println("set the configuration Custom_Route");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Custom_Route");
		}
		}
		
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		executor.executeScript("arguments[0].click();", productPage.lst_Term);
		productPage.lst_Term.waitUntilClickable().click();// Select Term
		waitABit(1000);
		String s = Keys.chord(Keys.CONTROL, "A");
		productPage.lst_Term.sendKeys(s);
		waitABit(800);
		//productPage.lst_Term.sendKeys(Keys.BACK_SPACE);
		//waitABit(1000);
		productPage.lst_Term.sendKeys(term);
		System.out.println("set the configuration term");
		waitABit(2000);
		getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
		
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for term");
		}
		
		executor.executeScript("arguments[0].scrollIntoView();", productPage.btn_continue);
		WebElement continbtn = getDriver().findElement(By.cssSelector("#btnAttribContinue"));
		continbtn.click();
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Continue");
		}
		
		
		waitABit(1000);
//		productPage.btn_continue.waitUntilClickable();// Select btn_continue
//		waitABit(5000);
//		productPage.btn_continue.click();
//		myflag = WaitAndSync();
//		if (myflag) {
//			System.out.println("error in WaitAndSync for Continue");
//		}

//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//		waitABit(1000);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_UP);
//		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
//		waitABit(2000);
		
		
		if(!protection.equals("Unprotected"))
		{
		productPage.lst_Protection.waitUntilClickable();// Select protection
		executor.executeScript("arguments[0].click();", productPage.lst_Protection);
		//productPage.lst_Protection.click();// Select protection
		waitABit(1000);
		productPage.lst_Protection.sendKeys(protection);
		System.out.println("set the configuration Protection ");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Protection");
		}
		}
		
		if(!circuit_Divesity.equals("No"))
		{
		executor.executeScript("arguments[0].click();", productPage.lst_CircuitDiversityRequired);
		//productPage.lst_CircuitDiversityRequired.waitUntilClickable().click();// Select lst_CircuitDiversityRequired
		waitABit(3000);
		productPage.lst_CircuitDiversityRequired.sendKeys(circuit_Divesity);
		System.out.println("set the configuration circuit_Divesity");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for lst_CircuitDiversityRequired");
		}
		}
		
		if(!latency_guarantee.equals("None"))
		{
		executor.executeScript("arguments[0].click();", productPage.lst_LatencyGuaranteeLevel);
		//productPage.lst_LatencyGuaranteeLevel.waitUntilClickable().click();// Select lst_LatencyGuaranteeLevel
		waitABit(3000);
		productPage.lst_LatencyGuaranteeLevel.sendKeys(latency_guarantee);
		System.out.println("set the configuration latency_guarantee ");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Latency_guarantee");
		}
		}
        if(latency_guarantee.equals("Standard"))
         {
			productPage.txt_LatencyValue.waitUntilClickable().click();// Select lst_LatencyGuaranteeLevel
			waitABit(1000);
			productPage.txt_LatencyValue.sendKeys("9000");
			System.out.println("set the configuration latence_value ");
			if (myflag) {
				System.out.println("error in WaitAndSync for txt_LatencyValue");
			}
         }
		
        if(!encryption.equals("No"))
        {
         executor.executeScript("arguments[0].click();", productPage.lst_Encryption);
        // productPage.lst_Encryption.waitUntilClickable().click();// Select Encryption moved to here for test 2
		waitABit(1000);
		productPage.lst_Encryption.sendKeys(encryption);
		System.out.println("set the configuration encryption");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Encryption");
		}
        }
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		//singleLocationNextandDiscount(); // this function does all the next and discount buttons
		waitABit(1000);
		if (smyproduct.equals("HSIP Wavelength")) {
			
			productPage.lst_A_Loc_Building.waitUntilClickable().click(); // Select Building Extension Drop down
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for standard deliver");
			}
			productPage.lst_custom_route.waitUntilClickable().click(); // Select custom route
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys("No", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for standard deliver");
			}
			set_HSIP_Service_single_location(); // set the single location hsip service
			singleLocationNextandDiscount(); // this function does all the next and discount buttons
		}
	}
	
	@Step
	public void preDeploySwitch(String preDeployValue)
	{
		preDeploy_Status=preDeployValue;
		productPage.waitForTextToAppear("New", 90000);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		executor.executeScript("arguments[0].scrollIntoView();", productPage.preDeployCurrent);
		waitABit(1200);
		String preDeployStatus=productPage.preDeployCurrent.getText();
		logger.info("Current Pre-Deploy Status-" +preDeployStatus);
		
		if(!preDeployValue.equals(preDeployStatus))
		{
			productPage.productConfigMenu.click();
			waitABit(1200);
			productPage.preDeployToggle.click();
			waitABit(7000);	
			
		}
	}
	
	public void a_Side_Access_Configuration(String promotion,String aAccessService,String aLoc3rdPartyXconnect)
	{
		productPage.promotion.waitUntilClickable().click(); // Select Building Extension Drop down
		waitABit(3000);
		productPage.promotion.selectByVisibleText(promotion);
		productPage.aAccessService.waitUntilClickable().click(); // Select Building Extension Drop down
		waitABit(3000);
		productPage.aAccessService.selectByVisibleText(aAccessService);
		
		productPage.aLoc3rdPartyXConnect.waitUntilClickable().click(); // Select Building Extension Drop down
		waitABit(3000);
		productPage.aLoc3rdPartyXConnect.selectByVisibleText(aLoc3rdPartyXconnect);
		
	}
	
	public void z_Side_Access_Configuration(String zAccessService,String zLoc3rdPartyXconnect)
	{
		
		productPage.zAccessService.waitUntilClickable().click(); // Select Building Extension Drop down
		waitABit(3000);
		productPage.zAccessService.selectByVisibleText(zAccessService);
		
		productPage.zLoc3rdPartyXConnect.waitUntilClickable().click(); // Select Building Extension Drop down
		waitABit(3000);
		productPage.zLoc3rdPartyXConnect.selectByVisibleText(zLoc3rdPartyXconnect);
		
	}
}
