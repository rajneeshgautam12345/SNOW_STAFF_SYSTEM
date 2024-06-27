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
public class CrossConnectStandaloneSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	// Cross Connect Standalone
	@Step
	public void user_adds_cross_connect_standalone_product(String smyproduct, String bill_type, String country) {
		Boolean myflag;
		String rc = "";
		String rc1 = "";
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.setProperty("myBillType.ID", bill_type); // set the product into memory
		String sBillType = System.getProperty("myBillType.ID");
		System.out.println("the product  is  " + sProductType); // print out product type
		System.out.println("the product  is  " + sBillType); // print out product type
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
		if (smyproduct.equals("Stand Alone Cross Connect")) {
			executor.executeScript("arguments[0].click();", productPage.lst_addressdd); // Select Product Dropdown
			// productPage.lst_addressdd.click();// Select Product Dropdown
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(rc1, Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for address select 1");
			}
			executor.executeScript("arguments[0].click();", productPage.sec_addressdd); // Select Product Dropdown
			productPage.sec_addressdd.click();// Select Product Dropdown
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys(rc, Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for address select 1");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			executor.executeScript("arguments[0].click();", productPage.lst_tranport); // open the Z End Service Type
			// productPage.lst_tranport.click(); // open the Z End Service Type
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("Order", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
			executor.executeScript("arguments[0].click();", productPage.lst_classdd); // open the Cable Type
			// productPage.lst_classdd.click(); // open the Cable Type
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("Single", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
			singleLocationNextandDiscount(); // fill out next button discount buttons etc
		}
		if (smyproduct.equals("HSIP Cross Connect")) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			productPage.lst_classdd.click(); // open band width
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("10", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
			// executor.executeScript("arguments[0].click();",productPage.txt_fvr_id_listbox);
			// // type in 22
			productPage.txt_fvr_id_listbox.type("22"); // type in 22
//			myflag = WaitAndSync();
//			if (myflag) {
//				 System.out.println("error in WaitAndSync for fvr ID");
//			}
			if (country.equalsIgnoreCase("US")) {
				getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			}
			set_HSIP_Service_single_location(); // set the single location hsip service
			singleLocationNextandDiscount(); // this function does all the next and discount buttons ;
		}
	}
}
