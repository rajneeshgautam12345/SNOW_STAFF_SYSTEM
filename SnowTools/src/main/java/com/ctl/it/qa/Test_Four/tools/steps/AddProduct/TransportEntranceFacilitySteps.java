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
public class TransportEntranceFacilitySteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	// Transport Entrance Facility
	// //////////////////////////////////////////////////////////////////////////////////////
	@Step
	public void user_adds_transportEntrancefacility_product(String smyproduct) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		Boolean myflag;
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
//Transport - Entrance Facility
		this.addNewProduct(); // add the product here
//	    if(myEnv.equals("TEST1")|| myEnv.equals("TEST2")) {
//			executor.executeScript("arguments[0].click();", productPage.lst_productdd); // Select Product Dropdown
//		//productPage.lst_productdd.click();// Select Product Dropdown
//		}else {
//			executor.executeScript("arguments[0].click();", productPage.lst_productdd_e2e); // Select Product Dropdown
//			//productPage.lst_productdd_e2e.click();// Select Product Dropdown
//		}
//	    //MISSING THE PICK NEED CODE HERE FOR TRANSPORT 
//		waitABit(2000);
//		myflag = WaitAndSync();
//		if (myflag) {
//			 System.out.println("error in WaitAndSync for  select Transport - Entrance Facility");
//		}
//		//productPage.btn_newproduct.click(); // New Product 
//		executor.executeScript("arguments[0].click();", productPage.btn_newproduct);   // New Product 
//		myflag = WaitAndSync();
//		if (myflag) {
//			 System.out.println("error in WaitAndSync for new product ");
//		}
		waitABit(4000);
		executor.executeScript("arguments[0].click();", productPage.lst_uniportbandwidth); // Select Transport -
																							// Entrance Facility
																							// Bandwidth Dropdown
		// productPage.lst_uniportbandwidth.click(); // Select Transport - Entrance
		// Facility Bandwidth Dropdown
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys("DS3", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
		singleLocationNextandDiscount(); // single location next
	}
}
