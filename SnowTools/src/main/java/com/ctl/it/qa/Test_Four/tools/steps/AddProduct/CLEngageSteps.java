package com.ctl.it.qa.Test_Four.tools.steps.AddProduct;

import org.openqa.selenium.Keys;

import com.ctl.it.qa.Test_Four.tools.pages.common.CenturyLinkEngage;
import com.ctl.it.qa.Test_Four.tools.pages.common.HomePage;
import com.ctl.it.qa.Test_Four.tools.pages.common.LoginPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ProductPage;
import com.ctl.it.qa.Test_Four.tools.pages.common.ScenarioPage;
import com.ctl.it.qa.Test_Four.tools.steps.E2ESteps;

import net.serenitybdd.annotations.Step;

@SuppressWarnings("serial")
public class CLEngageSteps extends E2ESteps {
	private static final String Boolen = null;
	LoginPage loginPage;
	HomePage homePage;
	ScenarioPage scenarioPage;
	ProductPage productPage;
	CenturyLinkEngage centurylinkengage;

	@Step
	public void user_adds_CLEngage_product(String smyproduct) {
		Boolean myflag;
		String myEnv = System.getProperty("staf.environment.key");
		System.setProperty("myProduct.ID", smyproduct); // set the product into memory
		String sProductType = System.getProperty("myProduct.ID"); // get the product from memory
		System.out.println("the product  is  " + sProductType); // print out product type
		this.addNewProduct(); // add the product here
		centurylinkengage.ddl_serviceprovider.selectByValue("CenturyLink"); // internet service provider
		waitABit(4000);
		centurylinkengage.txt_currentbandwith.type("1"); // current bandwidth
		waitABit(4000);
		centurylinkengage.ddl_BWUnitofMeasurement.selectByIndex(1); // set the speed
		waitABit(8000);
		centurylinkengage.ddl_term.selectByIndex(3); // set the monthly terms
		waitABit(4000);
		getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		centurylinkengage.btn_continue.click();// click the continue button
		waitABit(4000);
		centurylinkengage.btn_new_package.click(); // click on new package button
		centurylinkengage.ddl_packagetype.selectByIndex(3); // set package type
		waitABit(4000);
		centurylinkengage.txt_quantity.typeAndEnter("1"); // package quantity
		waitABit(3000);
		centurylinkengage.btn_pkg_save.click();// click the save button
		waitABit(8000);
		centurylinkengage.btn_cle_finish.click();// click the finish button
		waitABit(3000);
		singleLocationNextandDiscount(); // fill out next button discount buttons etc
	}
}
