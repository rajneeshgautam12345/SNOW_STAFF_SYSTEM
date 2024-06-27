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
public class ElynkSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

	// ELynk
	// //////////////////////////////////////////////////////////////////////////////////////
	@Step
	public void user_adds_elynk_product(String smyproduct) {
		Boolean myflag;
		String myEnv = System.getProperty("staf.environment.key");
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		this.addNewProduct(); // add the product here
		executor.executeScript("arguments[0].click();", productPage.DestTypeASide); // Select speed
		// productPage.lst_uniportbandwidth.click(); // Select speedf
		waitABit(3000);
		getDriver().switchTo().activeElement().sendKeys("1 Gbps", Keys.ENTER);
		myflag = WaitAndSync();
		if (myflag) {
			System.out.println("error in WaitAndSync for bandwidth");
		}
		singleLocationNextandDiscount(); // fillout next button discount buttons etc
	}
}
