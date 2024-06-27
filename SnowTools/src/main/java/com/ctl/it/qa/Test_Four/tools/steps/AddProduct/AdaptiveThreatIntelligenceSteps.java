package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.SwiftPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class AdaptiveThreatIntelligenceSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	// Adaptive Threat Intelligence
	// //////////////////////////////////////////////////////////////////////////////////////
	@Step
	public void user_adds_adaptive_threat_intelligence_product(String smyproduct) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		Boolean myflag;
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
		this.addNewProduct(); // add the product here
		executor.executeScript("arguments[0].click();", productPage.ddl_network_status); // service level
		// productPage.ddl_network_status.click(); // service level
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys("Enhanced", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for service level");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_tranport); // service tier
		// productPage.lst_tranport.click(); // service tier
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys("Large", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for service tier");
		}
		singleLocationNextandDiscount(); // Eline Next Buttons
	}
}
