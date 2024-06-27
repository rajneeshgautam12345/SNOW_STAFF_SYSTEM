package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class DDOSSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;

	@Step
	public void user_adds_ddos_product(String smyproduct, String clean_bandwidth, String kit_region, String spec_design,
			String service_type) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		Boolean myflag;
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
		this.addNewProduct(); // add the product here
		executor.executeScript("arguments[0].click();", productPage.lst_tranport);
		// productPage.lst_tranport.click(); // Select access Dropdown
		productPage.waitForTextToAppear("100 Mbps", 20000); // Wait for Upload;
		if (clean_bandwidth.equals("100 Mbps")) {
			getDriver().switchTo().activeElement().sendKeys("100", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for clean bandwidth");
			}
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		if (kit_region.equals("NA")) {
			executor.executeScript("arguments[0].click();", productPage.lst_elan_bandwidth);
			// productPage.lst_elan_bandwidth.click(); // Select Building Extension Drop
			// down
			getDriver().switchTo().activeElement().sendKeys("NA", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for kit region");
			}
		}
		executor.executeScript("arguments[0].click();", productPage.btn_quicksave);
		// productPage.btn_quicksave.click(); //quick save button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for quick save");
		}
		executor.executeScript("arguments[0].click();", productPage.btn_createpackage);
		// productPage.btn_createpackage.waitUntilClickable().click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product 2");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		executor.executeScript("arguments[0].click();", productPage.chk_addresses);
		// productPage.chk_addresses.click(); // check the first location check box
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		executor.executeScript("arguments[0].click();", productPage.btn_prodconfirmnext);
		// productPage.btn_prodconfirmnext.click(); // click the next button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync ");
		}
		// executor.executeScript("arguments[0].click();",productPage.btn_newproduct);
		// productPage.btn_newproduct.click(); // New Product
//    		myflag = WaitAndSync();
//    		if (myflag) {
//    			 System.out.println("error in WaitAndSync for new product ");
//    		}
		if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd);
			// productPage.lst_productdd.click();// Select Product Dropdown
		} else {
			executor.executeScript("arguments[0].click();", productPage.lst_productdd_e2e);
			// productPage.lst_productdd_e2e.click();// Select Product Dropdown
		}
		productPage.waitForTextToAppear("Adaptive Network Security - Site", 20000); // Wait for Upload;
		if (spec_design.equals("DDoS Mitigation Site")) {
			getDriver().switchTo().activeElement().sendKeys("DDoS Mitigation Site", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for new product ");
			}
		}
		executor.executeScript("arguments[0].click();", productPage.btn_newproduct);
		// productPage.btn_newproduct.click(); // New Product
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for new product ");
		}
		try {
			executor.executeScript("arguments[0].click();", productPage.lst_relService);
			// productPage.lst_relService.click(); // click on the service list box to open
			waitABit(4000);
			executor.executeScript("arguments[0].click();", productPage.btn_relService_radio);
			// productPage.btn_relService_radio.click(); // the pop up radio button
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			executor.executeScript("arguments[0].click();", productPage.btn_x_close_4);
			// productPage.btn_x_close_4.click(); // close the button
		} catch (Exception e) {
			System.out.println(e);
		}
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for service list");
		}
		executor.executeScript("arguments[0].click();", productPage.lst_tranport);
		// productPage.lst_tranport.click();//service type list box opens
		productPage.waitForTextToAppear("GRE", 20000); // Wait for Upload;
		if (service_type.equals("IP VPN Direct")) {
			getDriver().switchTo().activeElement().sendKeys("IP VPN Direct", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for new product ");
			}
		}
		if (kit_region.equals("NA")) {
			executor.executeScript("arguments[0].click();", productPage.lst_internetbandwidth);
			// productPage.lst_internetbandwidth.click(); // Select Building Extension Drop
			// down
			getDriver().switchTo().activeElement().sendKeys("NA", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for kit region");
			}
		}
		singleLocationNextandDiscount(); // fillout next button discount buttons etc
	}
}
