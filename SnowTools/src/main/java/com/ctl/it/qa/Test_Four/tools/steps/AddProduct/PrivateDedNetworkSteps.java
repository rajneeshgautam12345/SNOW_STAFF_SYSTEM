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
public class PrivateDedNetworkSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	@Step
	public void user_adds_private_dedicated_network_product(String smyproduct, String dednettype) {
		Boolean myflag;
		String myEnv = System.getProperty("staf.environment.key");
		System.out.println("the Env is : " + myEnv);
		this.addNewProduct(); // add the product here
		productPage.txt_ded_network_name.typeAndEnter("Automation");
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		productPage.lst_network_arrow.click();// dedicated network type
		productPage.waitForTextToAppear("Ring", 20000); // Wait for Upload;
		if (dednettype.equalsIgnoreCase("Wavelength Bandwidth Block")) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);// ded network
																											// type
		}
		if (dednettype.equalsIgnoreCase("Ring")) {
			getDriver().switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);// ded network type
		}
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for  select Ethernet Private Line");
		}
		for (int i = 0; i < 2; i++) {
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_UP);
			productPage.btn_quicksave.click(); // quick save button
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for quick save");
			}
			productPage.btn_createpackage.click(); // click on the new button
			if (myflag) {
				System.out.println("error in WaitAndSync for product config next button ");
			}
			productPage.cbox_address_w_floor.click(); // click on the select all location checkbox
			waitABit(1000);
			productPage.btn_prodconfirmnext.click(); // Product Configuration Next Button - next button
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for product config next button ");
			}
			if (myEnv.equals("TEST1") || myEnv.equals("TEST2")) {
				productPage.lst_productdd.click();// Select Product Dropdown
			} else {
				productPage.lst_productdd_e2e.click();// Select Product Dropdown
			}
			productPage.waitForTextToAppear("Adaptive Network Security - Site", 20000); // Wait for Upload;
			getDriver().switchTo().activeElement().sendKeys("Private Network Access Node", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for access");
			}
			productPage.btn_newproduct.click(); // New Product
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for new product 2");
			}
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			try {
				productPage.lst_relNetwork.click(); // click on network listbo x
				waitABit(1000);
				productPage.rdo_relNetwork_radio.click(); // the eland pop up radio button
			} catch (Exception e) {
				System.out.println(e);
				productPage.btn_close_x.click(); // press the close button
			}
		}
		singleLocationNextandDiscount(); // this function does all the next and discount buttons
	}
}
