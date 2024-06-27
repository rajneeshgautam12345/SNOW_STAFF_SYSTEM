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
import net.serenitybdd.core.annotations.findby.By;

@SuppressWarnings("serial")
public class EnniWholesaleUniEAccessOvcSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	@Step
	public void user_adds_enni_wholesaleUni_e_access_ovc(String smyproduct, String sNet, String bandwidth,
			String port_redun, String buildingExt, String evc_Type, String e_bandwidth, String e_class, String uni_type,
			String product_2) {
		Boolean myflag;
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		// ENNI
		this.addNewProduct(); // add the product here
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		waitABit(2000);
		executor.executeScript("arguments[0].click();", productPage.lst_tranport); // Select access Dropdown
		// productPage.lst_tranport.click(); // Select access Dropdown
		productPage.waitForTextToAppear("1 Gbps", 20000); // Wait for Upload;
		if (bandwidth.equals("10 Gbps")) {
			getDriver().switchTo().activeElement().sendKeys("10", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
		}
		executor.executeScript("arguments[0].click();", productPage.lst_classdd); // Select access Dropdown
		// productPage.lst_classdd.click(); // Select access Dropdown
		productPage.waitForTextToAppear("Dual", 20000); // Wait for Upload;
		if (port_redun.equals("Single")) {
			getDriver().switchTo().activeElement().sendKeys("S", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		if (buildingExt.equals("Standard_Delivery")) {
			executor.executeScript("arguments[0].click();", productPage.lst_evcclass); // Select Building Extension Drop
																						// down
			// productPage.lst_evcclass.click(); // Select Building Extension Drop down
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys("s", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for extended deliver");
			}
		}
		executor.executeScript("arguments[0].click();", productPage.btn_quicksave); // quick save button
		// productPage.btn_quicksave.click(); //quick save button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for quick save");
		}
		executor.executeScript("arguments[0].click();", productPage.btn_createpackage); // New Product
		// productPage.btn_createpackage.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product 2");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		productPage.txt_address.type("105 Westpark"); // Wait for Address box and type
		productPage.txt_city.type("Brentwood"); // Wait for city box and type
		productPage.lst_state.selectByVisibleText("Tennessee"); // Wait for state box and select
		executor.executeScript("arguments[0].click();", productPage.btn_search); // Wait for Search Button and click
		// productPage.btn_search.click(); // Wait for Search Button and click
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in myflag = WaitAndSync() for next button");
		}
		getDriver().findElement(By.id("PL0000079239")).click();
		waitABit(1000);
		executor.executeScript("arguments[0].click();", productPage.btn_prodconfirmnext); // click the next button
		// productPage.btn_prodconfirmnext.click(); // click the next button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for product new");
		}
		// wholesale Uni
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd); // Select Product Dropdown
			// productPage.lst_productdd.click();// Select Product Dropdown
		} else {
			productPage.lst_productdd_e2e.click();// Select Product Dropdown
		}
		waitABit(2000);
		executor.executeScript("arguments[0].click();", productPage.lst_wholesale_uni);
		// productPage.lst_wholesale_uni.click();
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for  select lst_iP_van_logic_interface_pick");
		}
		executor.executeScript("arguments[0].click();", productPage.btn_newproduct); // New Product
		// productPage.btn_newproduct.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product ");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_tranport); // Select access Dropdown
		// productPage.lst_tranport.click(); // Select access Dropdown
		productPage.waitForTextToAppear("1 Gbps", 20000); // Wait for Upload;
		if (bandwidth.equals("10 Gbps")) {
			getDriver().switchTo().activeElement().sendKeys("10", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for bandwidth");
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		if (uni_type.equals("Multiplexed")) {
			executor.executeScript("arguments[0].click();", productPage.lst_unitypedd); // Select Type Drop down
			// productPage.lst_unitypedd.click(); // Select Type Drop down
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("m", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for multiplexed");
			}
		}
		if (e_class.equals("Basic")) {
			executor.executeScript("arguments[0].click();", productPage.lst_elan_bandwidth);
			// productPage.lst_elan_bandwidth.click();
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("B", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for Basic");
			}
		}
		if (buildingExt.equals("Standard_Delivery")) {
			executor.executeScript("arguments[0].click();", productPage.lst_dia_billmethod); // Select Building
																								// Extension Drop down
			// productPage.lst_dia_billmethod.click(); // Select Building Extension Drop
			// down
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys("s", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for extended deliver");
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		executor.executeScript("arguments[0].click();", productPage.btn_quicksave); // quick save button
		// productPage.btn_quicksave.click(); //quick save button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for quick save");
		}
		// E_Access OVC
		executor.executeScript("arguments[0].click();", productPage.btn_createpackage); // New Product
		// productPage.btn_createpackage.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product ");
		}
		waitABit(2000);
		executor.executeScript("arguments[0].click();", productPage.chk_addresses); // check the first location check
																					// box
		// productPage.chk_addresses.click(); // check the first location check box
		executor.executeScript("arguments[0].click();", productPage.btn_prodconfirmnext); // click the next button
		// productPage.btn_prodconfirmnext.click(); // click the next button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for lst_ip_vpn_port_access");
		}
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd); // Select Product Dropdown
			// productPage.lst_productdd.click();// Select Product Dropdown
		} else {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd_e2e); // Select Product Dropdown
			// productPage.lst_productdd_e2e.click();// Select Product Dropdown
		}
		waitABit(2000);
		productPage.waitForTextToAppear("Adaptive Network Security", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("E-Access - OVC", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for E-Access - OVC");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_product_new_product); // New Product
		// productPage.lst_product_new_product.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product ");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_addressdd); // Select address Drop down
		// productPage.lst_addressdd.click();// Select address Drop down
		waitABit(1000);
		executor.executeScript("arguments[0].click();", productPage.lst_address1value); // Address 1 Select
		// productPage.lst_address1value.click(); // Address 1 Select
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for address select 1");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		executor.executeScript("arguments[0].click();", productPage.lst_cloud_access_point); // click on cloud access
																								// poing
		// productPage.lst_cloud_access_point.click(); //click on cloud access poing
		waitABit(3000);
		productPage.rdo_relCloud_Access_Point_radio.click();
		getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
		try {
			productPage.btn_x_close_1.click(); // close the pop up
		} catch (Exception e) {
			System.out.println(e);
		}
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_relCustomer_Access_Point); // customer access
																									// point
		// productPage.lst_relCustomer_Access_Point.click(); // customer access point
		waitABit(3000);
		productPage.rdo_relCustomer_Access_Point_radio.click();
		try {
			productPage.btn_x_close_2.click(); // close the pop up
		} catch (Exception e) {
			System.out.println(e);
		}
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_evctypedd); // OVC drop down open
		// productPage.lst_evctypedd.click(); // OVC drop down open
		productPage.waitForTextToAppear("Access-EPL", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("Access-EVPL", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_evcportbandwidth); // band width drop down
		// productPage.lst_evcportbandwidth.click(); // band width drop down
		productPage.waitForTextToAppear("2 Mbps", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("60", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		executor.executeScript("arguments[0].click();", productPage.ddl_pickclass); // class drop down
		// productPage.ddl_pickclass.click(); // class drop down
		productPage.waitForTextToAppear("Basic", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys("B", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Access-EVPL");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		singleLocationNextandDiscount(); // fillout next button discount buttons etc
	}
}
