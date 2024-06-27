package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import java.util.concurrent.TimeUnit;

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
public class ElynkInterConnectSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	// ELynk interconnect
	// //////////////////////////////////////////////////////////////////////////////////////
	@Step
	public void user_adds_elynk_interconnect_product(String smyproduct, String desTypeA, String ASideDataCenter,
			String desTypeZ, String ZSideDataCenter, String bandwith, String classpick) {
		Boolean myflag;
		String myEnv = System.getProperty("staf.environment.key");
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		this.addNewProduct(); // add the product here
		productPage.DestTypeASide.withTimeoutOf(30, TimeUnit.SECONDS).click(); // Select destination Type A
		productPage.waitForTextToAppear("DataCenter", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(desTypeA, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Destination Type A");
		}
		productPage.A_Side_Data_Center.click(); // Select A-Side Data Center
		productPage.waitForTextToAppear("Cologix", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(ASideDataCenter, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Select A-Side Data Center");
		}
		productPage.lst_billing_type_dd.click(); // Select Destination Type Z
		productPage.waitForTextToAppear("DataCenter", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(desTypeZ, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Destination Type Z");
		}
		// getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		productPage.lst_elan_bandwidth.click(); // Select Z-Side Data Center
		productPage.waitForTextToAppear("Cologix", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(ZSideDataCenter, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Select Z-Side Data Center");
		}
		productPage.lst_evcclass.click(); // Select bandwidth
		productPage.waitForTextToAppear("2 Mbps", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(bandwith, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Select bandwith");
		}
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		productPage.lst_router.click(); // Select class type
		productPage.waitForTextToAppear("Basic", 20000); // Wait for Upload;
		getDriver().switchTo().activeElement().sendKeys(classpick, Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for Select class type");
		}
		singleLocationNextandDiscount(); // fillout next button discount buttons etc
	}
}
