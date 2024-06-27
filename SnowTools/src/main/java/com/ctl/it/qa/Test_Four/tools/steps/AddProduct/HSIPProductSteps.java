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
public class HSIPProductSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	@Step
	public void user_adds_hsip_product(String smyproduct) {
		Boolean myflag;
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
		System.out.println("the Env is : " + myEnv);
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			productPage.lst_productdd.click();// Select Product Dropdown
		} else {
			productPage.lst_productdd_e2e.click();// Select Product Dropdown
		}
		productPage.waitForTextToAppear("Adaptive Network Security - Site", 20000); // Wait for Upload;
//HSIP Private Line 
		if (smyproduct.equals("HSIP Private Line")) {
			getDriver().switchTo().activeElement().sendKeys("HSIP Private Line", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for access");
			}
		}
		productPage.btn_newproduct.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product 2");
		}
		if (smyproduct.equals("HSIP Private Line")) {
			productPage.ddl_network_status.click();// Open bandwidth drop down
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("OC3", Keys.ENTER);// Selectbandwidth
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for  select Ethernet Private Line");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			productPage.lst_ethernet_loc_A_dd.click(); // Select Building Extension Drop down
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for standard deliver");
			}
			set_HSIP_Service_single_location(); // set the single location hsip service
			singleLocationNextandDiscount(); // this function does all the next and discount buttons
		}
	}
}
