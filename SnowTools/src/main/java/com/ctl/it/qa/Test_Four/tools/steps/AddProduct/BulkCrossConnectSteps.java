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
public class BulkCrossConnectSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	// Bulk Cross Connect
	@Step
	public void user_adds_bulk_cross_connect_product(String smyproduct, String cable_type) {
		Boolean myflag;
		String rc = "";
		String rc1 = "";
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String LocID = System.getProperty("Loc.ID");
		System.out.println("Location  is  " + LocID); // end of getting order id
		String myEnv = System.getProperty("staf.environment.key");
		try {
			String LocID_2 = System.getProperty("Loc_2.ID");
			System.out.println("Location  is  " + LocID_2); // end of getting order id
			rc = LocID_2.substring(0, 3);
		} catch (Exception e) {
			System.out.println(e);
		}
		rc1 = LocID.substring(0, 3);
		this.addNewProduct(); // add the product here
		this.set_CableType(cable_type); // add the cable type
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		singleLocationNextandDiscount(); // this function does all the next and discount buttons ;
	}
}
