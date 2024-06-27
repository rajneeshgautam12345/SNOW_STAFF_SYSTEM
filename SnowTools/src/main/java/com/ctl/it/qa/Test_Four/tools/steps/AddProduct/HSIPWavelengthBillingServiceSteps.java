package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

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
public class HSIPWavelengthBillingServiceSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	// hsip_wavelength_hsip_billing_hsip_service
	// //////////////////////////////////////////////////////////////////////////////////////
	@Step
	public void user_adds_hsip_wavelength_hsip_billing_hsip_service_product(String smyproduct, String bill_type) {
		Boolean myflag;
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.setProperty("myBillType.ID", bill_type); // set the product into memory
		String sBillType = System.getProperty("myBillType.ID");
		System.out.println("the product  is  " + sProductType); // print out product type
		System.out.println("the product  is  " + sBillType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
		System.out.println("the Env is : " + myEnv);
//HSIP Wavelength
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			productPage.lst_productdd.click();// Select Product Dropdown
		} else {
			productPage.lst_productdd_e2e.click();// Select Product Dropdown
		}
		waitABit(2000);
		if (smyproduct.equals("HSIP Wavelength")) {
			productPage.lst_hsip_wavelength.click();// Select Product Drop down
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for  select wave length");
			}
		}
		productPage.btn_newproduct.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product 2");
		}
		waitABit(2000);
//   		productPage.lst_addressdd.click();// Select address Drop down
//		waitABit(1000);
//		productPage.lst_address1value.click(); // Address 1 Select
//		myflag = WaitAndSync();
//		if (myflag) {
//			 System.out.println("error in WaitAndSync for address select 1");
//		}
		if (smyproduct.equals("HSIP Wavelength")) {
			productPage.lst_A_Loc_Building.click(); // Select Building Extension Drop down
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
			set_HSIP_Billing_single_location(); // set the single location billing arrangement
			// set_HSIP_Service_single_location(); // set the single location hsip service
			singleLocationNextandDiscount(); // this function does all the next and discount buttons
		}
	}
}
