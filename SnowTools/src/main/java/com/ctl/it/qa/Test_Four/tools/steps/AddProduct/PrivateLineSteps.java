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
public class PrivateLineSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;

	// Private Line
	// //////////////////////////////////////////////////////////////////////////////////////
	@Step
	public void user_adds_private_line_product(String smyproduct, String bill_type) {
		Boolean myflag;
		String LocID = System.getProperty("Loc.ID");
		System.out.println("the location  is  " + LocID); // print out product type
		String LocID_2 = System.getProperty("Loc_2.ID");
		System.out.println("the location  is  " + LocID_2); // print out product type
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		System.setProperty("myBillType.ID", bill_type); // set the oppty name into memory
		String sBillType = System.getProperty("myBillType.ID");
		String myEnv = System.getProperty("staf.environment.key");
		System.out.println("the Env is : " + myEnv);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//Private Line
		this.addNewProduct(); // add the product here
		if (smyproduct.equals("Ethernet Private Line") || smyproduct.equals("Private Line")) {
			waitABit(2000);
			executor.executeScript("arguments[0].click();", productPage.lst_addressdd); // Select address Drop down
			// productPage.lst_addressdd.click();// Select address Drop down
			waitABit(3000);
			;
			// productPage.lst_address1value.click(); // Address 1 Select
			getDriver().switchTo().activeElement().sendKeys(LocID, Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for address select 1");
			}
			executor.executeScript("arguments[0].click();", productPage.sec_addressdd); // Select second address
																						// Dropdown
			// productPage.sec_addressdd.click();// Select second address Dropdown
			waitABit(3000);
			// action.moveToElement(getDriver().findElement(By.xpath("//*[@id='Address2_listbox']/li[3]"))).sendKeys(LocID_2).click().perform();
			// //second location
			getDriver().switchTo().activeElement().sendKeys(LocID_2, Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for address select 2");
			}
		}
		if (smyproduct.equals("Private Line")) {
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			executor.executeScript("arguments[0].click();", productPage.lst_router); // Select A location Drop down
			// productPage.lst_loc_A_dd.click();// Select A location Drop down
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for building ");
			}
//			executor.executeScript("arguments[0].click();",productPage.lst_loc_Z_dd);  // Select Z location Drop down
//			//productPage.lst_loc_Z_dd.click();// Select Z location Drop down
//			waitABit(1000);
//			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
//			myflag = WaitAndSync();
//			if (myflag) {
//				 System.out.println("error in WaitAndSync for address select 1");
//			}
			singleLocationNextandDiscount(); // this function does all the next and discount buttons
		}
		if (smyproduct.equals("Ethernet Private Line")) {
			executor.executeScript("arguments[0].click();", productPage.lst_ethernet_loc_A_dd); // Select A location
																								// Drop down
			// productPage.lst_ethernet_loc_A_dd.click();// Select A location Drop down
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for address select 1");
			}
//			executor.executeScript("arguments[0].click();",productPage.lst_loc_Z_dd);  // Select Z location Drop down
//			//productPage.lst_loc_Z_dd.click();// Select Z location Drop down
//			waitABit(1000);
//			//action.moveToElement(getDriver().findElement(By.xpath("//*[@id='Z_Loc_Inside_Wiring_listbox']/li[3]"))).sendKeys("s").click().perform();  //Extended Deliver // Address Z 1st pick Select
//			getDriver().switchTo().activeElement().sendKeys("Standard", Keys.ENTER);
//			myflag = WaitAndSync();
//			if (myflag) {
//				 System.out.println("error in WaitAndSync for address select 1");
//			}
			singleLocationNextandDiscount(); // this function does all the next and discount buttons
		}
		if (smyproduct.equals("HSIP Ethernet Private Line")) {
			executor.executeScript("arguments[0].click();", productPage.lst_bandwith_hsipEPL_dd); // Open Product
																									// Dropdown
			// productPage.lst_bandwith_hsipEPL_dd.click();// Open Product Dropdown
			waitABit(1000);
			executor.executeScript("arguments[0].click();", productPage.lst_bandwith_hsipEPL_value_dd); // Select
																										// Product Drop
																										// down
			// productPage.lst_bandwith_hsipEPL_value_dd.click();// Select Product Drop down
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for  select Ethernet Private Line");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			executor.executeScript("arguments[0].click();", productPage.ddl_loc_building_ext); // Select Building
																								// Extension Drop down
																								// for Z
			waitABit(3000);
			// action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"AttributeForm\"]"))).sendKeys("s").click().perform();
			// //standard Deliver
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