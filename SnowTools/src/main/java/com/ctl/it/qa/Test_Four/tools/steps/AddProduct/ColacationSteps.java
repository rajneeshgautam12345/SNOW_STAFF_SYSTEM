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
public class ColacationSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	ScenarioDataPage senarioDataPage;
	SwiftPage swiftPage;

//////Co-Location
	@Step
	public void user_adds_colacation_product(String smyproduct) {
		Boolean myflag;
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		String myEnv = System.getProperty("staf.environment.key");
		System.out.println("the Env is : " + myEnv);
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
//CoLocation
		if (smyproduct.equals("Co-location")) {
			this.addNewProduct(); // add the product here
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			productPage.lst_tranport.click(); // Select Colo Type
			waitABit(1000);
			getDriver().switchTo().activeElement().sendKeys("Caged", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for  Colo Type");
			}
		}
		if (smyproduct.equals("Colocation NA Suite")) {
			this.addNewProduct(); // add the product here
			getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			productPage.txt_total_size.click();
			getDriver().switchTo().activeElement().sendKeys("10000", Keys.ENTER);
			myflag = WaitAndSync();
			if (myflag) {
				System.out.println("error in WaitAndSync for  Colo Type");
			}
		}
		singleLocationNextandDiscount(); // this function does all the next and discount buttons
	}
}
