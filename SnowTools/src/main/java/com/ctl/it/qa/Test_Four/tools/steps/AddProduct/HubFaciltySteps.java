package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioDataPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class HubFaciltySteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;

	@Step
	public void user_adds_hub_facility_product(String smyproduct, String bandwidth) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String LocID = System.getProperty("Loc.ID");
		System.out.println("Location  is  " + LocID); // end of getting order id
		String myEnv = System.getProperty("staf.environment.key");
		this.addNewProduct(); // add the product here
		executor.executeScript("arguments[0].click();", productPage.lst_addressdd);// A location
		// productPage.lst_addressdd.click(); // A location
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys(LocID, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for A Location");
		}
		executor.executeScript("arguments[0].click();", productPage.ddl_network_status);// bandwidth
		// productPage.ddl_network_status.click(); // bandwidth
		productPage.waitForTextToAppear("OC12", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(bandwidth, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for service tier");
		}
		singleLocationNextandDiscount(); // Next Buttons
	}
}
