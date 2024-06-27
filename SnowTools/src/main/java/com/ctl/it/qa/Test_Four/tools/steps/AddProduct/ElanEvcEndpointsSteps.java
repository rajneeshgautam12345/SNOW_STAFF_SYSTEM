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
public class ElanEvcEndpointsSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	@Step
	public void user_adds_elan_evc_endpoints(String smyproduct, String bandwidth, String uniType, String buildingExt,
			String evc_Type, String e_bandwidth, String e_class, String linear_diverse) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		String myEnv = System.getProperty("staf.environment.key");
		this.addNewProduct(); // add the product here
		productPage.WaitForPageToLoad(30);
		executor.executeScript("arguments[0].click();", productPage.lst_addressdd); // Select address Dropdown
		// productPage.lst_addressdd.click();// Select address Dropdown
		waitABit(1000);
		productPage.lst_address1value.waitUntilPresent().click(); // Address 1 Select
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for address select 1");
		}
		try {
			executor.executeScript("arguments[0].click();", productPage.btn_relELAN_EVC); // Select elan UNI Drop down
			// productPage.btn_relELAN_EVC.click(); // Select elan UNI Drop down
			waitABit(1000);
			productPage.btn_relELAN_EVC_radio.click(); // the eland pop up radio button
			productPage.btn_x_close_3.click(); // close the button
		} catch (Exception e) {
			System.out.println(e);
			productPage.btn_x_close_3.click(); // close the button
		}
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for EVP");
		}
		waitABit(1000);
		try {
			executor.executeScript("arguments[0].click();", productPage.btn_relUNI);
			// productPage.btn_relUNI.click(); // Select UNI Drop down
			waitABit(1000);
			productPage.btn_relUNI_radio.click(); // the uni pop up radio button
			productPage.btn_x_close_1.click(); // close the button
		} catch (Exception e) {
			System.out.println(e);
			productPage.btn_x_close_1.click(); // close the button
		}
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for UNI");
		}
		waitABit(1000);
		executor.executeScript("arguments[0].click();", productPage.lst_elan_bandwidth); // the bandwidth list box
		// productPage.lst_elan_bandwidth.click(); // the bandwidth list box
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys("1 Gbps", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for product config next button ");
		}
		try {
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			// executor.executeScript("arguments[0].click();",productPage.lst_elan_building_ext);
			// // Select Building Extension Drop down
			productPage.lst_elan_building_ext.click(); // Select Building Extension Drop down
			waitABit(3000);
			getDriver().switchTo().activeElement().sendKeys("s", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for extended deliver");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("error in WaitAndSync for extended deliver");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		waitABit(1000);
		executor.executeScript("arguments[0].click();", productPage.btn_quicksave); // quick save button
		// productPage.btn_quicksave.click(); //quick save button
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for quick save");
		}
		Boolean bflag;
		bflag = false;
		String sholder;
		int ncounter;
		ncounter = 0;
		do { // *[@id="package-summary-grid"]/div[2]/table/tbody/tr[1]/td[9]/span
			waitABit(100);
			// sholder=
			// swiftPage.find(By.xpath("//*[@id='package-summary-grid']/div[2]/table/tbody/tr[1]/td[9]/span")).getTextValue();
			sholder = swiftPage.find(By.xpath(
					"//html/body/app-root/app-product-summary/div/app-quote-products/div[4]/div/table/tbody/tr[1]/td[8]/div[1]"))
					.getTextValue();
			System.out.println("Holder contains " + sholder);
			if (sholder.equals("Valid")) {
				System.out.println("all good valid");
				bflag = true;
			} else {
				System.out.println("waiting on valid");
				ncounter = ncounter + 1;
				waitABit(5000);
				bflag = false;
			}
		} while (bflag != true);
		System.out.println("out of waiting on valid");
		System.out.println("out of waiting on valid" + ncounter);
		bflag = false;
		executor.executeScript("arguments[0].click();", productPage.btn_discounting);
		// productPage.btn_discounting.click();
		System.out.println("at Discounting Discounting Button");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for  Discounting Button");
			waitABit(2000);
		}
		executor.executeScript("arguments[0].click();", productPage.btn_discountingsave);
		// productPage.btn_discountingsave.waitUntilPresent().waitUntilEnabled().waitUntilClickable().withTimeoutOf(180,
		// TimeUnit.SECONDS).click();
		System.out.println("at Discounting Save Button");
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for  Discounting Save Button");
			waitABit(2000);
		}
//		waitABit(5000);
//		System.out.println("out of senerio manager and all the timing");
//		String currentURL = getDriver().getCurrentUrl();  // get the current url of page in now
//	    System.out.println("currentURL  is  " +currentURL); // // get the current url 
//	    String[] myTemp=currentURL.split("/"); // split the url on the "/" delimiter note- user can use split on any char/number etc String [array] is used to put data in from split 
//	    System.out.println("currentURL  is myTemp[5] " +myTemp[5]); // end of getting currentURL which has the return code number in array[5]
//	    String myURLid = System.getProperty("URL.ID"); //get original log in url from memory
//	    System.out.println("myURLid  is  " +(myURLid)); //get the url from memory
//	    String myUrl=String.valueOf(myURLid+myTemp[5]);
//	    System.out.println("BackURL is  " +myUrl); // this is the one for back to previous page
//	    getDriver().get(myUrl); //Easiest way to do this
//		waitABit(5000);
	}
}
